import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Receiver1
{
	public static void main(String[] args) {
		try {
			Socket socket=new Socket("localhost",7093);
			System.out.println("Request sent....");
			int num;
			int i=0;
			int k=0;
			String[] a=new String[2];
			String str=null;
			int frame=0;
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			Scanner sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("Waiting for frames:::;");
				str=dis.readUTF();
				StringTokenizer stkr=new StringTokenizer(str,";");
				while(stkr.hasMoreTokens())
				{
					a[i]=stkr.nextToken();
					i++;
				}
                if(a[0].equalsIgnoreCase("error"))
                {
                	System.out.println("ERROR HAS OCCURED!!!");
                	System.out.println();
                	System.out.println();
                	System.out.println("Again send the frame"+a[1]);
              //  	dos.writeUTF("NACK"+";"+frame);
                	 
                }
                else
                {
                	System.out.println("SUCCESSFULLY RECEIVED FRAME"+ a[1]);
                	System.out.println("DATA::"+a[0]);
                	frame++;
                	dos.writeUTF("ACKN"+";"+frame);
              
                }
               String str4=dis.readUTF();
               StringTokenizer stkr2=new StringTokenizer(str,";");
				while(stkr.hasMoreTokens())
				{
					a[k]=stkr.nextToken();
					k++;
				}
				
                System.out.println(str4);
               i=0;
			}


		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   



	}
}