package designpattern.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        SingletonClass obj = SingletonClass.getInstance();
        SingletonClass obj2 = SingletonClass.getInstance();
        SingletonClass obj3 = SingletonClass.getInstance();

        System.out.println(obj.hashCode() + " obj");
        System.out.println(obj2.hashCode() + " obj2");
        System.out.println(obj3.hashCode() + " obj2");






        //1.  break the Singleton using reflection API
        try {
            Constructor<SingletonClass> constructor = SingletonClass.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            SingletonClass refObje = constructor.newInstance();
            System.out.println(refObje.hashCode() + " Ref Obje");
            // to fix that just throw an exception in SingletonClass constructor so if someone try to execute the
            // constructor will throw the exception.
            // Also create teh enum , that will save us from reelection.
        }catch (Exception e){
            System.out.println(e);
        }

        try {

            //2. Deserialization
            SingletonClass newObj = SingletonClass.getInstance();
            System.out.println("newObje " + newObj.hashCode());

            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.ob"));
            oos.writeObject(newObj);
            System.out.println("Serialization Done ");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.ob"));
            SingletonClass objDes = (SingletonClass) ois.readObject();
            System.out.println("objDes " + objDes.hashCode());
        }catch (Exception e){
            System.out.println(e);
        }


        try{
            //3 . using clone
            SingletonClass cloneObj = obj.clone();
            System.out.println("cloneObj = "+cloneObj.hashCode());

        }catch (Exception e){
            System.out.println(e);
        }


        ExecutorService service = Executors.newFixedThreadPool(3);
        service.submit(Sample::useSingleton);
        service.submit(Sample::useSingleton);
        service.submit(Sample::useSingleton);
        service.shutdown();

    }

    private static void useSingleton(){
        SingletonClass obj = SingletonClass.getInstance();
        SingletonClass obj1 = SingletonClass.getInstance();
        System.out.println(Thread.currentThread().getName());
        System.out.println("obj "+obj.hashCode());
        System.out.println("obj1 "+obj1.hashCode());

    }
}
