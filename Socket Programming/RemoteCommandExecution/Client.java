import java.io.*;
import java.util.*;
import java.net.*;

class Client
{	public static void main(String args[])throws IOException
	{	Socket s=new Socket("localhost",6785);
		String str2;
		Scanner me=new Scanner(System.in);
		System.out.println("Enter Command");
		str2=me.nextLine();
		PrintStream ps2=new PrintStream(s.getOutputStream());
		ps2.println(str2);
		s.close();
	}
}

