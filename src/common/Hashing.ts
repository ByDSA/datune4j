declare var require: any

const Hashids = require('hashids/cjs');

export class Hashing {
    private constructor() {
    }

    private static hashids = new Hashids();

    public static hashArray(array: any[]): string {
        return Hashing.hashids.encode(Array.from(array));
    }

    public static hash(value: any): string {
        return Hashing.hashids.encode(value);
    }
}