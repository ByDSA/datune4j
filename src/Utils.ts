export class Utils {
  static cloneString(str: String): string {
    return (' ' + str).slice(1);
  }
  static arrayRemove<T>(array: T[], item: T): boolean {
    let index = array.indexOf(item);
    if (index >= 0 && index < array.length) {
      array.splice(index, 1);
      return true;
    }

    return false;
  }
  public static assertNotNull(v: any, name?: string): void {
    if (v === undefined || v === null)
      throw new Error("Variable " + (name ? "'" + name + "' " : '') + "is null or undefined.");
  }

  public static arrayRotate<T>(arr: T[], n: number, reverse = false): T[] {
    for (let i = 0; i < n; i++)
      if (reverse)
        arr.unshift(arr.pop());
      else
        arr.push(arr.shift());
    return arr;
  }

  public static setAddArray<T>(set: Set<T>, array: T[]): void {
    for (let e of array)
      set.add(e);
  }

  // Source: https://stackoverflow.com/questions/9083037/convert-a-number-into-a-roman-numeral-in-javascript/9083076
  public static getRomanNumeral(n: number): string {
    if (isNaN(n))
      return "NaN";
    var digits = String(+n).split(""),
      key = ["", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM",
        "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC",
        "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"],
      roman = "",
      i = 3;
    while (i--)
      roman = (key[+digits.pop() + (i * 10)] || "") + roman;
    return Array(+digits.join("") + 1).join("M") + roman;
  }

  public static arraySameContent<T>(a: T[], b: T[]): boolean {
    if (a == b)
      return true;

    if (a.length != b.length)
      return false;

    for (let i = 0; i < a.length; i++) {
      if (a[i] != b[i])
        return false;
    }

    return true;
  }
}