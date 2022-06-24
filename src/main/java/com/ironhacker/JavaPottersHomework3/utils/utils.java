package com.ironhacker.JavaPottersHomework3.utils;

import com.ironhacker.JavaPottersHomework3.models.Lead;
import com.ironhacker.JavaPottersHomework3.models.Opportunity;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.ironhacker.JavaPottersHomework3.utils.Constants.keyWords;

public class utils {
    // read questions, and return a list of strings
    public static List<String> getInputData(String... questions) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputData = new ArrayList<>();
        for (String question : questions) {
            System.out.println(question);
            inputData.add(scanner.next());
        }
        return inputData;
    }

    // valid if the user's input is a int
    public static int validInput(String questions){
        Scanner myScanner =  new Scanner(System.in);
        int input = 0;

        while (input <= 0){
            try {System.out.println(questions);
                input = myScanner.nextInt();
            } catch (InputMismatchException ex) {
                ex.getMessage();
                System.out.println("INVALID OPTION! Please insert an int" );
                myScanner =  new Scanner(System.in);
            }
        }
        return input;
    }

    public static Lead signingUp() {

        List<String> name = getInputData("\nIntroduce the lead's name: ");
        Integer phoneNumber = validInput("\nIntroduce the lead's phone number: ");
        List<String> emailAndCompany = getInputData("\nIntroduce the lead's email: ",
                "\nIntroduce the lead's company name: ");

        Lead lead = new Lead(name.get(0), phoneNumber , emailAndCompany.get(0), emailAndCompany.get(1));
        return lead;
    }

    // valid if a string is a keyword
    public static boolean isAKeyWord(String str){
        String[] splited = str.split(" ");
        String word = splited[0].toLowerCase();
        for(String keyWord: keyWords){
            if(word.equals(keyWord)){
                return true;
            }
        }
        return false;
    }


}
