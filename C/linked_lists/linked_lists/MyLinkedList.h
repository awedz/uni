#pragma once
#ifndef MYLINKEDLIST_H
# define MYLINKEDLIST_H
#include <stdio.h>
#include "stdlib.h"

typedef struct node
{
	int data;
	struct node * next;
}node_t;


typedef struct MyList
{
	node_t head;
	void(*append)(int data, node_t **Curr);
	void(*push)(int Data, node_t **Curr);
	void(*printListItems)(node_t **Curr);
}MyList;

void Push(int Data, node_t **Curr);
void Append(int data, node_t **Curr);
void PrintListItems(node_t ** Head);


void InitList(MyList *list);
#endif


