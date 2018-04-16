public class BinarySearch {
    public static int biSearch(int[] a, int elem) {
        int n = a.length;
        int low = 0;
        int high = n - 1;
        int mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if(a[mid] == elem) {
                return mid;
            }else if(a[mid] < elem) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}