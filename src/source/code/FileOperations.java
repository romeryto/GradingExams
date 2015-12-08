package source.code;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileOperations {

    List<String> notas;

    public FileOperations(){
        notas = new ArrayList<String>();
    }

    public List<String> readFile(String path){
        Scanner scanner;
        try {
            scanner = new Scanner(new FileReader(path)).useDelimiter("\\||\\n");
            while (scanner.hasNext()) {
                String value = scanner.next();
                this.notas.add(value.trim());
            }
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return notas;
    }

    public void writeFile(String path, String fileName, String value) {
        BufferedWriter buffWrite;
        try {
            buffWrite = new BufferedWriter(new FileWriter(path+fileName,true));
            buffWrite.append(value + "\n");
            buffWrite.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




}
