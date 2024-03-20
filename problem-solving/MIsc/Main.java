package MIsc;

import MIsc.FieldsAndMethods;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
//        accessPrivateFieldsAndMethods();
//        customException();
//        multiThreading();
    }

    private static void multiThreading() throws InterruptedException {
        FieldsAndMethods fAndM = new FieldsAndMethods(null, null, null);
        Runnable runnable = () -> fAndM.setAge(22);
        Runnable runnable1 = () -> fAndM.setAge(23);

        Thread thread = new Thread(runnable);
        Thread thread1 = new Thread(runnable1);
        thread.start();
        thread.join();
        thread1.start();
        Thread.sleep(1000);
        System.out.println(fAndM.getAge());
    }

    private static void customException() throws CustomException {
        try {
            throw new CustomException("custom exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    private static void accessPrivateFieldsAndMethods() throws Exception{
        FieldsAndMethods fAndM = new FieldsAndMethods("jahir", "basha", 23);

        Field firstName = FieldsAndMethods.class.getDeclaredField("firstName");

        Method setFirstName = FieldsAndMethods.class.getDeclaredMethod("setFirstName", String.class);
        Method setLastName = FieldsAndMethods.class.getDeclaredMethod("setLastName", String.class);
        Method setAge = FieldsAndMethods.class.getDeclaredMethod("setAge", Integer.class);
        Method setFullName = FieldsAndMethods.class.getDeclaredMethod("setFullName", String.class, String.class);

        setLastName.setAccessible(true);
        setFirstName.setAccessible(true);
        setFullName.setAccessible(true);

        setLastName.invoke(fAndM, "zahir");
        setFirstName.invoke(fAndM, "hello");
        setFullName.invoke(fAndM, "Hello", "Jahir");
        setAge.invoke(fAndM, 24);

        System.out.println(fAndM.getFullName() + " " + fAndM.getAge());
    }
}
