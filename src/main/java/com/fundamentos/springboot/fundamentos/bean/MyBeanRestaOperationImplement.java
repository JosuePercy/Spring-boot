package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanRestaOperationImplement  implements MyBeanRestaOperation{
    MyBeanResta myBeanResta;

    public MyBeanRestaOperationImplement (MyBeanResta myBeanResta)  {
        this.myBeanResta = myBeanResta;
    }
    @Override
    public void printResOperation() {
        int number = 40;
        System.out.println("=====>" + myBeanResta.res(number));
        System.out.println("Resultado de la Operation resta de mi nuevo BEan de implementacion");
    }
}
