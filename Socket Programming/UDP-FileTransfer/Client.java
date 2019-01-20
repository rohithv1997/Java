import java.io.*;
import java.net.*;

class Client 
{	public static void main(String args[]) throws IOException
	{	String str2=new String();
		byte[] send2=new byte[1024];
		DatagramSocket c=new DatagramSocket();
		InetAddress addr2=InetAddress.getByName("localhost");
		File f2=new File("f1.txt");
		FileInputStream fis2=new FileInputStream(f2);
		while(fis2.read(send2)!=0)
		{	DatagramPacket sp2=new DatagramPacket(send2,send2.length,addr2,8989);
			c.send(sp2);
		}
		fis2.close();
		c.close();
	}
}
