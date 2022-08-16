// 提供sellCar方法的接口类
interface CarFactoryImp {
    public void sellCar();
}

// 汽车厂商的实现类，在其中实现了sellCar的方法
class CarFactory implements CarFactoryImp {

    @Override
    public void sellCar() {
        System.out.println("Sell Car !!!");
    }
}

// 4s点的实现类
class CarProxy implements CarFactoryImp {

    // 最终提供服务的目标对象
    private CarFactoryImp target;
    @Override
    public void sellCar() {
        if (target == null) {
            target = new CarFactory();
        }
        target.sellCar();
    }
}
public class StaticProxy {
    public static void main(String[] args) {
        CarFactoryImp imp = new CarProxy();
        imp.sellCar();
    }
}


