package library.Validation;

import javafx.geometry.Pos;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class Dialog {

    public void errorMessage(String text){
        if(!text.isEmpty()) {
            Notifications error = Notifications.create()
                    .title("Błąd!")
                    .position(Pos.CENTER)
                    .hideAfter(Duration.seconds(10))
                    .text(text);
            error.showError();
        }
    }

    public void infoMessage(String text)
    {
        if(!text.isEmpty()) {
            Notifications info = Notifications.create()
                    .title("Info!")
                    .position(Pos.CENTER)
                    .hideAfter(Duration.seconds(10))
                    .text(text);
            info.showInformation();
        }
    }
}
