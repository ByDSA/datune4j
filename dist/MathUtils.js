export class MathUtils {
    static rotativeTrim(n, max) {
        n %= max;
        if (n < 0)
            n += max;
        return n;
    }
}
//# sourceMappingURL=MathUtils.js.map