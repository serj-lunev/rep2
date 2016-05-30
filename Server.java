import java.io.*;
import java.net.*;

class Server{
	public static void main(String argv[]) throws Exception{
		String clientSentence = "nothing here";
        String capitalizedSentence;
		int port;
		BufferedReader inFromUser = new BufferedReader (new InputStreamReader(System.in));
		System.out.printf("input port\n");
		port = Integer.parseInt(inFromUser.readLine());

        ServerSocket welcomeSocket = new ServerSocket(port);
		System.out.println("Server started");
        while(true){
			Socket connectionSocket = welcomeSocket.accept();
			System.out.printf("Client connected\n");
				BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
    	        DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
        	    clientSentence = inFromClient.readLine();
            	System.out.println("Received: " + clientSentence);
	            capitalizedSentence = clientSentence.toUpperCase() + '\n';
	            outToClient.writeBytes(capitalizedSentence);
		}
	}
}
