package library.controller;


import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	@FXML
	private Button editButton;
	@FXML 
	private Button deleteButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button newButton;
	
	
	
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
		
		TableColumn<BookDto,String> titleCol = new TableColumn("Title");
		titleCol.setCellValueFactory(value -> value.getValue().getTitle());
		
		TableColumn<BookDto,String> authorCol = new TableColumn("Author");
		authorCol.setCellValueFactory(value -> value.getValue().getAuthor());
		
		TableColumn<BookDto,String> isbnCol = new TableColumn("ISBN");
		isbnCol.setCellValueFactory(value -> value.getValue().getIsbn());
		
		TableColumn<BookDto,String> quantityCol = new TableColumn("Ilość");
		quantityCol.setCellValueFactory(value -> value.getValue().getQuantity());
		
		TableColumn<BookDto,String> yearCol = new TableColumn("Rok Wydania");
		yearCol.setCellValueFactory(value -> value.getValue().getYearOfPublication());
		
		TableColumn<BookDto,String> categoryCol = new TableColumn("Kategoria");
		categoryCol.setCellValueFactory(value -> value.getValue().getCategory());
		
		tableView.getColumns().clear();
		
		tableView.getColumns().addAll(idCol,titleCol,authorCol,isbnCol
				,quantityCol,yearCol,categoryCol);
		
		List<BookDto> books = bookBroker.getAllBooks();
		
		tableView.getItems().addAll(books);
	
	}
	
	private void initButtons()
	{
		editButton.setOnAction(clicked -> {
			tableView.getSelectionModel().getSelectedCells().
		});
	}
}
