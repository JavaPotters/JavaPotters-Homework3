package com.ironhacker.JavaPottersHomework3.utils;

import com.ironhacker.JavaPottersHomework3.models.Lead;
import com.ironhacker.JavaPottersHomework3.models.Opportunity;
import com.ironhacker.JavaPottersHomework3.repository.LeadRepository;
import com.ironhacker.JavaPottersHomework3.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static com.ironhacker.JavaPottersHomework3.utils.Constants.keyWords;

public class Utils {
    // read questions, and return a list of strings
    public List<String> getInputData(String... questions) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputData = new ArrayList<>();
        for (String question : questions) {
            System.out.println(question);
            inputData.add(scanner.next());
        }
        return inputData;
    }

    // valid if the user's input is a int
    public int validInput(String questions){
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

    public Lead signingUp() {

        List<String> name = getInputData("\nIntroduce the lead's name: ");
        Integer phoneNumber = validInput("\nIntroduce the lead's phone number: ");
        List<String> emailAndCompany = getInputData("\nIntroduce the lead's email: ",
                "\nIntroduce the lead's company name: ");

        Lead lead = new Lead(name.get(0), phoneNumber , emailAndCompany.get(0), emailAndCompany.get(1));
        return lead;
    }

    // valid if a string is a keyword
    public boolean isAKeyWord(String str){
        String[] splited = str.split(" ");
        String word = splited[0].toLowerCase();
        for(String keyWord: keyWords){
            if(word.equals(keyWord)){
                return true;
            }
        }
        return false;
    }

    @Autowired
    private LeadRepository leadRepository;
    public void showLead(){
        System.out.println("List of leads: ");
        List<Lead> leadList = leadRepository.findAll();
        for(Lead lead: leadList){
            System.out.println(lead);
        }
    }

    @Autowired
    private OpportunityRepository opportunityRepository;

    public void showOpportunities(){
        System.out.println("List of opportunities: ");
        List<Opportunity> opportunityList = opportunityRepository.findAll();
        for(Opportunity opportunity: opportunityList){
            System.out.println(opportunity);
        }
    }


}
