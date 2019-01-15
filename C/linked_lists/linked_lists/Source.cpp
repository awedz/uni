#include "stdio.h"
#include "conio.h"
#include "stdlib.h"
#include "MyLinkedList.h"

void main()
{
	node_t *head = NULL;
	MyList a;
	InitList(&a);
		int input;
		do
		{
			printf("input a number");
			scanf_s("%d", &input);
			if (input != 0)
				Append(input, &head);
		} while (input != 0);
	a.printListItems(&head);



	_getch();
}
//typedef struct node
//{
//	int data;
//	struct node * next;
//}node_t;
//
//typedef struct FuncTest
//{
//	int a;
//	void(*fun)(int *a);
//}FuncTest;
//
//void Push(int Data, node_t *Curr);
//void Append(int data, node_t **Curr);
//void PrintListItems(node_t ** Head);
//
//
//void Multi(int *a);
//
//	struct FuncTest test;
//	test.a = 2;
//	printf("%d\n", test.a);
//	test.fun = Multi;
//	test.fun(&test.a);
//	printf("%d\n",test.a);
//
//	//node_t * head = NULL;
//	//int input;
//	//do
//	//{
//	//	printf("input a number");
//	//	scanf_s("%d", &input);
//	//	if (input != 0)
//	//		Append(input, &head);
//	//} while (input != 0);
//	//PrintListItems(&head);
//	_getch();
//}
//
//
//
//void Multi(int *a)
//{
//	int temp = *a;
//	temp *= 2;
//	*a = temp;
//}
//void Push(int Data, node_t *Curr)
//{
//	node_t *new_node = (node_t*)malloc(sizeof(node_t));
//	new_node->data = Data;
//	new_node->next = Curr;
//	Curr = new_node;
//}
//void Append(int Data, node_t **Curr)
//{
//	node_t *temp = (*Curr);
//	node_t *new_data = (node_t*)malloc(sizeof(node_t));
//	new_data->data = Data;
//	new_data->next = NULL;
//
//	if ((*Curr) == NULL)
//	{
//		(*Curr) = new_data;
//		return;
//	}
//
//	while (temp->next != NULL)
//	{
//		temp = temp->next;
//	}
//	temp->next = new_data;
//}
//void PrintListItems(node_t ** Head)
//{
//	while ((*Head) != NULL)
//	{
//		printf(" %d ", (*Head)->data);
//		(*Head) = (*Head)->next;
//	}
//}
