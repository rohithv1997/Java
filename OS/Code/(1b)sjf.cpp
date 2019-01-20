#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
int p[100], bt[100], wt[100], tat[100], btu[100], pu[100],i,n,j,m,l, min, wait; int k=1;
cout<<"\n enter the no. of processes : "; cin>>n;
	cout<<"\n enter the burst time ";
	for(i=1;i<=n;i++)
	{
		cout<<"\n p"<<i<<" = "; cin>>bt[i];
	}
	for(i=1;i<=n;i++)
	btu[i]= bt[i];
		
	for(i=1;i<=n-1;i++)
	{
	   min = btu[i];
	   for(j=i+1;j<=n;j++)
	   {
           if(btu[j]<min)
           {
              min = btu[j];
              btu[i] = (btu[i] + btu[j]) - (btu[j]= btu[i]);
           } 
       }
    }
    for(m=1;m<=n;m++)               for(l=1;l<=n;l++)             {if(btu[m]==bt[l]) pu[k++]=l;}
              
cout<<"\n WAITING TIME ";
wait = 0;
for(i=1;i<=n;i++)
{
wt[i]=wait;
cout<<"\n p"<<pu[i]<<" = "<<wait;
wait = wait + btu[i];
}
cout<<"\n TURN AROUND TIME";
for(i=1;i<=n;i++)
{
tat[i]=wt[i]+btu[i];
cout<<"\n p"<<pu[i]<<" = "<<tat[i];
}
cout<<"\n GAMIT CHART \n|";
for(i=1;i<=n;i++)
	{cout<<"	p"<<pu[i]<<"\t|";}
	cout<<"\n";
for(i=1;i<=n;i++)
	{
	cout<<"   \t\t"<<tat[i];
 	}
getch();
return 0;
}

