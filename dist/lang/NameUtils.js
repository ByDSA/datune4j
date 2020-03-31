export class NameUtils {
    static alts(n) {
        if (n < 0)
            return "♭".repeat(-n);
        else if (n > 0)
            return "♯".repeat(n);
        else
            return "";
    }
}
NameUtils.b9 = NameUtils.alts(-1) + "9";
NameUtils.a9 = NameUtils.alts(1) + "9";
NameUtils.b5 = NameUtils.alts(-1) + "5";
NameUtils.a5 = NameUtils.alts(1) + "5";
NameUtils.a11 = NameUtils.alts(1) + "11";
NameUtils.add = "ADD";
//# sourceMappingURL=NameUtils.js.map