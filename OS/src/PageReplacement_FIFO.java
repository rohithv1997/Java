import java.util.Scanner;

public class PageReplacement_FIFO
{   public static void main(String[] args)
    {   int i, j, k=0, check, src, n, f, flag=0;
        Scanner me=new Scanner(System.in);
        System.out.print("Enter Reference Page Size: ");
        n=me.nextInt();
        int ref[]=new int[n];
        System.out.println("Enter Reference Page: ");
        for(i=0;i<n;i++)
            ref[i]=me.nextInt();
        System.out.print("Enter Frame Size:\t"); 
        f=me.nextInt();
        int buf[]=new int[f];
        int fault=0;
        for(i=0;i<f;i++)  buf[i]=-1;
        System.out.println("Memory Page:");
        for(i=0;i<n;i++)
        {   src=ref[k++];
            check=0;
            for(j=0;j<f;j++)
                if(buf[j]==src) { check=1; break; }
            if(check!=1)
            {   if(buf[flag]==-1) --fault;
                buf[flag]=src;
                flag=(flag+1)%f;
                ++fault;
            }
            for(j=0;j<f;j++)
                if(buf[j]==-1)
                    System.out.print("  ");
                else
                    System.out.print(buf[j]+"  ");
            System.out.println();
        }
        System.out.print("Faults= "+fault);
        me.close();
    }
}