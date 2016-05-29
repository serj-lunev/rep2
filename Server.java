import java.io.*;
import java.net.*;

class Server{
	public static void main(String argv[]) throws Exception{
		String clientSentence = "nothing here";
        String capitalizedSentence;
        ServerSocket welcomeSocket = new ServerSocket(6789);
		System.out.println("Server started");
        while(true){
			Socket connectionSocket = welcomeSocket.accept();
			System.out.printf("Client connected\n");
//			while (clientSentence != "exit"){
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
    	        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        	    clientSentence = inFromClient.readLine();
            	System.out.println("Received: " + clientSentence);
	            capitalizedSentence = clientSentence.toUpperCase() + '\n';
	            outToClient.writeBytes(capitalizedSentence);
//			}
		}
	}
}
