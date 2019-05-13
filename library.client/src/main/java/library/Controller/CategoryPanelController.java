package library.Controller;

import Brokers.CategoryBroker;
import Dtos.CategoryDto;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;

import java.util.ArrayList;
import java.util.List;

public class CategoryPanelController extends AbstractWindowTableController<CategoryDto> {

    private static String WINDOW_NAME = "Gatunki";

    public CategoryPanelController() {
        super(WINDOW_NAME);
        broker = new CategoryBroker();
    }


    @Override
    protected List<TableColumn<CategoryDto, String>> configureTableViewColumns() {
        List<TableColumn<CategoryDto,String>> columns = new ArrayList();

        TableColumn<CategoryDto,String> nameCol = new TableColumn("Nazwa");
        nameCol.setCellValueFactory(value -> value.getValue().getCategoryName());
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit( event ->{
            event.getTableView().getItems()
                    .get(event.getTablePosition().getRow())
                    .setCategoryName(event.getNewValue());
        });
        columns.add(nameCol);

        return columns;
    }
}
