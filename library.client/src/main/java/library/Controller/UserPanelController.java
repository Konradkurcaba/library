package library.Controller;

import Brokers.UserBroker;
import Dtos.UserDto;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.ArrayList;
import java.util.List;

public class UserPanelController extends AbstractWindowTableController<UserDto> {

    private static String WINDOW_NAME = "Użytkownicy";

    public UserPanelController() {
        super(WINDOW_NAME);
        broker = new UserBroker();
    }

    @Override
    protected List<TableColumn<UserDto, String>> configureTableViewColumns() {

        List<TableColumn<UserDto,String>> columns = new ArrayList();

        TableColumn<UserDto,String> firstNameCol = new TableColumn("Imię");
        firstNameCol.setCellValueFactory(value -> value.getValue().getFirstName());
        firstNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        firstNameCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setFirstName(event.getNewValue());
        });
        columns.add(firstNameCol);

        TableColumn<UserDto,String> lastNameCol = new TableColumn("Nazwisko");
        lastNameCol.setCellValueFactory(value -> value.getValue().getLastName());
        lastNameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        lastNameCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setLastName(event.getNewValue());
        });

        columns.add(lastNameCol);

        TableColumn<UserDto,String> zipCodeCol = new TableColumn("Kod pocztowy");
        zipCodeCol.setCellValueFactory(value -> value.getValue().getZipCode());
        zipCodeCol.setCellFactory(TextFieldTableCell.forTableColumn());
        zipCodeCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setZipCode(event.getNewValue());
        });
        columns.add(zipCodeCol);

        TableColumn<UserDto,String> cityCol = new TableColumn("Miasto");
        cityCol.setCellValueFactory(value -> value.getValue().getCity());
        cityCol.setCellFactory(TextFieldTableCell.forTableColumn());
        cityCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setCity(event.getNewValue());
        });
        columns.add(cityCol);

        TableColumn<UserDto,String> streetCol = new TableColumn("Ulica");
        streetCol.setCellValueFactory(value -> value.getValue().getStreet());
        streetCol.setCellFactory(TextFieldTableCell.forTableColumn());
        streetCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setStreet(event.getNewValue());
        });

        columns.add(streetCol);

        TableColumn<UserDto,String> houseNumberCol = new TableColumn("Nr domu");
        houseNumberCol.setCellValueFactory(value -> value.getValue().getHouseNumber());
        houseNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
        houseNumberCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setHouseNumber(event.getNewValue());
        });

        columns.add(houseNumberCol);

        TableColumn<UserDto,String> phoneNumberCol = new TableColumn("Telefon");
        phoneNumberCol.setCellValueFactory(value -> value.getValue().getPhoneNumber());
        phoneNumberCol.setCellFactory(TextFieldTableCell.forTableColumn());
        phoneNumberCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setPhoneNumber(event.getNewValue());
        });

        columns.add(phoneNumberCol);

        TableColumn<UserDto,String> emailCol = new TableColumn("Email");
        emailCol.setCellValueFactory(value -> value.getValue().getEmail());
        emailCol.setCellFactory(TextFieldTableCell.forTableColumn());
        emailCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setEmail(event.getNewValue());
        });

        columns.add(emailCol);

        return columns;
    }
}
