/**
 * 根据数据的历史访问记录来进行淘汰数据
 * 其核心思想是“如果数据最近被访问过
 * 那么将来被访问的几率也更高”
 * 
 * 数据存储结构长度确定
 * 新加入的数据被放在最顶端，
 * 最后使用的数据放在最顶端，
 * 末位数据被淘汰
 * 
 * 类说明：利用LinkedHashMap实现简单的缓存， 必须实现removeEldestEntry方法
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Map;

public class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    private final int maxCapacity;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private final Lock lock = new ReentrantLock();

    public LRULinkedHashMap(int maxCapacity) {
        super(maxCapacity, DEFAULT_LOAD_FACTOR, true);
        this.maxCapacity = maxCapacity;
    }

    protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
        reutrn size() > maxCapacity;
    }

    @Override
    protected boolean containsKey(Object key) {
        try{
            lock.lock();
            return super.containsKey(key);
        }finally{
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        try{
            lock.lock();
            return super.get(key);
        }finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        try{
            lock.lock();
            return super.put(key, value);
        }finally {
            lock.unlock();
        }
    }

    public int size() {
        try{
            lock.lock();
            return super.size();
        }finally {
            lock.unlock();
        }
    }

    public void clear() {
        try{
            lock.lock();
            super.clear();
        }finally {
            lock.unlock();
        }
    }


}