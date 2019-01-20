import java.util.*;

public class Scheduling_RoundRobin
{   public static void main(String args[])
    {   String pid[]=new String[10];
        int n=0, i=0, j=0, sum=0, count=0;
        int at[]=new int[10];
        int bt[]=new int[10];
        int q;
        int wt[]=new int[10];
        int rt[]=new int[10];
	int st[]=new int[10];
        int end[]=new int[10];
        
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
            wt[i]=0;
            count+=bt[i];
            st[i]=0;
            end[i]=0;
            rt[i]=bt[i];
        }
        
        System.out.print("\nEnter Quantum:\t");
        q=me.nextInt();
        System.out.println();
	             
        sum=count;
        i=0;
        j=0;
            
        while(sum!=0 && i<count)
        {   if(at[j]<=i && rt[j]!=0)
            {   if(rt[j]>q)
                {   st[j]=i;
                    wt[j]+=(st[j]-end[j]);
                    i+=q;
                    end[j]=i;
                    rt[j]-=q;
                    sum-=q;
                }
                else if(rt[j]<=q && rt[j]!=0)    
                {   st[j]=i;
                    wt[j]+=(st[j]-end[j]);
                    i+=rt[j];
                    end[j]=i;
                    sum-=rt[j];
                    rt[j]=0;
                }
            }
            j=(j+1)%n;
        }
        
        sum=0;
        for(i=0;i<n;i++)
        {   wt[i]-=at[i];
            System.out.println("\nProcess ID:\t"+pid[i]);
            System.out.println("Arrival Time:\t"+at[i]);
            System.out.println("Burst Time:\t"+bt[i]);
            System.out.println("Quantum:\t"+q);
            System.out.println("Waiting Time:\t"+wt[i]);
            sum+=wt[i];
        }
        System.out.println("\nAverage Waiting Time:\t"+(sum/(float)(n))+"ms");
    }
}