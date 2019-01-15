#pragma once
#ifndef COURSE_ITEM_H
#define COURSE_ITEM_H

#include "course_list.h"
#include "waiting_course.h"

typedef struct course_item{
    int id_course;
    int max_quantety,current_quantety;
    struct course_list * student_list;//inclide
    struct waiting_course * waiting_list;//include
    struct course_item * next;
}course_item_t;
#endif