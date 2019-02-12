
import java.util.Random;
import java.util.Scanner;
public class Life {
    public static void main(String[] args) {
        // Declaration of variables.
        int iterationNumber;
        int chance;
        int limit;
        int counter = 0;
        int row = 10;
        int col = 10;
        boolean[][] matrix = new boolean[row][col];
        boolean[][] matrix2 = new boolean[row][col];
        Random R = new Random();
        Scanner factor = new Scanner(System.in);
        System.out.println("Life factor: (0 - 100)");
        limit = Integer.parseInt(factor.nextLine());
        // Seeding life in first matrix.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                chance = R.nextInt(100) + 1;
                if (chance > limit) {
                    matrix[i][j] = true;
                }
            }
        }
        // Printing first matrix.
        for (int i = 1; i < row - 1; i++) {
            for (int j = 1; j < col - 1; j++) {
                if (matrix[i][j] == false) {
                    System.out.print("0 ");
                } else if (matrix[i][j] == true) {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }
        System.out.println("Number of iterations:");
        iterationNumber = Integer.parseInt(factor.nextLine());
        System.out.println("///////////////");
        for (int o = 0; o < iterationNumber; o++) {
            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    for (int ii = i - 1; ii <= i + 1; ii++) {
                        for (int jj = j - 1; jj <= j + 1; jj++) {
                            if (matrix[ii][jj] == true) {
                                counter++;
                            }
                        }
                    }
                    if (matrix[i][j] == true){
                        counter = counter - 1;
                    } 
                    if ((counter == 2 || counter == 3) && matrix[i][j] == true) {
                        matrix2[i][j] = true;
                    }
                    if ((counter <= 1 || counter >= 4) && matrix[i][j] == true) {
                        matrix2[i][j] = false;
                    }
                    if (counter == 3 && matrix[i][j] == false) {
                        matrix2[i][j] = true;
                    }
                    counter = 0; 
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    matrix[i][j] = matrix2[i][j];
                }
            }
            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    if (matrix[i][j] == false) {
                        System.out.print("0 ");
                    } else if (matrix[i][j] == true) {
                        System.out.print("1 ");
                    }
                }
                System.out.println();
            }
            for (int i = 1; i < row - 1; i++) {
                for (int j = 1; j < col - 1; j++) {
                    matrix2[i][j] = false;
                }
            }
            System.out.println("");
            System.out.println("///////////////");
        }
    }
}