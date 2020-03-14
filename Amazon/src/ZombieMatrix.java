import java.util.*;

public class ZombieMatrix {

    public static void main(String[] args) {
        int rows = 5;
        int columns = 5;
        List<List<Integer>> grid = createGrid();
        System.out.println("Start: ");
        print(rows, columns, grid);
        int hours = minHours(rows, columns, grid);
        System.out.println(hours);
    }
    private static List<List<Integer>> createGrid() {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 0, 0, 0, 0));
        List<Integer> b = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0));
        List<Integer> c = new ArrayList<>(Arrays.asList(0, 0, 1, 0, 0));
        List<Integer> d = new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0));
        List<Integer> e = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1));

        res.add(a);
        res.add(b);
        res.add(c);
        res.add(d);
        res.add(e);
        return res;
    }

    private static int minHours(int rows, int cols, List<List<Integer>> grid) {
        int hours = 0;
        Queue<int[]> q= new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid.get(i).get(j) == 1)
                    q.add(new int[] {i, j});
            }
        }

        if(q.isEmpty()) return -1;

        while(!q.isEmpty()) {
            int size = q.size();
            boolean infected = false;
            for(int i = 0; i < size; i++) {
                int[] point = q.poll();
                int row = point[0];
                int col = point[1];

                if(col > 0 && grid.get(row).get(col - 1) == 0){
                    grid.get(row).set(col - 1, 1);
                    q.add(new int[] {row, col - 1});
                    infected = true;
                }
                if(col < grid.get(row).size() - 1 && grid.get(row).get(col + 1) == 0) {
                    grid.get(row).set(col + 1, 1);
                    q.add(new int[] {row, col + 1});
                    infected = true;
                }
                if(row > 0 && grid.get(row - 1).get(col) == 0){
                    grid.get(row - 1).set(col, 1);
                    q.add(new int[] {row - 1, col});
                    infected = true;
                }
                if(row < grid.size() - 1 && grid.get(row + 1).get(col) == 0) {
                    grid.get(row + 1).set(col, 1);
                    q.add(new int[] {row + 1, col});
                    infected = true;
                }
            }
            if(infected)
                hours++;
            System.out.println("Hour: " + hours);
            print(rows, cols, grid);
        }

        return hours;
    }

    private static boolean convertToZombies(int rows, int cols, List<List<Integer>> grid) {
        boolean infected = false;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid.get(i).get(j) == -1) {
                    grid.get(i).set(j, 1);
                    infected = true;
                }
            }
        }
        return infected;
    }

    private static void print(int rows, int cols, List<List<Integer>> grid) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                System.out.print(grid.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println();
    }

}

/*

        int hours = 0;
        //Queue<Point> q = new LinkedList<>();
        boolean isFinished = false;
        while(!isFinished) {
            isFinished = true;
            for(int i = 0; i < rows; i++) {
                for(int j = 0; j < cols; j++) {
                    if (grid.get(i).get(j) == 1) {
                        if (j > 0 && grid.get(i).get(j - 1) == 0) {
                            isFinished = false;
                            grid.get(i).set(j - 1, -1);
                        }
                        if (j < grid.get(i).size() - 1 && grid.get(i).get(j + 1) == 0) {
                            isFinished = false;
                            grid.get(i).set(j + 1, -1);
                        }
                        if (i > 0 && grid.get(i - 1).get(j) == 0) {
                            isFinished = false;
                            grid.get(i - 1).set(j, -1);
                        }
                        if (i < grid.size() - 1 && grid.get(i + 1).get(j) == 0) {
                            isFinished = false;
                            grid.get(i + 1).set(j, -1);
                        }
                    }
                }
            }
            .out.println("Hour: " + hours + "before");
            print(rows, cols, grid);

    boolean infected = convertToZombies(rows, cols, grid);
            System.out.println("Hour: " + hours + "after");
            print(rows, cols, grid);
            if(infected) hours++;
                    }

                    return hours;

 */