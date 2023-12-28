import java.util.Scanner;

/**
 * This class contains methods for approximating the value of pi using different techniques.
 */
public class App {

    /**
     * Checks if a given integer is even.
     *
     * @param x The integer to be checked.
     * @return {@code true} if the integer is even, {@code false} otherwise.
     */
    public static boolean isEven(int x) {
        return x % 2 == 0;
    }

    /**
     * Checks if a given integer is odd.
     *
     * @param x The integer to be checked.
     * @return {@code true} if the integer is odd, {@code false} otherwise.
     */
    public static boolean isOdd(int x) {
        return x % 2 != 0;
    }

    /**
     * Approximates pi using the Gregory-Leibniz series.
     *
     * @param iterations The number of iterations to perform.
     * @return An approximation of pi using the Gregory-Leibniz series.
     */
    public static double gregoryLeibniz(int iterations) {
        double piApproximation = 0.0;
        double sign = 1.0;

        for (int i = 0; i < iterations; i++) {
            double term = sign * 4.0 / (2 * i + 1);
            piApproximation += term;
            sign = -sign;
        }
        
        return piApproximation;
    }

    /**
     * Approximates pi using the Nilakantha series.
     *
     * @param iterations The number of iterations to perform.
     * @return An approximation of pi using the Nilakantha series.
     */
    public static double Nilakantha(int iterations) {
        double piApproximation = 3.0;
        double sign = 1.0;

        for (int i = 0; i < iterations; i++) {
            double x1 = 2 * i + 2;
            double x2 = x1 + 1;
            double x3 = x1 + 2;
            double term = sign * 4.0 / (x1 * x2 * x3);

            piApproximation += term;
            sign = -sign;
        }
        
        return piApproximation;
    }

    /**
     * Approximates pi using a limit-based approach.
     *
     * @param x The value used in the limit calculation.
     * @return An approximation of pi using a limit-based approach.
     */
    public static double Limit(int x) {
        double angleInRadians = Math.toRadians(180);
        double piApproximation = x * Math.sin(angleInRadians / x);
        return piApproximation;
    }

    public static void main(String[] args) throws Exception {
        try (Scanner scanner = new Scanner(System.in)) {

            // User chooses which method to use for estimating pi
            System.out.print("How would you like to estimate the value of PI? (GL/L/NL) ");
            String piChoice = scanner.nextLine();

            // User enters the number of iterations for the selected method
            System.out.print("Enter the number of iterations (N value): ");
            int iterations = scanner.nextInt();

            double result;

            // Using a switch statement to select the appropriate estimation method
            switch (piChoice.toUpperCase()) {
                case "GL":
                    result = gregoryLeibniz(iterations);
                    break;
                case "L":
                    result = Limit(iterations);
                    break;
                case "NL":
                    result = Nilakantha(iterations);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid choice: " + piChoice);

            }

            // Displaying the approximation and the actual value of pi
            System.out.println("Approximation of pi after " + iterations + " iterations: " + result);
            double pi = Math.PI;
            System.out.println("Official value of PI: " + pi);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
