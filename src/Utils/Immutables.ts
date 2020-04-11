export class Immutables {
    static lock<T>(obj: T): T {
        return Object.freeze(Object.preventExtensions(obj));
    }

    static lockr<T>(obj: T): T {
        for (var k in obj) {
            if (typeof obj[k] == "object" && obj[k] !== null)
                this.lockr(k);
        }

        if (typeof obj == "function") {
            let p = Object.getOwnPropertyNames(obj);
            for (let k of p) {
                if (typeof obj[k] == "object" && obj[k])
                    this.lockr(obj[k]);
            }
        }

        return Object.freeze(Object.preventExtensions(obj));
    }
}