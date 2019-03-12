#include <stdio.h>
#include <stdlib.h>
#include "./headers/student.h"
#include "string.h"


void Push(student_item_t *head,char *id,char *name,int courseCount);
void Append(student_item_t *head,char *id,char *name,int courseCount);
void Remove(student_item_t *head,char *id,char *name);
void Print(student_item_t *head);

void main()
{
    student_item_t *head = (student_item_t*)malloc(sizeof(student_item_t));
    char name[] = "aaaaaa";
    char id[] = "123456";
    int num = 1;
    Append(head,id,name,num);
    Print(head);



    printf("test\n");
}
void Append(student_item_t *head,char *id,char *name,int courseCount)
{
    student_item_t *newStudent = (student_item_t*)malloc(sizeof(student_item_t));
    newStudent->id[0] = '\0';
    strcpy(newStudent->id,id);
    newStudent->name[0] = '\0';
    strcpy(newStudent->name,name);
    newStudent->number_of_courses = courseCount;
    newStudent->next_student = NULL;

    student_item_t *temp = head;
    if(temp == NULL)
    {
        head = newStudent;
        return;
    }
    while(temp->next_student != NULL){
        temp = temp->next_student;
    }
    temp->next_student = newStudent;
}

void Print(student_item_t *head)
{
    student_item_t *temp = head;
    while(temp != NULL)
    {
        printf("%s %s\n",temp->id,temp->name);
        temp = temp->next_student;
    }
}