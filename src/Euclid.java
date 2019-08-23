/*
 * Recursively calculate the greatest common divisor of two positive integers.
 */
package euclid;

/**
 *
 * @author ayeletbuchen
 * @since October 15, 2018
 */
public class Euclid {
     /**
     * Recursively calculate the greatest common divisor of two positive
     * integers.
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
        if (m % n == 0)
        {
            gcf = n;
        }
        else
        {
            gcf = gcd(m, m % n);
        }
        return gcf;
    }
}
