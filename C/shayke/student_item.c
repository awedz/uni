#include "student_item.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>



//student struct
//char id[ID_SIZE];
//char name[NAME_SIZE];
//int number_of_courses;
//struct student_item * next;

//TODO:
//FUNC - check if student exists
//insert sort -> by name


// void InitList(student_list_t *list)
// {
// 	list->insert = Insert;
// 	list->printListItems = PrintListItems;
// }


void Insert(student_item *head, char ID[ID_SIZE],char name[NAME_SIZE],int coursesCount)
{
	student_item *newStudent = (student_item *)malloc(sizeof(student_item)),*temp = head,*tempNext;
	int cmpRes;
    //init new student
    strcpy(newStudent->id,ID);
    strcpy(newStudent->name,name);
    newStudent->number_of_courses = 0;
	newStudent->next = NULL;

	if (head == NULL)
	{
		printf("head empty\n");
		head = newStudent;
		return;
	}

	while (temp->next != NULL)
	{
		cmpRes = strcmp(temp->name,newStudent->name);
		if(cmpRes > 0 || cmpRes < 0)
		{
			if(cmpRes < 0)
			{
				//name == temp->name
				tempNext = temp->next;
				temp->next = newStudent;
				newStudent->next = tempNext;
				printf("%s inserted after %s ",newStudent->name,tempNext->name);
				return;
			}
			else{
				temp = temp->next;
				printf("skipped\n");
			}
		}
		else{
				tempNext = temp->next;
				temp->next = newStudent;
				newStudent->next = tempNext;
				printf("%s inserted after %s ",newStudent->name,tempNext->name);
		}
	}
}

void PrintListItems(student_item * head)
{
	printf("print %s\n",head->id);
	
	while (head != NULL)
	{
		printf(" %s \n", head->name);
		head = head->next;
	}
}