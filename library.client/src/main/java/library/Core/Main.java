package library.Core;

import Entities.Borrowing;
import Entities.Employee;
import EntityManager.PersistenceManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import library.Controller.LoginPanelController;

import javax.persistence.EntityManager;


public class Main extends Application {

	
	public static void main(String...aArgs)
	{
		dirtyCode();
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
				.getResource("FXML/login.fxml"));
		
		Parent root = loader.load();
		primaryStage.setScene(new Scene(root));
		
		LoginPanelController controller = loader.getController();
		controller.init(primaryStage);
		
		primaryStage.show();
	}
	

	public static void dirtyCode()
	{

		Borrowing borrowing = new Borrowing();
		Employee employee = new Employee();

		employee.setFirstName("Adrianna");
		employee.setLastName("Zolta");

		borrowing.setEmployee(employee);



		EntityManager entityManager =  PersistenceManager.emf.createEntityManager();
//		Category cat = new Category("Dla dzieci");
//
//		byte[] passwordHash = null;
//		String password = "konrad123";
//		try {
//
//			MessageDigest md = MessageDigest.getInstance("SHA-256");
//			passwordHash = md.digest(password.getBytes());
//
//
//		}catch (NoSuchAlgorithmException aEx)
//		{
//			aEx.printStackTrace();
//		}
//
//		LoginData loginData = new LoginData();
//		loginData.setAccountName("konrad");
//		loginData.setPassword(passwordHash);
//
//
////
		entityManager.getTransaction().begin();
//		entityManager.persist(loginData);
//		entityManager.persist(cat);
		entityManager.persist(employee);
		entityManager.persist(borrowing);
		entityManager.getTransaction().commit();

//		UserBroker userBroker = new UserBroker();
//		System.out.println(userBroker.getAllEmails().toString());
	}
}
