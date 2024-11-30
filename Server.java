import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1717;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running on port " + PORT + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

                double v = Double.parseDouble(input.readLine());
                double d = Double.parseDouble(input.readLine());
                double t = d / v;

                output.println(t);
                System.out.println("Processed: V = " + v + ", D = " + d + ", T = " + t);
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
