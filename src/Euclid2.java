/*
 * Non-recursively calculate the greatest common divisor of two positive
 * integers.
 */
package euclid2;

/**
 *
 * @author ayeletbuchen
 * @since October 15, 2018
 */
public class Euclid2 {
    /**
     *
     * @param m the first positive integer
     * @param n the second positive integer
     * @return the greatest common divisor of the two positive integers
     */
    public static int gcd(int m, int n)
    {
        int gcf;
        if (m < n)
        {
            int temp = m;
            m = n;
            n = temp;
        }
        while (m % n != 0)
        {
            n = m % n;
        }
        gcf = n;
        return gcf;
    }
}
