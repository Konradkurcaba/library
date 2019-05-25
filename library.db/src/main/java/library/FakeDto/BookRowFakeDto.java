package library.FakeDto;

import Dtos.BookDto;
import Dtos.DtoCaValue;
import Dtos.DtoType;
import Dtos.DtoWithCa;

public class BookRowFakeDto implements DtoWithCa {

    private BookDto bookDto;

    public BookRowFakeDto() {
    }

    public BookRowFakeDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    @Override
    public DtoCaValue getCaValue(DtoType aExpectedDto) {
        if (bookDto != null)
        {
            return bookDto;
        }
        else return new DtoCaValue() {
            @Override
            public String getCaName() {
                return "";
            }
        };
    }

    @Override
    public void setCaValue(DtoCaValue aNewDtoValue) {
        if(aNewDtoValue instanceof BookDto) bookDto = (BookDto) aNewDtoValue;
    }

    public BookDto getBookDto() {
        return bookDto;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }
}
