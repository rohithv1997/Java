import java.io.*;
import java.net.*;

class Server
{	public static void main(String args[])throws IOException
	{	byte[] sd=new byte[1024];
		byte[] rd=new byte[1024];
		DatagramSocket s=new DatagramSocket(4567);
		DatagramPacket rp=new DatagramPacket(rd,rd.length);
		s.receive(rp);
		String str=new String(rp.getData());
		System.out.println("Server : "+str);
		InetAddress addr=rp.getAddress();
		int port=rp.getPort();
		String strc=str.toUpperCase();
		sd=strc.getBytes();
		DatagramPacket sp=new DatagramPacket(sd,sd.length,addr,port);
		s.send(sp);
		s.close();
	}
}

