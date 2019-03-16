package library.controller;


import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.TextFieldTableCell;
import library.broker.BookBroker;
import library.broker.Broker;
import library.entities.Book;
import library.dto.BookDto;

public class BooksPanelController extends AbstractWindowTableController<BookDto>{
	
	private static String WINDOW_NAME = "Ksiązki";
	public BooksPanelController() {
		super(WINDOW_NAME);
		broker = new BookBroker();
	}
	
	@Override
	protected void initTableView()
	{
		TableColumn<BookDto,String> idCol = new TableColumn("ID");
		idCol.setCellValueFactory(value -> value.getValue().getId());
		
		TableColumn<BookDto,String> titleCol = new TableColumn("Title");
		titleCol.setCellValueFactory(value -> value.getValue().getTitle());
		titleCol.setCellFactory(TextFieldTableCell.forTableColumn());
		titleCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setTitle(event.getNewValue());
		});
		
		TableColumn<BookDto,String> authorCol = new TableColumn("Author");
		authorCol.setCellValueFactory(value -> value.getValue().getAuthor());
		authorCol.setCellFactory(TextFieldTableCell.forTableColumn());
		authorCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setAuthor(event.getNewValue());
		});
		
		TableColumn<BookDto,String> isbnCol = new TableColumn("ISBN");
		isbnCol.setCellValueFactory(value -> value.getValue().getIsbn());
		isbnCol.setCellFactory(TextFieldTableCell.forTableColumn());
		isbnCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setIsbn(event.getNewValue());
		});
		
		TableColumn<BookDto,String> quantityCol = new TableColumn("Ilość");
		quantityCol.setCellValueFactory(value -> value.getValue().getQuantity());
		quantityCol.setCellFactory(TextFieldTableCell.forTableColumn());
		quantityCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setQuantity(event.getNewValue());
		});
		
		TableColumn<BookDto,String> yearCol = new TableColumn("Rok Wydania");
		yearCol.setCellValueFactory(value -> value.getValue().getYearOfPublication());
		yearCol.setCellFactory(TextFieldTableCell.forTableColumn());
		yearCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setYearOfPublication(event.getNewValue());
		});
		
		TableColumn<BookDto,String> categoryCol = new TableColumn("Kategoria");
		categoryCol.setCellValueFactory(value -> value.getValue().getCategory());
		categoryCol.setCellFactory(TextFieldTableCell.forTableColumn());
		categoryCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setCategory(event.getNewValue());
		});
		
		
		tableView.getColumns().clear();
		
		tableView.getColumns().addAll(idCol,titleCol,authorCol,isbnCol
				,quantityCol,yearCol,categoryCol);
		
		List<BookDto> books = broker.getAll();
		
		tableView.getItems().addAll(books);
	
	}
	
}
