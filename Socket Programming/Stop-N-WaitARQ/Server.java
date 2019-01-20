import java.io.*;
import java.net.*;
import java.util.*;

public class Server
{	public static void main(String args[]) throws IOException
	{	Socket sender=null;
		ObjectOutputStream out=null;
		ObjectInputStream in=null;
                Scanner me=new Scanner(System.in);
		String packet="",ack,str, msg="";
		int n,i=0,sequence=0;
		try
		{	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			sender = new Socket("localhost",2089);
			sequence=0;
			out=new ObjectOutputStream(sender.getOutputStream());
			out.flush();
			in=new ObjectInputStream(sender.getInputStream());
			str=(String)in.readObject();
			System.out.println("Receiver- "+str);
                        System.out.println("Enter Number Of Frames: \t");
                        n=me.nextInt();
			
			while(i<n)
			{		
                                        System.out.println("Enter Data to be Sent: \t");
                                        packet=br.readLine();
                                        if(i<n)
					{	msg=String.valueOf(sequence);
						msg=msg.concat(packet);
					} 
					
					out.writeObject(msg);
					sequence=(sequence==0)?1:0;
					out.flush();
					System.out.println("Packet Sent- "+msg);
					ack=(String)in.readObject();
					System.out.println("Waiting for Acknowledgement....");
					if(ack.equals(String.valueOf(sequence)))
					{	i++;
						System.out.println("Receiver- Packet Received\n");
					}
					else
					{	System.out.println("Time Out:\t Resending Data\n");
						sequence=(sequence==0)?1:0;
					}
				
			}
			if(i==n)
                        {	msg="end";
				out.writeObject(msg);
			}
			System.out.println("All data Sent.");
			br.close();
		}catch(Exception e){}
		in.close();
		out.close();
	}
}
