import java.io.IOException;
import java.util.Scanner;

public class SchreibeNachricht extends Thread {
	@Override
	public void run() {
		while (true) {
			Scanner scanner = new Scanner(System.in);
			String nachricht = scanner.nextLine();
			try {
				if (nachricht.startsWith("/msg ")) {
					int count = nachricht.length() - nachricht.replaceAll(" ", "").length();
					if (count >= 2) {
						Client.schreibeNachricht(Client.socket, nachricht);
					} else {
						System.out.println("Please type /msg <name> <message>");
					}
				}else if(nachricht.startsWith("/broadcast")) {
					int count = nachricht.length() - nachricht.replaceAll(" ", "").length();
					if (count >= 1) {
						Client.schreibeNachricht(Client.socket, nachricht);
					}else {
						System.out.println("Pleas type /broadcast <message>");
					}
				} else {
					Client.schreibeNachricht(Client.socket, nachricht);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
