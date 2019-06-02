package library.Controller;

import Email.EmailSender;
import Email.MailCreator;
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

import javax.mail.MessagingException;
import java.io.IOException;

public class AdminMenuController extends EmployeeMenuController {

    public final static String ADMIN_MENU_FXML_PATH = "FXML/adminMenu.fxml";

    @FXML
    private Button employeeButton;

    @FXML
    private Button emailButton;

    public void init(Stage aPrimaryStage) {
        super.init(aPrimaryStage);
        employeeButton.setOnAction(event -> {
            EmployeePanelController controller = new EmployeePanelController();
            openNewWindow(controller);
        });
        emailButton.setOnAction( event -> {
            try {
                EmailSender sender = new EmailSender();
                MailCreator mailCreator = new MailCreator();
                String mailBody = mailCreator.getMailBody();
                sender.sendMail("konradkurcaba@gmail.com","New Books!", mailBody);
            }catch (IOException | MessagingException aEx)
            {
                aEx.printStackTrace();
            }

        });
    }
}
