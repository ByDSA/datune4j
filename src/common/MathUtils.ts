export class MathUtils {
    public static rotativeTrim(n : number, max: number): number {
        n %= max;
        if (n < 0)
            n += max;

        return n;
    }
}