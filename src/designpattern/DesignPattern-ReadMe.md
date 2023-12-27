## Design Pattern

### 1. Singleton Design Patterns

A call that has its single instance of object throughout the life cycle of object.

#### How to create the Singleton class.

1. Create a class with lazy initializer, that means initialize clas when only it required.
2. Make constructor private. so that no other can create the object.
3. crate a method that provide the instance of the class.

```java
    public static SingletonClass getInstance(){
        if(instance==null){
synchronized (SingletonClass.class){
        if(instance==null){
        instance=new SingletonClass();
        }}}
        return instance;
        }
```

This method is using `synchronized` for making object initialization thread safe.

4. We can break the singleton property by using Reflection API , Deserializable and using cloneable interface.

##### Solutions

1. Reflection API ,
    1. to fix this we can throw the `IllegalStateException`  Exception from the constructor if somehow
       someone can access the constructor then it will throw the exception.
    2. Using Emum.

```java
    private SingletonClass(){
        if(instance!=null)
        throw new IllegalStateException("You cann't call constructor , call geInstance() to get the object.");
        }
```

2. Deserializable
    1. We need to implement the readResolve() method that return the instance of class.
    2. also add the `volatile` keyword
    3. implement the `Serizable` inteface to the class.

```java
 private static volatile SingletonClass instance;
@Serial
public Object readResolve(){
        return instance;
        }
```

3. Cloneable
    1. impement the `Cloneable` interface and implemet the `clone()`
    2. return the same instance of the object.

```java
    @Override
public SingletonClass clone()throws CloneNotSupportedException{
        if(instance!=null){
        throw new CloneNotSupportedException("Can't create instance. Please use getInsance() to create it.");
        }
        return(SingletonClass)super.clone();
        }
```
