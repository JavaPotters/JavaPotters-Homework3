package com.ironhacker.JavaPottersHomework3.utils;

public class Constants {
    // Static string with options to show for screen
    public static final String options = "You can type: \n" +
            "\033[3m- Signup:\033[0m to create a lead.\n" +
            "\033[3m- Show leads:\033[0m  to see the leads list.\n" +
            "\033[3m- Convert <leadId>:\033[0m to convert a lead into an opportunity.\n" +
            "\033[3m- Show opportunities:\033[0m to see the opportunities list.\n" +
            "\033[3m- Lookup <opportunityId>:\033[0m to find an opportunity.\n" +
            "\033[3m- Close-won <opportunityId>:\033[0m to close an opportunity that was won.\n" +
            "\033[3m- Close-lost <opportunityId>:\033[0m to close an opportunity that was lost.\n"+
            "\033[3m- Report lead by salesRep:\033[0m to obtain the count of leads by salesRep.\n"+
            "\033[3m- Report opportunity by salesRep:\033[0m to obtain the count of opportunities by salesRep.\n"+
            "\033[3m- Report <StatusEnum> by salesRep:\033[0m to obtain the count of all opportunities with this status by salesRep.\n"+
            "\033[3m- Report opportunity by product:\033[0m to obtain the count of opportunities by product.\n"+
            "\033[3m- Report <StatusEnum> by product:\033[0m to obtain the count of all opportunities with this status by product.\n"+
            "\033[3m- Report opportunity by country:\033[0m to obtain the count of opportunities by country.\n"+
            "\033[3m- Report <StatusEnum> by country:\033[0m to obtain the count of all opportunities with this status by country.\n"+
            "\033[3m- Report opportunity by city:\033[0m to obtain the count of opportunities by city.\n"+
            "\033[3m- Report <StatusEnum> by city:\033[0m to obtain the count of all opportunities with this status by city.\n"+
            "\033[3m- Report opportunity by industry:\033[0m to obtain the count of opportunities by industry.\n"+
            "\033[3m- Report <StatusEnum> by industry:\033[0m to obtain the count of all opportunities with this status by industry.\n"+
            "\033[3m- Mean employee count:\033[0m to obtain the mean of the number of employees.\n"+
            "\033[3m- Mean quantity:\033[0m to obtain the mean of the number of products.\n"+
            "\033[3m- Mean opps per account:\033[0m to obtain the mean of the opportunities associated with an account.\n"+
            "\033[3m- Max employee count:\033[0m to obtain the max  number of employees.\n"+
            "\033[3m- Max quantity:\033[0m to obtain the max  number of products.\n"+
            "\033[3m- Max opps per account:\033[0m to obtain the max number of opportunities associated with an account.\n"+
            "\033[3m- Min employee count:\033[0m to obtain the min number of employees.\n"+
            "\033[3m- Min quantity:\033[0m to obtain the min number of products.\n"+
            "\033[3m- Min opps per account:\033[0m to obtain the min number of opportunities associated with an account.\n"+
            "\033[3m- Exit:\033[0m to finish the program.";


    // Key words to enter in the switch-case
    public static final String[] keyWords = {"convert", "lookup", "close-lost", "close-won", "show",
            "signup", "exit", "report", "mean", "max", "min"};
}
