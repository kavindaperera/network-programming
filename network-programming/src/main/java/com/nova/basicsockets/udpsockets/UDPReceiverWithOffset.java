package com.nova.basicsockets.udpsockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;

public class UDPReceiverWithOffset {

    public static void main(String[] args) {
        DatagramSocket dgsocket = null;

        try {
            // Create a DatagramSocket to receive data on port 9876
            dgsocket = new DatagramSocket(9876);

            // Initialize a byte array buffer of size 20
            byte[] buf = new byte[20];
            for (int i = 0; i < buf.length; i++) {
                buf[i] = (byte) i;
            }

            // Create a DatagramPacket with the middle 10 bytes of the buffer
            DatagramPacket dg = new DatagramPacket(buf, 5, 10);

            // Receive the packet
            dgsocket.receive(dg);

            // Print the entire buffer to see which parts have been modified
            System.out.println("Full buffer: " + Arrays.toString(buf));

            // Extract only the received data using getOffset() and getLength()
            byte[] destBuf = Arrays.copyOfRange(dg.getData(), dg.getOffset(), dg.getOffset() + dg.getLength());

            // Print the received data
            System.out.println("Received data: " + Arrays.toString(destBuf));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dgsocket != null && !dgsocket.isClosed()) {
                dgsocket.close();
            }
        }

    }
}
