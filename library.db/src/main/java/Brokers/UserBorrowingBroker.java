package Brokers;

import Brokers.BorrowingBroker;
import Dtos.BorrowingDto;
import Entities.Borrowing;
import Entities.LoginData;

import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;

public class UserBorrowingBroker extends BorrowingBroker {

    private static String GET_USER = "SELECT b FROM Borrowing b JOIN b.user u JOIN u.loginData l " +
            "WHERE l.id = :dataId ";
    private static LoginData loginData;

    public UserBorrowingBroker(LoginData aLoginData) {
        loginData = aLoginData;
    }

    @Override
    public List<BorrowingDto> getAll() {

       Query query = entityManager.createQuery(GET_USER);
       query.setParameter("dataId",loginData.getId());
       List<Borrowing> borrowingList = query.getResultList();
       return borrowingList.stream()
               .map(BorrowingDto::new)
               .collect(Collectors.toList());
    }
}
