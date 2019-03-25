package Brokers;

import Dtos.UserDto;
import Entities.User;
import EntityManager.PersistenceManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class UserBroker implements BrokerIf<UserDto> {

    private final EntityManager entityManager;
    private final String GET_ALL_USERS_Q = "SELECT u FROM User u";

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

    }

    @Override
    public void delete(List<UserDto> aDtoList) {

    }

    @Override
    public UserDto create() {
        return null;
    }

    //todo 
    public List<String> getAllEmails()
    {
        return null;
    }
}
