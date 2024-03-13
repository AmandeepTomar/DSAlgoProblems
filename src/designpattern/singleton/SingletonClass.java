package designpattern.singleton;

import java.io.Serial;
import java.io.Serializable;

/**
 * 1. Create a private constructor so client can not create the object.
 * 2. Create a getInstance() method thread safe by calling the the initialization code inside the synchronized() block.
 * Break 1. We can create the object using refelection API and break the Singleton
 * Solution -> 1. we will throw an exception, somehow we try to access the constructor.
 * 2. enum
 * Break 2. Using Deserializable  and  Serializable
 * Solution -> implementing readResolve method.
 *
 * @Serial public Object readResolve() {
 * return instance;
 * }
 * Break 3. We can break using cloning object.
 * Solution -> implement the Clonable interfacedetails and override the clone method and return the same instance.
 */
public class SingletonClass implements Serializable, Cloneable {
    private static volatile SingletonClass instance;

    private SingletonClass() {
        if (instance != null)
            throw new IllegalStateException("You cann't call constructor , call geInstance() to get the object.");
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }

    @Serial
    public Object readResolve() {
        return instance;
    }

    @Override
    public SingletonClass clone() throws CloneNotSupportedException {
        if (instance != null) {
            throw new CloneNotSupportedException("Can't create instance. Please use getInsance() to create it.");
        }
        return (SingletonClass) super.clone();
    }
}
