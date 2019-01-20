import java.io.*;
import java.net.*;

class Server
{       public static void main(String args[]) throws IOException
        {       ServerSocket ss = new ServerSocket(6790);
                Socket s = ss.accept();
               	PrintStream ps=new PrintStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
		String str;
		str=br.readLine();
		ps.println(str);
		br.close();
		ps.close();
		s.close();
		ss.close();
        }
}
//ssver Side

