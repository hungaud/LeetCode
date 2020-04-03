import java.util.Stack;

public class TowerOfHanoi {

    public static void main(String[] args) {
        int numDisk = 3;
        Stack<Integer> origin = new Stack<>();
        Stack<Integer> destination = new Stack<>();
        Stack<Integer> buffer = new Stack<>();
        for(int i = numDisk; i > 0; i--) {
            origin.push(i);
        }
        moveDisk(numDisk, origin, destination, buffer);
        System.out.println(destination.toString());
    }

    private static void moveDisk(int numDisk, Stack<Integer> origin, Stack<Integer> destination, Stack<Integer> buffer) {
        if(numDisk == 0) {
            return;
        }

        moveDisk(numDisk - 1, origin, buffer, destination);

        int currentDisk = origin.pop();
        if(destination.isEmpty() || currentDisk < destination.peek()) {
            destination.push(currentDisk);
        } else if (currentDisk > destination.peek()) {
            origin.push(currentDisk);
            return;
        }

        moveDisk(numDisk - 1, buffer, destination, origin);
    }

}
