package search;

import java.util.Arrays;

/**
 * 斐波那契查找（黄金分割查找）
 * <p>
 * <p>
 * <p>
 * 斐波那契数列 {1,1,2,3,5,8,13,21,34,55,...}
 * <p>
 * 具有F[k]=F[k-1]+F[k-2]的特性
 * <p>
 * 两个相邻的数的比例无限接近黄金分割值
 *
 * @author HuanJu
 */
public class FibonacciSearch {
    /**
     * 获得一个长度为len的斐波那契数列
     *
     * @param len 长度
     */
    public static int[] fib(int len) {
        if (len == 0) {
            return new int[0];
        } else if (len == 1) {
            return new int[]{1};
        } else if (len == 2) {
            return new int[]{1, 1};
        }
        int[] f = new int[len];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < len; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }


    /**
     * 斐波那契查找与二分查找相似，
     * 仅仅是改变pos的位置
     * pos的位置不再是中间位置
     * 而是位于黄金分割点附近
     * <p>
     * pos=left+F[k-1]-1   (F表示斐波那契数列)
     * <p>
     * 由F[k]=F[k-1]+F[k-2]，可以得到F[k]-1=(F[k-1]-1)+(F[k-2]-1)+1
     * <p>
     * 即当顺序表的长度为F[K]-1时，可以将顺序表分成
     * 长度为F[K-1]-1和F[K-2]-1的两段
     * 而pos的位置为pos=left+F[k-1]-1
     *
     * @param arr 数组
     * @param val 查找的值
     */
    public static int search(int[] arr, int val) {
        /*
        定义高位索引和低位索引
         */
        int left = 0;
        int right = arr.length - 1;

        int pos = 0;
        //表示斐波那契分割数值的下标
        int k = 0;
        //获取斐波那契数列
        int[] f = fib(20);

        /*
        获取在斐波那契数组中
        长度大于等于原数组长度的最小值
        的下标
         */
        while (right > f[k] - 1) {
            k++;
        }

        /*
        创建长度为f[k]的数组
        复制原数组的值到新数组
        长度不满足f[k]时
        后面用原数组最后的数填充
         */
        int[] temp = Arrays.copyOf(arr, f[k]);
        //填充
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }


        while (left < right) {
            pos = left + f[k - 1] - 1;

            if (val < temp[pos]) {
                /*
                向左查找

                由f[k]=f[k-1]+f[k-2]
                全部元素的=前面元素+后面元素
                在前面f[k-1]个元素中
                可以继续拆分成两部分
                f[k-1]=f[k-2]+f[k-2]
                即下一次环境分割点pos的值为
                left+f[k-2]-1=left+f[k-1-1]-1
                 */
                right = pos - 1;
                k--;
            } else if (val > temp[pos]) {
                /*
                向右查找
                ...
                后面的f[k-2]个元素中
                可以拆分成f[k-2]=f[k-3]+f[k-4]

                即黄金分割点
                pos=left+f[k-3]-1=left+f[k-1-2]-1
                 */
                left = pos + 1;
                k -= 2;
            }else {
                /*
                找到了
                确定返回哪个值

                如果pos的值还在原arr数组的长度之内
                返回pos

                否则返回right
                因为找到的是填充的
                 */
                if (pos<=right){
                    return pos;
                }else {
                    return right;
                }

            }
        }
        return -1;
    }
}
