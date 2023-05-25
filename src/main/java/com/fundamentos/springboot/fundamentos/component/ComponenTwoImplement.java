package com.fundamentos.springboot.fundamentos.component;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
public class ComponenTwoImplement  implements  ComponentDependency{
    @Override
    public void saludar() {
        System.out.println("Hola mundo desde mi 2do mensaje");
    }
}
