import java.util.*;

public class InsertDeleteRandom_381 {

    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        r.insert(1);
        r.insert(1);
        r.insert(2);
        r.insert(1);
        r.insert(2);
        r.insert(2);
        r.remove(1);
        r.remove(2);
        r.remove(2);
        r.remove(2);

        for(int i = 0; i < 100; i++) {
            System.out.println(r.getRandom());
        }

    }


    static class RandomizedCollection {

        HashMap<Integer, ArrayDeque<Integer>> map;
        ArrayList<Integer> numbers;
        int size;

        /** Initialize your data structure here. */
        public RandomizedCollection() {
            map = new HashMap<>();
            numbers = new ArrayList<>();
            size = 0;
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            boolean alreadyContains = map.containsKey(val);
            if(!alreadyContains) {
                map.put(val, new ArrayDeque<>());
            }
            map.get(val).add(size);
            numbers.add(val);
            size++;
            return !alreadyContains;
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            boolean seen = map.containsKey(val);
            if(!seen)
                return false;
            int i = map.get(val).peek();
            numbers.set(i, numbers.get(size - 1));

            if(!map.get(numbers.get(size - 1)).isEmpty() && numbers.get(size - 1) != val)
                map.get(numbers.get(size - 1)).removeLast();
            System.out.println(numbers.get(size-1));
            map.get(numbers.get(size - 1)).addLast(i);
            if(map.get(val).isEmpty())
                map.remove(val);
            numbers.remove(size - 1);
            size--;

            return seen;
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int i = (int) (Math.random() * size);
            return numbers.get(i);
        }
    }
}
