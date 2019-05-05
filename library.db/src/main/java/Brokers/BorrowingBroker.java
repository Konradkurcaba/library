package Brokers;

import Dtos.BorrowingDto;
import Entities.Borrowing;
import EntityManager.PersistenceManager;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowingBroker implements BrokerIf<BorrowingDto> {

    private EntityManager entityManager = PersistenceManager.emf.createEntityManager();
    private static String GET_ALL = "SELECT b FROM Borrowing b";

    @Override
    public List<BorrowingDto> getAll() {
        List<Borrowing> resultList = entityManager.createQuery(GET_ALL).getResultList();
        return resultList
                .stream()
                .map(BorrowingDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void commitChanges(List<BorrowingDto> aDtoList) {

        aDtoList.stream()
                .filter(dto -> !dto.isPersisted())
                .forEach(dto ->{
                    Borrowing borrowing = new Borrowing();
                    entityManager.persist(borrowing);
                    dto.setBorrowing(borrowing);
                });


        aDtoList.stream()
                .forEach(BorrowingDto::commitChanges);

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();


    }

    @Override
    public void delete(List<BorrowingDto> aDtoList) {

        aDtoList.stream()
                .map(BorrowingDto::getBorrowing)
                .forEach(entityManager::remove);
    }

    @Override
    public BorrowingDto create() {
        return new BorrowingDto();
    }
}
