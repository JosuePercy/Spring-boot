package com.fundamentos.springboot.fundamentos.configuration;


import com.fundamentos.springboot.fundamentos.bean.MyBeanCatchProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanCatchPropertiesImplement;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.apellido}")
    private String apellido;


    @Bean
    public MyBeanCatchProperties function(){
        return new MyBeanCatchPropertiesImplement(name,apellido);
    }

}
