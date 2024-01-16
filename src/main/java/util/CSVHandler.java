package util;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHandler {

    public static void adicionarLinha() {
        try {
            // Caminho para o arquivo JSON de credenciais
        	String caminhoArquivoCredenciais = "src/main/resources/CSVcredentials.json";

            // Carrega as credenciais do arquivo JSON
            InputStream credentialsStream = CSVHandler.class.getResourceAsStream(caminhoArquivoCredenciais);

            if (credentialsStream == null) {
                throw new IOException("Não foi possível carregar o arquivo de credenciais.");
            }

            GoogleCredential credentials = GoogleCredential.fromStream(credentialsStream);
            if (credentials == null) {
                throw new IOException("Falha ao criar as credenciais do Google.");
            }

            // Resto do seu código para adicionar a linha...
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}