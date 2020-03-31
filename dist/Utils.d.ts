export declare class Utils {
    static cloneString(str: String): string;
    static arrayRemove<T>(array: T[], item: T): void;
    static assertNotNull(v: any, name?: string): void;
    static arrayRotate<T>(arr: T[], n: number, reverse?: boolean): T[];
    static setAddArray<T>(set: Set<T>, array: T[]): void;
    static getRomanNumeral(n: number): string;
    private static hashids;
    static hashArray(array: any[]): string;
}
