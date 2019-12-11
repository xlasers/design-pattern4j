##### 目的
确保只有一个实例的类,并提供一个全局方法可以获取到


##### 实现
* 构造方法私有化
* 静态属性指向实例
* public static的 getInstance方法，返回第二步的静态属性


维基百科
> 在软件工程中,单例模式是一种对类实例化对象做出限制的软件设计模式,这适用于系统中,仅仅需要一个对象来完成运转的模式;如,公共资源的加载获取



##### 适用性
* 一个类必须只有一个实例，并且客户端能够通过一个方法去访问


##### 教程
* [Singleton Pattern Tutorial](https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples)
