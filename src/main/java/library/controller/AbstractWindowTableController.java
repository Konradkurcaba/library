package library.controller;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import library.broker.BrokerIf;
import library.dto.BookDto;

public abstract class AbstractWindowTableController<T> {

	private String windowTitle;
	protected BrokerIf<T> broker;
	
	public AbstractWindowTableController(String aWindowTitle) {
		super();
		windowTitle = aWindowTitle;
	}
	@FXML
	private Label windowLabel;
	@FXML
	private TableView<T> tableView;
	@FXML
	private Button onEditButton;
	@FXML
	private Button saveButton;
	@FXML
	private Button deleteButton;
	@FXML
	private Button newButton;
	
	protected abstract List<TableColumn<T,String>> configureTableViewColumns();
	
	public void init()
	{
		windowLabel.setText(windowTitle);
		configureTableView();
		configureTableViewColumns();
		initButtons();
	}
	
	protected void configureTableView()
	{
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		tableView.getColumns().clear();
		tableView.getColumns().addAll(configureTableViewColumns());
		List<T> books = broker.getAll();
		tableView.getItems().addAll(books);
	}
	
	protected void initButtons()
	{
		saveButton.setDisable(true);
		
		onEditButton.setOnAction(clicked -> {
			tableView.setEditable(true);
			onEditButton.setDisable(true);
			saveButton.setDisable(false);
		});
		
		saveButton.setOnAction(clicked -> {
			tableView.setEditable(false);
			onEditButton.setDisable(false);
			saveButton.setDisable(true);
			broker.commitChanges(tableView.getItems());
			tableView.refresh();
		});
		
		deleteButton.setOnAction(clicked ->{
			List<T> selectedDtos = tableView.getSelectionModel().getSelectedItems();
			broker.delete(selectedDtos);
			tableView.getItems().removeAll(selectedDtos);
			tableView.refresh();
		});
		
		newButton.setOnAction(clicked ->{
			T newDto = broker.create();
			tableView.getItems().add(newDto);
		});
		
	}
	
	
}
