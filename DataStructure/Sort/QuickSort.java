/**
 * QuickSort 快速排序
 */
public class QuickSort {
    /**
     * 核心部分，先选一个数字，把比该数小的放左边，大的放右边
     * 本实现方法用了3个指针：基准，low,high
     * 基准选择开头数据
     */
    public static int partition(int[] data, int start, int end) {
        int flag = start;
        int middleValue = data[flag];  //选基准
        while(start < end) {
            while(data[end] >= middleValue && start < end) {
                end--;
            }
            while(data[start] <= middleValue && start < end) {
                start++;
            }
            int temp = data[start];
            data[start] = data[end];
            data[end] = temp;
        }
        int temp = data[flag];
        data[flag] = data[start];
        data[start] = temp;

        return start;
    }

    /**
     * 算法入口
     */
    public static void quickSort(int[] data) {
        subQuickSort(data, 0, data.length - 1);
    }

    /**
     * 递归部分
     */
    public static void subQuickSort(int[] data, int start, int end) {
        if(start >= end) {
            return ;
        }
        int index = partition(data, start, end);
        subQuickSort(data, start, index - 1);
        subQuickSort(data, index + 1, end);
    }

    /**
     * 测试用例
     */
    public static void main(String[] args) {
        int[] data = {8,2,5,6,3,7,1,4};
        quickSort(data);
        for(int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
    
}