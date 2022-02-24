package com.nova.basicsockets.tcpsockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

public class TCPEchoClient {
    public static void main(String[] args) throws IOException {

        // java TCPEchoClient 127.0.0.1 "Echo this!"

        if ((args.length < 2) || (args.length > 3))     // Test for correct # of args
            throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

        String server = args[0];    // Server name or IP address
        // Covert argument String to bytes using the default character encoding
        byte[] data = args[1].getBytes();

        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 8080;

        // Create socket that is connected to server on specified port
        Socket socket = new Socket(server, servPort);
        System.out.println("Connected to server...sending echo string");
        InputStream in = socket.getInputStream();       // receive by reading from the InputStream
        OutputStream out = socket.getOutputStream();    // send data over the socket by writing bytes to the OutputStream

        out.write(data);    // Send the encoded string to the server

        // Receive the same string back from the server
        int totalBytesRcvd = 0;     //  Total bytes received so far
        int bytesRecvd;             //  Bytes received in the last read
        while (totalBytesRcvd < data.length){
            if ((bytesRecvd = in.read(data, totalBytesRcvd, data.length - totalBytesRcvd)) == -1)
                throw new SocketException("Connection closed prematurely");
            totalBytesRcvd += bytesRecvd;
        }   //  data array is full


        System.out.println("Received: " + new String(data));

        socket.close();     //  Close the socket and its streams

    }
}
