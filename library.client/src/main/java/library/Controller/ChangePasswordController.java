package library.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library.Login.LoginHelper;
import library.Validation.Dialog;


public class ChangePasswordController {

    public static final String FXML_PATH = "FXML/changepassword.fxml";

    @FXML
    private TextField oldPasswordTextField;

    @FXML
    private TextField newPasswordTextField;

    @FXML
    private TextField repeatedPasswordTextField;

    @FXML
    private Button confirmButton;

    private Dialog infoDialog = new Dialog();

    @FXML
    private void initialize()
    {
        confirmButton.setOnAction( event ->{

            String oldPassword = oldPasswordTextField.getText();
            String newPassword = newPasswordTextField.getText();
            String repeatedPassword = repeatedPasswordTextField.getText();

            if(oldPassword.length() < 1 || newPassword.length() < 1 || repeatedPassword.length() < 1)
            {
                infoDialog.errorMessage("Musisz wypełnić wszystkie pola");
                return;
            }

            if(!newPassword.equals(repeatedPassword))
            {
                infoDialog.errorMessage("Wpisane wartości nie są takie same !");
                return;
            }

            if(newPassword.length()<8)
            {
                infoDialog.errorMessage("Hasło musi mieć minumum 8 znaków");
                return;
            }

            LoginHelper loginHelper = new LoginHelper();
            boolean success = loginHelper.checkAndChangePassword(oldPassword,newPassword);

            if(success)
            {
                infoDialog.infoMessage("Pomyslnie zmieniono hasło");
            }else
            {
                infoDialog.errorMessage("Nie udało się zmienić hasłą");
            }

        });
    }



}
