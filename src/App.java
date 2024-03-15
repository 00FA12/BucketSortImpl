import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int[] bigList = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int rand = random.nextInt(1,1000);
            bigList[i] = rand;
        }
        BucketSort bs = new BucketSort(bigList);
        int[] sorted = bs.sort();
        for (int var:sorted
             ) {
            Integer temp = var;
            System.out.println(temp.toString());
        }
        }
}
