import java.io.*;
import java.net.*;

class Client{
	public static void main(String argv[]) throws Exception{
		String sentence;
		String serverIP;
		int serverPort;
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader (new InputStreamReader(System.in));

		System.out.printf("input server IP\n");
		serverIP = inFromUser.readLine();
		System.out.printf("input port\n");
		serverPort = Integer.parseInt(inFromUser.readLine());

		Socket clientSocket = new Socket(serverIP, serverPort);
		DataOutputStream outToServer = new DataOutputStream (clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
		
		System.out.printf("input something\n");
		sentence = inFromUser.readLine();
		outToServer.writeBytes(sentence + '\n');
		modifiedSentence = inFromServer.readLine();
		System.out.println("FROM SERVER: " + modifiedSentence);
		sentence = inFromUser.readLine();
		clientSocket.close();
	}
}
