import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NachrichtLesenClient extends Thread{

    @Override
    public void run() {
        while(true) {
            try {
            	String nachricht = leseNachricht();
            	if(nachricht.equalsIgnoreCase(".quit")) {
            		Client.socket.close();
            		System.out.println("Server closed the Connection. Please try again later.");
            		System.exit(0);
            	}else {
            		System.out.println(nachricht);
            	}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    String leseNachricht() throws IOException {
        BufferedReader bufferedReader =
                new BufferedReader(
                        new InputStreamReader(
                                Client.socket.getInputStream()));
        char[] buffer = new char[200];
        int anzahlZeichen = bufferedReader.read(buffer, 0, 200); // blockiert bis Nachricht empfangen
        String nachricht = new String(buffer, 0, anzahlZeichen);
        return nachricht;
    }
}
