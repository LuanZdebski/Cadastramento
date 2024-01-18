package application;

import java.io.IOException;
import java.util.List;

import com.opencsv.exceptions.CsvException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.Cadastro;
import util.CSVHandler;

public class ProgramController<T> {
	
	List<Cadastro> Cadastros;
	ObservableList<T> CadastrosNaListView;
	
	public ProgramController() throws IOException, CsvException {
        this.Cadastros = csvHandler.lerCsv();
        this.CadastrosNaListView = FXCollections.observableArrayList(Cadastros);
        
	}
    @FXML
    public void initialize() {
        listViewCadastros.setItems(CadastrosNaListView);
        RefreshListView();
    }

	CSVHandler csvHandler = new CSVHandler();
	
    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField txtFieldCPF;
    
    @FXML
    private ListView<T> listViewCadastros;

    @FXML
    void onPressCadastrar(ActionEvent event) throws IOException, CsvException {
    	Cadastro novoCadastro = new Cadastro();
    	
    	novoCadastro.setCPF(txtFieldCPF.getText());
    	novoCadastro.setNome(textFieldNome.getText());
    	
    	Cadastros.add(novoCadastro);
    	
    	csvHandler.escreverCsv(Cadastros);
    	
    	CadastrosNaListView.setAll(Cadastros);
    	RefreshListView();
    }
    private void RefreshListView() {
        listViewCadastros.setCellFactory((Callback<ListView<T>, ListCell<T>>) new Callback<ListView<T>, ListCell<T>>() {
            @Override
            public ListCell<T> call(ListView<T> param) {
                return new ListCell<T>() {
                    @Override
                    protected void updateItem(T item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty || item == null) {
                            setText(null);
                        } else {
                            // Customize a exibição do item aqui
                            String[] array = (String[]) item;
                            setText(String.join(" - ", array));
                        }
                    }
                };
            }
         });
    
    }
}
