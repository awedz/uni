#include <stdio.h>
#include <stdlib.h>
#include "student.c"
#include "string.h"
void main() 
{
    char test[] = "\0";
    if(test)
    {
        printf("empty\n");
    }
    student_list_manager_t * list = (student_list_manager_t * ) malloc(sizeof(student_list_manager_t));
    student_item_t *head=(student_item_t*) malloc(sizeof(student_item_t));
    head->id[0] = '\0';
    head->name[0] = '\0';
    InitList(list, &head);
    for(int i = 0;i < 5;i++)
    {
        char n[] = {'a',(i+97)+'0','\0'};
        char d[] = {(i+97)+'0','\0'};
        int nu = i+1;
        //i%2 == 0 ? 
        //list -> Append(list -> head, d, n, nu):
        //list -> Push(list -> head, d, n, nu);

        //list -> Push(list -> head, d, n, nu);
        //printf("%s %s %d",d,n,nu);
        list -> Append(&list -> head, d, n, nu);
    }

    list -> Print(list -> head);
}