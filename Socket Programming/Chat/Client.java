import java.io.*;
import  java.net.*;

public class Client 
{   public static void main(String args[]) throws IOException
    {   Socket s=new Socket("localhost",4001);
        String str2=" ", str11=" ";
	Boolean flag=true;
        PrintStream ps1=new PrintStream(s.getOutputStream());
        BufferedReader br1=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader br21=new BufferedReader(new InputStreamReader(System.in));
        while(flag)
        {   System.out.print("\nMe:\t ");
            str2=br21.readLine();
            ps1.println(str2);
            str11=br1.readLine();
            System.out.print("Server:   "+str11);
            if(str11.equals("exit") || str2.equals("exit"))
            {	flag=false;
                break;
            }
        }
        br21.close();
        br1.close();
        ps1.close();
        s.close();
        
    }
    
}

