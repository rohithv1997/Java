import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Sender1
{
	public static void main(String[] args) {
		try {
			ServerSocket server=new ServerSocket(7093);
			System.out.println("Server Created....");
			Socket socket=server.accept();
			System.out.println("Request received....");
			int num;
			String[] a=new String[2];
			String str=null;
			int frame=0;
			int j=0;
			DataInputStream dis=new DataInputStream(socket.getInputStream());
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			Scanner sc=new Scanner(System.in);
			while(true)
			{
				System.out.println("Enter the size of the window:");
				num=sc.nextInt();
				for(int i=0;i<num;i++)
				{
					System.out.println("Enter the data to be sent");
					str=sc.next()+";"+frame;
					++frame;
					dos.writeUTF(str);	
				}
				String str2=dis.readUTF();
				StringTokenizer stkr=new StringTokenizer(str2,";");
				while(stkr.hasMoreTokens())
				{
					a[j]=stkr.nextToken();
					j++;
				}
               if(a[0].equalsIgnoreCase("ACKN"))
               {
            	   System.out.println("Successfully sent the window");
            	 
            	   
            	   
               }
               else
               {
            	   System.out.println("Error occured while sending the frame::"+a[1]);
                   System.out.println("RESENDING THE FRAME::");
                   String str4=sc.next()+";"+frame;
            	   dos.writeUTF(str4);
               }
			}




		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



}