package library.Controller;

import Entities.AccountType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import library.Login.LoginHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginPanelController {

    private final static Logger logger = LogManager.getLogger(LoginPanelController.class);
    private final static String HASH_ALGORITHM = "SHA-256";

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    private Stage primaryStage;


    public void init(Stage aPrimaryStage)
    {
        primaryStage = aPrimaryStage;
        loginButton.setOnAction( event ->{
            String login = loginField.getText();
            String password = passwordField.getText();
            try {

                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] passwordHash = md.digest(password.getBytes());

                LoginHelper loginHelper = new LoginHelper();
                boolean loginSuccess = loginHelper.tryToLogin(login,passwordHash);
                if(loginSuccess)
                {
                    AccountType accountType = loginHelper.getCurrentAccountType();
                    openMainMenu(accountType);
                }

            }catch (NoSuchAlgorithmException aEx)
            {
                aEx.printStackTrace();
                logger.debug("Hash algorithm : " + HASH_ALGORITHM + " doesn't exist");
            }

        });
    }

    private void openMainMenu(AccountType aAccountType)
    {
        try {

            FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
                    .getResource("FXML/menu_employee.fxml"));

            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));

        EmplMenuController controller = loader.getController();

        //primaryStage.show();
        }catch (Exception aEx)
        {
            logger.debug(aEx);
        }
    }


}
