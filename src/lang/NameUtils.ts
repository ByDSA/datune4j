export class NameUtils {
    public static b9 = NameUtils.alts(-1) + "9";
    public static a9 = NameUtils.alts(1) + "9";
    public static b5 = NameUtils.alts(-1) + "5";
    public static a5 = NameUtils.alts(1) + "5";
    public static a11 = NameUtils.alts(1) + "11";
    public static add = "ADD";

    public static alts(n: number): string {
        if (n < 0)
            return "♭".repeat(-n);
        else if (n > 0)
            return "♯".repeat(n);
        else
            return "";
    }
}