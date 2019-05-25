package library.Validation;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Validator {

    public void errorMessage(String text){
        Notifications error = Notifications.create()
                .title("Błąd!")
                .position(Pos.CENTER)
                .hideAfter(Duration.seconds(10))
                .text(text);
        error.showError();
    }
}
