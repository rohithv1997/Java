package lab;
import java.io.*;
import java.net.*;
import java.util.*;
public class paritygen {

	 public static void main(String args[])
     {
     try       
     {         
      BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
      Socket clsct=new Socket("127.0.0.1",1434);
      DataInputStream din=new DataInputStream(clsct.getInputStream());
      DataOutputStream dout=new DataOutputStream(clsct.getOutputStream());	
      System.out.println("Enter the binary data:");
      int count=0;
      String arr[]=new String[8];
       for(int i=0;i<7;i++)
          {
                 arr[i]=in.readLine();
                 if(arr[i].equals("1"))
                 {
                    count++;
                 }
         }
       System.out.println("enter the parity u want even or odd 0 for even parity and 1 for odd parity \n");
      int  x=Integer.parseInt(in.readLine());
       switch(x)
       {
       case 0:
             if(count%2==0)
             {
            	arr[7]="0"; 
             }
             else
            	 arr[7]="1";
                  break;
       case 1:
    	   if(count%2==1)
    	   {
    		   arr[7]="0";
    	   }
    	   else
    	   {
    		   arr[7]="1";
    	   }
    	   break;
       }
       System.out.println("The data we are going to transmit is :");
       for(int i=0;i<8;i++){
    	   System.out.print(arr[i]);
       }
       System.out.println();
     //System.out.println(" do u want to take risk sending the packet in noisy channel??");
     //int y=Integer.parseInt(in.readLine());
    // if(y==1)
      Random r=new Random(); 
      int num=r.nextInt(6);
      if(arr[num].equals("0"))
       {
    	 arr[num]="1";
       }
     else
    	 arr[num]="0";
      
    
     System.out.println("enter the parity u used for security");
     String s=new String();
     s=in.readLine();	
     DataOutputStream dout1=new DataOutputStream(clsct.getOutputStream());
     dout1.writeBytes(s+"\n");
     System.out.println(din.readUTF());
     
     for(int i=0;i<8;i++)
     { dout.writeBytes(arr[i]+'\n');
     }         
     String str=din.readLine();
     System.out.println(str);                      
     clsct.close();
}
catch (Exception e)
{          System.out.println(e); }
}}	 