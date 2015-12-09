package source.code;

import java.util.Scanner;

public class Input {


    public Input(){}

    public static String readLine(){
        String result = "";
        Scanner sc = new Scanner(System.in);
        result = sc.nextLine();
        return result.trim();
    }

    public static boolean isCharInRange(char character, char firstLetter, char lastLatter){
        return character >= firstLetter  && character <= lastLatter;
    }
}
