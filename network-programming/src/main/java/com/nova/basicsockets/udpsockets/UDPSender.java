package com.nova.basicsockets.udpsockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class UDPSender {

    public static void main(String[] args) {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            InetAddress receiverAddress = InetAddress.getByName("localhost");
//            String message = "Hello, World!";
//            byte[] sendBuffer = message.getBytes();

            // Message to send (8 bytes)
            byte[] sendBuffer = {41, 42, 43, 44, 45, 46, 47, 48};

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, receiverAddress, 9876);

            socket.send(sendPacket);

            System.out.println("Message sent: " + Arrays.toString(sendBuffer));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }

    }

}
