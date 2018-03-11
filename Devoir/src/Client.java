
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
	 private static PrintWriter getMesOut(Socket soc) throws IOException{
	        return new PrintWriter (new OutputStreamWriter(soc.getOutputStream()));
	    }
	
	private static BufferedReader getMesInp(Socket soc) throws IOException {
        return new BufferedReader(new InputStreamReader(soc.getInputStream()));
    }
    
   
    
    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("127.0.0.1",1500);
        System.out.println(soc.getLocalSocketAddress());
        BufferedReader reader = getMesInp(soc);
        PrintWriter response = getMesOut(soc);
        response.printf("test\n");
        response.flush();
        System.out.println(reader.readLine());
    }
}
