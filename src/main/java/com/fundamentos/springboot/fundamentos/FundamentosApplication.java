package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanCatchProperties;
import com.fundamentos.springboot.fundamentos.bean.MyBeanGenerateOperation;
import com.fundamentos.springboot.fundamentos.bean.MyBeanRestaOperation;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.component.ComponentImplement;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	//Dependencias
	private final ComponentDependency componentDependency;
	private final MyBean myBean;

	private final MyBeanGenerateOperation myBeanGenerateOperation;
	private final MyBeanRestaOperation myBeanRestaOperation;
	private final MyBeanCatchProperties myBeanCatchProperties;
	private final UserPojo userPojo;

	private final UserRepository userRepository;

	public FundamentosApplication( @Qualifier("componenTwoImplement") ComponentDependency componentDependency, MyBean myBean,
								   MyBeanGenerateOperation myBeanGenerateOperation, MyBeanRestaOperation myBeanRestaOperation,
								   MyBeanCatchProperties myBeanCatchProperties, UserPojo userPojo, UserRepository userRepository) {
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanGenerateOperation = myBeanGenerateOperation;
		this.myBeanRestaOperation = myBeanRestaOperation;
		this.myBeanCatchProperties = myBeanCatchProperties;
		this.userPojo = userPojo;
		this.userRepository =userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}
	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		/*LOGGER.info("Usuario con el metodo findByUserEmail" +
				userRepository.findByUserEmail("julie@domain").orElseThrow(() -> new RuntimeException("No se encontro el usario")));

		userRepository.findAndSort("Perc", Sort.by("id").descending())
				.stream()
				.forEach(user -> LOGGER.info("Usario con el metodo sort" + user));

		userRepository.findByName("John")
				.stream()
				.forEach(user -> LOGGER.info("Usario con query method " + user));

		LOGGER.info("Usario con query mehod findByEmailAndName" + userRepository.findByEmailAndName("Daniela@domain", "Daniela")
				.orElseThrow(() ->  new RuntimeException("Usario no encontrado")));

		userRepository.findByNameLike("%J%")
				.stream()
				.forEach(user -> LOGGER.info("Usario findByNameLike" + user));

		userRepository.findByNameOrEmail(null, "Romanso@domain" )
				.stream()
				.forEach(user -> LOGGER.info("Usario fimdByNameOrEmail" + user));*/

		userRepository
				.findByBirthDateBetween(LocalDate.of(2021, 3, 1), LocalDate.of(2022, 4, 2))
				.stream()
				.forEach(user -> LOGGER.info("Usario con intervalo de fechas : "+ user));

		userRepository.findByNameContainingOrderByIdDesc("user")
				.stream()
				.forEach(user -> LOGGER.info("Usario encontrado de manera descendente: " + user));
	}

	private void saveUsersInDataBase(){
		User user1 = new User("John", "john@domain", LocalDate.of(2021, 05, 3));
		User user2 = new User("Julie", "julie@domain", LocalDate.of(2022, 04, 2));
		User user3 = new User("Daniela", "Daniela@domain", LocalDate.of(2023, 02, 4));
		User user4 = new User("Romanso", "Romanso@domain", LocalDate.of(2021, 03, 4));
		User user5 = new User("Percy", "Percy@domain", LocalDate.of(2022, 01, 9));
		User user6 = new User("Erick", "Erick@domain", LocalDate.of(2022, 07, 3));
		User user7 = new User("Stalin", "Stalin@domain", LocalDate.of(2022, 03, 1));
		User user8 = new User("Favian", "Favian@domain", LocalDate.of(2023, 02, 25));
		User user9 = new User("Rodrigo", "Rodrigo@domain", LocalDate.of(2021, 10, 23));
		User user10 = new User("Micaela", "Micaela@domain", LocalDate.of(2021, 12, 29));

		List<User> list = Arrays.asList(user1, user2,user3,user4, user5,user6,user7,user8,user9,user10);
		list.stream().forEach(userRepository::save);
	}
	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanGenerateOperation.printGenerateOperation();
		myBeanRestaOperation.printResOperation();
		System.out.println("=====>"+ myBeanCatchProperties.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getPassaword());
		try{
			int value = 10/0;
			LOGGER.debug("Mi valor : " + value);
			//error
		}catch (Exception e){
			LOGGER.error("Esto es un error al dividir  por cero " + e.getMessage());
		}
	}
}


