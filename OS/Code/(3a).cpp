#include<stdio.h>
#include<conio.h>
int main()
{
char a[100], n; int s, ch, r=0, i; int last = 0; int l = 0, m, b; int intf=0, extf=0;

for(i=0;i<100;i++)
a[i]= '0';
printf("\n enter the size of memory and the no. of blocks to be made : ");
scanf("%d %d", &m , &b);
l = m / b;
do{
printf("\n enter the name and size of file to be stored : ");
scanf("%s %d", &n, &s);
if(s > l)
{printf("\n file size too big!");  }
else if(s <= l)
{
for(i=last;i<s;i++)          { a[i] = n; }
r = l - s;

intf = intf + r;
last += (s + r);
extf = m - last;
printf("\n internal fragmentation is %d and external fragmentation is %d", intf, extf);
}
printf("\n enter 1 to continue! \n"); scanf("%d", &ch);
} while(ch==1);
getch();
return 0;
}
