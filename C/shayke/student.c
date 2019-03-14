#include "./headers/student.h"
#include "string.h"

void InitList(student_list_manager_t *list,student_item_t *head)
{
    list -> head = head;
	list -> Append = Append;
	list -> Push = Push;
    list -> Remove = Remove;
	list -> Print = Print;
}

void Append(student_item_t *head,char *id,char *name,int courseCount)
{
    student_item_t *temp = head;
    student_item_t *newStudent = (student_item_t*)malloc(sizeof(student_item_t));
    newStudent->id[0] = '\0';
    strcpy(newStudent->id,id);
    newStudent->name[0] = '\0';
    strcpy(newStudent->name,name);
    newStudent->number_of_courses = courseCount;
    newStudent->next_student = NULL;
    if(!head || head->name)
    {
        printf("app\n");
        (*head) = (*newStudent);
        return;
    }
    while(temp->next_student){
        temp = temp->next_student;
    }
    temp->next_student = newStudent;
}

void Push(student_item_t *head,char *id,char *name,int courseCount)
{
    student_item_t *newStudent = (student_item_t*)malloc(sizeof(student_item_t));
    newStudent->id[0] = '\0';
    strcpy(newStudent->id,id);
    newStudent->name[0] = '\0';
    strcpy(newStudent->name,name);
    newStudent->number_of_courses = courseCount;
    if(!head)
    {
        *head = *newStudent;
        head -> next_student = NULL;
        return;
    }
    newStudent -> next_student = (student_item_t*)malloc(sizeof(student_item_t));
    (*newStudent -> next_student) = (*head);
    (*head) = (*newStudent);
}

void Remove(student_item_t *head,char *id,char *name)
{

}
void Print(student_item_t *head)
{
    int count = 0;
    student_item_t *temp = head;
    while(temp->next_student)
    {
        printf("%d %s %s\n",temp->number_of_courses,temp->id,temp->name);
        temp = temp -> next_student;
        count++;
    }
    printf("%d\n",count);
}