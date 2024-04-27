//program to reverse a string using stack
#include<stdio.h>
#include<string.h>
int stack[10],top;
void push(char ch[])
{
	int i;
	if(top==-1)
	{
			printf("stack is empty");
	}
	else
	{
	
		
	        stack[++top]=ch;	
	
		  	
	}
}
void pop()
{
	printf("%c",stack[top--]);
}
int main()
{
	char ch[10];
	int i;
	printf("enter the string into the satck\n");
    gets(ch);
    for(i=0;i<strlen(ch);i++)
    {
    		push(ch[i]);
	}
	printf("The inverted string is:");
	 for(i=0;i<strlen(ch);i++)
    {
    		 pop(ch[i]);
	}


}
