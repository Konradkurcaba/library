package Brokers;

import Dtos.LoginDataDto;
import Entities.LoginData;
import javassist.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import EntityManager.PersistenceManager;
import org.hibernate.annotations.common.util.impl.Log;

public class LoginDataBroker {


    private static Logger logger = LogManager.getLogger(LoginDataBroker.class);
    private static String CHECK_ACCOUNT = "SELECT l FROM LoginData l where l.accountName = :login AND " +
            "l.password = :password";
    private static String GET_ACCOUNT = "SELECT l from LoginData l where l.accountName = :login";

    private EntityManager entityManager = PersistenceManager.emf.createEntityManager();

    public LoginDataDto checkLoginData(String aLogin, byte[] aPassword)
    {
        logger.debug("Trying to login on account: " + aLogin);
        TypedQuery<LoginData> query = entityManager.createQuery(CHECK_ACCOUNT, LoginData.class);
        query.setParameter("login", aLogin);
        query.setParameter("password",aPassword);

        try
        {
             LoginData loginData = query.getSingleResult();
             return new LoginDataDto(loginData);
        }catch (NoResultException aEx)
        {
            logger.debug("Cannot login - account doesn't exist");
            throw aEx;
        }
    }

    public void changePassword(String aLogin,byte[] aNewPassword) throws NoResultException
    {
        TypedQuery<LoginData> query = entityManager.createQuery(GET_ACCOUNT,LoginData.class);
        query.setParameter("login",aLogin);

        LoginData loginData = query.getSingleResult();
        loginData.setPassword(aNewPassword);
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();

    }

    public LoginData getAccount(String aLogin) throws NoResultException
    {
        logger.debug("Trying to login on account: " + aLogin);
        TypedQuery<LoginData> query = entityManager.createQuery(GET_ACCOUNT, LoginData.class);
        query.setParameter("login", aLogin);

        try
        {
            LoginData loginData = query.getSingleResult();
            return loginData;
        }catch (NoResultException aEx)
        {
            logger.debug("Cannot login - account doesn't exist");
            throw aEx;
        }
    }



}
