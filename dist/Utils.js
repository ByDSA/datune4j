import Hashids from 'hashids';
export class Utils {
    static cloneString(str) {
        return (' ' + str).slice(1);
    }
    static arrayRemove(array, item) {
        array.splice(array.indexOf(item), 1);
    }
    static assertNotNull(v, name) {
        if (v === undefined || v === null)
            throw new Error("Variable " + (name ? "'" + name + "' " : '') + "is null or undefined.");
    }
    static arrayRotate(arr, n, reverse = false) {
        for (let i = 0; i < n; i++)
            if (reverse)
                arr.unshift(arr.pop());
            else
                arr.push(arr.shift());
        return arr;
    }
    static setAddArray(set, array) {
        for (let e of array)
            set.add(e);
    }
    // Source: https://stackoverflow.com/questions/9083037/convert-a-number-into-a-roman-numeral-in-javascript/9083076
    static getRomanNumeral(n) {
        if (isNaN(n))
            return "NaN";
        var digits = String(+n).split(""), key = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",
            "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
            "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"], roman = "", i = 3;
        while (i--)
            roman = (key[+digits.pop() + (i * 10)] || "") + roman;
        return Array(+digits.join("") + 1).join("M") + roman;
    }
    static hashArray(array) {
        return Utils.hashids.encode(array);
    }
}
Utils.hashids = new Hashids();
//# sourceMappingURL=Utils.js.map