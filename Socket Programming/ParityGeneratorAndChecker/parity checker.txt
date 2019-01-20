package lab;
import java.io.*;
import java.net.*;
import java.util.*;
public class paritycheck {
	 public static void main(String args[])
     {
     try
    {         
                 ServerSocket obj=new ServerSocket(1434);
                 Socket obj1=obj.accept();	
                 DataInputStream din=new DataInputStream(obj1.getInputStream());
                 DataOutputStream dout=new DataOutputStream(obj1.getOutputStream());
                 String str[]=new String[8];
                 String str1="Data Received Correctly";
                 String str2="Retransmit the data";
                 DataInputStream din1=new DataInputStream(obj1.getInputStream());
                 String parity=din1.readLine(); 
                 String ack="recieved the parity now send the data ";
                 dout.writeUTF(ack+"\n");
                 int count=0;
                 for(int i=0;i<7;i++)
                 {
                             str[i]=din.readLine();
                             System.out.print(str[i]);
                             if(str[i].equals("1"))
                             {
                            	 count++;
                             }
                  }
                 str[7]=din.readLine();
                 if(parity.equals("even"))
                 {
                	 if(((count%2==0)&& str[7].equals("0"))||(count%2==1)&& str[7].equals("1"))
                 {  dout.writeBytes(str1+'\n');
                 } 
                  else{
                	 dout.writeBytes(str2+'\n');
                 }
                 }
                 else if(parity.equals("odd"))
                 {
                	 if(((count%2==1)&& str[7].equals("0"))||(count%2==0)&& str[7].equals("1"))
                 {
                 dout.writeBytes(str1+'\n');
                 }
                 else
                 {
                	 dout.writeBytes(str2+'\n');
                 }	 
                 }
                 obj.close();
                 obj1.close();
                 
    }
                 catch(Exception e)
                 {System.out.println(e);}
                 }
	            
}