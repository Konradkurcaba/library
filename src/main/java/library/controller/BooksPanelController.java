package library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class BooksPanelController {

	@FXML
	private Label windowLabel;
	@FXML
	private TableView tableView;
	
	private String WINDOW_TITLE = "Książki";
	
	public void init()
	{
		windowLabel.setText(WINDOW_TITLE);
	}
	
}
