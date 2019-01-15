#include <stdio.h>
#include <stdlib.h>
void ex1();
void ex2();
void ex3();
typedef struct node
{
    int num;
    struct node *next1;
    struct node *next2;
}NODE;
int max_up_seq(int num[],int size);
void fillList(struct node *head);
void linq_freq(struct node *head);
int main()
{
    //1)
    //ex1();
    //2)
    //ex2();
    //3)
    ex3();


    return 0;
}

void ex1()
{
    //1)
    int i,j;
    int res;
    res = 0;
    for(i=0;i<12;i++)
        for(j=0;j<10;j++)
            res++;
    printf("%d\n",res);//120
    res=0;
    for(i=0;i<12;i++) res++;
    for(j=0;j<10;j++) res++;
    printf("%d\n",res);//22

    res = i = 0;
    while(++i<12)
        for(j=0;j<10;j++) res++;
    printf("%d\n",res);//110

    i = j = res = 0;
    while(i<12)
    {
        i++;
        while(j<10)
        {
            res++;
            j++;
        }
    }
    printf("%d\n",res);//10
}
void ex2()
{
    int size = 13;
    int arr1[] = {1,3,4,7,5,2,3,4,5,6,7,8,9};
    printf("%d\n",max_up_seq(arr1,size));
    int arr2[] = {1,2,3,4,0,1,2,0,1,2,0,1,2};
    printf("%d\n",max_up_seq(arr2,size));
    int arr3[] ={1,4,7,8,11,10,8,1,2,3,4,5,6,7,8,9,0}; 
    printf("%d\n",max_up_seq(arr3,15));
}

void linq_freq(struct node *head)
{
    struct node *temp = head;
    struct node *curr = head;
    int listSize = 0;
    int counter1 = 0,counter2 = 0,biggest;
    while(curr)
    {
        listSize++;
        curr = curr->next1;
    }
    while(temp)
    {
        curr = temp;
        while(curr)
        {
            if(temp->num == curr-> num)
            {
                counter1++;
            }
            curr = curr-> next1;
        }
        if(counter1 > counter2)
        {
            biggest = temp->num;
            counter2 = counter1;
        }
        counter1 = 0;
        temp = temp->next1;
    }
    while(head -> num != biggest)
    {
        head = head -> next1;
    }
    temp = head;
    while(head)
    {
        if(head -> num == biggest)
        {
                temp->next2 = head;
                head->next2 = temp;
        }
        head = head -> next1;
    }
    while(temp && counter2 > 0)
    {
        printf("%d\n",temp->num);
        counter2--;
        temp = temp->next2;
    }

}

void ex3()
{
    int arr[] = {1,4,5,4,1,5,4,3,4,1,4,3,3,4,6,7,4};
    int size = 12;
    int i;
    struct node *head = (struct node*)malloc(sizeof(struct node));
    struct node *first = head;
    head->num=arr[0];
    head->next1 = NULL;
    head->next2 = NULL;
    struct node * newnode;
    for(i=1;i<size;i++)
    {
        newnode = (struct node*)malloc(sizeof(struct node));
        newnode->num = arr[i];
        newnode -> next1 = NULL;
        newnode -> next2 = NULL;
        head->next1 = newnode;
        head = head->next1;
    }
    linq_freq(first);
}

int max_up_seq(int num[],int size)
{
    int i,curr = 0,seq1 = 0,seq2 = 0;
    for(i=0;i<size - 1;i++)
    {
        while(num[i+1] - num[i] == 1)
        {
            seq1++;
            i++;
        }
        if(seq1 >= seq2)
        {
            curr = i - seq1;
            seq2 = seq1;
        }
        seq1 = 0;
    }
    return curr;
}