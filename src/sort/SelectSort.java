package sort;

/**
 * @author HuanJu
 */
public class SelectSort {


    /**
     * 把排好序后面的最小值以及索引选择出来
     * 交换到排序的序列的末端
     */
    public static void sort(int[] arr){
        /*
        数组的长度
         */
        int len = arr.length;
        
        /*
        存放最小值以及最小值的索引
         */
        int minVal = 0;
        int min = 0;


        for (int i = 0; i < len-1; i++) {
            /*
            假设当前值为最小值
             */
            minVal = arr[i];
            min = i;
            
            
            /*
            从当前位置的后一个位置开始
            查找出最小值以及其索引
             */
            for (int j = 1 + i; j < len; j++) {
                if (minVal > arr[j]) {
                    minVal = arr[j];
                    min = j;
                }
            }
            
            
            /*
              如果当前位置的值不是最小值
              则交换
             */
            if (min != i) {
                arr[min] = arr[i];
                arr[i] = minVal;
            }
        }
    }
}
