package spms;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSMS {
 
  public static final String ACCOUNT_SID = "";
  public static final String AUTH_TOKEN = "";
 
  public static void send(String no,String msg) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(new PhoneNumber("+91"+no),
        new PhoneNumber(""), 
        msg).create();
  }
}
