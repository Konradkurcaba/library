package Brokers;

import Dtos.UserDto;
import Entities.LoginData;
import Entities.User;
import EntityManager.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

public class UserBroker implements BrokerIf<UserDto> {

    private final EntityManager entityManager;
    private final String GET_ALL_USERS_Q = "SELECT u FROM User u";
    private final String GET_ALL_EMAILS = "SELECT u.email FROM User u";

    public UserBroker() {
        entityManager = PersistenceManager.emf.createEntityManager();
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = entityManager.createQuery(GET_ALL_USERS_Q).getResultList();
        return users.stream()
            .map(UserDto::new)
            .collect(Collectors.toList());
    }

    @Override
    public void commitChanges(List<UserDto> aDtoList) {
        aDtoList.stream()
                .filter(userDto -> !userDto.isPersisted())
                .forEach(userDto -> {
                    User user = new User();
                    entityManager.persist(user);
                    userDto.setUser(user);
                    LoginData loginData = new LoginData();
                    entityManager.persist(loginData);
                    user.setLoginData(loginData);
                });

        aDtoList.stream()
                .forEach(UserDto::commitChanges);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(List<UserDto> aDtoList) {
        entityManager.getTransaction().begin();
        aDtoList.stream()
                .map(UserDto::getUser)
                .forEach(user ->{
                    entityManager.remove(user.getLoginData());
                    entityManager.remove(user);
                });
        entityManager.getTransaction().commit();
    }

    @Override
    public UserDto create() {
        return new UserDto();
    }

    public List<String> getAllEmails()
    {
        TypedQuery<String> typedQuery = entityManager.createQuery(GET_ALL_EMAILS,String.class);
        return typedQuery.getResultList();
    }
}
