package library.Login;


import Brokers.LoginDataBroker;
import Dtos.LoginDataDto;
import Entities.AccountType;
import Entities.LoginData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.NoResultException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;


public class LoginHelper {

    public final static String HASH_ALGORITHM = "SHA-256";
    private final static Logger logger = LogManager.getLogger(LoginHelper.class);
    private static LoginData loginData;


    public static boolean tryToLogin(String aLogin, byte[] aPassword) {
        try {
            LoginDataBroker dataBroker = new LoginDataBroker();
            loginData = dataBroker.checkLoginData(aLogin, aPassword);
        } catch (NoResultException aEx) {
            logger.debug(aEx);
            return false;
        }
        return true;
    }
    public String getCurrentUserLogin()
    {
        return loginData.getAccountName();
    }

    public AccountType getCurrentAccountType()
    {
        if(loginData == null) return AccountType.notLogged;
        else {
            return loginData.getType();
        }
    }

    public LoginData getLoginData()
    {
        return loginData;
    }

    public void changePassword(String aLogin,byte[] aNewPassword) throws NoResultException {
        LoginDataBroker dataBroker = new LoginDataBroker();
        dataBroker.changePassword(aLogin,aNewPassword);
    }

    /**
     *
     * @param oldPassword current password
     * @param newPassword new password
     * @return true if password is changed, false if something go wrong.
     */
    public boolean checkAndChangePassword(String oldPassword, String newPassword)
    {
        byte[] oldPasswordHash = createPasswordHash(oldPassword);
        if(Arrays.equals(oldPasswordHash,loginData.getPassword()))
        {
            changePassword(loginData.getAccountName(),createPasswordHash(newPassword));
            return true;
        }
        else return false;
    }

    public String getMail(String aLogin)
    {
        LoginDataBroker dataBroker = new LoginDataBroker();
        LoginData loginData = dataBroker.getAccount(aLogin);
        return loginData.getEmail();
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
        loginData = null;
    }

}
