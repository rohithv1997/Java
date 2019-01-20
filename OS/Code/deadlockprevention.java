import java.util.*;
class deadlockprevention
{
         
 public static void main(String args[])
 {
     Scanner sc = new Scanner(System.in);
     int i,j,n,r;
      System.out.println("Enter the no. of processes");
      n = sc.nextInt();
      System.out.println("Enter the no. of resources");
      r = sc.nextInt();
      int avail[] = new int[100];
      int max[][]= new int[n][r];
      int alloc[][]= new int[n][r];
      System.out.println("Enter the request matrix");
      for(i=0;i<n;i++)
        {
            for(j=0;j<r;j++)
            {
            max[i][j] = sc.nextInt();
             }
        
        }
        System.out.println("Enter the allocation matrix");
        for(i=0;i<n;i++)
        {
            for(j=0;j<r;j++)
            {
            alloc[i][j] = sc.nextInt();
             }
        
        }
        System.out.println("Enter the available vector");
        for(j=0;j<r;j++)
            {
            avail[i] = sc.nextInt();
             }
             System.out.print("Process\t Allocation\t Max\t Available\t");
             for(i=0;i<n;i++)
               {
                              System.out.print("\nP"+(i+1)+"\t   ");
                              for(j=0;j<r;j++)
                              {
                                             System.out.print(""+alloc[i][j]+" ");
                              }
                              System.out.print("\t");
                              for(j=0;j<r;j++)
                              {
                                             System.out.print(""+max[i][j]+" ");
                              }
                              System.out.print("\t");
                              if(i==0)
                              {
                                             for(j=0;j<r;j++)
                                             System.out.print(""+avail[j]+" ");
                              }
               }
               int finish[]=new int[100],temp,flag=1,k,c1=0;int need[][]= new int [100][100];
               int dead[]=new int [100];
               int safe[]=new int[100];
               
               for(i=0;i<n;i++)
               {
                              finish[i]=0;
               }
               //find need matrix
               for(i=0;i<n;i++)
               {
                              for(j=0;j<r;j++)
                              {
                                             need[i][j]=max[i][j]-alloc[i][j];
                              }
               }
               while(flag!=0)
               {
                              flag=0;
                              for(i=0;i<n;i++)
                              {
                                             int c=0;
                                             for(j=0;j<r;j++)
                                             {
                                                            if((finish[i]==0)&&(need[i][j]<=avail[j]))
                                                            {
                                                                           c++;
                                                                           if(c==r)
                                                                           {
                                                                                          for(k=0;k<r;k++)
                                                                                          {
                                                                                                         avail[k]+=alloc[i][j];
                                                                                                         finish[i]=1;
                                                                                                         flag=1;
                                                                                          }
                                                                                           //printf("\nP%d",i);
                                                                                           if(finish[i]==1)
                                                                                          {
                                                                                                         i=n;
                                                                              }
                                                                  }
                                                      }
                                          }
                             }
                }
                j=0;
                flag=0;
                for(i=0;i<n;i++)
                {
                              if(finish[i]==0)
                              {
                                             dead[j]=i;
                                             j++;
                                             flag=1;
                              }
               }
               if(flag==1)
               {
                              System.out.print("\n\nSystem is in Deadlock and the Deadlock process are\n");
                              for(i=0;i<n;i++)
                              {
                                             System.out.print("P"+dead[i]+"\t");
                              }
               }
               else
               {
                              System.out.print("\nNo Deadlock Occur");
               }
            }
        }