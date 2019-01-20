import java.io.*;
import java.net.*;

class Client
{	public static void main(String args[])throws IOException
	{	Socket cli=new Socket("localhost",6789);
		DataInputStream inpstr= new DataInputStream(cli.getInputStream());
		String s=new String(inpstr.readLine());
		System.out.println(s);
		inpstr.close();
		cli.close();
	}
}
//Client Side
