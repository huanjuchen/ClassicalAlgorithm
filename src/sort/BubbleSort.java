package sort;

/**
 * @author HuanJu
 */
public class BubbleSort {

    public static void sort(int[] arr){
        /*
        表示循环的次数
        有arr.length个数，
        就走arr.length-1次大循环
         */
        int count=arr.length-1;
        /*
        标志位
        如果为false
        则表示没有发生交换，
        即顺序已经排好
         */
        boolean flag = false;
        //临时变量
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            /*
            j < count - i
            第一趟：忽略最后0个数
            第二趟：忽略最后1个数
            ...
             */
            for (int j = 0; j < count - i; j++) {
                /*
                如果前面的值大于后面的值，则交换
                 */
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    //交换了把标志设为true
                    flag = true;
                }
            }
            /*
            如果本次循环没有发生交换
            则提前退出
            否则重置flag
             */
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }
}
