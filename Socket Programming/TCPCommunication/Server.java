import java.io.*;
import java.net.*;

class Server
{	public static void main(String args[]) throws IOException
	{	ServerSocket ser = new ServerSocket(6789);
		Socket cli = ser.accept();
		DataOutputStream outstr= new DataOutputStream(cli.getOutputStream());
		outstr.writeBytes("This is Server");
		outstr.close();
		cli.close();
		ser.close();
	}
}
//Server Side
