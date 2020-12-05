package assigment6.DI;

public class SMSServiceInjector implements MessageServiceInjector {
    @Override
	public Consumer getConsumer() {
		return new MyDIApplication(new SMSServiceImpl());
	}
}
