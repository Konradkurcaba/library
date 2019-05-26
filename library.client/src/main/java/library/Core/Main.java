package library.Core;

import Entities.*;
import EntityManager.PersistenceManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import library.Controller.LoginPanelController;
import library.Login.LoginHelper;
import library.Validation.Dialog;

import javax.persistence.EntityManager;
import java.time.LocalDate;


public class Main extends Application {

	
	public static void main(String...aArgs)
	{
		dirtyCode();
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Dialog validator = new Dialog();
		FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
				.getResource("FXML/login.fxml"));
		
		Parent root = loader.load();
		primaryStage.setScene(new Scene(root));
		
		LoginPanelController controller = loader.getController();
		controller.init(primaryStage);
		Thread.setDefaultUncaughtExceptionHandler( (exThread,aException) ->
				validator.errorMessage(aException.getMessage()));
		primaryStage.show();
	}
	

	public static void dirtyCode()
	{

		LoginData loginData = new LoginData();
		loginData.setAccountName("admin");
		LoginHelper loginHelper = new LoginHelper();
		byte[] hash = loginHelper.createPasswordHash("password");
		loginData.setPassword(hash);

		Category category = new Category("Dla dzieci");
		Category category1 = new Category("Fantastyka");
		Category category2 = new Category("Kulinarne");



		Employee employee = new Employee();

		employee.setFirstName("Adrianna");
		employee.setLastName("Zolta");

		Employee employee1 = new Employee();
		employee1.setLastName("Borowiecki");
		employee1.setFirstName("Jan");

		User user = new User();
		user.setFirstName("Marcin");
		user.setLastName("Szymczok");


		User user2 = new User();
		user2.setFirstName("Kornel");
		user2.setLastName("Czuk");


		Borrowing borrowing = new Borrowing();
		borrowing.setEmployee(employee);
		borrowing.setUser(user);

		LocalDate startDate = LocalDate.now();
		LocalDate endDate = LocalDate.of(2019,07,01);

		borrowing.setStartBorrowDate(startDate);
		borrowing.setEndBorrowDate(endDate);


		EntityManager entityManager =  PersistenceManager.emf.createEntityManager();

		entityManager.getTransaction().begin();

//		entityManager.persist(employee);
//		entityManager.persist(employee1);
//		entityManager.persist(user);
//		entityManager.persist(user2);
//		entityManager.persist(borrowing);
		entityManager.persist(loginData);
		entityManager.persist(category);
		entityManager.persist(category1);
		entityManager.persist(category2);
		entityManager.getTransaction().commit();


	}
}
