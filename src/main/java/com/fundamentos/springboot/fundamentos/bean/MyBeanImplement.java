package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanImplement implements  MyBean{
    @Override
    public void print() {
        System.out.print("Hola desde my implementacion propia del bean");
    }
}
