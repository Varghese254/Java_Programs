//converting an infix expression into postfix using stack
#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#define max 100
int priorty(char operator)
{
	switch(operator)
	{
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		case '^':
			return 3;
		default:
			return -1;			
	}
}
int check_operator(char ch)
{
		return(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^');
}
char* infixTopostfix(char* infix)
{
	int i,j;
	int len=strlen(infix);
	char* postfix=(char*)malloc(sizeof(char)*(len+2));
	char stack[max];
	int top=-1;
	for(i=0,j=0;i<len;i++)
	{
			if(infix[i]==' ' || infix[i]=='\t')
			continue;
			if(isalnum(infix[i]))
			{
					stack[++top]=infix[i];
			}
			else if(infix[i]=='(')
			{
					stack[++top]=infix[i];

			}
			else if(infix[i]==')')
			{
					while(top>-1 && stack[top]!='(')
						postfix[j++]=stack[top--];
					if(top>-1 && stack[top]!='(')
						return "invalid";
					else
						top--;	
			}
			else if(check_operator(infix[i]))
			{
					while(top>-1 && priorty(stack[top])>=priorty(infix[i]))
					postfix[j++]=stack[top--];
					stack[++top]=infix[i];
			}
	}	
	while(top>-1)
	{
			if(stack[top]=='(')
			{
					return "invalid";
					
			}
			postfix[j++]=stack[top--];
	}
	postfix[j]='\0';
	return postfix;
}

int main()
{
		char infix[max]="a+b";
		char* postfix=infixTopostfix(infix);
		printf("%s\n",postfix);
		free(postfix);
		return 0;
}
