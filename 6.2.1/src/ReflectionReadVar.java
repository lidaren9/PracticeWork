import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

class MyClass {
    private int val1;

    public String val2;

    protected final  String val3 = "Java";
}

public class ReflectionReadVar {
    public static void main(String[] args) {
        Class<MyClass> clazz = MyClass.class;
        // 获取类的所有属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            // 输出修饰符
            System.out.print(Modifier.toString(field.getModifiers()) + "\t");
            // 输出属性的类型
            System.out.print(field.getGenericType().toString() + "\t");
            // 输出属性的名称
            System.out.println(field.getName());
        }
    }
}
