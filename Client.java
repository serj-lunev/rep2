import java.io.*;
import java.net.*;

class Client{
	public static void main(String argv[]) throws Exception{
		String sentence;
		String exit = "EXIT" + '\n';
		String modifiedSentence;
		BufferedReader inFromUser = new BufferedReader (new InputStreamReader(System.in));
		Socket clientSocket = new Socket("localhost", 6789);
		DataOutputStream outToServer = new DataOutputStream (clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));
		sentence = inFromUser.readLine();
//		if(sentence == exit) 
//			System.out.println("==");
//		else 
//			System.out.println("!=");
//		while (sentence != "exit\n"){
			outToServer.writeBytes(sentence + '\n');
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
			sentence = inFromUser.readLine();
//		}
		clientSocket.close();
	}
}
