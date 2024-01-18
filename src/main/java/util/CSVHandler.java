package util;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import com.opencsv.CSVWriterBuilder;
import com.opencsv.ICSVWriter;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CSVHandler {

	private static String Cadastros = "src/main/resources/Cadastros.csv";
	
    public <T> List<T> lerCsv() throws IOException, CsvException {
        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(Cadastros)).build()) {
            return (List<T>) csvReader.readAll();
        }
    }

    public <T> void escreverCsv(List<T> linhas) throws IOException {
        try (CSVWriter csvWriter = (CSVWriter) new CSVWriterBuilder(new FileWriter(Cadastros)).build()) {
            csvWriter.writeAll((Iterable<String[]>) linhas);
        }
    }

}