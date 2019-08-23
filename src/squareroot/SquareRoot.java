/*
 * Calculate the square root of a number recursively and non recursively
 * Limitations on the arguments: The precision within which the estimated square
 * root must be, as well as the number whose square root will be calculated,
 * must both be greater than or equal to 0.
 */
package squareroot;

/**
 *
 * @author ayeletbuchen
 * @since October 14, 2018
 */
public class SquareRoot {
    /**
     * Recursively calculate square root of a number.
     * @param number the number whose square root is being calculated
     * @param sqrtGuess the estimated square root
     * @param precision the precision within which the calculated square root
     *  must be 
     * @return the square root of number within the specified precision
     */
    public static double sqrt(double number, double sqrtGuess, double precision)
    {
        double squareRoot = -1;
        if (number >= 0 && precision > 0)
        {
            if (accurateSqrtGuess(number, sqrtGuess, precision))
            {
                squareRoot = sqrtGuess;
            }
            else
            {
                squareRoot = sqrt(number, newSqrtGuess(number, sqrtGuess), precision);
            }
        }
        return squareRoot;
    }

    /**
     * Calculate the square root of a number non-recursively.
     * @param number the number whose square root is being calculated
     * @param sqrtGuess the estimated square root
     * @param precision the precision within which the calculated square root
     *  must be 
     * @return the square root of number within the specified precision
     */
    public static double nrsqrt(double number, double sqrtGuess, double precision)
    {
        double squareRoot = -1;
        if (number >= 0 && precision > 0)
        {
            while (!accurateSqrtGuess(number, sqrtGuess, precision))
            {
                sqrtGuess = newSqrtGuess(number, sqrtGuess);
            }
            squareRoot = sqrtGuess;
        }
        return squareRoot;
    }

    /**
     * Check to see if the estimated square root is accurate, within the 
     * specified precision.
     * @param number the number whose square root is being calculated
     * @param sqrtGuess the estimated square root
     * @param precision the precision within which the calculated square root
     *  must be
     * @return true if sqrtGuess is within the specified precision, otherwise false
     */
    private static boolean accurateSqrtGuess(double number, double sqrtGuess, double precision)
    {
        boolean accurate = false;
        if (Math.abs((sqrtGuess * sqrtGuess) - number) <= precision)
        {
            accurate = true;
        }
        return accurate;
    }

    /**
     * Change the estimated square root to be more accurate
     * @param number the number whose square root is being calculated
     * @param sqrtGuess the original estimated square root
     * @return an estimated square root that is more accurate
     */
    private static double newSqrtGuess(double number, double sqrtGuess)
    {
        return (((sqrtGuess * sqrtGuess) + number) / (2 * sqrtGuess));
    }
}
