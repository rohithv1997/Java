#include<iostream>
#include<conio.h>
using namespace std;
int main()
{
int p[100], bt[100], wt[100], tat[100],pr[100],pru[100],pu[100],btu[100],l,m,i,n,j, min,wait; int k=1, o=1;
cout<<"\n enter the no. of processes : "; cin>>n;
	cout<<"\n enter the burst time ";
	for(i=1;i<=n;i++)
	{
		cout<<"\n p"<<i<<" = "; cin>>bt[i];
	}
	cout<<"\n enter the priority ";
	for(i=1;i<=n;i++)
	{
		cout<<"\n p"<<i<<" = "; cin>>pr[i];
	}
for(i=1;i<=n;i++)
pru[i]= pr[i];

for(i=1;i<=n-1;i++)
{
    min = pru[i];
    for(j=i+1;j<=n;j++)
    {
        if(pru[j]<min)
        {
                min = pru[j];
                pru[i] = (pru[i]+pru[j])-(pru[j]=pru[i]);
        }
    }
}
for(m=1;m<=n;m++)                for(l=1;l<=n;l++)                  if(pru[m]==pr[l]) {pu[k++]=l; btu[o++]=bt[l];}
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
