#include "MyLinkedList.h"
void InitList(MyList *list)
{
	list->append = Append;
	list->push = Push;
	list->printListItems = PrintListItems;
}
void Push(int Data, node_t **Curr)
{
	node_t *new_node = (node_t*)malloc(sizeof(node_t));
	new_node->data = Data;
	new_node->next = *Curr;
	*Curr = new_node;
}
void Append(int Data, node_t **Curr)
{
	node_t *temp = (*Curr);
	node_t *new_data = (node_t*)malloc(sizeof(node_t));
	new_data->data = Data;
	new_data->next = NULL;

	if ((*Curr) == NULL)
	{
		(*Curr) = new_data;
		return;
	}

	while (temp->next != NULL)
	{
		temp = temp->next;
	}
	temp->next = new_data;
}
void PrintListItems(node_t ** Head)
{
	while ((*Head) != NULL)
	{
		printf(" %d ", (*Head)->data);
		(*Head) = (*Head)->next;
	}
}