import java.io.*;
import java.net.*;

class Server
{	public static void main (String args[])throws IOException
	{	ServerSocket ss=new ServerSocket(6785);
		Socket s=ss.accept();
		String str;
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));	
		Runtime r=Runtime.getRuntime();
		str=br.readLine();
		Process p=r.exec(str);
		BufferedReader br2=new BufferedReader(new InputStreamReader(p.getInputStream()));
		while((str=br2.readLine())!=null)
			System.out.println(str);
		br2.close();
		br.close();
		s.close();
		ss.close();
	}
}

	
