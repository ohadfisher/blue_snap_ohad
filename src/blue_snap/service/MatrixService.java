package blue_snap.service;

public class MatrixService {
    public void printSpiral(String[][] matrix, int xMax, int yMax) {
        int iterator;
        int x_position = 0;
        int y_position = 0;

        while (x_position < xMax && y_position < yMax) {
            for (iterator = y_position; iterator < yMax; ++iterator) {
                System.out.print(matrix[x_position][iterator] + " ");
            }
            x_position++;

            for (iterator = x_position; iterator < xMax; ++iterator) {
                System.out.print(matrix[iterator][yMax - 1] + " ");
            }
            yMax--;


            if (x_position < xMax) {
                for (iterator = yMax - 1; iterator >= y_position; --iterator) {
                    System.out.print(matrix[xMax - 1][iterator] + " ");
                }
                xMax--;
            }

            if (y_position < yMax) {
                for (iterator = xMax - 1; iterator >= x_position; --iterator) {
                    System.out.print(matrix[iterator][y_position] + " ");
                }
                y_position++;
            }
        }
    }

}

