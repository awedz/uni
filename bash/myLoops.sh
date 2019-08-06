#!/bin/bash

num=0

for i in $@
do
    num=$(($num+$i))
done

echo $num