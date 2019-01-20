import java.io.*;
import java.net.*;

class Client
{       public static void main(String args[])throws IOException
        {       Socket s=new Socket("localhost",6790);		
		DataOutputStream dos=new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str="Hi! Server here",str1;
		dos.writeBytes(str+"\n");
		str1=br.readLine();
		System.out.println(str1);
		br.close();
		dos.close();
             
        }
}
//sent Side
