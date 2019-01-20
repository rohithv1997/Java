import java.io.*;
import java.net.*;
import java.lang.*;
import java.util.LinkedList;
import java.util.*;
public class gbnc
{
public static void main(String args[]) throws IOException
{

Socket con =new Socket("localhost",2469);
BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
DataOutputStream toserver= new DataOutputStream(con.getOutputStream());
DataInputStream fromserver = new DataInputStream(con.getInputStream());
LinkedList<String> list = new LinkedList<String>();
int ret=0;
System.out.println("Enter number of frames to be transmitted");
String n=in.readLine();
int nf=Integer.parseInt(n);
toserver.writeBytes(nf+"\n");
int dis = 8;
for(int i=0;i<nf;i++) {
System.out.println("Enter frame"+i+"to be transmitted");
String frame=in.readLine();
list.add(frame);
}
System.out.println(list);
int ack=0;
for(int i=0;i<nf;i++)
{
String str=list.get(i);

toserver.writeBytes(i+"\n");
toserver.writeBytes(str+"\n");

String ak = fromserver.readLine();
ack = Integer.parseInt(ak);
if(ack==dis)
{
  for(int r=ret;r<nf;r++)
  {
  System.out.println("Resending All Frames from::"+r);
  str=list.get(r);
  toserver.writeBytes(r+"\n");
  toserver.writeBytes(str+"\n");
  ak = fromserver.readLine();
  ack = Integer.parseInt(ak); 
  System.out.println(" ack received for "+ack); 
  break;
}
}
else
{System.out.println(" ack received for "+ack);
if(ack==nf)
{
 ack++;
 break;
}

 ret++;
}}

/*if(ack<=nf)
 {for(int r=ack;r<nf;r++)
{*/

/*}}*/
fromserver.close();
toserver.close();
con.close();

}
}
