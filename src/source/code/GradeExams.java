package source.code;

import java.util.ArrayList;
import java.util.Arrays;
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
    public static final double WEIGHT_BY_QUESTION = 0.5;
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;
    public static final int TYPE4 = 4;
    public static final int TYPE5 = 5;

    public GradeExams() {
        answerKeysByTypeMap = new HashMap<Integer, List<String>>();

        answerKeysType1 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "a", "b", "c", "d", "e", "a",
                "b", "c", "d", "e", "a", "b", "c", "d", "e"));
        answerKeysType2 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "a", "b", "c", "d", "e", "a",
                "b", "c", "d", "e", "a", "b", "c", "d", "e"));
        answerKeysType3 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "a", "b", "c", "d", "e", "a",
                "b", "c", "d", "e", "a", "b", "c", "d", "e"));
        answerKeysType4 = new ArrayList<String>(Arrays.asList("x", "y", "z", "w", "o","x", "y", "z", "w", "o","x", "y",
                "z", "w", "o","x", "y", "z", "w", "o" ));
        answerKeysType5 = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "a", "b", "c", "d", "e", "a",
                "b", "c", "d", "e", "a", "b", "c", "d", "e"));
        setup();
    }

    private void setup() {
        answerKeysByTypeMap.put(TYPE1, answerKeysType1);
        answerKeysByTypeMap.put(TYPE2, answerKeysType2);
        answerKeysByTypeMap.put(TYPE3, answerKeysType3);
        answerKeysByTypeMap.put(TYPE4, answerKeysType4);
        answerKeysByTypeMap.put(TYPE5, answerKeysType5);
    }

    public double getGrade(List<String> studentAnswerKeys, int type) {
        double gradeFinal = 0.0;
        switch (type) {
            case TYPE1:
                gradeFinal = this.calculateGlade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE1));
                break;
            case TYPE2:
                gradeFinal = this.calculateGlade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE2));
            case TYPE3:
                gradeFinal = this.calculateGlade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE3));
                break;
            case TYPE4:
                gradeFinal = this.calculateGlade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE4));
                break;
            case TYPE5:
                gradeFinal = this.calculateGlade(studentAnswerKeys, answerKeysByTypeMap.get(TYPE5));
                break;
            default:
                break;
        }

        return gradeFinal;

    }

    private double calculateGlade(List<String> studentAnswerKeys, List<String> oficialAnswerKeys){
        int numberOfMaches = 0;
        for (int i = 0; i < studentAnswerKeys.size(); i++) {
            String studentAnswer = studentAnswerKeys.get(i);
            String oficialAnswer = oficialAnswerKeys.get(i);
            if(studentAnswer.equals(oficialAnswer)){
                numberOfMaches++;
            }
        }
        System.out.println("NumberOfMatches: "+numberOfMaches);
        return numberOfMaches*WEIGHT_BY_QUESTION;
    }

}