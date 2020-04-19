package search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HuanJu
 */
public class BinarySearch {

    public static void main(String[] args) {
//        int[] arr = {1, 4, 6, 13, 13, 13, 13, 15, 22, 26, 30};
        int[] arr = {1, 4, 6, 13, 15, 22, 26, 30};

        int index = search(arr, 13);
        System.out.println(index);


        List<Integer> resList = searchIndex(arr, 13);
        System.out.println(resList);
    }


    /*
    二分查找
    数组必须是有序的
    不包含相同值
     */
    public static int search(int[] arr, int val) {
        /*
        左索引
        右索引
        中间索引
         */
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;

        /*
        如果左索引不大于右索引，就
        退出循环
         */
        while (left <= right) {
            //获得中间索引
            mid = (left + right) / 2;
            if (val == arr[mid]) {
                /*
                找到直接返回
                 */
                return mid;
            } else if (val > arr[mid]) {
                /*
                如果查找的值大于中间的值
                则表示要查找的在右半部分
                将低位索引指向mid的后一个位置
                 */
                left = mid + 1;
            } else {
                /*
                如果查找的值小于中间的值
                则表示查找的在左半部
                将高位索引指向mid的前一个位置
                 */
                right = mid - 1;
            }
        }
        return -1;
    }


    public static List<Integer> searchIndex(int[] arr, int val) {
        List<Integer> res = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (val == arr[mid]) {
                res.add(mid);

                //向左扫描
                int ml = mid - 1;
                while (ml >= left && arr[ml] == val) {
                    res.add(ml);
                    ml--;
                }
                //向右扫描
                int mr = mid + 1;

                while (mr <= right && arr[mr] == val) {
                    res.add(mr);
                    mr++;
                }
                return res;
            } else if (val > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }


}
