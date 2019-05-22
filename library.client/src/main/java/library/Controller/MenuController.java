package library.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MenuController {

    private final static Logger logger = LogManager.getLogger();

    @FXML
    private Button booksButton;
    @FXML
    private Button borrowButton;
    @FXML
    private Button userButton;

    private Stage primaryStage;

    private final static String FXML_PATH = "FXML/books.fxml";

    public void init(Stage aPrimaryStage)
    {
        primaryStage = aPrimaryStage;

        booksButton.setOnAction(event -> {
            BooksPanelController controller = new BooksPanelController();
            openNewWindow(controller);
        });

        borrowButton.setOnAction(event -> {
            BorrowingPanelController controller = new BorrowingPanelController();
            openNewWindow(controller);
        });
        userButton.setOnAction(event -> {
            UserPanelController controller = new UserPanelController();
            openNewWindow(controller);
        });

    }

    private void openNewWindow(AbstractWindowTableController aController)
    {
        try
        {
            Stage newWindowStage = new Stage();
            newWindowStage.initModality(Modality.WINDOW_MODAL);
            newWindowStage.initOwner(primaryStage);
            FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
                    .getResource(FXML_PATH));
            loader.setController(aController);
            Parent root = loader.load();
            aController.init();
            newWindowStage.setScene(new Scene(root));
            newWindowStage.showAndWait();
        }
        catch (IOException | RuntimeException aEx  )
        {
            logger.debug(aEx);
        }
    }
}
