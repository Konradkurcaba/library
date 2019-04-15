package library.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import java.awt.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LoginPanelController {

    @FXML
    TextField loginField;

    @FXML
    PasswordField passwordField;

    @FXML
    Button logButton;

    public void init()
    {
        logButton.addActionListener( event ->{
            String login = loginField.getText();
            String password = passwordField.getText();
            try {

                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] passwordHash = md.digest(password.getBytes());

            }catch (NoSuchAlgorithmException aEx)
            {
                aEx.printStackTrace();
            }

        });
    }


}
