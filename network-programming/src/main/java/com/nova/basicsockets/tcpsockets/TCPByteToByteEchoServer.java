package com.nova.basicsockets.tcpsockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class TCPByteToByteEchoServer {
    private static final int BUFSIZE = 32;      // Size of receive buffer
    public static void main(String[] args) throws IOException {

        if (args.length != 1)     // Test for correct # of args
            throw new IllegalArgumentException("Parameter(s): <Port>");

        int servPort = Integer.parseInt(args[0]);

        // Create a server socket to accept client connection requests
        ServerSocket servSock = new ServerSocket(servPort);

        int recvMsgSize;    // Size of received message
        byte[] receiveBuf = new byte[BUFSIZE];

        while (true) {  // Run forever, accepting and servicing connections
            Socket clntSock = servSock.accept();

            SocketAddress clientAddress = clntSock.getRemoteSocketAddress();
            System.out.println("Handling client at " + clientAddress);

            InputStream in = clntSock.getInputStream();
            OutputStream out = clntSock.getOutputStream();

            // Send a "Hello" message to the client
            String helloMessage = "Hello";
            byte[] helloBuf = helloMessage.getBytes();
            out.write(helloBuf);

            // Echo the received message one byte at a time
            int recvByte;
            while((recvByte = in.read()) != -1) {
                out.write(recvByte);
                out.flush();
                try {
                    Thread.sleep(1000); // Sleep for 1 second between bytes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            clntSock.close();   // Close the socket. We are done with this client!
        }

    }
}
