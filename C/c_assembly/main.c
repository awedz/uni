#include <stdio.h>
#include <stdlib.h>

// typedef struct node{
//     int data;
//     struct node *next;
// }node_t;
void Add(struct node * head, int newData);
void Print(struct node * head);
void main()
{

    int a = 1, b = 2,c = a + b;
    int arr[] = {1,2,3,4,5};
    // struct node *head = (struct node*)malloc(sizeof(struct node));
    // head->data = a;
    // head->next =NULL;
    // Add(head,b);
    // Add(head,c);

    // Print(head);
}


// void Add(struct node * head, int newData)
// {
//     struct node *temp = head; 
//     struct node * newNode = (struct node*)malloc(sizeof(struct node));
//     newNode ->data = newData;
//     newNode->next = NULL;
//     while(temp->next)
//     {
//         temp = temp->next;
//     }
//     temp->next = newNode;
// }
// void Print(struct node * head)
// {
//     struct node *temp = head; 
//     while(temp)
//     {
//         printf("%d\n",temp->data);
//         temp = temp->next;
//     }
// }



