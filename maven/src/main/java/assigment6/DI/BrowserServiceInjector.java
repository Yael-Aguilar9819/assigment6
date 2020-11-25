package assigment6.DI;

public class BrowserServiceInjector implements MessageServiceInjector {
    public Consumer getConsumer() {
        return new MyDIApplication(new BrowserServiceImpl());
    }
}
