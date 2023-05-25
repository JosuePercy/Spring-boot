package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanGenerateOperationImpement implements MyBeanGenerateOperation {

    MyOperation myOperation;
    public MyBeanGenerateOperationImpement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printGenerateOperation() {
        int numero = 20;
        System.out.println( " =======> " + myOperation.sum(numero));
        System.out.println("Hola desde la implementacion de un bean con de generar una operacion de una dependecia");
    }
}
