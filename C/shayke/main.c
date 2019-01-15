#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "student_item.h"


//menu-
//1-student registration
//add course to course list
//add student to course
//remove student to course
//print student credentials by id
//print student course list


void main()
{
    printf("start\n");
    //student_list *list;
    student_item *head = NULL;
    //InitList(list);
    //InitList(list);
    student_item *a = (student_item *)malloc(sizeof(student_item));
    strcpy(a->id,"123456");
    strcpy(a->name,"aaaa");
    a->number_of_courses = 0;

    student_item *b = (student_item *)malloc(sizeof(student_item));
    strcpy(b->id,"123456");
    strcpy(b->name,"aabb");
    b->number_of_courses = 0;

    student_item *c = (student_item *)malloc(sizeof(student_item));
    strcpy(c->id,"123456");
    strcpy(c->name,"aacc");
    c->number_of_courses = 0;

    Insert(head,a->id,a->name,a->number_of_courses);
    PrintListItems(head);
    Insert(head,c->id,c->name,c->number_of_courses);
    PrintListItems(head);
    Insert(head,b->id,b->name,b->number_of_courses);
    PrintListItems(head);
    free(a);
    free(b);
    free(c);
}