import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.Math.floor;

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

        //Using clumpedList and smallList cause lists have the same size
        //Scenario 1 - not evenly distributed
        //BucketSort notEvenlyDistributed = new BucketSort(clumpedList);
        //outputTimeForSorting(notEvenlyDistributed);

        //Scenario 2 - evenly distributed
        //BucketSort evenlyDistributed = new BucketSort(smallList);
        //outputTimeForSorting(evenlyDistributed);


        //for Graph
        //size 100:
        System.out.println("size 100:");
        outputTimeForSorting(new BucketSort(generateData(100, true)));
        outputTimeForSorting(new BucketSort(generateData(100, false)));

        //size 250:
        System.out.println("size 250:");
        outputTimeForSorting(new BucketSort(generateData(250, true)));
        outputTimeForSorting(new BucketSort(generateData(250, false)));


        //size 500:
        System.out.println("size 500:");
        outputTimeForSorting(new BucketSort(generateData(500, true)));
        outputTimeForSorting(new BucketSort(generateData(500, false)));

        //size 750:
        System.out.println("size 750:");
        outputTimeForSorting(new BucketSort(generateData(750, true)));
        outputTimeForSorting(new BucketSort(generateData(750, false)));

        //size 1000:
        System.out.println("size 1000:");
        outputTimeForSorting(new BucketSort(generateData(1000, true)));
        outputTimeForSorting(new BucketSort(generateData(1000, false)));

        //size 5000:
        System.out.println("size 5000:");
        outputTimeForSorting(new BucketSort(generateData(5000, true)));
        outputTimeForSorting(new BucketSort(generateData(5000, false)));

        //size 10000:
        System.out.println("size 10000:");
        outputTimeForSorting(new BucketSort(generateData(10000, true)));
        outputTimeForSorting(new BucketSort(generateData(10000, false)));


        //size 50000:
        System.out.println("size 50000:");
        outputTimeForSorting(new BucketSort(generateData(50000, true)));
        outputTimeForSorting(new BucketSort(generateData(50000, false)));
    }

    private static int[] generateData(int size, boolean evenlyDistributed){
        Random random = new Random();
        int[] array = new int[size];
        if(evenlyDistributed){
            for(int i=0; i<size; i++){
                int rand = random.nextInt(1,1000);
                array[i] = rand;
            }
        }
        if(!evenlyDistributed){
            int firstPart = (int) floor(size * 0.1);
            int secondPart = (int) floor(size * 0.5);
            int lastPart = size - firstPart - secondPart;
            for(int i=0; i<firstPart; i++){
                int rand = random.nextInt(1,100);
                array[i] = rand;
            }

            for(int i=0; i<secondPart; i++){
                int rand = random.nextInt(1,10000);
                array[i] = rand;
            }

            for(int i=0; i<lastPart; i++){
                int rand = random.nextInt(900,1000);
                array[i] = rand;
            }
        }
        return array;
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

private static void outputTimeForSorting(BucketSort input){
        long startTime = System.nanoTime();
        input.sort();
        long endTime = System.nanoTime();

        long timePassed = endTime - startTime;

        System.out.println("Time passed:" + timePassed/100);
        }
}
