//array
#include<stdio.h>
int pos=-1,array[5];
void insert(int e)
{
	 if(pos+1==5)
	 {
	 	 printf("array is full");
	 }
	 else
	 {
	 	 	array[pos++]=e;
	 }
}
void delete()
{
	if(pos==-1)
	printf("empty");
	else
	 printf("deleted elem is =%d",array[--pos]);
}

void search(int s) {
    int i, flag = 0;
    for (i = 0; i <= pos; i++) {
        if (array[i] == s) {
            flag = 1;
            
        }
    }
    if (flag == 1)
        printf("Element is found.\n");
    else
        printf("Element is not found.\n");
}
void sort() {
    int i, j, temp;
    for (i = 0; i <= pos; i++) {
        for (j = i + 1; j <= pos; j++) {
            if (array[i] > array[j]) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
    }
    printf("Sorted array in ascending order:\n");
    for (i = 0; i <= pos; i++) {
        printf("%d\n", array[i]);
    }
}

int menu()
{
	 int ch;
	  printf("1-insert\n2-delete\n3-search\n4-sort\n5-exit\n enter ur choice\n");
	  scanf("%d",&ch);
	  return ch;
}
void process()
{
	 int ch,n,e;
	 for(ch=menu();ch!=5;ch=menu()){
	  switch(ch)
	 {
	 	case 1: printf("enter thr elem to be inserted");
	 		scanf("%d",&n);
	 		insert(n);
	 		break;
	 	case 2 :delete();
		     break;
	
		case 3:printf("enter  the  elem to be searched:");
		       scanf("%d",&e);
		       search(e);
		       break;
		case 4:sort();
		       break;       
			case 5:printf("exit");
			break;	   	
		default:printf("wrong choice");
			  break;				 	
	 }	
	 }
	
}
int main()
{
	 	process();
}
