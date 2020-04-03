public class MultiplyWithoutOperator {

    public static void main(String[] args) {
        int a = -6;
        int b = -5;
        System.out.println(multiply(a, b));
    }
    /* function to multiply two numbers x and y*/
    private static int multiply(int x, int y) {
        /* 0 multiplied with anything gives 0 */
        if (y == 0)
            return 0;
        /* Add x one by one */
        if (y > 0)
            return (x + multiply(x, y - 1));
        /* the case where y is negative */
        if (y < 0)
            return -multiply(x, -y);
        return -1;
    }
}
