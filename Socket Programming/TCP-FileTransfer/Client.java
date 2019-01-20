import java.io.*;
import java.net.*;

class Client
{	public static void main(String args[]) throws IOException
	{	Socket s=new Socket("localhost",7899);
		BufferedReader br22=new BufferedReader(new InputStreamReader(s.getInputStream()));		
		String str2;
		File f2=new File("f2.txt");
		FileOutputStream fos=new FileOutputStream(f2);
		PrintWriter pw=new PrintWriter((fos));
		while((str2=br22.readLine())!=null)
			pw.println(str2);
		pw.close();
		fos.close();
		br22.close();
		s.close();
	}
}

		
