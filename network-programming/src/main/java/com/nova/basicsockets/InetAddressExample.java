package com.nova.basicsockets;

import java.net.*;
import java.util.Enumeration;

public class InetAddressExample
{
    public static void main( String[] args )
    {
        // Get the network interfaces and associated addresses for this host
        try {
            Enumeration<NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
            if (interfaceList == null) {
                System.out.println("----No interfaces fount----");
            } else {
                while(interfaceList.hasMoreElements()){
                    NetworkInterface iface = interfaceList.nextElement();
                    System.out.println("Interface " + iface.getName() + ":");
                    Enumeration<InetAddress> addrList = iface.getInetAddresses();;
                    if (!addrList.hasMoreElements()){
                        System.out.println("\t(No addresses for this interface)");
                    }
                    while (addrList.hasMoreElements()){
                        InetAddress address = addrList.nextElement();
                        System.out.println("\tAddress "
                        + ((address instanceof Inet4Address ? "(v4)"
                                : (address instanceof Inet6Address ? "(v6)" : "(?)"))) + ": " + address.getHostAddress());
                    }
                }
            }
        } catch (SocketException se) {
            System.out.println("Error getting network interfaces: " + se.getMessage());
        }

        // Get name(s)/ address(es) of hosts given on command line
        for (String host : args) {
            try{
                System.out.println(host + ":");
                InetAddress[] addressList = InetAddress.getAllByName(host);
                for (InetAddress address : addressList) {
                    System.out.println("\t" + address.getHostName() + " : " + address.getHostAddress() + " : " + address.getCanonicalHostName());
                }

            } catch (UnknownHostException e) {
                System.out.println("\tUnable to find address for: " + e.getMessage());
            }
        }


    }
}
