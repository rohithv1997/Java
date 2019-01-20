import java.util.Scanner;

public class Scheduling_Priority_PreEmptive
{   public static void main(String args[])
    {   String pid[]=new String[10];
        int n;
        int i, j;
        int sum=0, count=0, flag=0, min=9999;
        int at[]=new int[10];
        int bt[]=new int[10];
        int p[]=new int[10];
        int wt[]=new int[10];
        int rt[]=new int[10];

        Scanner me=new Scanner(System.in);
        System.out.print("Enter No.of Process:\t");
        n=me.nextInt();
        for(i=0;i<n;i++)
        {   System.out.print("\nEnter Process ID:\t");
            pid[i]=me.next();
            System.out.print("Enter Arrival Time:\t");
            at[i]=me.nextInt();
            System.out.print("Enter Burst Time:\t");
            bt[i]=me.nextInt();
            System.out.print("Enter Priority:\t");
            p[i]=me.nextInt();
            wt[i]=0;
            rt[i]=bt[i];
            count+=bt[i];
        }
        
        for(i=0;i<count;i++)
        {   min=9999;
            flag=-1;
            for(j=0;j<n;j++)
                if(at[j]<=i && rt[j]!=0 && p[j]<min)
                {   min=p[j];
                    flag=j;
                }
            rt[flag]--;
            for(j=0;j<n;j++)
               if(at[j]<=i && rt[j]!=0 && j!=flag) 
                    wt[j]++;
        }
        
        for(i=0;i<n;i++)
        {   System.out.println("\nProcess ID:\t"+pid[i]);
            System.out.println("Arrival Time:\t"+at[i]);
            System.out.println("Burst Time:\t"+bt[i]);
            System.out.println("Priority:\t"+p[i]);
            System.out.println("Waiting Time:\t"+wt[i]);
            sum+=wt[i];
        }
        System.out.println("Average Waiting Time:\t ms"+(sum/(float)(n)));
        
    }
}
