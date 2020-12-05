package assigment6.DI;

public class BrowserServiceImpl implements MessageService {
    @Override
    public void sendMessage(String msg, String rec) {
        System.out.println("Browser Message sent to " + rec + " with Message=" + msg);
    }
}
