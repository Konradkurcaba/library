package library.Controller;

import java.util.ArrayList;
import java.util.List;

import Brokers.BrokerIf;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public abstract class AbstractWindowTableController<T> {

	private String windowTitle;
	private List<T> toDeleteDtos;
	protected BrokerIf<T> broker;
	
	public AbstractWindowTableController(String aWindowTitle) {
		super();
		windowTitle = aWindowTitle;
		toDeleteDtos = new ArrayList<>();
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
	@FXML
	private Button resetButton;
	
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
		offEditMode();
		
		onEditButton.setOnAction(clicked -> {
			onEditMode();
		});
		
		saveButton.setOnAction(clicked -> {
			offEditMode();
			broker.delete(toDeleteDtos);
			toDeleteDtos.clear();
			broker.commitChanges(tableView.getItems());
			tableView.refresh();
		});
		
		deleteButton.setOnAction(clicked ->{
			toDeleteDtos.addAll(tableView.getSelectionModel().getSelectedItems());
			tableView.getItems().removeAll(toDeleteDtos);
			tableView.refresh();
		});
		
		newButton.setOnAction(clicked ->{
			T newDto = broker.create();
			tableView.getItems().add(newDto);
		});

		resetButton.setOnAction(clicked ->{
			offEditMode();
			tableView.getItems().addAll(toDeleteDtos);
			toDeleteDtos.clear();
			tableView.refresh();
		});
		
	}
	
	private void onEditMode()
	{
		tableView.setEditable(true);
		newButton.setDisable(false);
		deleteButton.setDisable(false);
		onEditButton.setDisable(true);
		saveButton.setDisable(false);
		resetButton.setDisable(false);
	}

	private void offEditMode()
	{
		tableView.setEditable(false);
		newButton.setDisable(true);
		deleteButton.setDisable(true);
		onEditButton.setDisable(false);
		resetButton.setDisable(true);
		saveButton.setDisable(true);
	}
	
	
}