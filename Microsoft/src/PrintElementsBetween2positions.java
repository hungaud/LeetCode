import java.awt.Point;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PrintElementsBetween2positions {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{5, 2, 3}, {4, 41, 2}, {11, 34, 98}};

        Point p1 = new Point(0, 0);
        Point p2 = new Point(1, 1);
        test(matrix, p1, p2);
    }

    public static void test(int[][] matrix, Point a, Point b) {
        ArrayList<Point> coordinatesList = new ArrayList<>();
        ArrayList<Integer> valuesList = new ArrayList<>();

        int row = (int) a.getY();
        int col = (int) a.getX();
        int rowEnd = (int) b.getY();
        int colEnd = (int) b.getX();
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        boolean finish = false;

        while(row < rowSize && !finish) {
            while(col < colSize && !finish){
                coordinatesList.add(new Point(row, col));
                valuesList.add(matrix[row][col]);
                finish = row == rowEnd && col == colEnd;
                col++;
            }
            row++;
            col = 0;
        }

        System.out.println(coordinatesList.toString());
        System.out.println(valuesList.toString());

    }

}
