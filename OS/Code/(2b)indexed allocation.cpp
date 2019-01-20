#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
int main()
{
int f[20], n,q; int s,b,con,l,ch,i,ctr=0; int flag=0;
for(i=0;i<20;i++)
f[i]='\0';
for(i=0;i<20;i++)
{
if(i%7=='\0')
f[i]=1;
}
do{
//X:
printf("\n enter 1 to give input, 2 to check existing file location: "); scanf("%d",&s);
switch(s)
{
case 1:
printf("\n enter the name of the file : ");
scanf("%d",&n);
printf(" enter the base address and the size of the file : ");
scanf("%d %d",&b,&l);
for(i=0;i<20;i++)
{
if(f[i]=='\0')  ctr++;
}
if(l>ctr) 
{
  printf("\n storage not sufficient");  
}
else
{
  for(i=b;i<20;i++)
  {
   if(f[i]=='\0')  {  f[i]=n; l--;  }
   if(l==0) break;
  }
  if(l>0)
  {
  for(i=0;i<b;i++)
  { if(f[i]=='\0')  {  f[i]=n; l--;  }
   if(l==0) break;  }
  }
}
for(int m=0;m<20;m++)
printf("\t %d -> %d",m,f[m]);

break;

case 2:
printf("\n enter the file name: "); scanf("%d",&q);
for(i=0;i<20;i++)
{
if(f[i]==q) {
flag=1; break;}
}
if(flag==1)
{
for(i=0;i<20;i++){
if(f[i]==q)
printf("\t %d ",i);}
}
else
printf("\n doesnt exist");
break;
}
printf("\n enter 1 to continue..."); scanf("%d",&con);
}while(con==1);
//if(con==1) goto X;
getch();
return 0;
}

