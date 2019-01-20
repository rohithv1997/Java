import java.io.*;
import  java.net.*;

public class Server 
{   public static void main(String args[]) throws IOException
    {   ServerSocket ss=new ServerSocket(4001);
        Socket s=ss.accept();
        String str=" ", str1=" ";
	Boolean flag=true;
        PrintStream ps=new PrintStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
        BufferedReader br2=new BufferedReader(new InputStreamReader(System.in));
        while(flag)
        {	str1=br.readLine();
            	System.out.println("\nClient: "+str1);
            	System.out.print("Me:   ");
            	str=br2.readLine();
            	ps.println(str);
                if(str.equals("exit")|| str1.equals("exit"))
                {	flag=false;
                        break;
                }  
        }
        br2.close();
        br.close();
        ps.close();
        s.close();
        ss.close();
            
    }
    
}
