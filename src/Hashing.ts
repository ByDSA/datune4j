declare var require: any

const Hashids = require('hashids/cjs');

export class Hashing {
    private constructor() {
    }

    private static hashids = new Hashids();

    public static hashArray(array: any[]): string {
        return Hashing.hashids.encode(Array.from(array));
    }
}