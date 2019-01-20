
import java.io.*;
import java.net.*;

public class webserver {
	public static void main(String[]args)throws Exception
	{    
		 System.setProperty("java.net.useSystemProxies","true");
         System.setProperty("https.proxyHost","172.16.0.3");
         System.setProperty("https.proxyPort","8080");
		 ServerSocket s=new ServerSocket(8091);
		Socket s2=s.accept();
		DataInputStream dis=new DataInputStream(s2.getInputStream());
		String s1=new String();
		s1=dis.readLine();
		URL url=new URL(s1);
		BufferedReader reader =new BufferedReader(new InputStreamReader(url.openStream()));
		 BufferedWriter writer = new BufferedWriter(new FileWriter("data1.html")); 
			      String line;
			      while ((line = reader.readLine())!= null) {
			         System.out.println(line);
			         writer.write(line);
			         writer.newLine();
			         }
	dis.close();
	reader.close();	
	writer.close();
	s.close();
	}	
}
