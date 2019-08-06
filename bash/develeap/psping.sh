#!/bin/bash

count=0


user=""
exeName=""

baseCMD="ps -A"

isUser=false


isTimeout=false
timeOut=1

isPing=false
pings=1



while getopts ":u:t:c:" opt; do
    case $opt in
        u)
            user=$OPTARG
            isUser=true
            ;;
        t)
            if ! [[ $OPTARG = *[[:digit:]]* ]];then
                echo "-t must be a number"
                exit 1
            fi
            timeOut=$OPTARG
            isTimout=true
            ;;
        c)
            if ! [[ $OPTARG = *[[:digit:]]* ]];then
                echo "-c must be a number"
                exit 1
            fi
            pings=$OPTARG
            isPing=true
            ;;
    esac
done
exeName="${@: -1}"
userCMD="| grep '^[^$user]'"
commandCMD="| grep -c $exeName"

if $isUser
then
    baseCMD="$baseCMD$userCMD"
    echo "pinging $exeName for $user"
fi
echo "pinging $exeName for any user" 
baseCMD="$baseCMD$commandCMD"
while [ $pings -gt 0 ]
do
    out=$(eval "$baseCMD")
    echo "$exeName has $out instances"

    if $isPing
    then
        pings=$((pings-1))
    fi

    if $isTimeout
    then
        sleep $timeOut
    else
        sleep 1
    fi
done