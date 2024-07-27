package com.nova.basicsockets.tcpsockets;
import java.io.*;
import java.net.*;

public class TCPEchoServer {
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

            // Receive until client closes connection, indicated by -1 return
            while ((recvMsgSize = in.read(receiveBuf)) != -1) {
                out.write(receiveBuf, 0, recvMsgSize);
            }
            clntSock.close();   // Close the socket. We are done with this client!
        }

    }
}
