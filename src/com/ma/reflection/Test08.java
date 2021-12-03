package com.ma.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

@SuppressWarnings("all")
public class Test08 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.ma.reflection.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        //获得注解的value的值
        TableMa tableMa = (TableMa) c1.getAnnotation(TableMa.class);
        String value = tableMa.value();
        System.out.println(value);

        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        FieldMa annotation = f.getAnnotation(FieldMa.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());
    }

}

@TableMa("db_student")
class Student2{
    @FieldMa(columnName = "db_id",type = "int",length = 10)
    private int id;;
    @FieldMa(columnName = "db_name",type = "varchar",length = 10)
    private String name;
    @FieldMa(columnName = "db_age",type = "int",length = 10)
    private int age;

    public Student2() {
    }

    public Student2(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

//类名的注解
@SuppressWarnings("all")
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableMa{
    String value();
}

//属性的注解
@SuppressWarnings("all")
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldMa{
    String columnName();
    String type();
    int length();
}
