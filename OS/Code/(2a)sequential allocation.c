#include<stdio.h>
#include<conio.h>
int main()
{
int f[100],i,st,j,len,c,k;
for(i=0;i<50;i++)
f[i]=0;
do{
printf("\n Enter the starting block & length of file");
scanf("%d%d",&st,&len);
for(i=st;i<(st+len);i++)
if(f[i]==0)
{
f[i]=1;
//printf("\n%d->%d",j,f[j]);
}
else
{
for(j=st;j<=i;j++)   f[j]=0;
printf("Block already allocated");
break;
}
if(j==(st+len))
printf("\n the file is allocated to disk");
for(k=st;k<st+len;k++) printf("\n %d = %d ",k,f[k]);
printf("\n if u want to enter more files?(y-1/n-0)");
scanf("%d",&c);
}while(c==1);
getch();
return 0;
}
