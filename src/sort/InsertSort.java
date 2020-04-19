package sort;

/**
 * @author HuanJu
 */
public class InsertSort {


    /**
     * 插入排序
     * 把n个元素看作一个无序表和一个有序表
     * <p>
     * 有序表有1个元素
     * 无序表有n-1个元素
     * <p>
     * 把无序表元素按顺序插入到有序表中
     * <p>
     * 先把第一个数当做有序，然后为每一个数找位置并插入
     * <p>
     * 查找顺序：从后往前
     */
    public static void sort(int[] arr) {
        /*
        定义需要插入的数
        以及插入的位置
         */
        int val = 0;
        int pos = 0;

        /*
        以该数组的第一个元素为有序表
        第二及以后的元素组成无序表
         */
        for (int i = 1; i < arr.length; i++) {
            /*
            将需要插入的值设置为当前值
            pos设置为当前位置
             */
            val = arr[i];
            pos = i;

            /*
            寻找待插入位置
            位置要求：
                前一位的值小于或等于插入的值
                如果不满足，则把一位的值后移
                插入位置前移
                继续比较
            当退出循环时，表示位置已经被找到
             */
            while (pos - 1 >= 0 && val < arr[pos - 1]) {

                //前一位值后移
                arr[pos] = arr[pos - 1];

                //插入的位置前移
                pos--;
            }

            /*
            如果当前位置不是插入的位置
            则替换值
             */
            if (pos != i) {
                arr[pos] = val;
            }
        }
    }
}
