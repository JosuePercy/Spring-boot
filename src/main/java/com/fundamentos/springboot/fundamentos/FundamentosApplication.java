package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanCatchProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanGenerateOperation;
import com.fundamentos.springboot.fundamentos.bean.MyBeanRestaOperation;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentImplement;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	//Dependencias
	private final ComponentDependency componentDependency;
	private final MyBean myBean;

	private final MyBeanGenerateOperation myBeanGenerateOperation;
	private final MyBeanRestaOperation myBeanRestaOperation;
	private final MyBeanCatchProperties myBeanCatchProperties;


	public FundamentosApplication( @Qualifier("componenTwoImplement") ComponentDependency componentDependency, MyBean myBean,
								   MyBeanGenerateOperation myBeanGenerateOperation, MyBeanRestaOperation myBeanRestaOperation, MyBeanCatchProperties myBeanCatchProperties) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanGenerateOperation = myBeanGenerateOperation;
		this.myBeanRestaOperation = myBeanRestaOperation;
		this.myBeanCatchProperties = myBeanCatchProperties;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}
	@Override
	public void run(String... args) {
		componentDependency.saludar();
		myBean.print();
		myBeanGenerateOperation.printGenerateOperation();
		myBeanRestaOperation.printResOperation();
		System.out.println("=====>"+ myBeanCatchProperties.function());
	}
}
