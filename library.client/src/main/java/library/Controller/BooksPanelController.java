package library.Controller;


import java.util.ArrayList;
import java.util.List;

import Brokers.BookBroker;
import Brokers.CategoryBroker;
import Dtos.BookDto;
import Dtos.CategoryDto;
import Dtos.DtoType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import library.Controls.LibraryContentAssist;


public class BooksPanelController extends AbstractWindowTableController<BookDto>{
	
	private static String WINDOW_NAME = "Książki";
	
	public BooksPanelController() {
		super(WINDOW_NAME);
		broker = new BookBroker();
	}
	
	@Override
	protected List<TableColumn<BookDto,String>> configureTableViewColumns()
	{
		
		List<TableColumn<BookDto,String>> columns = new ArrayList();
		
		TableColumn<BookDto,String> titleCol = new TableColumn("Tytuł");
		titleCol.setCellValueFactory(value -> value.getValue().getTitle());
		titleCol.setCellFactory(TextFieldTableCell.forTableColumn());
		titleCol.setOnEditCommit( event -> {
				event.getTableView().getItems()
						.get(event.getTablePosition().getRow())
						.setTitle(event.getNewValue());
			});

		columns.add(titleCol);
		
		TableColumn<BookDto,String> authorCol = new TableColumn("Autor");
		authorCol.setCellValueFactory(value -> value.getValue().getAuthor());
		authorCol.setCellFactory(TextFieldTableCell.forTableColumn());
		authorCol.setOnEditCommit( event ->
				event.getTableView().getItems()
				.get(event.getTablePosition().getRow())
				.setAuthor(event.getNewValue()));
		columns.add(authorCol);
		
		TableColumn<BookDto,String> isbnCol = new TableColumn("ISBN");
		isbnCol.setCellValueFactory(value -> value.getValue().getIsbn());
		isbnCol.setCellFactory(TextFieldTableCell.forTableColumn());
		isbnCol.setOnEditCommit( event ->
				event.getTableView().getItems()
				.get(event.getTablePosition().getRow())
				.setIsbn(event.getNewValue()));
		columns.add(isbnCol);
		
		TableColumn<BookDto,String> quantityCol = new TableColumn("Ilość");
		quantityCol.setCellValueFactory(value -> value.getValue().getQuantity());
		quantityCol.setCellFactory(TextFieldTableCell.forTableColumn());
		quantityCol.setOnEditCommit( event ->
				event.getTableView().getItems()
				.get(event.getTablePosition().getRow())
				.setQuantity(event.getNewValue()));
		columns.add(quantityCol);
		
		TableColumn<BookDto,String> yearCol = new TableColumn("Rok wydania");
		yearCol.setCellValueFactory(value -> value.getValue().getYearOfPublication());
		yearCol.setCellFactory(TextFieldTableCell.forTableColumn());
		yearCol.setOnEditCommit( event ->
				event.getTableView().getItems()
				.get(event.getTablePosition().getRow())
				.setYearOfPublication(event.getNewValue()));
		columns.add(yearCol);

		TableColumn categoryColumn =
		LibraryContentAssist.getCaColumn("Kategoria",new CategoryBroker()
				, DtoType.Category,false);

		columns.add(categoryColumn);
		return columns;
	
	}
	
}
