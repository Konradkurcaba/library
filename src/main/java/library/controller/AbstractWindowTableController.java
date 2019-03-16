package library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import library.broker.Broker;

public abstract class AbstractWindowTableController<T> {

	private String windowTitle;
	protected Broker<T> broker;
	
	public AbstractWindowTableController(String aWindowTitle) {
		super();
		windowTitle = aWindowTitle;
	}
	@FXML
	protected Label windowLabel;
	@FXML
	protected TableView<T> tableView;
	@FXML
	protected Button onEditButton;
	@FXML
	protected Button saveButton;
	@FXML
	protected Button newButton;
	
	protected abstract void initTableView();
	
	public void init()
	{
		windowLabel.setText(windowTitle);
		initTableView();
		initButtons();
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
		
	}
	
}
