package sort;

/**
 * @author HuanJu
 */
public class MergeSort {


    public static void sort(int [] arr){
        int[] temp=new int[arr.length];
        sort(arr,0,arr.length-1,temp);
    }


    private static void sort(int[] arr,int left, int right, int[] temp){
        if (left >= right) {
            return;
        }
        //中间索引
        int mid = (left + right) / 2;
        //向左递归分解
        sort(arr, left, mid, temp);
        //向右递归
        sort(arr, mid + 1, right, temp);
        /*
        将左右两个有序表合并
         */
        merge(arr, left, mid, right, temp);
    }


    /**
     * 合并两个有序数组
     *
     * @param arr   原始数组
     * @param left  左边有序序列的初始索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        /*
        初始化 i 为左边有序序列的初始索引
        初始化 j 为右边有序序列的初始索引
        t为指向temp的当前索引
         */
        int i = left;
        int j = mid + 1;
        int t = 0;

        /*
        把左右两边的有序序列按顺序填充到temp数组
        直到有一边处理完为止
        左边处理完：i==mid
        右边处理完：j==right
         */
        while (i <= mid && j <= right) {

            /*
             如果左边有序序列的当前元素小于或等于右边有序序列的当前元素
             将左边有序序列的当前元素填充到temp 数组
             否则将右边有序序列的当前元素填充到temp 数组
             */
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t++;
                i++;
            } else {
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        /*
        如果左边序列还有数据，就把数据填充到temp数组
         */
        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        /*
        如果右边有序序列还有数据，就把数据填充到temp数组
         */
        while (j <= right) {
            temp[t++] = arr[j++];
        }


        /*
        将temp数组的数据拷贝到arr
         */
        t = 0;
        int tempIndex = left;
        while (tempIndex <= right) {
            arr[tempIndex++] = temp[t++];
        }
    }
}
