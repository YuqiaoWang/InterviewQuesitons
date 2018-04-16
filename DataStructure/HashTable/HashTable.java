import HashItem;

public class HashTable {
    private HashItem[] ht;
    private int tableSize;
    private int currentSize;

    HashTable(int m) {
        tableSize = m;
        ht = new HashItem[tableSize];
        currentSize = 0;
    }

    public boolean isIn(int x) {
        int i = find(x);
        if(i > 0) {
            return true;
        }else {
            return false;
        }
    }

    public int getValue(int i) {
        return ht[i].data;
    }

    public find(int x) {
        int i = x % tableSize;
        int j = i;

        if(ht[j] == null) {
            ht[j] = new HashItem(0);
        }

        while(ht[j].info == 1 && ht[j].data != x) { //说明存在冲突
            j = (j + 1) % tableSize;    //得到下一个哈希地址
            if(j == i) {
                return -tableSize;  //表示查找完整个哈希表的数组
            }
        }
        if(ht[j].info == 1) {   //表示查找到
            return j;
        }else {                 //表示没有查找到
            return -j;      
        }
    }

    /**
     * 插入
     */
    public void insert(int x) throws Exception {
        int i = find(x);
        if(i > 0) {            //如果x存在
            throw new Exception("该数据已存在");
        }else if(i != -tableSize) { //如果x不存在
            ht[-i] = new HashItem(x, 1); //在该位置插入哈希表项
            currentSize++;
        }else {
            throw new Exception("哈希表已满");
        }
    }

    /**
     * 删除
     */
    public void delete(int x) throws Exception {
        int i = find(x);
        if(i >= 0) {
            ht[i].info = 0;
            currentSize--;
        }else {
            throw new Exception("该数据不存在");
        }
    }
}