package source.code;
import java.io.FileNotFoundException;

public class Main {

    final static String GRADES_FILE = "grades.txt";
    final static String STUDENTS_FILE = "students.txt";
    final static String PATH = "./files/";

    public static void main(String[] args) throws FileNotFoundException {

        FileOperations op = new FileOperations();
        writeGrade("Joao", "10.0");
        writeGrade("Maria", "12.0");
        writeGrade("Larissa", "8.0");

    }

    public static void writeGrade(String studentName, String grade) {
        FileOperations op = new FileOperations();
        op.writeFile(PATH,GRADES_FILE, grade);
        op.writeFile(PATH,STUDENTS_FILE, studentName);
    }
}
