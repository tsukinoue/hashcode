import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class HTWC {

    private static final int TABLE_SIZE = 10;

    public static void main(String[] args) {
        
        ArrayList<LinkedList<Integer>> hashTable = new ArrayList<>();
        for (int i = 0; i < TABLE_SIZE; i++) {
            hashTable.add(new LinkedList<>());
        }

        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int num = random.nextInt(100) + 1;
            int bucket = num % TABLE_SIZE;

            hashTable.get(bucket).add(num);
        }

        System.out.println("Hash Table:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Bucket " + i + ": " + hashTable.get(i));
            System.out.println();
        }

        int searchNum = 20; 
        int bucket = searchNum % TABLE_SIZE;

        if (hashTable.get(bucket).contains(searchNum)) {
            System.out.println("Found " + searchNum + " in bucket " + bucket);
            hashTable.get(bucket).remove((Integer) searchNum);
            System.out.println(searchNum + " removed.");
        } else {
            System.out.println(searchNum + " not found.");
        }

        System.out.println("\nHash Table after removal:");
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Bucket " + i + ": " + hashTable.get(i));
            System.out.println();
        }
    }
}