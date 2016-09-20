import java.io.*;
import java.net.*;
public class GossipServer{
	public static void main(String []args)throws Exception{
		ServerSocket SS = new ServerSocket(8000);
		System.out.println("Server Ready For Chatting ... ");
		Socket SK = SS.accept();
		BufferedReader KeyRead = new BufferedReader(new InputStreamReader(System.in)); // Reading from KeyBoard ..
		OutputStream Os = SK.getOutputStream();
		PrintWriter Pwrite = new PrintWriter(Os , true); // Sending to Client PrintWriter Object ...

		InputStream Istream = SK.getInputStream();
		BufferedReader receiveRead = new BufferedReader(new InputStreamReader(Istream)); // Receiving From another Side ... 

		String receiveMessage , sendMessage ;
		while(true){
			if((receiveMessage = receiveRead.readLine()) != null)  
        	{
         	  System.out.println("Friend :: " + receiveMessage);         
        	}
        	sendMessage = KeyRead.readLine(); 
        	Pwrite.println("ME :: " + sendMessage);   
        	Pwrite.flush();
			/*Flushes the output stream and forces any buffered
			 output bytes to be written out. The general contract 
			 of flush is that calling it is an indication that, 
			 if any bytes previously written have been buffered 
			 by the implementation of the output stream,
			  such bytes should immediately be written to their intended destination.
		
		*/
		}


	}
}