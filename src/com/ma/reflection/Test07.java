package com.ma.reflection;

@SuppressWarnings("all")
public class Test07 {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->根加载器(c/c++)
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        /*
        sun.misc.Launcher$AppClassLoader@18b4aac2
        sun.misc.Launcher$ExtClassLoader@1b6d3586
        null
         */

        //测试当前类是由哪个加载器加载的
        ClassLoader classLoader = Class.forName("com.ma.reflection.Test07").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内置的类是谁加载的
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //System.out.println(System.getProperty("java.class.path"));
    }
}
