#include<iostream>
#include<conio.h>
using namespace std;

int main(){
	
	int a[20],b[20],e[20],n,k=0,temp=0;
	int c[20],d[20],i,wait=0,sum=0,j=0,ctr=0,p=0;
	
	cout<<"enter the no of processes";
	cin>>n;
	cout<<"enter the slice time";
	cin>>k;
	
	for(i=0;i<n;i++){
	cout<<" process name:";
	cin>>a[i];
	cout<<" burst time:";
	cin>>b[i];
	cout<<"\n";
	}
	
	for(i=0;i<n;i++)
	sum+=b[i];
	cout<<"sum is:"<<sum;

	while(sum!=0){
     
     for(i=0;i<n;i++){
     if(b[i]!=0){
     temp=b[i];
     c[p++]=wait;
     
     if(temp>=k){
     cout<<"\n waiting time:"<<wait;
     wait+=k;
     b[i]-=k;
     sum-=k;
     }
     
     else if(temp<k&&temp>0){
     cout<<"\n waiting time:"<<wait;
     wait+=temp;
     b[i]-=temp;
     sum-=temp;
     }
     
     if(b[i]==0){
     d[i]=wait;
     //cout<<"\n TAT:"<<d[i]<<"\n";
     }
     //cout<<" "<<temp<<" "<<wait<<" "<<b[i]<<" "<<sum<<"\n";
     e[j++]=a[i];
     ctr++;
     }}
     }
      c[p++]=wait; 
    for(i=0;i<n;i++)
    cout<<"\n turnaround time:"<<d[i];
    cout<<"\n";
    	cout<<"|\t";
	for(i=0;i<ctr;i++)
	cout<<e[i]<<" |\t";
	cout<<"\n";
	
	for(i=0;i<ctr+1;i++)
	cout<<c[i]<<"\t ";
    getch();
    return 0;
    }
