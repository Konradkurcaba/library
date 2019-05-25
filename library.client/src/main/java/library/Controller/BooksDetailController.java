package library.Controller;

import Brokers.BookBroker;
import Brokers.BorrowBookBroker;
import Dtos.*;
import javafx.scene.control.TableColumn;
import library.FakeDto.BookRowFakeDto;
import library.Controls.LibraryContentAssist;

import java.util.ArrayList;
import java.util.List;

public class BooksDetailController extends AbstractWindowTableController{

    public BooksDetailController(String aWindowTitle,BorrowingDto aBorrow) {
        super(aWindowTitle);
        broker = new BorrowBookBroker(aBorrow);
    }

    @Override
    protected List configureTableViewColumns() {

        List<TableColumn<BookRowFakeDto,BookDto>> columns = new ArrayList();

        TableColumn<BookRowFakeDto, BookDto> bookColumn =
                LibraryContentAssist.getCaColumn("Pracownik",new BookBroker(), DtoType.Book);
        columns.add(bookColumn);

        return columns;
    }


}
