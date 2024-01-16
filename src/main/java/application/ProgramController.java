package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import util.CSVHandler;

public class ProgramController {
	
	CSVHandler csvHandler = new CSVHandler();
	
    @FXML
    private Button btnCadastrar;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField txtFieldCPF;

    @FXML
    void onPressCadastrar(ActionEvent event) throws IOException {
    	System.out.println("teste");
    	csvHandler.adicionarLinha();
    }

}
