package library.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import library.Login.LoginHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class MenuController {

    private final static Logger logger = LogManager.getLogger();

    public final static String MENU_FXML_PATH = "FXML/menu.fxml";

    @FXML
    private Button booksButton;
    @FXML
    private Button borrowButton;
    @FXML
    private Button userButton;
    @FXML
    private Button logOutButton;

    private Stage primaryStage;



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

        logOutButton.setOnAction(event ->{
            logOut();
        });

    }

    private void openNewWindow(AbstractWindowTableController aController)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
                    .getResource(AbstractWindowTableController.FXML_PATH));
            Stage newWindowStage = new Stage();
            newWindowStage.initModality(Modality.WINDOW_MODAL);
            newWindowStage.initOwner(primaryStage);
            loader.setController(aController);
            Parent root = loader.load();
            aController.init();
            newWindowStage.setScene(new Scene(root));
            newWindowStage.showAndWait();
        }
        catch (IOException aEx )
        {
            logger.debug(aEx);
        }
    }

    private void logOut()
    {
        try
        {
            LoginHelper.logout();
            FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
                    .getResource(LoginPanelController.LOGIN_PANEL_FXML_PATH));

            Parent root = loader.load();
            LoginPanelController controller = loader.getController();
            controller.init(primaryStage);
            primaryStage.setScene(new Scene(root));
        }
        catch (IOException aEx )
        {
            logger.debug(aEx);
        }
    }



}
