package sort;

/**
 * @author HuanJu
 */
public class ShellSort {

    public static void sort(int[] arr) {
        /*
        数组的长度
         */
        int len = arr.length;
        /*
        插入的值以及插入位置
         */
        int val = 0;
        int pos = 0;
        /*
        gap：步长，增量
        0   1   2   3   4   5   6   7   8   9
        步长为5时
        0   5
        1   6
        2   7
        ...
        步长为2时
        0   2   4   6   8
        1   3   5   7   9
         */

        /*
        根据步长进行分组
        并对每一组进行排序
         */
        for (int gap = len / 2; gap > 0; gap = gap / 2) {

            /*
            对每一组进行插入排序
            第一组第二个元素
            第二组第二个元素
            第三组第二个元素
            ....
             */
            for (int i = gap; i < len; i++) {
                pos = i;
                val = arr[pos];
                /*
                当退出while循环后，就给val 找到了插入的位置
                 */
                while (pos - gap >= 0 && val < arr[pos - gap]) {
                    arr[pos] = arr[pos - gap];
                    pos -= gap;
                }
                if (i != pos) {
                    arr[pos] = val;
                }

            }
        }
    }
}
