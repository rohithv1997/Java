import java.net.*;
import java.io.*;
import java.util.*;
class Sender
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
for(k=1;k<sz;k++)
for(j=0;j<11;j++)
if((a[k])==j)
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
int codeword[] = new int[11];
int i,flag=0,r0,r11,r3,r7,j,k,c=0,d=0,f=0,e=0;
String input="",str="";
System.out.println(" Enter whether to apply parity even or odd ");
input = sc.nextLine();
if(input.equalsIgnoreCase("even"))
flag=0;
else
flag=1;
for(i=0;i<11;i++)
{ if(s1[i].charAt(3)=='1')
r1[c++]= i;
if(s1[i].charAt(2)=='1')
r2[d++] = i;
if(s1[i].charAt(1) =='1')
r4[e++]= i;
if(s1[i].charAt(0) =='1')
r8[f++]= i;
}
System.out.println("Enter the dataword");
for(i=0;i<11;i++)
if(i!=0 && i!=1 && i!=3 && i!=7)
codeword[i] = sc.nextInt();
r0= scan(r1,c,codeword,flag);
r11= scan(r2,d,codeword,flag);
r3= scan(r4,e,codeword,flag);
r7 = scan(r8,f,codeword,flag);
codeword[0]=r0;
codeword[1]=r11;
codeword[3]=r3;
codeword[7]= r7;
for(i=0;i<11;i++)
str=str+codeword[i];
str=str+"\n";
System.out.println("Transmitting codeword");
for(i=0;i<11;i++)
System.out.println(codeword[i]);
ServerSocket ss = new ServerSocket(8080);
Socket s =ss.accept();
DataOutputStream dos =
new DataOutputStream(s.getOutputStream());
dos.writeBytes(str+"\n");
}
}