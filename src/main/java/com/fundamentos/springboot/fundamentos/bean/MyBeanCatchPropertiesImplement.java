package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanCatchPropertiesImplement  implements MyBeanCatchProperties{

    private final String nombre;
    private final String appellido;

    public MyBeanCatchPropertiesImplement(String nombre, String appellido) {
        this.nombre = nombre;
        this.appellido = appellido;
    }

    @Override
    public String function() {
        return nombre + "-" + appellido ;
    }
}
