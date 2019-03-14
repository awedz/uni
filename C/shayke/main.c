#include <stdio.h>
#include <stdlib.h>
#include "student.c"
#include "string.h"
//03-7347555
void main() 
{
    char test[] = "\0";
    if(test)
    {
        printf("empty\n");
    }
    student_list_manager_t * list = (student_list_manager_t * ) malloc(sizeof(student_list_manager_t));
    student_item_t *head=(student_item_t*) malloc(sizeof(student_item_t));
    InitList(list, head);
    for(int i = 0;i < 20;i++)
    {
        char n[] = {'a',(i+97)+'0','\0'};
        char d[] = {(i+97)+'0','\0'};
        int nu = i+1;
        //i%2 == 0 ? 
        //list -> Append(list -> head, d, n, nu):
        //list -> Push(list -> head, d, n, nu);

        //list -> Push(list -> head, d, n, nu);
        list -> Append(list -> head, d, n, nu);
    }

    list -> Print(list -> head);
}