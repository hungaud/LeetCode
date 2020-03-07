public class PointOfLattice {

    public static void main(String[] args) {
        int ax = -1, ay = 3, bx = 3, by = 1;
        int[] arr = solution(ax, ay, bx, by);
        System.out.println("[" + arr[0] + ", " + arr[1] + "]");
    }

    public static int[] solution(int ax, int ay, int bx, int by) {
        int dx = bx - ax, dy = by - ay;

        // rotate 90
        int rx = dy, ry = -dx;

        // reduce
        int gcd = Math.abs(gcd(rx, ry));
        rx /= gcd;
        ry /= gcd;

        return new int[]{bx + rx, by + ry};
    }
    private static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }

}
