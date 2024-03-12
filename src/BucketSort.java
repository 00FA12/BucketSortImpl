public class BucketSort {
    private int[] input;
    private int[][] bucket;
    private int[] sorted;
    private int k;
    private int m;
    public BucketSort(int[] input)
    {
        this.input = input;
        sorted = new int[input.length];
        k = findK();

        bucket = new int[k][input.length];
        m = findMax();
    }

    private int findK()
    {
        return findMax()/input.length;
    }

    private int findMax()
    {
        int max = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] > max) {
                max = input[i];
            }
        }
        return max;
    }

    public int[] sort()
    {
        for (int i = 0; i < input.length; i++) {
            bucket[(int) Math.floor((k*input[i])/(m+1))][i] = 5;
        }
        for (int i = 0; i < k; i++) {
            bucket[i] = insertionSort(bucket[i]);
        }

        sorted = concatenateArrays(bucket);

        System.out.println(sorted.toString());

        return sorted;
    }

    private int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    private int[] concatenateArrays(int[]... arrays)
    {
        int[] array = new int[input.length];

        int i = 0;
        
        for (int[] arr : arrays) {
            for (int value : arr) {
                array[i++] = value;
            }
        }
        return array;
    }
}