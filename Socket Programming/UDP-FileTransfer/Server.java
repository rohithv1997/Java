import java.io.*;
import java.net.*;

class Server
{	public static void main(String args[]) throws IOException
	{	byte rxr[]=new byte[1024];
		DatagramSocket s=new DatagramSocket(8989);
		FileOutputStream f=new FileOutputStream("f3.txt");
		PrintWriter pw=new PrintWriter(f);
		DatagramPacket rxrpkt=new DatagramPacket(rxr,rxr.length);
		s.receive(rxrpkt);
		String str=new String(rxrpkt.getData(),0,rxrpkt.getLength());
		System.out.println(str.trim());
		pw.println(str.trim());
		pw.close();
		f.close();
		s.close();
	}
}

			
