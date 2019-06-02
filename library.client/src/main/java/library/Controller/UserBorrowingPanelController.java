package library.Controller;

import Entities.LoginData;
import Brokers.UserBorrowingBroker;

public class UserBorrowingPanelController extends BorrowingPanelController {

    public UserBorrowingPanelController(LoginData aLogin) {
        super();
        broker = new UserBorrowingBroker(aLogin);
    }
}
