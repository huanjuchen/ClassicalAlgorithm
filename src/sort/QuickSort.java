package sort;

/**
 * @author HuanJu
 */
public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }


    private static void sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        /*
        将数组中的第left个元素作为基准数
         */
        int standard = arr[start];
        /*
        记录需要排序的下标
         */
        int left = start;
        int right = end;
        while (left < right) {

            /*
            在右边查找比基准数小的数的下标
            找到则退出循环
            如果没有找到
            right索引向左走继续查找
            当left等于right退出
             */
            while (left < right && arr[right] >= standard) {
                right -= 1;
            }

            /*
            使用右边的数替换左边的数
             */
            arr[left] = arr[right];

            /*
            找比基准数大的数的下标
            找到则退出循环
            如果没有找到
            left索引向右走继续查找
            当left等于right退出
             */
            while (left < right && arr[left] <= standard) {
                left += 1;
            }
            arr[right] = arr[left];
        }

        /*
        当左指针等右指针时
        将基准数替换到当前位置
         */
        if (right == left) {
            arr[left] = standard;
        }
        /*
        递归排序小于基准数部分
         */
        sort(arr, start, left - 1);
        /*
        递归排序大于基准数部分
         */
        sort(arr, left + 1, end);
    }

}
