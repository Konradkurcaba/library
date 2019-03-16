package library.core;

import java.time.Year;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.jboss.jandex.TypeTarget.Usage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import library.controller.BooksPanelController;
import library.entities.Book;
import library.entities.Category;


public class Main extends Application {

	
	public static void main(String...aArgs)
	{
		dirtyCode();
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
				.getResource("FXML/books.fxml"));
		
		Parent root = loader.load();
		primaryStage.setScene(new Scene(root));
		
		BooksPanelController controller = loader.getController();
		controller.init();
		
		
		primaryStage.show();
	}
	

	public static void dirtyCode()
	{
		EntityManager entityManager =  Constants.emf.createEntityManager();
		Category cat = new Category("Dla dzieci");
		
		Book book = new Book();
		book.setTitle("O Psie który jeżdził koleją");
		book.setCategory(cat);
		book.setAuthor("Andrzej Plebs");
		book.setQuantity(11);
		book.setIsbn("5454545fddff");
		book.setYearOfPublication(Year.of(1995));
		
		entityManager.getTransaction().begin();
		entityManager.persist(book);
		entityManager.persist(cat);
		entityManager.getTransaction().commit();
	}
}
