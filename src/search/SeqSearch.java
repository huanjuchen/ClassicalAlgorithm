package search;

/**
 * 线性查找
 *
 * @author HuanJu
 */
public class SeqSearch {

    public static void main(String[] args) {

        int arr[]={1,9,11,-1,34,123};

        int index=seqSearch(arr,-1);
        System.out.println(index);


    }


    /**
     *  线性查找
     *
     *  找到第一个就返回
     */
    public static int seqSearch(int[] arr,int value){

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==value){
                return i;
            }
        }
        return -1;
    }


}
