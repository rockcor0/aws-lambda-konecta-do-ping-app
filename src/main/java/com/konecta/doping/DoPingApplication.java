package com.konecta.doping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoPingApplication {

	public final static String IP_DIR = "****";
	public final static int PORT = 0;

	public static void main(String[] args) {
		SpringApplication.run(DoPingApplication.class, args);

		handleRequest2();

	}

	public static void handleRequest2() {


		try {
			Socket pingSocket = null;
			PrintWriter out = null;
			BufferedReader in = null;

			try {
				pingSocket = new Socket("IP_DIR", PORT);
//				pingSocket = new Socket("127.0.0.1", 8080);
				out = new PrintWriter(pingSocket.getOutputStream(), true);
				in = new BufferedReader(new InputStreamReader(pingSocket.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			out.println("ping");
			System.out.println(in.readLine());
			out.close();
			in.close();
			pingSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void handleRequest() {

		try {
			String ipAddress = "127.0.0.1";
			InetAddress inet = InetAddress.getByName(ipAddress);

			System.out.println("Sending Ping Request to " + ipAddress);
			System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");

			ipAddress = "IP_DIR";
			inet = InetAddress.getByName(ipAddress);

			System.out.println("Sending Ping Request to " + ipAddress);
			System.out.println(inet.isReachable(5000) ? "Host is reachable" : "Host is NOT reachable");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
