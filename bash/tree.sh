#!/bin/bash

myTree()
{
        echo $1
    for folder in $(ls -l  $1| grep '^d' | grep -o '[^, ]\+$')
    do
        if [ -z "$folder" ]
        then
            echo "done"
        else
        #echo "-----"
            #echo $PWD
            p="$1/$folder"
            #echo $PWD
            myTree $p
        fi
    done
}
myTree "a"