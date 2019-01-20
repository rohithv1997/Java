import java.util.Scanner;

public class PageReplacement_LRU 
{   public static void main(String[] args) 
    {   int n, i, j, check=-1, min=999, ptr=0, fault=0;
        System.out.print("Enter Reference Page Size:\t");
        Scanner me=new Scanner(System.in);
        n=me.nextInt();
        int ref[]=new int[n];
        System.out.print("Enter Reference Page:\t");
        for(i=0;i<n;i++) ref[i]=me.nextInt();
        System.out.print("Enter Frame Size:\t");
        int f=me.nextInt();
        int buf[]=new int[f]; int flag[]=new int[f];
        for(i=0;i<f;i++) { buf[i]=-1; flag[i]=-1; }
        boolean isfull=false;
        System.out.println("Frame Page:");
        for(i=0;i<n;i++)
        {   check=0;
            for(j=0;j<f;j++)
            {   if(buf[j]==-1 && !isfull)
                {   buf[j]=ref[i]; ptr++; check=1; flag[j]=i;
                    if(ptr==f){ isfull=true; ptr=0; }
                    break;
                }
                else if(buf[j]==ref[i]) { flag[j]=i; check=2; break; } 
            }
            if(check==0 && isfull==true)
            {   min=999; ptr=-1;
                for(j=0;j<f;j++)
                    if(min>flag[j]) { ptr=j; min=flag[j]; }
                buf[ptr]=ref[i]; flag[ptr]=i;
                ++fault;
            }
            for(j=0;j<f;j++) 
                if(buf[j]==-1)
                    System.out.print("  ");
                else
                    System.out.print(buf[j]+" ");
            System.out.println();
        }
        System.out.print("Faults= "+fault);
        me.close();
    }
}