export class Assert {
  public static notNull(v: any, message?: string): void {
    if (v === undefined || v === null)
      throw new Error("Variable is null or undefined." + (message ? " " + message : ""));
  }
}