import { Assert } from './Assert';

export class ImmutablesCache<T, H> {
    private immutablesMap : Map<string, T>;

    public getHash: (H) => string;
    public getHashingObject: (T) => H;
    protected create: (H) => T;

    public constructor(getHash, getHashingObject, create) {
        this.getHash = getHash;
        this.getHashingObject = getHashingObject;
        this.create = create;
    }

    public add(scale: T): void {
        let hashingObject = this.getHashingObject(scale);
        if (hashingObject === undefined)
            throw new Error("No hashingObject has been put.");
        let hash = this.getHash(hashingObject);

        this.immutablesMap = this.immutablesMap || new Map<string, T>();
        this.immutablesMap.set(hash, scale);
    }

    public get(hashingObject: H): T | undefined {
        let hash = this.getHash(hashingObject);
        this.immutablesMap = this.immutablesMap || new Map<string, T>();
        return this.immutablesMap.get(hash);
    }

    public getOrCreate(hashingObject: H): T {
        let obj: T | undefined = this.get(hashingObject);

        if (obj === undefined) {
            obj = this.create(hashingObject);
            Assert.notNull(obj);
            this.add(obj);
        }

        return obj;
    }

    public get list(): T[] {
        return Array.from( this.immutablesMap.values() );
    }
}