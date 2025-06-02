package Reflection;

import University.Point;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Application implements Runnable{

    @Override
    public void run() {
        Class myClass = Point.class;
        Class secondClass = Integer.class;

        Integer integer = 10;
        integer.getClass();

        System.out.println(myClass.getName());
        System.out.println(myClass.getCanonicalName());
        System.out.println(myClass.getSuperclass());
        System.out.println(myClass.getInterfaces()[0]);

        myClass.getTypeParameters();

        Constructor[] constructors = myClass.getConstructors();
        try {
            myClass.getConstructor(byte[].class, Integer.class, Integer.class);
        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
        }
        for (Constructor constructor : constructors) {
            Parameter[] parameters = constructor.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType());
                parameter.getParameterizedType();
            }
            System.out.println("===================");
        }

        Object o = null;
        try {
            o = myClass.getConstructor(double.class,double.class).newInstance(65.2,91.3);
        } catch (InstantiationException e) {
//            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
        } catch (Exception ex) {

        }

        System.out.println(o.getClass());
        System.out.println(o.toString());

        Method[] methods = myClass.getMethods();

        for (Method method : methods) {
            System.out.println(method.getName());
            System.out.println(method.getReturnType());
//            System.out.println(method.getParameters());

            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName());
                System.out.println(parameter.getType());
                parameter.getParameterizedType();
            }
            method.getParameterTypes();
            System.out.println("===================");
        }

        try {
            Method method = myClass.getMethod("setX", double.class);
            Object result = method.invoke(o,100.4);
//            For static method:
//            Object result = method.invoke(null);
            System.out.println(result);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Field[] fields = myClass.getDeclaredFields();
        for(Field field:fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
            System.out.println("=============");
        }
        try {
            Field field = myClass.getDeclaredField("x");
            field.setAccessible(true);
            field.set(o, 65.2);
//            field.set(null, 65.2);
            System.out.println(field.getDouble(o));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }

        try {
            URLClassLoader urlClassLoader = new URLClassLoader(
                    new URL[]{new URL("file:///home/hima/Desktop/custom/")}
            );
            Class loadedClass = urlClassLoader.loadClass("CustomClasses.Point");
            System.out.println(loadedClass.getName());
            Object customObject = loadedClass.getConstructor().newInstance();
            System.out.println(customObject.toString());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        Annotations.Main annotationMain = new Annotations.Main();
        Class mainClass = annotationMain.getClass();
        Annotation[] annotations = mainClass.getAnnotations();
        for(Annotation annotation:annotations) {
            System.out.println(annotation);
        }

        Method[] annotationMethods = annotationMain.getClass().getDeclaredMethods();
        for(Method method:annotationMethods) {
            System.out.println(method);
            Annotation[] methodAnnotations = method.getAnnotations();
            for(Annotation annotation:methodAnnotations) {
                System.out.println(annotation);
            }
        }
    }
}
