/**
 * 哈希表项
 */
public class HashItem {
    int data;
    int info;   //标志，等于0空闲，等于1占用

    public HashItem(int i) {
        info = i;
    }

    public HashItem(int d, int i) {
        data = d;
        info = i;
    }
}