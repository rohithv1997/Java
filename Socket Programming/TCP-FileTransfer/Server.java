import java.net.*;
import java.io.*;

class Server
{	public static void main(String args[]) throws IOException
	{	ServerSocket ss=new ServerSocket(7899);
		Socket s=ss.accept();
		String str;
		File f=new File("f1.txt");
		FileInputStream fis=new FileInputStream(f);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		PrintStream ps=new PrintStream(s.getOutputStream());
		while((str=br.readLine())!=null)
			ps.println(str);
		ps.close();
		br.close();
		fis.close();
		s.close();
		ss.close();
	}
}


		
