package library.Core;

import javax.persistence.EntityManager;

import Entities.Category;
import Entities.LoginData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import library.Controller.BooksPanelController;
import EntityManager.PersistenceManager;
import library.Controller.LoginPanelController;
import library.Login.LoginHelper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main extends Application {

	
	public static void main(String...aArgs)
	{
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
				.getResource("FXML/login.fxml"));
		
		Parent root = loader.load();
		primaryStage.setScene(new Scene(root));
		
		LoginPanelController controller = loader.getController();
		controller.init();
		
		primaryStage.show();
	}
	

	public static void dirtyCode()
	{
		EntityManager entityManager =  PersistenceManager.emf.createEntityManager();
		Category cat = new Category("Dla dzieci");

		byte[] passwordHash = null;
		String password = "konrad123";
		try {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			passwordHash = md.digest(password.getBytes());


		}catch (NoSuchAlgorithmException aEx)
		{
			aEx.printStackTrace();
		}

		LoginData loginData = new LoginData();
		loginData.setAccountName("konrad");
		loginData.setPassword(passwordHash);


//		
		entityManager.getTransaction().begin();
		entityManager.persist(loginData);
		entityManager.persist(cat);
		entityManager.getTransaction().commit();
	}
}
