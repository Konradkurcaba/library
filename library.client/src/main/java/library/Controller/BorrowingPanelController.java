package library.Controller;

import Brokers.BorrowingBroker;
import Brokers.EmployeeBroker;
import Brokers.UserBroker;
import Dtos.BorrowingDto;
import Dtos.DtoType;
import Dtos.EmployeeDto;
import Dtos.UserDto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Modality;
import javafx.stage.Stage;
import library.Controls.LibraryContentAssist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class BorrowingPanelController extends AbstractWindowTableController<BorrowingDto> {

    private static final Logger logger = LogManager.getLogger(BooksPanelController.class);

    public BorrowingPanelController() {
        super("Wypożyczenia");
        broker = new BorrowingBroker();
    }

    @Override
    public void init() {
        super.init();
        configureContextMenu();
    }

    @Override
    protected List<TableColumn> configureTableViewColumns() {
        List<TableColumn> columns = new ArrayList<>();

        TableColumn<BorrowingDto, EmployeeDto> employeeColumn =
                LibraryContentAssist.getCaColumn("Pracownik",new EmployeeBroker(), DtoType.Employee);
        columns.add(employeeColumn);



        TableColumn<BorrowingDto, UserDto> userColumn =
                LibraryContentAssist.getCaColumn("Klient",new UserBroker(),DtoType.User);
        columns.add(userColumn);

        TableColumn<BorrowingDto,String> startDateCol = new TableColumn("Data wypożyczenia");
        startDateCol.setCellValueFactory(value -> value.getValue().startDateProperty());
        startDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        startDateCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setStartDate(event.getNewValue());
        });
        columns.add(startDateCol);

        TableColumn<BorrowingDto,String> endDateCol = new TableColumn("Data oddania");
        endDateCol.setCellValueFactory(value -> value.getValue().endDateProperty());
        endDateCol.setCellFactory(TextFieldTableCell.forTableColumn());
        endDateCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setEndDate(event.getNewValue());
        });
        columns.add(endDateCol);

        return columns;
    }

    private void configureContextMenu()
    {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem details = new MenuItem("Szczegóły");
        details.setOnAction(event -> {});
        contextMenu.getItems().add(details);
        tableView.setContextMenu(contextMenu);
    }

    private void openDetailsWindow()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader()
                    .getResource(AbstractWindowTableController.FXML_PATH));
            Stage newWindowStage = new Stage();
            newWindowStage.initModality(Modality.WINDOW_MODAL);
            BooksPanelController controller = new BooksPanelController();
            loader.setController(controller);
            Parent root = loader.load();
            controller.init();
            newWindowStage.setScene(new Scene(root));
            newWindowStage.showAndWait();
        }
        catch (IOException aEx )
        {
            logger.debug(aEx);
        }

    }



}
