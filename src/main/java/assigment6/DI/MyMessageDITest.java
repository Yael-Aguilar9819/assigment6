package assigment6.DI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MyMessageDITest {

	// try-with-resources on multiple resources - short and sweet 
	static String firstLineOfFile(String path, String defaultVal) { 
		try (BufferedReader br = new BufferedReader( new FileReader(path))) { 
			return br.readLine(); 
		} catch (IOException e) { return defaultVal; }}


    public static void main(String[] args) {
		
		String msg = "Hi Pankaj";
		String email = "pankaj@abc.com";
		String phone = "4088888888";
		String browser = "Firefox";
		MessageServiceInjector injector = null;
		// Consumer app = null;
		
		//Send email
		injector = new EmailServiceInjector();
		Consumer app = injector.getConsumer();
		
		
		
		app.processMessages(msg, email);
		
		//Send SMS
		injector = new SMSServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, phone);

		injector = new BrowserServiceInjector();
		app = injector.getConsumer();
		app.processMessages(msg, browser);		

		
	}

}
