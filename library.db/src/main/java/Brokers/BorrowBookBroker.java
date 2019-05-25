package Brokers;

import Dtos.BookDto;
import Dtos.BorrowingDto;

import java.util.List;
import java.util.stream.Collectors;

public class BorrowBookBroker implements BrokerIf<BookDto> {

    private BorrowingDto borrowingDto;

    public BorrowBookBroker(BorrowingDto borrowingDto) {
        this.borrowingDto = borrowingDto;
    }

    @Override
    public List<BookDto> getAll() {
        return borrowingDto.getBooks().stream()
                .map(BookDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public void commitChanges(List<BookDto> aDtoList) {

    }

    @Override
    public void delete(List<BookDto> aDtoList) {
        aDtoList.stream()
                .map(BookDto::getBook)
                .forEach(book -> borrowingDto.getBooks().remove(book));
    }

    @Override
    public BookDto create() {
        return null;
    }
}
