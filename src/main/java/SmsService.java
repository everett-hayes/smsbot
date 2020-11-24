import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;

public class SmsService {


        //insert your sid, token, & number here
        private static final String accountSid = "<accountSid>";
        private static final String authToken = "<authToken>";
        private static final String trialNumber = "+<trialNumber>";

        public void sendSms(String phoneNum, String body) {
                Twilio.init(accountSid, authToken);

                PhoneNumber to = new PhoneNumber(phoneNum);
                PhoneNumber from = new PhoneNumber(trialNumber);

                try {
                        MessageCreator creator = Message.creator(to, from, body);
                        creator.create();
                        System.out.println("Message sent!");
                } catch (TwilioException e) {
                        System.out.println(e.getMessage());
                }
        }

}
