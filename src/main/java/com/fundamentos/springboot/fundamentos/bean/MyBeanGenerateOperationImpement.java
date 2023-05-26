package com.fundamentos.springboot.fundamentos.bean;

import ch.qos.logback.classic.spi.LoggerRemoteView;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanGenerateOperationImpement implements MyBeanGenerateOperation {
    Log LOGGER = LogFactory.getLog(MyBeanGenerateOperationImpement.class);

    MyOperation myOperation;
    public MyBeanGenerateOperationImpement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printGenerateOperation() {
        LOGGER.info("Hemos ingresado al metodo printGenerateOperation");
        int numero = 20;
        LOGGER.debug("El numero enviado como parametro a la dependencia Operacion es : " + numero);
        System.out.println( " =======> " + myOperation.sum(numero));
        System.out.println("Hola desde la implementacion de un bean con de generar una operacion de una dependecia");

    }
}
