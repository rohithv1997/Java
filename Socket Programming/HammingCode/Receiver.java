import java.io.*;
import java.net.*;
import java.util.*;
class Receiver
{ public static int chkevenodd(int a[],int f)
{ int i,c=0;
for(i=0;i<a.length;i++)
	if(a[i]==1)
		c++;
if(f==0)
{ if(c%2==0)
	return 0;
else
	return 1;
}
else
{ if(c%2!=0)
	return 0;
else
	return 1;
}
}
public static int scan(int a[],int sz,int cd[],int f)
{ int k,j,g=0;
for(k=0;k<sz;k++)
	for(j=0;j<11;j++)
		if((a[k]-1)==j)
			a[g++]= cd[j];
int r = chkevenodd(a,f);
return r;
}
public static void main(String args[]) throws IOException
{ Scanner sc = new Scanner(System.in);
String s1[]= {"0001","0010","0011","0100","0101","0110","0111","1000","1001","1010","1011"};
int r1[] = new int[10];
int r2[] = new int[10];
int r4[] = new int[10];
int r8[] = new int[10];
String str="",input="";
int a[]= new int[11];
int i,flag,r0,r11,r3,r7,c1=0,pos1=0,d=0,f=0,e=0;;
System.out.println("Even or odd");
input= sc.nextLine();
if(input.equalsIgnoreCase("even"))
	flag=0;
else
	flag=1;
Socket s = new Socket("localhost",8080);
BufferedReader br =
new BufferedReader(new InputStreamReader(s.getInputStream()));
str= br.readLine();
for(i=0;i<11;i++)
{ char c = str.charAt(i);
a[i]= ((int)c) - 48;
}
System.out.println(" After Transmission");
int pos = (int)(Math.random()*(11));
if(a[pos]==0)
	a[pos]=1;
else
	a[pos]=0;
System.out.println("Distorted codeword");
for(i=0;i<11;i++)
	System.out.println(a[i]);
for(i=0;i<11;i++)
{ if(s1[i].charAt(3)=='1')
	r1[c1++]= i+1;
else if(s1[i].charAt(2)=='1')
	r2[d++] = i+1;
else if(s1[i].charAt(1) =='1')
	r4[e++]= i+1;
else
	r8[f++]= i+1;
}
r0= scan(r1,c1,a,flag);
r11= scan(r2,d,a,flag);
r3= scan(r4,e,a,flag);
r7 = scan(r8,f,a,flag);
if(r0==0 && r11==0 && r3==0 && r7==0)
	System.out.println("No Error");
else
{ System.out.println(r0+" "+r11+" "+r3+" "+r7);
pos1= (r0*1)+(r11*2)+(r3*4)+(r7*8);
System.out.println("Error Found at position"+ pos1);
}
}
}