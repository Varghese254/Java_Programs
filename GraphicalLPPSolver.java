import java.util.Scanner;

public class GraphicalLPPSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the coefficients of the objective function
        System.out.println("Enter the coefficients of the objective function (c1 c2):");
        double[] objectiveCoefficients = readCoefficients(scanner);

        // Input the coefficients of the constraints
        System.out.println("Enter the coefficients of the constraints (a11 a12 b1, a21 a22 b2):");
        double[][] constraintCoefficients = readConstraintCoefficients(scanner);

        // Calculate the feasible region and its corner points
        double[][] cornerPoints = calculateCornerPoints(constraintCoefficients);

        // Evaluate the objective function at each corner point
        double[] objectiveValues = evaluateObjectiveFunction(objectiveCoefficients, cornerPoints);

        // Find the index of the maximum objective function value
        int maxIndex = findMaxIndex(objectiveValues);

        // Print the optimal solution
        System.out.println("Optimal solution:");
        System.out.print("x1 = " + cornerPoints[maxIndex][0] + ", ");
        System.out.println("x2 = " + cornerPoints[maxIndex][1]);

        // Print the value of Z at the optimal solution
        double optimalZ = objectiveValues[maxIndex];
        System.out.println("Optimal value of Z: " + optimalZ);

        scanner.close();
    }

    // Helper method to read coefficients from input
    private static double[] readCoefficients(Scanner scanner) {
        String[] coefficientsStr = scanner.nextLine().split(" ");
        double[] coefficients = new double[coefficientsStr.length];
        for (int i = 0; i < coefficientsStr.length; i++) {
            coefficients[i] = Double.parseDouble(coefficientsStr[i]);
        }
        return coefficients;
    }

    // Helper method to read constraint coefficients from input
    private static double[][] readConstraintCoefficients(Scanner scanner) {
        double[][] coefficients = new double[2][3];
        for (int i = 0; i < 2; i++) {
            String[] constraintCoefficientsStr = scanner.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                coefficients[i][j] = Double.parseDouble(constraintCoefficientsStr[j]);
            }
        }
        return coefficients;
    }

    // Helper method to calculate corner points of the feasible region
    private static double[][] calculateCornerPoints(double[][] constraintCoefficients) {
        double[][] cornerPoints = new double[4][2];
        double a11 = constraintCoefficients[0][0];
        double a12 = constraintCoefficients[0][1];
        double b1 = constraintCoefficients[0][2];
        double a21 = constraintCoefficients[1][0];
        double a22 = constraintCoefficients[1][1];
        double b2 = constraintCoefficients[1][2];

        // Calculate the intersection points of the lines defined by the constraints
        double x1, y1, x2, y2, x3, y3, x4, y4;
        double det = a11 * a22 - a12 * a21;
        x1 = (b1 * a22 - b2 * a12) / det;
        y1 = (a11 * b2 - a21 * b1) / det;
        x2 = b1 / a12;
        y2 = b1 / a11;
        x3 = b2 / a21;
        y3 = b2 / a22;
        x4 = (b2 - a21 * b1 / a11) / (a22 - a21 * a12 / a11);
        y4 = (b1 - a12 * b2 / a22) / (a11 - a12 * a21 / a22);

        cornerPoints[0][0] = x1;
        cornerPoints[0][1] = y1;
        cornerPoints[1][0] = x2;
        cornerPoints[1][1] = y2;
        cornerPoints[2][0] = x3;
        cornerPoints[2][1] = y3;
        cornerPoints[3][0] = x4;
        cornerPoints[3][1] = y4;

        return cornerPoints;
    }

    // Helper method to evaluate the objective function at each corner point
    private static double[] evaluateObjectiveFunction(double[] objectiveCoefficients, double[][] cornerPoints) {
        double[] objectiveValues = new double[cornerPoints.length];
        for (int i = 0; i < cornerPoints.length; i++) {
            double value = 0;
            for (int j = 0; j < objectiveCoefficients.length; j++) {
                value += objectiveCoefficients[j] * cornerPoints[i][j];
            }
            objectiveValues[i] = value;
        }
        return objectiveValues;
    }

    // Helper method to find the index of the maximum value in an array
    private static int findMaxIndex(double[] array) {
        double max = Double.NEGATIVE_INFINITY;
        int maxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
