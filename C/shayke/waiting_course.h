#pragma once
#ifndef STUDENT_COURSE_H
#define STUDENT_COURSE_H

#include "student_item.h"


//fifo
typedef struct waiting_course{
    struct student_item * student;//include
    struct waiting_course * next;
}waiting_course_t;

#endif
