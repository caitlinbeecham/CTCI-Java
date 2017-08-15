import java.util.ArrayList;

class CTCICh1P8 {
    public static int[][] zero_matrix(int[][] matrix) {
        ArrayList<Integer> rows_to_zero = new ArrayList<Integer>();
        ArrayList<Integer> columns_to_zero = new ArrayList<Integer>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows_to_zero.add(i);
                    columns_to_zero.add(j);
                }
            }
        }
        for (int i = 0; i < rows_to_zero.size(); i++) {
            for (int j = 0; j < matrix[rows_to_zero.get(i)].length; j++) {
                matrix[rows_to_zero.get(i)][j] = 0;
            }
        }
        for (int j = 0; j < columns_to_zero.size(); j++) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][columns_to_zero.get(j)] = 0;
            }
        }
        return matrix;
    }
    
    public static void print_matrix(int[][] matrix) {
        String line;
        for (int i = 0; i < matrix.length; i++) {
            line = "{";
            for (int j = 0; j < matrix[i].length - 1; j++) {
                line = line  + String.valueOf(matrix[i][j]) + ", ";
            }
            line = line + String.valueOf(matrix[i][matrix[i].length - 1]) + "}";
            System.out.println(line);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] r1 = {1,2,3,4,5};
        int[] r2 = {1,0,3,4,5};
        int[] r3 = {1,2,3,4,5};
        int[] r4 = {1,2,3,4,5};
        int[] r5 = {1,2,3,0,5};
        int[][] matrix0 = {r1, r2, r3, r4, r5};
        print_matrix(matrix0);
        int[][] matrix1 = zero_matrix(matrix0);
        print_matrix(matrix1);
        
        
    }
}