import java.util.Scanner;

public class Scheduling_SJF_NonPreEmptive 
{   public static void main(String args[])
    {   String pid[]=new String[10];
        int n;
        int i, j;
        int sum=0, c=0, tmp, pos=0,pos2=-1, flag=-1;
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
        int sort[]=new int[10];
        for(i=0;i<n;i++)
        {   if(at[i]==0)
            {   wt[i]=0;
                sum+=wt[i];
                flag=bt[i];
                pos2=i;
                break;
            } 
        }
        for(i=0;i<n;i++)
            if(i!=pos2)
            {   sort[pos]=bt[i];      
                pos++;
            }   
        
        
        for(i=0;i<pos;i++)
            for(j=i+1;j<pos;j++)
                if(sort[i]>sort[j])
                {   tmp=sort[i];
                    sort[i]=sort[j];
                    sort[j]=tmp;
                }
        
        for(j=0;j<pos;j++)
            for(i=0;i<n;i++)
                {   if(sort[j]==bt[i] && at[i]!=0)
                    {	if(j==0)
                            c+=flag;
                	else
                            c+=sort[j-1];
                	wt[i]=c-at[i];
                        sum+=wt[i];
                    }
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

