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

public class EmployeeMenuController extends UserMenuController{

    @FXML
    public static final String FXML_PATH = "FXML/employeeMenu.fxml";

    @FXML
    private Button userButton;

    private static final Logger logger = LogManager.getLogger(EmployeeMenuController.class);

    @Override
    public void init(Stage aPrimaryStage)
    {
        super.init(aPrimaryStage);
        userButton.setOnAction(event -> {
            UserPanelController controller = new UserPanelController();
            openNewWindow(controller);
        });

        borrowButton.setOnAction(event -> {
            BorrowingPanelController controller = new BorrowingPanelController();
            openNewWindow(controller);
        });

    }

    protected void openNewWindow(AbstractWindowTableController aController)
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
            aController.init(true);
            newWindowStage.setScene(new Scene(root));
            newWindowStage.showAndWait();
        }
        catch (IOException aEx )
        {
            logger.debug(aEx);
        }
    }

}
