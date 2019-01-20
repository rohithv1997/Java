import java.util.Scanner;

public class Scheduling_FCFS
{   public static void main(String args[])
    {   String pid[]=new String[10];
        int n=0;
        int i, flag=-1, pos=-1;
        int sum=0, c=0;
        int at[]=new int[10];
        int bt[]=new int[10];
        int wt[]=new int[10];
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
        }
	for(i=0;i<n;i++)
            if(at[i]==0)
            {   wt[i]=0;
		c=0;
                sum+=wt[i];
                flag=i;
                pos=i;
                break;
            }
        for(i=0;i<n;i++)
            if(i!=pos)
            {   c+=bt[flag];
                wt[i]=c-at[i];
                sum+=wt[i];
                flag=i;
            }
        for(i=0;i<n;i++)
        {   System.out.println("\nProcess ID:\t"+pid[i]);
            System.out.println("Arrival Time:\t"+at[i]);
            System.out.println("Burst Time:\t"+bt[i]);
            System.out.println("Waiting Time:\t"+wt[i]);
        }
        System.out.println("Average Waiting Time:\t"+(sum/(float)(n))+" ms");
    }
}