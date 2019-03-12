#include "./headers/student.h"
#include "string.h"

void InitList(student_list_manager_t *list)
{
	list->Append = Append;
	list->Push = Push;
    list->Remove = Remove;
	list->Print = Print;
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
    while(temp->next_student != NULL)
    {
        printf("%s %s",temp->id,temp->name);
        temp = temp->next_student;
    }
}