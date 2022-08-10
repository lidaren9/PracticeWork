import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class  Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public void saySkill(String skill) {
        System.out.println("Name is : " + name + " , skill is : " + skill);
    }

    public int addSalary(int current) {
        return current + 100;
    }
}

public class CallFuncDemo {
    public static void main(String[] args) {
        Class clazz = null;
        Constructor c = null;
        try {
            clazz = Class.forName("Person");
            c = clazz.getDeclaredConstructor(String.class);
            Person p = (Person) c.newInstance("Peter");
            p.saySkill("Java");
            // 调用方法，，必须传递对象实例
            Method method1 = clazz.getMethod("saySkill", String.class);
            // 因为没有返回值，所以直接调用
            method1.invoke(p, "C#");
            Method method2 = clazz.getMethod("addSalary", int.class);
            Object invoke = method2.invoke(p, 100);
            System.out.println(invoke);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
