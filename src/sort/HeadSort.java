package sort;

/**
 * @author HuanJu
 */
public class HeadSort {

    /**
     * 堆排序
     * 升序用大顶堆，降序用小顶堆
     */
    public static void heapSort(int[] arr) {
        int len = arr.length;

        /*
        1. 将无序的数组构建成一个初始堆
        构建从最后一个非叶子节点开始

        完全二叉树有n/2个非叶子节点
        即，最后一个非叶子节点的索引为：n/2-1
        len/2-1
         */
        for (int i = len / 2 - 1; i >= 0; i--) {
            modifyHead(arr, i, len);
        }

        //交换缓存
        int temp = 0;

        /*
        2. 将堆顶元素与末尾元素交换，将最大元素沉到末端
        3. 重新调整结构，使其满足堆定义
        然后继续交换堆顶元素与当前末尾元素
        反复执行调整+交换步骤，直到整个序列有序
         */
        for (int j = len - 1; j > 0; j--) {
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            /*
            调整
             */
            modifyHead(arr, 0, j);
        }
    }

    /**
     * 以rootIndex为根节点构建一个大顶堆
     *
     * @param arr    数组
     * @param rootIndex   非叶子节点在数组中的索引
     * @param length 对多个个元素进行调整
     */
    public static void modifyHead(int[] arr, int rootIndex, int length) {
        /*
        交换缓存
         */
        int temp = 0;
        /*
        son指向parent节点的左子节点
         */
        int parent = rootIndex;
        for (int son = parent * 2 + 1; son < length; son = son * 2 + 1) {
            /*
            如果son的值小于右子节点的值
            则将son指向右子节点
             */
            if (son + 1 < length && arr[son] < arr[son + 1]) {
                son++;
            }
            /*
            如果子节点的值大于父节点的值
            则交换父节点与子节点的值
            并将parent指针指向子节点
            否则表示堆调整已经完成
             */
            if (arr[son] > arr[parent]) {
                temp = arr[parent];
                arr[parent] = arr[son];
                arr[son] = temp;
                parent = son;
            } else {
                break;
            }
        }
    }
}
