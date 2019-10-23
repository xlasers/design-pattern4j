# ZH
### 目的

将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示.

### Wiki百科

构建器模式是一种创建对象的软件设计模式，它是伸缩构造器模式的优化解决方案.(反面模式是低效有待优化的设计模式)

### 伸缩构造模式

构造器的参数根据属性数量,以及实际需要可以不断添加扩展,但是随着属性参数的增加,这些参数顺序以及意义难理理解.

```java
 Developer(LanguageLevel languageLevel, LanguageType languageType, DevelopTool developTool, Measurement measurement, Hobby hobby, String name, ... ...);
```

### 一言蔽之

>在避免污染构造器的情况下,可以创建不同数量属性的对象;适用于创建多种不同属性数量或者构建过程复杂的对象.

# EN
### Intent

Separate the construction of a complex object from its representation so that the same 
construction process can create different representations.

### telescoping constructor anti-pattern

The number of constructor parameters can quickly get out of hand and it might become difficult to 
understand the arrangement of parameters. Plus this parameter list could keep on growing if you 
would want to add more options in future. 

### Real world examples

* [java.lang.StringBuilder](http://docs.oracle.com/javase/8/docs/api/java/lang/StringBuilder.html)
* [java.nio.ByteBuffer](http://docs.oracle.com/javase/8/docs/api/java/nio/ByteBuffer.html#put-byte-) as well as similar buffers such as FloatBuffer, IntBuffer and so on.
* [java.lang.StringBuffer](http://docs.oracle.com/javase/8/docs/api/java/lang/StringBuffer.html#append-boolean-)
* All implementations of [java.lang.Appendable](http://docs.oracle.com/javase/8/docs/api/java/lang/Appendable.html)
* [Apache Camel builders](https://github.com/apache/camel/tree/0e195428ee04531be27a0b659005e3aa8d159d23/camel-core/src/main/java/org/apache/camel/builder)

### In plain words

>Allows you to create different flavors of an object while avoiding constructor pollution. Useful 
when there could be several flavors of an object. Or when there are a lot of steps involved in 
creation of an object.


