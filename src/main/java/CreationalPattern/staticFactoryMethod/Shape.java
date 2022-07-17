package CreationalPattern.staticFactoryMethod;


/*
静态工厂模式：根据参数的不同返回不同类的实例，被创建的实例一般均具有公共的父类
组成：1、抽象产品角色 2、具体产品角色 3、工厂方法
 */
//定义抽象静态方法
public interface Shape {
    void Draw();
    void Erase();
}


//实现具体类，重载静态方法
class Circle implements Shape {

    @Override
    public void Draw() {
        System.out.println("Circle Draw");
    }

    @Override
    public void Erase() {
        System.out.println("Circle Erase");
    }
}


class Rectangle implements Shape {

    @Override
    public void Draw() {
        System.out.println("Rectangle Draw");
    }

    @Override
    public void Erase() {
        System.out.println("Rectangle Erase");
    }
}

class Triangle implements Shape {

    @Override
    public void Draw() {
        System.out.println("Triangle Draw");
    }

    @Override
    public void Erase() {
        System.out.println("Triangle Erase");
    }
}

class supportSharpException extends Exception {
//    构造器
    public supportSharpException() {}
    public supportSharpException(String message) {
        System.out.println(message);
    }
}

class SharpFactory {
    public static Shape createSharp(String name) throws Exception {
        Shape newSharp = null;
        switch (name) {
            case "circle":
                newSharp = new Circle();
                break;
            case "triangle":
                newSharp = new Triangle();
                break;
            default:
                throw new supportSharpException("不存在图形");
        }
        return newSharp;
    }
}