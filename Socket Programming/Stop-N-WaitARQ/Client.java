import java.io.*;
import java.net.*;

public class Client
{	public static void main(String args[]) throws IOException 
	{	ServerSocket receiver = new ServerSocket(2089);
		Socket connection=null;
		ObjectOutputStream out=null;
		ObjectInputStream in=null;
		String packet="",ack,data="";
		int i=0,sequence=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		connection=receiver.accept();
		sequence=0;
		out=new ObjectOutputStream(connection.getOutputStream());
		out.flush();
		in=new ObjectInputStream(connection.getInputStream());
		out.writeObject("Connected.");
                while(!(packet.equals("end")))
		{	try
			{	packet=(String)in.readObject();
				if(Integer.valueOf(packet.substring(0,1))==sequence)
				{	data+=(" ");
                                        data+=packet.substring(1,packet.length());
					sequence=(sequence==0)?1:0;
					System.out.println("Receiver- "+packet);
				}
				else 
					System.out.println("Receiver- "+packet +"--> Duplicate Data\n");
				out.writeObject(String.valueOf(sequence));
				i++;
			} catch(Exception e){}
		}
		if(packet.equals("end"))
			data+="\0";
		System.out.println("Data received= "+data);
		in.close();
		out.close();
		receiver.close();
	}
}
