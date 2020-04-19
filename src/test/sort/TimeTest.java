package test.sort;

/**
 * @author HuanJu
 */
public class TimeTest {

    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        System.out.println("时间: " + (endTime - startTime) + "ms");
    }

}
