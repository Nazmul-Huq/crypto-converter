
import java.util.regex.*;
import java.util.Scanner;
import java.util.Random;


public class CryptoConverter {
    public static void main(String[] args) {

        //// create instance for imported classes
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // Welcome greeting and asking for name
        System.out.println("Welcome to Nazmul's Crypto converter!");
        System.out.println("What is your firstname? ");
        String firstName = scanner.nextLine();
        System.out.println("What is your surname? ");
        String lastName = scanner.nextLine();

        //select a random character from full name
        String fullName = firstName + lastName;
        int pickRandomIndex = rand.nextInt((fullName.length() - 1));
        char randomCharFromFullname = fullName.charAt(pickRandomIndex);


        //printing greeting, random character and ask for more
        System.out.println("Welcome dear " + firstName + " " + lastName + " ");
        System.out.println("Here is a random character in your fullname: " + randomCharFromFullname);
        System.out.println("Anyways we hope you're ready to convert some dollars.");

        //get amount of dollar from user and check if given amount is numeric
        System.out.println("How many dollars can you convert today?");
        while (!scanner.hasNextInt()) {
            String givenDollar = scanner.next();
            System.out.println("You have typed " + givenDollar + " which is a string");
            System.out.println("Please enter valid amount");
        }
        int givenDollar = scanner.nextInt();


        //create different message based on different given amount
        if (givenDollar < 11) {
            System.out.println(givenDollar + " dollars why not more?");
        } else if (givenDollar > 39) {
            System.out.println("Wauv " + givenDollar + " dollars thats a lot");
        } else {
            System.out.println(givenDollar + " dollars, well done");
        }


        // calculate converted coin's value from given amount
        final double BITCOIN_VALUE = 0.00002;
        final double ETHEREUM_VALUE = 0.00027;
        final double CARDANO_VALUE = 0.36;
        double dollarToBitcoin = givenDollar * BITCOIN_VALUE;
        double dollarToEthereum = givenDollar * ETHEREUM_VALUE;
        double dollarToCardano = givenDollar * CARDANO_VALUE;
        double totalCoinAfterConversion = dollarToBitcoin + dollarToCardano + dollarToEthereum;
        double averageCoinAfterConversion = totalCoinAfterConversion / 3;

        // print converted amount in different currencies
        System.out.println("Here is what you can get with " + givenDollar + " dollars");
        System.out.println("- " + String.format("%.5f", dollarToBitcoin) + " bitcoin");
        System.out.println("- " + String.format("%.5f", dollarToEthereum) + " ethereum");
        System.out.println("- " + String.format("%.5f", dollarToCardano) + " cardano");
        System.out.println("In total that is " + String.format("%.5f", totalCoinAfterConversion) + " coins and the average is " + String.format("%.5f", averageCoinAfterConversion) + " !");


        // *********** "Optional task 3 - User selects currency to convert" start here **********************

        //request to convert from USD/EUR/DKK  to specific cryptocurrency
        System.out.println("\nWow that's quite a lots of information");
        System.out.println("Can I convert Euro and Dkk too to a specific cryptocurrency?");


        System.out.println("why not? How much you want to convert?");
        while (!scanner.hasNextInt()) {
            String givenAmount = scanner.next();
            System.out.println("You have typed " + givenAmount + " which is a string");
            System.out.println("Please enter valid amount");
        }
        int givenAmount = scanner.nextInt();


        //ask for given currency name and cryptocurrency name to convert to
        System.out.println("From what currency (\"Enter 1 for dollar 2 for Euro or 3 for Dkk\")?");
        int chooseYourCurrentCurrency = scanner.nextInt();
        System.out.println("To what crypto currency (\"Enter 1 for bitcoin 2 for Ethereum or 3 for Cardano\")?");
        int chooseCurrencyToConvert = scanner.nextInt();

        //check if dollar, euro and krone should be written as plural or singular
        String dollarPlural;
        String euroPlural;
        String kronePlural;
        if (givenAmount > 1) {
            dollarPlural = "dollars";
            euroPlural = "euros";
            kronePlural = "kroner";
        } else {
            dollarPlural = "dollar";
            euroPlural = "euro";
            kronePlural = "krone";
        }

        //calculate the amount and print message
        //The array should read as: first array for dollar, 2nd for euro and 3rd for dkk to cryptocurrency (in following order inside each array bitcoin, ethreum, cardano)
        double[][] currencyValues = {{0.00002, 0.00027, 0.36}, {0.000024, 0.00031, 0.39}, {0.0000032, 0.000042, 0.054}};
        double convertedAmount = givenAmount * (currencyValues[(chooseYourCurrentCurrency - 1)][(chooseCurrencyToConvert - 1)]);
        System.out.println("You can get " + (String.format("%.5f", convertedAmount)) + " bitcoins for " + givenAmount + " " + dollarPlural);


    } //end of "public static void main(String[] args)"
} // end of "public class CryptoConverterNazmul"
