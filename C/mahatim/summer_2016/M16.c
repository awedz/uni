#include <stdio.h>
#include <stdlib.h>

typedef struct node
{
    int data;
    struct node * next1;
    struct node * next2;
} node_t;

//node_t *func(int num[10]);
void func(int num[10]);
void main()
{
    int arr[] = {1,2,3,4,5,6,7,8,9,10};
}

void func(int num[10])
{
    node_t *temp;
    node_t *head;
    int i = 0;
    for(i = 0; i < 10; i++)
    {
        temp = (node_t*)malloc(sizeof(node_t));
        temp->data = num[i];
        temp->next1 = NULL;
        temp->next2 = NULL;
        if(i==0)
        {
            head = temp;
        }
        else{
            


        }
    }
    temp = head;
    while(temp)
    {
        printf("%d",temp->data);
        temp = temp->next1;
    }
}
