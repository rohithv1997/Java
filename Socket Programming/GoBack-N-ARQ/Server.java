import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.LinkedList;
public class gbns
{
public static void main(String args[]) throws IOException
{

int dis=8;
int on=1;
ServerSocket s=new ServerSocket(2469);
Socket cs =s.accept();
BufferedReader fromclient = new BufferedReader(new
InputStreamReader(cs.getInputStream()));
DataOutputStream toclient= new DataOutputStream(cs.getOutputStream());
OutputStream output = cs.getOutputStream();
LinkedList<String> list = new LinkedList<String>();

String f = fromclient.readLine();
int nf=Integer.parseInt(f);
System.out.println("Number of frames = "+nf);
int ack=0;




for(int i=0;i<nf;i++) {


String n=fromclient.readLine();
int num=Integer.parseInt(n);
String frame=fromclient.readLine();
list.add(num,frame);


if((frame.equals("hello"))&&(on==1))
{
 toclient.writeBytes(dis+"\n");
 System.out.println("Corrupted Frame::"+num);
 on =0;	
 i--;
 continue;

 
}
System.out.println("received frame"+num+" = "+frame);
toclient.writeBytes(num+"\n");



System.out.println("sending ack"+num);
toclient.flush();


ack++;
}

fromclient.close();
output.close();
cs.close();
}

}

