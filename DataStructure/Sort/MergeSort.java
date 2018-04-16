/**
 * MergeSort 归并排序
 */
import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] data) {
        subMergeSort(data, new int[data.length], 0, data.length -1);
    }

    public static void subMergeSort(int[] data, int[] temp, int left, int right) {
        if(left < right) {
            int center = (left + right) / 2;
            subMergeSort(data, temp, left, center);    //左边
            subMergeSort(data, temp, center + 1, right);   //右边
            merge(data, temp, left, center+1, right);    //合并两个有序
        }
    }

    /**
     * 将两个有序表归并成一个有序表
     *
     * @param data
     * @param temp     临时数组
     * @param leftPos  左边开始下标
     * @param rightPos 右边开始下标
     * @param rightEnd 右边结束下标
     */
    public static void merge(int[] data, int[] temp, int leftPos, 
            int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1; //左边结束下标
        int tempPos = leftPos;      //从左边开始算
        int numEle = rightEnd - leftPos + 1; //元素个数
        while(leftPos <= leftEnd && rightPos <= rightEnd) {
            if(data[leftPos] <= data[rightPos]) {
                temp[tempPos++] = data[leftPos++];
            }else {
                temp[tempPos++] = data[rightPos++];
            }
        }
        while(leftPos <= leftEnd) { //如果左边剩余
            temp[tempPos++] = data[leftPos++];
        }
        while(rightPos <= rightEnd) {//如果右边剩余
            temp[tempPos++] = data[rightPos++];
        }
        //将temp复制到data
        for(int i = 0; i < numEle; i++) {
            data[rightEnd] = temp[rightEnd];
            rightEnd--;
        }
    }

    public static void main(String[] args) {
        int[] data = {5,6,3,7,1,4};
        mergeSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
    
}