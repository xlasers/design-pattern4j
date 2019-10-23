### 目的
确保只有一个实例的类,并提供一个全局方法可以获取到。


### 实现
* 构造方法私有化
* 静态属性指向实例
* public static的 getInstance方法，返回第二步的静态属性

## 说明

> 象牙塔设为单例模式，因为巫师们学习魔法的地方是唯一的一个象牙塔。


> 确保只创建特定类的唯一对象

维基百科
> 在软件工程中,单例模式是一种对类实例化对象做出限制的软件设计模式,这适用于系统中,仅仅需要一个对象来完成运转的模式;如,公共资源的加载获取。

**编程示例**

> 单元素枚举类型是实现单元素的最佳方式

```java
public enum EnumIvoryTower {
  INSTANCE
}
```

方法调用

```java
EnumIvoryTower enumIvoryTower1 = EnumIvoryTower.INSTANCE;
EnumIvoryTower enumIvoryTower2 = EnumIvoryTower.INSTANCE;
assertEquals(enumIvoryTower1, enumIvoryTower2); // true
```

## 适用性
使用单例模式的场景如下：

* 一个类必须只有一个实例，并且客户端能够通过一个方法去访问。

## 典型应用

* the logging class
* managing a connection to a database
* file manager

## jdk使用示例

* [java.lang.Runtime#getRuntime()](http://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html#getRuntime%28%29)
* [java.awt.Desktop#getDesktop()](http://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html#getDesktop--)
* [java.lang.System#getSecurityManager()](http://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getSecurityManager--)
