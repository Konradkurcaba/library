package library.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import library.Login.LoginHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginPanelController {

    private final static Logger logger = LogManager.getLogger(LoginPanelController.class);
    private final static String HASH_ALGORITHM = "SHA-256";

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    Button loginButton;

    public void init()
    {
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
                    System.out.println("success");
                }

            }catch (NoSuchAlgorithmException aEx)
            {
                aEx.printStackTrace();
                logger.debug("Hash algorithm : " + HASH_ALGORITHM + " doesn't exist");
            }

        });
    }


}
