#pragma once
#ifndef STUDENT_ITEM_H
#define STUDENT_ITEM_H

#define ID_SIZE 20
#define NAME_SIZE 20

//sorted by name

typedef struct student_item_t{
    char id[ID_SIZE];
    char name[NAME_SIZE];
    int number_of_courses;
    struct student_item_t * next;
}student_item;



typedef struct student_list
{
	void(*insert)(student_item *head,char id[ID_SIZE],char name[NAME_SIZE],int number_of_courses);
	void(*printListItems)(student_item *head);
}student_list_t;


void PrintListItems(student_item * Head);
void Insert(student_item *head, char ID[ID_SIZE],char name[NAME_SIZE],int coursesCount);
void InitList(student_item *list);


#endif