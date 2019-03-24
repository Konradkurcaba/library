package library.controller;


import java.util.ArrayList;
import java.util.List;

import Brokers.BookBroker;
import Dtos.BookDto;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;


public class BooksPanelController extends AbstractWindowTableController<BookDto>{
	
	private static String WINDOW_NAME = "Ksiązki";
	
	public BooksPanelController() {
		super(WINDOW_NAME);
		broker = new BookBroker();
	}
	
	@Override
	protected List<TableColumn<BookDto,String>> configureTableViewColumns()
	{
		
		List<TableColumn<BookDto,String>> columns = new ArrayList();
		
		TableColumn<BookDto,String> titleCol = new TableColumn("Title");
		titleCol.setCellValueFactory(value -> value.getValue().getTitle());
		titleCol.setCellFactory(TextFieldTableCell.forTableColumn());
		titleCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setTitle(event.getNewValue());
		});
		columns.add(titleCol);
		
		TableColumn<BookDto,String> authorCol = new TableColumn("Author");
		authorCol.setCellValueFactory(value -> value.getValue().getAuthor());
		authorCol.setCellFactory(TextFieldTableCell.forTableColumn());
		authorCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setAuthor(event.getNewValue());
		});
		
		columns.add(authorCol);
		
		TableColumn<BookDto,String> isbnCol = new TableColumn("ISBN");
		isbnCol.setCellValueFactory(value -> value.getValue().getIsbn());
		isbnCol.setCellFactory(TextFieldTableCell.forTableColumn());
		isbnCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setIsbn(event.getNewValue());
		});
		columns.add(isbnCol);
		
		TableColumn<BookDto,String> quantityCol = new TableColumn("Ilość");
		quantityCol.setCellValueFactory(value -> value.getValue().getQuantity());
		quantityCol.setCellFactory(TextFieldTableCell.forTableColumn());
		quantityCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setQuantity(event.getNewValue());
		});
		columns.add(quantityCol);
		
		TableColumn<BookDto,String> yearCol = new TableColumn("Rok Wydania");
		yearCol.setCellValueFactory(value -> value.getValue().getYearOfPublication());
		yearCol.setCellFactory(TextFieldTableCell.forTableColumn());
		yearCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setYearOfPublication(event.getNewValue());
		});
		
		columns.add(yearCol);
		
		TableColumn<BookDto,String> categoryCol = new TableColumn("Kategoria");
		categoryCol.setCellValueFactory(value -> value.getValue().getCategory());
		categoryCol.setCellFactory(TextFieldTableCell.forTableColumn());
		categoryCol.setOnEditCommit( event ->{
			event.getTableView().getItems()
			.get(event.getTablePosition().getRow())
			.setCategory(event.getNewValue());
		});
		
		columns.add(categoryCol);

		return columns;
	
	}
	
}
