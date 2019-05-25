package Brokers;

import Dtos.BookDto;
import Dtos.BorrowingDto;
import EntityManager.PersistenceManager;
import library.FakeDto.BookRowFakeDto;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

public class BorrowBookBroker implements BrokerIf<BookRowFakeDto> {

    private BorrowingDto borrowingDto;

    public BorrowBookBroker(BorrowingDto borrowingDto) {
        this.borrowingDto = borrowingDto;
    }

    @Override
    public List<BookRowFakeDto> getAll() {
        return borrowingDto.getBooks().stream()
                .map(BookDto::new)
                .map(BookRowFakeDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void commitChanges(List<BookRowFakeDto> aDtoList) {
        aDtoList.stream()
                .map(BookRowFakeDto::getBookDto)
                .map(BookDto::getBook)
                .forEach(bookDto ->{borrowingDto.getBooks().add(bookDto);});

        EntityManager entityManager = PersistenceManager.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(List<BookRowFakeDto> aDtoList) {
        aDtoList.stream()
                .map(BookRowFakeDto::getBookDto)
                .map(BookDto::getBook)
                .forEach(book -> borrowingDto.getBooks().remove(book));

        EntityManager entityManager = PersistenceManager.emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }

    @Override
    public BookRowFakeDto create() {
        return new BookRowFakeDto();
    }
}
