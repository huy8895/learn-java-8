package com.training.lap_trinh_mang_voi_java.url;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressExample {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress ip = InetAddress.getLocalHost();
        System.out.println("Host Name: " + ip.getHostName());
        System.out.println("IP Address: " + ip.getHostAddress());

        ip = InetAddress.getByName("www.studytonight.com");
        System.out.println("\nHost Name: " + ip.getHostName());
        System.out.println("IP Address: " + ip.getHostAddress());

        System.out.println("\nAll address of google: ");
        InetAddress[] sw = InetAddress.getAllByName("facebook.com");
        for (InetAddress inetAddress : sw) {
            System.out.println("sw = " + inetAddress);
        }
    }
}
