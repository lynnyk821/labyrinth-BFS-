import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] getCorrectPointFor(char[][] matrix, char c){
        int[] point;
        do {
            System.out.print("Enter point " + c + ": ");
            point = Arrays.stream(new Scanner(System.in).nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        } while (point[0] < 0 || point[0] >= matrix[0].length || point[1] < 0 || point[1] >= matrix.length);
        return point;
    }
    static char[][] fillMatrix(int x, int y){
        char[][] matrix = new char[y][x];
        for(int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++) matrix[i][j] = '.';
        return matrix;
    }
    public static void main(String[] args) throws Exception
    {
        int[] s, f;
        char[][] matrix;
        System.out.print("[0] - my labyrinth\n[1] - default labyrinth\n\nAnswer: ");
        if(new Scanner(System.in).nextInt() == 1){
            matrix = new char[][]{
                new char[]{'#', '.', 'S', '.', '.','.', '.', '.'},
                new char[]{'#', '#', '.', '#', '.', '#', '#', '#'},
                new char[]{'.', '.', '.', '.', '.', '.', '.','.'},
                new char[]{'.', '#', '#', '#', '#', '.', '#', '.'},
                new char[]{'.', '.', '.', '.', '.', '#', '.', '.'},
                new char[]{'.', '.', '#', '.', 'F', '#', '.', '.'},
                new char[]{'.', '.', '#', '#', '#', '#', '.', '.'},
                new char[]{'#', '.', '.', '.', '.', '.', '.', '.'},
            };
            Labyrinth labyrinth = new Labyrinth(matrix, new int[]{2, 0}, new int[] {4,5});
            labyrinth.print();
            labyrinth.getPath();
            labyrinth.setPath();
            labyrinth.print();
        }
        else {
            matrix = fillMatrix(4, 4);
            do {
                s = getCorrectPointFor(matrix, 'S');
                f = getCorrectPointFor(matrix, 'F');
            } while (s[0] == f[0] && s[1] == f[1]);
            Labyrinth labyrinth = new Labyrinth(matrix, s, f);
            labyrinth.print();
            labyrinth.getPath();
            labyrinth.setPath();
            labyrinth.print();
        }
    }
}
