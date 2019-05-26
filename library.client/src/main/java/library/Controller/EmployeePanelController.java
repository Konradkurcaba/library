package library.Controller;

import Brokers.EmployeeBroker;
import Dtos.EmployeeDto;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.ArrayList;
import java.util.List;

public class EmployeePanelController extends AbstractWindowTableController<EmployeeDto> {

    private static String WINDOW_NAME = "Pracownicy";

    public EmployeePanelController() {
        super(WINDOW_NAME);
        broker = new EmployeeBroker();
    }

    @Override
    protected List<TableColumn<EmployeeDto, String>> configureTableViewColumns() {
        List<TableColumn<EmployeeDto,String>> columns = new ArrayList();

        TableColumn<EmployeeDto,String> firstNameCol = new TableColumn("Imię");
        firstNameCol.setCellValueFactory(value -> value.getValue().getFirstName());
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setFirstName(event.getNewValue());
        });
        columns.add(firstNameCol);

        TableColumn<EmployeeDto,String> lastNameCol = new TableColumn("Nazwisko");
        lastNameCol.setCellValueFactory(value -> value.getValue().getLastName());
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setLastName(event.getNewValue());
        });

        columns.add(lastNameCol);

        TableColumn<EmployeeDto,String> zipCodeCol = new TableColumn("Kod pocztowy");
        zipCodeCol.setCellValueFactory(value -> value.getValue().getZipCode());
        zipCodeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        zipCodeCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setZipCode(event.getNewValue());
        });
        columns.add(zipCodeCol);

        TableColumn<EmployeeDto,String> cityCol = new TableColumn("Miasto");
        cityCol.setCellValueFactory(value -> value.getValue().getCity());
        cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
        cityCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setCity(event.getNewValue());
        });
        columns.add(cityCol);

        TableColumn<EmployeeDto,String> streetCol = new TableColumn("Ulica");
        streetCol.setCellValueFactory(value -> value.getValue().getStreet());
        streetCol.setCellFactory(TextFieldTableCell.forTableColumn());
        streetCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setStreet(event.getNewValue());
        });

        columns.add(streetCol);

        TableColumn<EmployeeDto,String> houseNumberCol = new TableColumn("Nr domu");
        houseNumberCol.setCellValueFactory(value -> value.getValue().getHouseNumber());
        houseNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
        houseNumberCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setHouseNumber(event.getNewValue());
        });

        columns.add(houseNumberCol);

        TableColumn<EmployeeDto,String> email = new TableColumn("Email");
        email.setCellValueFactory(value -> value.getValue().getEmail());
        email.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setEmail(event.getNewValue());
        });

        columns.add(email);

        return columns;
    }
}
