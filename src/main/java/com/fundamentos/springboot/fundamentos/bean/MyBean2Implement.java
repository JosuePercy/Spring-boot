package com.fundamentos.springboot.fundamentos.bean;

public class MyBean2Implement implements  MyBean{
    @Override
    public void print() {
        System.out.print("Hola desde my implementacion propia del bean 2 : ");
    }
}
