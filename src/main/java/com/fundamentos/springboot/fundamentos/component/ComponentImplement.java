package com.fundamentos.springboot.fundamentos.component;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency {
    @Override
    public void saludar() {
        System.out.println("Mi primer componente en Java con Spring boot");
    }
}
