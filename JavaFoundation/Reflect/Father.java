import java.io.BufferedReader;
import java.io.FileReader;

/**
 * 本例旨在介绍多态和反射结合的应用
 * 通过读取配置文件中写好的类名，动态加载需要的对象
 */
public class Father {
    public static void main(String[] args) throws Exception{

        //FileReader fileReader = new FileReader("DynamicObject.txt");
        //BufferedReader bufferedReader = new BufferedReader(fileReader);
        //String name = bufferedReader.readLine();
        Class clazz = Class.forName("Daughter");
        //clazz.newInstance();
        Father father = (Father) clazz.newInstance();
        //Father father = new Daughter();
        father.sing();
    }
    public void sing() {
        System.out.println("lala");
    }

}
class Son extends Father{
    @Override
    public void sing() {
        System.out.println("hehe");

    }

}
class Daughter extends Father {
    @Override
    public void sing() {
        System.out.println("haha");
    }
}