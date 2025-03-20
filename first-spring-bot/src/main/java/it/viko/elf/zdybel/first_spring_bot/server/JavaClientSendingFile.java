package it.viko.elf.zdybel.first_spring_bot.server;
import java.io.*;
import java.net.ConnectException;
import java.net.Socket;

public class JavaClientSendingFile {

    private static DataOutputStream dos = null;
    private static DataInputStream dis = null;

    // Nowa metoda statyczna, która wywoła sendFile()
    public static void clientSendingFile() {
        try (Socket socket = new Socket("localhost", 900)) {
            dis = new DataInputStream(socket.getInputStream());
            dos = new DataOutputStream(socket.getOutputStream());

            System.out.println("Sending the File to the Server");
            sendFile("C:\\Users\\zdybe\\IdeaProjects\\AnotherProject\\target\\SendingFile\\customers.xml");
            dis.close();
            dos.close();
        } catch (ConnectException e) {
            System.out.println("Error: Server is not listening on port 900. Please make sure the server is running.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(String path) throws Exception {
        int bytes = 0;
        File file = new File(path);

        FileInputStream fileInputStream = new FileInputStream(file);

        dos.writeLong(file.length());

        byte[] buffer = new byte[4 * 1024];
        while ((bytes = fileInputStream.read(buffer)) != -1) {
            dos.write(buffer, 0, bytes);
            dos.flush();
        }

        fileInputStream.close();
    }
}
