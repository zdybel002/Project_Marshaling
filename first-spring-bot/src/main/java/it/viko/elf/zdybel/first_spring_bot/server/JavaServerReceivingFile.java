package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaServerReceivingFile {

    private static DataOutputStream dos = null;
    private static DataInputStream dis = null;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(900)) {
            System.out.println("server is Starting in Port 900");


            Socket clientSocket = serverSocket.accept();
            System.out.println("Connected");

            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());


            receiveFile("file.xml");


            dis.close();
            dos.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void receiveFile(String fileName) throws Exception {
        int bytes = 0;
        FileOutputStream fileOutputstream = new FileOutputStream(fileName);


        long size = dis.readLong();
        byte[] buffer = new byte[4 * 1024];


        while (size > 0 && (bytes = dis.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
            fileOutputstream.write(buffer, 0, bytes);
            size -= bytes;
        }
        System.out.println("File is Received");
        fileOutputstream.close();
    }
}
