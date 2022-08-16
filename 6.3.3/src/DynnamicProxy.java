import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 提供服务的接口
interface Service {
    String sellCar(String carName);
}

// 实现服务的类
class ServiecImpl implements Service {

    @Override
    public String sellCar(String carName) {
        return carName + " is ready！";
    }
}

// 实现InvocationHandler接口
class MyInvocationHandler implements InvocationHandler {

    private Object target;

    // 在构造函数中初始化target对象
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    // 通过invokie方法，，可以调用target类中的方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Call : " + method.getName());
        // 通过method的invoke方法调用target类中的方法
        Object result = method.invoke(target, args);
        return result;
    }

}
public class DynnamicProxy {
    public static void main(String[] args) {
        Service service = new ServiecImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(service);
        Service serviceProxy = (Service) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), invocationHandler);
        System.out.println(serviceProxy.sellCar("Aston Martin"));
    }
}
