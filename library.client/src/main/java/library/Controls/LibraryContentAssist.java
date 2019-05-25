package library.Controls;

import Brokers.BrokerIf;
import Dtos.DtoCaValue;
import Dtos.DtoType;
import Dtos.DtoWithCa;
import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.util.StringConverter;

import java.util.Optional;

public class LibraryContentAssist {

    public static <S extends DtoWithCa,T extends DtoCaValue> TableColumn<S,T>
    getCaColumn(String aColumnName, BrokerIf<T> aValuesBroker, DtoType aColumnContent)
    {
        TableColumn<S,T> tableColumn = new TableColumn<>(aColumnName);
        ObservableList<T> values = FXCollections.observableArrayList(aValuesBroker.getAll());

        tableColumn.setCellFactory(ComboBoxTableCellHijack.forTableColumn(new StringConverter<T>() {

            @Override
            public String toString(T object) {
                return object.getCaName();
            }

            @Override
            public T fromString(String string) {
                Optional<T> equalsValue = values.stream()
                        .filter(value ->{
                            if(value.getCaName().equals(string)) return true;
                            else return false;
                        })
                        .findAny();
                return equalsValue.orElse(null);

            }
        },values));

        tableColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<S, T>, ObservableValue<T>>() {
            @Override
            public ObservableValue<T> call(TableColumn.CellDataFeatures<S, T> param) {
                return new ObjectBinding<T>() {
                    @Override
                    protected T computeValue() {
                        return (T) param.getValue().getCaValue(aColumnContent);
                    }
                };
            }
        });

        tableColumn.setOnEditCommit(event -> {
            event.getRowValue().setCaValue(event.getNewValue());
        });

        return tableColumn;

    }

}


