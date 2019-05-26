package library.Controller;

import Email.EmailSender;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import library.Login.LoginHelper;
import library.Validation.Dialog;

import javax.mail.MessagingException;
import javax.persistence.NoResultException;
import java.io.IOException;
import java.util.Random;


public class RemindPasswordController {

    public static final String REMIND_FXML = "FXML/resetpassword.fxml";

    @FXML
    private TextField loginTextField;

    @FXML
    private Button sendButton;

    @FXML
    private void initialize()
    {
        sendButton.setOnAction( event -> {
            String login = loginTextField.getText();
            if(login != null )
            {
                remindPassword(login);
                Dialog validator = new Dialog();
                validator.errorMessage("Nowe hasło zostało wysłane");
            }
        });
    }


    private void remindPassword(String aLogin)
    {
        try {
            LoginHelper loginHelper = new LoginHelper();
            String newPassword = generateRandomPassword();
            byte[] newPasswordHash = loginHelper.createPasswordHash(newPassword);
            LoginHelper helper = new LoginHelper();
            helper.changePassword(aLogin, newPasswordHash);
            sendEmailWithNewPassword(aLogin,newPassword);
        }catch (NoResultException aEx)
        {
            Dialog validator = new Dialog();
            validator.errorMessage("Login nie istnieje");
        }catch (IOException | MessagingException aEx)
        {
            Dialog validator = new Dialog();
            validator.errorMessage("Błąd podczas wysyłania wiadomości");
        }

    }
    private void sendEmailWithNewPassword(String aLogin,String aNewPassword)
            throws IOException, MessagingException {
        EmailSender emailSender = new EmailSender();
        LoginHelper loginHelper = new LoginHelper();
        String eMail = loginHelper.getMail(aLogin);
        emailSender.sendMail(eMail,"Nowe haslo",aNewPassword);

    }

    private String generateRandomPassword() {

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 12;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }


}
