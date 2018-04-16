public class Singleton {
    /*
    private static Singleton single;
    //构造方法被设为私有，防止外部使用new来创建对象，破坏单例
    private Singleton() {
        System.out.println("Constructor used.");
    }
    //公有的静态方法，供外部调用来获取单例对象
    public static Singleton getInstance() {
        if(single == null) {//第一次调用该方法时，创建对象。
            single = new Singleton();
        }
        return single;
    }*/
    private static class SingletonHolder {
        private static Singleton outInstance = new Singleton();
    }

    public synchronized static Singleton getInstance() {
        return SingletonHolder.outInstance;
    }

    private Singleton() {
        System.out.println("Constructor used.");
    }

    public static void main(String[] args) {
        System.out.println("main method execute");
        //创建实现了Runnable接口的匿名类
        Runnable run = () -> Singleton.getInstance();
        for(int i = 0; i < 50; i++){
            if(i == 0) {
                System.out.println("first thread");
            }
            Thread thread = new Thread(run);
            thread.start();
        }

    }
}