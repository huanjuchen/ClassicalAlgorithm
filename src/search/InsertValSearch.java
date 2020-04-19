package search;

/**
 * @author HuanJu
 */
public class InsertValSearch {


    public static void main(String[] args) {

//        int[] arr = new int[100];
//        for (int i = 0; i < 100; i++) {
//            arr[i] = i *2;
//        }
        int[] arr = {1, 4, 6, 13, 15, 22, 26, 30};


        System.out.println("index= " + search(arr, 2));
    }

    /**
     * 插值查找算法，二分查找进化版
     *
     * @param arr 数组
     * @param val 查找的值
     */
    public static int search(int[] arr, int val) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        /*
        左索引
        右索引
        用于比较的值的位置（索引）

         */
        int left = 0;
        int right = arr.length - 1;
        int pos = 0;

        /*
        如果查找的值比最小值还小或者比最大值还大
        则直接返回-1表示未找到
        除此之外，还能防止pos越界
         */
        if (val < arr[left] || val > arr[right]) {
            return -1;
        }

        while (left <= right) {
            /*
            防止{1,1,1,1,1,1}类型的数组
            出现除以0异常
             */
            if (arr[left] == arr[right]) {
                if (arr[left]==val){
                    return left;
                }else {
                    return -1;
                }
            }

            /*
            比较的位置不再是中间位置
            而是自适应，查看需要查找的值更倾向于哪一边
             */
            pos = left + (right - left) * (val - arr[left]) / (arr[right] - arr[left]);


            /*
            二分查找逻辑
             */
            if (val == arr[pos]) {
                return pos;
            } else if (val < arr[pos]) {
                right = pos - 1;
            } else {
                left = pos + 1;
            }
        }
        return -1;
    }
}
