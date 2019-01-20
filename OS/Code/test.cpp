#include<iostream>
using namespace std;
int main()
{ int i=1,totmem,mempro[10],extfrag,memallocated;
  int c;
  cout<<"Enter total memory available:";
  cin>>totmem;
  extfrag=totmem;
  do
  { cout<<"\nEnter memory required for process"<<i<<": ";
    cin>>mempro[i];
    extfrag-=mempro[i];
    if(extfrag>0)
    { cout<<"\nMemory allocated for process"<<i<<"\nDo you want to continue? press 1:\n";
      cin>>c;
    }
    else
    { cout<<"\nMemory is full";
      extfrag+=mempro[i];
      c=0;
			break;
    }
		i++;
  }while(c==1);
    memallocated=totmem-extfrag;
    cout<<"\nTotal memory available:"<<totmem;
    cout<<"\nTotal memory allocated:"<<memallocated;
    cout<<"\nTotal ext fragmentation:"<<extfrag;
    return 0;
}
