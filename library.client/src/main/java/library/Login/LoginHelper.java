package library.Login;


import Brokers.LoginDataBroker;
import Dtos.LoginDataDto;
import Entities.AccountType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.NoResultException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class LoginHelper {

    public final static String HASH_ALGORITHM = "SHA-256";
    private final static Logger logger = LogManager.getLogger(LoginHelper.class);
    private static LoginDataDto loginDataDto;


    public static boolean tryToLogin(String aLogin, byte[] aPassword) {
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
        if(loginDataDto == null) return AccountType.notLogged;
        else {
            return loginDataDto.getType();
        }
    }

    public byte[] createPasswordHash(String aPassword)
    {
        byte[] passwordHash = null;

        try {

            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            passwordHash = md.digest(aPassword.getBytes());


        }catch (NoSuchAlgorithmException aEx)
        {
            aEx.printStackTrace();
            logger.debug("Hash algorithm : " + HASH_ALGORITHM + " doesn't exist");
        }
        return passwordHash;
    }

    public static void logout()
    {
        loginDataDto = null;
    }

}
