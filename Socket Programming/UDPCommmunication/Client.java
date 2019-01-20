import java.io.*;
import java.net.*;
import java.util.*;

class Client
{	public static void main(String args[]) throws IOException
	{	Scanner me2=new Scanner(System.in);
		DatagramSocket c=new DatagramSocket();
		InetAddress addr2=InetAddress.getByName("localhost");
		byte[] sd2=new byte[1024];
		byte[] rd2=new byte[1024];
		System.out.println("Enter String");
		String str2=me2.nextLine();
		sd2=str2.getBytes();
		DatagramPacket sp2=new DatagramPacket(sd2,sd2.length,addr2,4567);
		c.send(sp2);
		DatagramPacket rp2=new DatagramPacket(rd2,rd2.length);
		c.receive(rp2);
		String str21=new String(rp2.getData());
		System.out.println("Client : "+str21);
		c.close();
	}
}
	
