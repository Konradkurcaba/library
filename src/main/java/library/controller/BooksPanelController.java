package library.controller;


import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import library.broker.BookBroker;
import library.entities.Book;
import library.dto.BookDto;

public class BooksPanelController {
	private String WINDOW_TITLE = "Książki";
	
	@FXML
	private Label windowLabel;
	@FXML
	private TableView tableView;
	
	private BookBroker bookBroker = new BookBroker();
	
	public void init()
	{
		windowLabel.setText(WINDOW_TITLE);
		initTableView();
	}
		
	private void initTableView()
	{
		TableColumn<BookDto,String> idCol = new TableColumn("ID");
		idCol.setCellValueFactory(value -> value.getValue().getId());
		
		
		TableColumn titleCol = new TableColumn("Title");
		TableColumn authorCol = new TableColumn("Author");
		TableColumn isbnCol = new TableColumn("ISBN");
		TableColumn quantityCol = new TableColumn("Ilość");
		TableColumn yearCol = new TableColumn("Rok Wydania");
		TableColumn categoryCol = new TableColumn("Kategoria");
		
		tableView.getColumns().addAll(idCol,titleCol,authorCol,isbnCol
				,quantityCol,yearCol,categoryCol);
		
		List<BookDto> books = bookBroker.getAllBooks();
		
		tableView.getItems().addAll(books);
	
	}
}
