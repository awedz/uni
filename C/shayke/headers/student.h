#pragma once
#ifndef STUDENT_H
#define STUDENT_H
#include <stdio.h>
#include "stdlib.h"

typedef struct student_item{
    char id[20];
    char name[20];
    int number_of_courses;
    struct student_item *next_student;
    
}student_item_t;

typedef struct student_list_manager{
    student_item_t *head;
    void(*Append)(student_item_t **head,char *id,char *name,int courseCount);
    student_item_t(*Push)(student_item_t *head,char *id,char *name,int courseCount);
    void(*Remove)(student_item_t *head,char *id,char *name);
    void(*Print)(student_item_t *head);
    
}student_list_manager_t;

void Push(student_item_t *head,char *id,char *name,int courseCount);
void Append(student_item_t **head,char *id,char *name,int courseCount);
void Remove(student_item_t *head,char *id,char *name);
void Print(student_item_t *head);
void InitList(student_list_manager_t *list, student_item_t **head);

#endif