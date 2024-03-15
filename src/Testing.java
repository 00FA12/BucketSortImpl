import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Testing {

    public static void main(String[] args) {

        int[] reallybigList = new int[100000];
        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int rand = random.nextInt(1,100000);
            reallybigList[i] = rand;
        }

        int[] smallList = new int[1000];
        for (int i = 0; i < 1000; i++) {
            int rand = random.nextInt(1,1000);
            smallList[i] = rand;
        }

        int[] clumpedList = new int[1000];
        for (int i = 0; i < 100; i++) {
            int rand = random.nextInt(1,100);
            clumpedList[i] = rand;
        }
        for (int i = 100 ; i < 700; i++) {
            int rand = random.nextInt(1,10000);
            clumpedList[i] = rand;
        }
        for (int i = 700 ; i < 1000; i++) {
            int rand = random.nextInt(900,1000);
            clumpedList[i] = rand;
        }

        int[] bigemptylist = new int[1000000];


        BucketSort sortedreallybigList = new BucketSort(reallybigList);


        outputbucketsort(sortedreallybigList);


        BucketSort SortedsmallList = new BucketSort(smallList);


        outputbucketsort(SortedsmallList);



        BucketSort clumpedListsort = new BucketSort(clumpedList);


        outputbucketsort(clumpedListsort);


        BucketSort bigemptylistsorted = new BucketSort(bigemptylist);

        outputbucketsort(bigemptylistsorted);


    }

    private static void outputbucketsort(BucketSort input)
    {
        int[] sorted = input.sort();
        for (int var:sorted
        ) {
            Integer temp = var;
            System.out.println(temp.toString());
        }
    }
}
