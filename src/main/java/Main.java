import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ArrayList<String> quotes = new ArrayList<String>();
    static SmsService smsService = new SmsService();

    public static void main(String[] args) throws Exception {

        //get stuff ready
        Random rand = new Random();
        initializeQuotes();

        //read from user
        Scanner input = new Scanner(System.in);

        System.out.println("This is a Quote Bot powered by Twilio");
        System.out.println("Enter a phone number like +18001234567 to send a quote");
        System.out.println("Or enter q to exit");

        String target = input.nextLine();
        while (!target.equals("q")) {
            String quote = quotes.get(rand.nextInt(quotes.size()));
            smsService.sendSms(target, quote);
            target = input.nextLine();
        }

        System.out.println("Program Finished!");
    }

    public static void initializeQuotes () throws FileNotFoundException{
        File file = new File("src/main/resources/quotes.txt");

        Scanner s = new Scanner(file);

        while (s.hasNextLine()) {

            StringBuilder sb = new StringBuilder();
            boolean endQuote = false;

            while (!endQuote) {
                String line = s.nextLine();
                sb.append(line);
                if (line.split(" ")[0].equals("--")) {
                    endQuote = true;
                } else {
                    sb.append("\n");
                }
            }

            quotes.add(sb.toString());

        }

    }


}
