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
            "\033[3m- Exit:\033[0m to finish the program.";

    // Key words to enter in the switch-case
    public static final String[] keyWords = {"convert", "lookup", "close-lost", "close-won", "show", "signup", "exit"};
}
