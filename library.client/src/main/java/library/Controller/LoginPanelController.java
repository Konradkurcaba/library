package library.Controller;

import Entities.AccountType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import library.Login.LoginHelper;
import library.Validation.Dialog;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginPanelController {

    private final static Logger logger = LogManager.getLogger(LoginPanelController.class);
    private final static String HASH_ALGORITHM = "SHA-256";
    public final static String LOGIN_PANEL_FXML_PATH = "FXML/login.fxml";


    private Dialog validator = new Dialog();

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginButton;

    @FXML
    private Button remindPasswordButton;

    private Stage primaryStage;

    public void init(Stage aPrimaryStage)
    {
        primaryStage = aPrimaryStage;
        loginButton.setOnAction( event ->{
            String login = loginField.getText();
            String password = passwordField.getText();
            if( (!login.isEmpty() && login !=null) && (!password.isEmpty() && password != null)){
                try {

                    MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
                    byte[] passwordHash = md.digest(password.getBytes());

                    LoginHelper loginHelper = new LoginHelper();
                    boolean loginSuccess = loginHelper.tryToLogin(login,passwordHash);
                    if(loginSuccess)
                    {
                        AccountType accountType = loginHelper.getCurrentAccountType();
                        openMainMenu(accountType);
                    }
                    else{
                        validator.errorMessage("Niepoprawne dane logowania! Spróbuj ponownie");
                    }

                }catch (NoSuchAlgorithmException aEx)
                {
                    aEx.printStackTrace();
                    logger.debug("Hash algorithm : " + HASH_ALGORITHM + " doesn't exist");
                }
            }
            else{
                validator.errorMessage("Brak loginu/hasła! Spróbuj ponownie.");
            }
        });

        remindPasswordButton.setOnAction(event -> {
            openRemindPanel();
        });
    }

    private void openRemindPanel()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
                    .getResource(RemindPasswordController.REMIND_FXML));
            Stage newWindowStage = new Stage();
            newWindowStage.initModality(Modality.WINDOW_MODAL);
            newWindowStage.initOwner(primaryStage);

            Parent root = loader.load();
            newWindowStage.setScene(new Scene(root));
            newWindowStage.showAndWait();
        }
        catch (IOException aEx )
        {
            logger.debug(aEx);
        }
    }

    private void openMainMenu(AccountType aAccountType)
    {
        try {

            FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
                    .getResource(MenuController.ADMIN_MENU_FXML_PATH));

            Parent root = loader.load();
            primaryStage.setScene(new Scene(root));

            MenuController controller = loader.getController();
            controller.init(primaryStage);

        }catch (Exception aEx)
        {
            logger.debug(aEx);
        }
    }


}
