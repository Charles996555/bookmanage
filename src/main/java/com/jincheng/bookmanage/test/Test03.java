package com.jincheng.bookmanage.test;

import java.util.Objects;

/**
 * @Author: 张雨潇
 * @Date: 2020/1/14 8:45
 */
public class Test03 {
    public static void main(String[] args) {
        A a=new B();
        a.setName("123");
        a.setSex("male");
        B b=(B)a;
        b.setAge(10);
        System.out.println(b.getSex()+" "+b.getAge());
    }
}

class A{
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

class B extends A{
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        B b = (B) o;
        return Objects.equals(age, b.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "B{" +
                "age=" + age +
                '}';
    }
}