package com.ironhacker.JavaPottersHomework3;

import com.ironhacker.JavaPottersHomework3.enums.IndustryEnum;
import com.ironhacker.JavaPottersHomework3.enums.ProductEnum;
import com.ironhacker.JavaPottersHomework3.enums.StatusEnum;
import com.ironhacker.JavaPottersHomework3.models.*;
import com.ironhacker.JavaPottersHomework3.repository.*;
import com.ironhacker.JavaPottersHomework3.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static com.ironhacker.JavaPottersHomework3.utils.Utils.*;
import static com.ironhacker.JavaPottersHomework3.utils.Constants.*;

public class MainMenu {
    @Autowired
    private LeadRepository leadRepository;

    @Autowired
    private OpportunityRepository opportunityRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SalesRepRepository salesRepRepository;
    @Autowired
    private ContactRepository contactRepository;


    private Utils utils;

    public MainMenu() {
       utils= new Utils();


       main();

    }

    public void main() {

        //Create a Scanner to collect user input
        Scanner myScanner = new Scanner(System.in);

        System.out.println("************* Starting CRM *************");
        System.out.println("What is your name?");
        String salesAssistName = myScanner.nextLine();
        System.out.println("Welcome to the CRM system, " + salesAssistName + ".\n" + options);

        while (true) {
            Optional<Opportunity> optionalOpportunity;
            Optional<Lead> optionalLead;
            System.out.println("\nWhat do you want to do, " + salesAssistName + "?");
            String userInput = myScanner.nextLine();
            if(utils.isAKeyWord(userInput)){
                userInput = userInput.toLowerCase();
                int id;
                try{
                    String[] splited = userInput.split(" ");
                    String keyword = splited[0].toLowerCase(); // ignore mayus, always lowerCase
                    switch (keyword) {
                        case "signup":
                            Lead lead = utils.signingUp();
                            leadRepository.save(lead);
                            break;
                        case "convert":
                            convertMethod(splited);
                            break;
                        case "lookup":
                            try {
                                String objectType = splited[1];
                                id = Integer.parseInt(splited[2]);
                                switch (objectType) {
                                    case "leads":
                                        optionalLead = leadRepository.findById(id);
                                        if (optionalLead.isPresent()) {
                                            System.out.println(optionalLead.get());
                                        } else {
                                            System.out.println("Not found opportunity");
                                        }
                                        break;
                                    case "opportunities":
                                        optionalOpportunity = opportunityRepository.findById(id);
                                        if (optionalOpportunity.isPresent()) {
                                            System.out.println(optionalOpportunity.get());
                                        } else {
                                            System.out.println("Not found opportunity");
                                        }
                                        break;
                                    default:
                                        System.out.println("Invalid option. Lookup does not have " + objectType + " option, " +
                                                "please try again. With \033[3mLookup leads {lead_id}\033[0m " +
                                                "or \033[3mLookup opportunities{opportunity_id}\033[0m");
                                        break;
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Invalid option. Please try again with \033[3mLookup leads {lead_id}\033[0m " +
                                        "or \033[3mLookup opportunities{opportunity_id}\033[0m");
                            }
                            break;
                        case "show":
                            String objectType = splited[1];
                            if (objectType.equals("leads")) {
                                utils.showLead();
                            } else if (objectType.equals("opportunities")) {
                                utils.showOpportunities();
                            } else {
                                System.out.println("Invalid option. Show does not have " + objectType + " option, please " +
                                        "try again. With \033[3mshow leads\033[0m or \033[3mshow opportunities\033[0m");
                                break;
                            }
                            break;
                        case "close-lost":
                            id = Integer.parseInt(splited[1]);
                            optionalOpportunity = opportunityRepository.findById(id);
                            if (optionalOpportunity.isPresent()) {
                                optionalOpportunity.get().setStatus(StatusEnum.CLOSED_LOST);
                                System.out.println("The opportunity with id " + id + " was closed-lost.");
                            } else {
                                System.out.println("Not found opportunity");
                            }
                            break;
                        case "close-won":
                            id = Integer.parseInt(splited[1]);
                            optionalOpportunity = opportunityRepository.findById(id);
                            if (optionalOpportunity.isPresent()) {
                                optionalOpportunity.get().setStatus(StatusEnum.CLOSED_WON);
                                System.out.println("The opportunity with id " + id + " was closed-won");
                            } else {
                                System.out.println("Not found opportunity");
                            }
                            break;
                        case "report":
                            List<SalesRep> salesReps;
                            String objectReport = splited[1];
                            switch (objectReport) {
                                case "lead":
                                    salesReps = salesRepRepository.findAll();
                                    for (SalesRep salesRep : salesReps) {
                                        System.out.println(salesRep.getName());
                                        System.out.println(leadRepository.findBySalesRep(salesRep).size());
                                    }
                                    break;
                                case "opportunity":
                                    String objectReport2 = splited[3];
                                    switch (objectReport2) {
                                        case "salesrep":
                                            utils.showObjectList(opportunityRepository.findBySalesRepAssociate());
                                            break;
                                        case "the":
                                            if (splited[4].equals("product")) {
                                                utils.showObjectList(opportunityRepository.findByProductEnum());
                                            } else {
                                                System.out.println("Invalid option. Please try again");
                                            }
                                            break;
                                        case "country":
                                            utils.showObjectList(opportunityRepository.findByCountry());
                                            break;
                                        case "city":
                                            utils.showObjectList(opportunityRepository.findByCity());
                                            break;
                                        case "industry":
                                            utils.showObjectList(opportunityRepository.findByIndustryEnum());
                                            break;
                                    }
                                    break;
                                case "closed-won", "closed_won":
                                    String objectReport3 = splited[3];
                                    switch (objectReport3) {
                                        case "salesrep":
                                            utils.showObjectList(salesRepRepository.findByStatusCloseWon());
                                            break;
                                        case "the":
                                            if (splited[4].equals("product")) {
                                                utils.showObjectList(opportunityRepository.findByProductEnumAndStatus(StatusEnum.CLOSED_WON));
                                            } else {
                                                System.out.println("Invalid option. Please try again");
                                            }
                                            break;
                                        case "country":
                                            utils.showObjectList(accountRepository.findByCountryAndStatus("CLOSED_WON"));
                                            break;
                                        case "city":
                                            utils.showObjectList(accountRepository.findByCityAndStatus("CLOSED_WON"));
                                            break;
                                        case "industry":
                                            utils.showObjectList(accountRepository.findByIndustryAndStatus("CLOSED_WON"));
                                            break;
                                    }
                                    break;
                                case "closed-lost", "closed_lost":
                                    String objectReport4 = splited[3];
                                    switch (objectReport4) {
                                        case "salesrep":
                                            utils.showObjectList(salesRepRepository.findByStatusCloseLost());
                                            break;
                                        case "the":
                                            if (splited[4].equals("product")) {
                                                utils.showObjectList(opportunityRepository.findByProductEnumAndStatus(StatusEnum.CLOSED_LOST));
                                            } else {
                                                System.out.println("Invalid option. Please try again");
                                            }
                                            break;
                                        case "country":
                                            utils.showObjectList(accountRepository.findByCountryAndStatus("CLOSED_LOST"));
                                            break;
                                        case "city":
                                            utils.showObjectList(accountRepository.findByCityAndStatus("CLOSED_LOST"));
                                            break;
                                        case "industry":
                                            utils.showObjectList(accountRepository.findByIndustryAndStatus("CLOSED_LOST"));
                                            break;
                                    }
                                    break;
                                case "open":
                                    String objectReport5 = splited[3];
                                    switch (objectReport5) {
                                        case "salesrep":
                                            utils.showObjectList(salesRepRepository.findByStatusOpen());
                                            break;
                                        case "the":
                                            if (splited[4].equals("product")) {
                                                utils.showObjectList(opportunityRepository.findByProductEnumAndStatus(StatusEnum.OPEN));
                                            } else {
                                                System.out.println("Invalid option. Please try again");
                                            }
                                            break;
                                        case "country":
                                            utils.showObjectList(accountRepository.findByCountryAndStatus("OPEN"));
                                            break;
                                        case "city":
                                            utils.showObjectList(accountRepository.findByCityAndStatus("OPEN"));
                                            break;
                                        case "industry":
                                            utils.showObjectList(accountRepository.findByIndustryAndStatus("OPEN"));
                                            break;
                                    }
                                    break;
                            }
                            break;

                        case "mean":
                            String objectMean = splited[1];
                            switch (objectMean){

                                case "employeecount":
                                    System.out.println("The employees's mean is: "+ accountRepository.findEmployeeAverage());
                                break;
                                case "quantity":
                                    System.out.println("The quantity's mean is: "+ opportunityRepository.findQuantityAverage());
                                    break;
                                case "opps":
                                    System.out.println("The quantity's mean is: "+ accountRepository.findAverageOppsByAccount());
                                    break;
                            }
                            break;

                        case "max":
                            String objectMax = splited[1];
                            switch (objectMax){

                                case "employeecount":
                                    System.out.println("The employees's max is: "+ accountRepository.findEmployeeMax());
                                    break;
                                case "quantity":
                                    System.out.println("The quantity's max is: "+ opportunityRepository.findQuantityMax());
                                    break;
                                case "opps":
                                    System.out.println("The quantity's max is: "+ accountRepository.findMaxOppsByAccount());
                                    break;
                            }
                            break;
                        case "min":
                            String objectMin = splited[1];
                            switch (objectMin){

                                case "employeecount":
                                    System.out.println("The employees's min is: "+ accountRepository.findEmployeeMin());
                                    break;
                                case "quantity":
                                    System.out.println("The quantity's min is: "+ opportunityRepository.findQuantityMin());
                                    break;
                                case "opps":
                                    System.out.println("The quantity's min is: "+ accountRepository.findMinOppsByAccount());
                                    break;
                            }
                            break;

                        case "exit":
                            System.exit(0);
                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Please insert ID");
                }

            }
            else {
                System.out.println("Invalid option, please try again.");
                System.out.println(options);
                myScanner = new Scanner(System.in);
            }
        }
    }

    // option convert is a method because is larger
    private void convertMethod(String[] splited){
        Scanner myScanner = new Scanner(System.in);

        int id = Integer.parseInt(splited[1]);
        Optional<Lead> optionalLead = leadRepository.findById(id);

        Contact contact = new Contact(optionalLead.get().getName(),
                optionalLead.get().getPhoneNumber(),
                optionalLead.get().getEmail(),
                optionalLead.get().getCompanyName());
        contactRepository.save(contact);

        int productQuantity = utils.validInput("How many trucks does the lead want?");

        ProductEnum productEnum = null;
        int productTypeInt;
        //Validation productType
        do{
            productTypeInt = utils.validInput("\nWhich of our products? \n" +
                    "1. HYBRID,\n" + "2. FLATBED,\n" + "3. BOX");
            switch (productTypeInt){
                case 1:
                    productEnum = ProductEnum.HYBRID;
                    break;
                case 2:
                    productEnum = ProductEnum.FLATBED;
                    break;
                case 3:
                    productEnum = ProductEnum.BOX;
                    break;
            }
            if(productTypeInt > 3){
                System.out.println("Invalid option, please insert an int between 1 - 3");
            }
        } while (productTypeInt > 3);

        Opportunity opportunity = new Opportunity(productEnum, productQuantity,
                contact, StatusEnum.OPEN);
        opportunityRepository.save(opportunity);
        String userInput;
        do{
            System.out.println("Would you like to create a new Account? (Y/N)");
            userInput = myScanner.nextLine();

            if (userInput.equals("Y")) {

                int industryTypeInt;
                IndustryEnum industryEnum = null;
                //Validation industryType
                do{
                    industryTypeInt = utils.validInput("\nWhich industry are the products for? \n" +
                            "1. PRODUCE\n" + "2. ECOMMERCE\n" + "3. MANUFACTURING\n" + "4. MEDICAL\n" +
                            "5. OTHER");
                    switch (industryTypeInt){
                        case 1:
                            industryEnum = IndustryEnum.PRODUCE;
                            break;
                        case 2:
                            industryEnum = IndustryEnum.ECOMMERCE;
                            break;
                        case 3:
                            industryEnum = IndustryEnum.MANUFACTURING;
                            break;
                        case 4:
                            industryEnum = IndustryEnum.MEDICAL;
                            break;
                        case 5:
                            industryEnum = IndustryEnum.OTHER;
                            break;
                    }
                    if(industryTypeInt > 5){
                        System.out.println("Invalid option, please insert an int between 1 - 5");
                    }
                }while (industryTypeInt > 5);

                int numEmployees = utils.validInput("\nHow many employees does the contact's company have?");
                List<String> companyData = utils.getInputData(
                        "\nIntroduce the city where the contact's company is located.",
                        "\nIntroduce the country where the contact's company is located.");

                Account account = new Account(optionalLead.get().getCompanyName(),
                        industryEnum, numEmployees,
                        companyData.get(0), companyData.get(1));
                //contact.setCompany(account);
                accountRepository.save(account);

            }
            else if (userInput.equals("N")) {
                while (true){
                    // preguntar id de account
                    int accountId = utils.validInput("\nPlease insert account ID");
                    Optional<Account> optionalAccount = accountRepository.findById(accountId);
                    if(optionalAccount.isPresent()){
                        //contact.setCompany(optionalAccount.get());
                        break;
                    } else {
                        System.out.println("Not found this account");
                    }
                }
            } else {
                System.out.println("Invalid option");
            }
        } while (userInput!="Y" && userInput!="N");

        leadRepository.delete(optionalLead.get());
        System.out.println("Convert done");
    }



}
