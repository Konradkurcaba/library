package library.Login;


import Brokers.LoginDataBroker;
import Dtos.LoginDataDto;
import Entities.AccountType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.NoResultException;


public class LoginHelper {

    private final static Logger logger = LogManager.getLogger(LoginHelper.class);
    private static LoginDataDto loginDataDto;

    public boolean tryToLogin(String aLogin, byte[] aPassword) {
        try {
            LoginDataBroker dataBroker = new LoginDataBroker();
            loginDataDto = dataBroker.checkLoginData(aLogin, aPassword);
        } catch (NoResultException aEx) {
            logger.debug(aEx);
            return false;
        }
        return true;
    }
    public String getCurrentUserLogin()
    {
        return loginDataDto.getAccountName();
    }

    public AccountType getCurrentAccountType()
    {
        return loginDataDto.getType();
    }

}
