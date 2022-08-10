class MyClass {
    public void print() {
        System.out.println("Java");
    }
}

public class ForClassDemo {
    public static void main(String[] args) {
        // 通过New创建类和使用类
        MyClass myClassObj = new MyClass();
        myClassObj.print();
        // 通过forName和newInstance加载类
        try {
            Class<?> clazz = Class.forName("MyClass");
            MyClass myClass = (MyClass) clazz.newInstance();
            myClass.print();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
