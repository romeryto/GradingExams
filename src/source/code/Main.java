package source.code;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    final static String GRADES_FILE = "gradesSC-P1-161.txt";
    final static String STUDENTS_FILE = "studentsSC-P1-161.txt";
    final static String PATH = "./files/";
    final static String PATH_STUDENTS_ANSWERS = "./files/studentsAnswers/SC/";
    final static int NUMBER_OF_QUESTIONS = 12;
    final static String CSV_FILE = "csvStudentsResultSC--P1-161.csv";
    static FileOperations op;
    static GradeExams grader;
    static List<String> studentAnswerKeys;

    public static void main(String[] args) throws FileNotFoundException {
        op = new FileOperations();
        grader = new GradeExams();

        String lineSeparator = System.getProperty("line.separator");

        studentAnswerKeys = new ArrayList<String>();
        System.out.println("============= GRADING EXAMS =============");
        Scanner sc = new Scanner(System.in);
        System.out.print("Type name of student: ");
        String studentName = Input.readLine();
        System.out.println();
        System.out.println("Student Name = "+studentName);
        System.out.println();
        String isCorrectAnswerKey = "";
        while(!isCorrectAnswerKey.equals("y")){
            System.out.print("Insert the *TYPE* of Test: ");
            String type = Input.readLine();
        	//String type = "6";
        	System.out.println("*TYPE* of Test = "+type);
            System.out.println();
            System.out.println();
            if(Integer.parseInt(type)>6 || Integer.parseInt(type)<1){
                System.out.println("*** Please insert a type between 1-5 ***");
                System.out.println();
                System.out.println();
                continue;
            }
            System.out.println();
            System.out.println(" *** INSERT THE ANSWERKEYS OF STUDENT *** ");
            for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
                System.out.print(i+1 +" - ");
                String answer = Input.readLine().toLowerCase();
                while(answer.length()!=1 || answer.equals(lineSeparator) || answer.isEmpty() ||
                        answer==null || !Character.isLetter(answer.charAt(0)) || !Input.isCharInRange(answer.charAt(0), 'a', 'f')){
                    System.out.println("***Please type a valid answer***");
                    System.out.print(i+1 +" - ");
                    answer = Input.readLine().toLowerCase();
                }
                studentAnswerKeys.add(answer);
            }
            System.out.println();
            System.out.println();
            //System.out.println("ANSWER KEYS = "+studentAnswerKeys);
            System.out.println("ANSWER KEYS = "+returnStringAnswers(studentAnswerKeys));
            
            double gladeFinal = grader.getGrade(studentAnswerKeys, Integer.parseInt(type));
            System.out.println(studentName+" - FINAL GRADE: "+String.format("%.2f", gladeFinal));
            System.out.println("Unmatch Questions: "+grader.getUnmatchQuestions());
            System.out.print(" =====>  Is AnswerKeys filled correctly? y(Yes) ou n(No) : ");
            isCorrectAnswerKey = Input.readLine();
            System.out.println();
            if(isCorrectAnswerKey.equals("y")){
                System.out.println(" *********>>>> GRADE STORED!!! =D =D =D <<<<********* ");
                writeGrade(studentName, String.format("%.2f", gladeFinal).replace(".", ","));
                writeAnswers(studentName, studentAnswerKeys);
            }else{
                System.out.println("Insert again the answerKeys to Student");
                studentAnswerKeys = new ArrayList<String>();
            }
        }
    }

    public static void writeGrade(String studentName, String grade) {
        op = new FileOperations();
        op.writeFile(PATH,GRADES_FILE, grade);
        op.writeFile(PATH,STUDENTS_FILE, studentName);
        op.writeFile(PATH,CSV_FILE, studentName, grade);
    }
    
    public static void writeAnswers(String studentName, List<String> answers) {
        op = new FileOperations();
        op.writeFile(PATH_STUDENTS_ANSWERS, studentName+"-SC-P1-161", answers);
    }
    public static String returnStringAnswers(List<String> answers) {
    	String result = "";
        for (int i = 0; i < answers.size(); i++) {
			result+=(i+1)+"-"+answers.get(i)+"|";
		}
        return result;
    }




}
