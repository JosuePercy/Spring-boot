package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanRestaImplement implements MyBeanResta {
    @Override
    public int res(int number) {
        return number - 12;
    }
}
