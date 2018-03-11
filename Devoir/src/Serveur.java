
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
    private static BufferedReader getMesIn(Socket soc) throws IOException {
        return new BufferedReader(new InputStreamReader(soc.getInputStream()));
    }

    private static PrintWriter getMesOut(Socket soc) throws IOException {
        return new PrintWriter(new OutputStreamWriter(soc.getOutputStream()));
    }

    public static void main(String[] args) throws IOException {
        ServerSocket servSoc = new ServerSocket(1500);
        System.out.println(servSoc.getLocalSocketAddress());
        while (true) {
            try (Socket soc = servSoc.accept()) {
                System.out.println(soc.getRemoteSocketAddress());
                BufferedReader reader = getMesIn(soc);
                PrintWriter reply = getMesOut(soc);
                String text;
                System.out.println("Tant Que");
                while ((text = reader.readLine()) != null) {
                    System.out.println("faire");
                    System.out.printf("test %s\n", text);
                    reply.printf("test %s\n", text);
                    reply.flush();
                }
            }
        }
    }
}
