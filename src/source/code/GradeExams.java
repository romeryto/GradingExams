package source.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeExams {

    private Map<Integer, List<String>> answerKeysByTypeMap;
    List<String> answerKeysType1;
    List<String> answerKeysType2;
    List<String> answerKeysType3;
    List<String> answerKeysType4;
    List<String> answerKeysType5;
    List<String> answerKeysType6;
    //public static final double WEIGHT_BY_QUESTION = 0.5;
    public static final double WEIGHT_BY_QUESTION = 1.12;
    public final static String PATH_ANSWERS = "./files/answerKeysGAP/";
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;
    public static final int TYPE4 = 4;
    public static final int TYPE5 = 5;
    private static final int TYPE6 = 6;
    public static final String ansKT1 = "A.txt";
    public static final String ansKT2 = "B.txt";
    public static final String ansKT3 = "3.txt";
    public static final String ansKT4 = "4.txt";
    public static final String ansKT5 = "5.txt";
    public static final String ansKT6 = "mt1.txt";
    List<Integer> unmatchQuestions;
	

    FileOperations op;

    public GradeExams() {
        op = new FileOperations();
        answerKeysByTypeMap = new HashMap<Integer, List<String>>();

        answerKeysType1 = new ArrayList<String>(op.readFile(PATH_ANSWERS + ansKT1));
        System.out.println("AnswerKeys TYPE 1: "+answerKeysType1);
        answerKeysType2 = new ArrayList<String>(op.readFile(PATH_ANSWERS + ansKT2));
        System.out.println("AnswerKeys TYPE 2: "+answerKeysType2);
        answerKeysType3 = new ArrayList<String>(op.readFile(PATH_ANSWERS + ansKT3));
        System.out.println("AnswerKeys TYPE 3: "+answerKeysType3);
        answerKeysType4 = new ArrayList<String>(op.readFile(PATH_ANSWERS + ansKT4));
        System.out.println("AnswerKeys TYPE 4: "+answerKeysType4);
        answerKeysType5 = new ArrayList<String>(op.readFile(PATH_ANSWERS + ansKT5));
        System.out.println("AnswerKeys TYPE 5: "+answerKeysType5);
        unmatchQuestions = new ArrayList<Integer>();
        
        answerKeysType6 = new ArrayList<String>(op.readFile(PATH_ANSWERS + ansKT6));
        System.out.println("AnswerKeys TYPE 6-Final: "+answerKeysType6);
        
        System.out.println();
        setup();
    }

    private void setup() {
        answerKeysByTypeMap.put(TYPE1, answerKeysType1);
        answerKeysByTypeMap.put(TYPE2, answerKeysType2);
        answerKeysByTypeMap.put(TYPE3, answerKeysType3);
        answerKeysByTypeMap.put(TYPE4, answerKeysType4);
        answerKeysByTypeMap.put(TYPE5, answerKeysType5);
        answerKeysByTypeMap.put(TYPE6, answerKeysType6);
    }

    public double getGrade(List<String> studentAnswerKeys, int type) {
        double gradeFinal = 0.0;
        System.out.println("Type -----> "+ type);
        switch (type) {
            case TYPE1:
                gradeFinal = this.calculateGrade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE1));
                break;
            case TYPE2:
                gradeFinal = this.calculateGrade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE2));
                break;
            case TYPE3:
                gradeFinal = this.calculateGrade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE3));
                break;
            case TYPE4:
                gradeFinal = this.calculateGrade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE4));
                break;
            case TYPE5:
                gradeFinal = this.calculateGrade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE5));
                break;
            case TYPE6:
                gradeFinal = this.calculateGrade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE6));
                break;
            default:
                break;
        }

        return gradeFinal;

    }

    private double calculateGrade(List<String> studentAnswerKeys, List<String> oficialAnswerKeys){
        int numberOfMaches = 0;
        for (int i = 0; i < studentAnswerKeys.size(); i++) {
            String studentAnswer = studentAnswerKeys.get(i);
            String oficialAnswer = oficialAnswerKeys.get(i);
            if(studentAnswer.equals(oficialAnswer)){
                numberOfMaches++;
            }else{
            	unmatchQuestions.add(i+1);
            }
        }
        System.out.println("NumberOfMatches: "+numberOfMaches);
        return numberOfMaches*WEIGHT_BY_QUESTION;
    }

	public List<Integer> getUnmatchQuestions() {
		return unmatchQuestions;
	}  

}
