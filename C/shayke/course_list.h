#pragma once
#ifndef COURSE_LIST_H
#define COURSE_LIST_H

#include "student_item.h"

typedef struct course_list{
    struct student_item * student;//include
    struct course_list *next;
}course_list_t;

#endif