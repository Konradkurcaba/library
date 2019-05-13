package library.Controller;

import Brokers.BorrowingBroker;
import Brokers.EmployeeBroker;
import Brokers.UserBroker;
import Dtos.BorrowingDto;
import Dtos.DtoType;
import Dtos.EmployeeDto;
import Dtos.UserDto;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import library.Controls.LibraryContentAssist;

import java.util.ArrayList;
import java.util.List;

public class BorrowingPanelController extends AbstractWindowTableController<BorrowingDto> {


    public BorrowingPanelController() {
        super("Wypożyczenia");
        broker = new BorrowingBroker();
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
}
