package com.nova.basicsockets.udpsockets;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiver {

    public static final int ECHOMAX = 65_600;

    public static void main(String[] args) {

        DatagramSocket socket = null;

        try {
            socket = new DatagramSocket(9876);
            byte[] receiveBuffer = new byte[ECHOMAX];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, ECHOMAX);

                socket.receive(receivePacket);

                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received: " + receivedData);
                System.out.println("Received Msg Length: " + receivePacket.getLength());

                receivePacket.setLength(ECHOMAX);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        }

    }

}
