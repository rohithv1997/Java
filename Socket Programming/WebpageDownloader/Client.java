
import java.io.*;
import java.net.*;
public class webclient 
{
	public static void main(String[]args)throws Exception
	{
Socket s1 = new Socket("localhost",8091);
System.setProperty("java.net.useSystemProxies","true");
System.setProperty("https.proxyHost","172.16.0.3");
System.setProperty("https.proxyPort","8080");
BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
System.out.println(" enter the url u want to open ");
String s =br.readLine();
DataOutputStream dos=new DataOutputStream(s1.getOutputStream());
dos.writeBytes(s);
dos.close();
	}		
}
 