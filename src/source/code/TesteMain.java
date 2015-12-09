package source.code;

import java.util.List;

public class TesteMain {

    public static void main(String[] args) {
        FileOperations op = new FileOperations();
        List<String> result = op.readFile("./files/answerKeysSC/1.txt");
        System.out.println(result);

    }

}
