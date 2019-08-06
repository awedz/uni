#!/bin/bash
rec=false
verb=false
filesExtracted=0


extract()
{
    if [ $verb = true ];
    then
        echo "unpacking $(basename $1)"
    fi
    case $1 in
        *.bz2)       bunzip2 $1                 ;;
        *.gz)        gunzip $1                  ;;
        *.zip)       unzip $1 > "out"; rm "out" ;;
        *.Z)         uncompress $1              ;;
        *)           return 0                   ;;
    esac
    filesExtracted=$((filesExtracted+1))
}

recExtract()
{
    mkdir ${1%.*}
    prevDir=$PWD
    cd ${1%.*}
    extract "$prevDir/$1"
    for file in $(ls -l $PWD| grep '^-' | grep -o '[^, ]\+$')
    do
        case "$file" in
            *.bz2)       
                recExtract "$file"  
                ;;
            *.gz)
                recExtract "$file"  
                ;;
            *.zip)  
                recExtract "$file" 
                ;;
            *.Z)            
                recExtract "$file"  
                ;;
            *)  
                if [ $verb = true ];
                then
                    echo "$file skipped"   
                fi   
                ;;
        esac
    done
    cd ..
}


options()
{
    case $1 in
        "-v")
            verb=true
            return 1
            ;;
        "-r")
            rec=true
            return 1
            ;;
        *)
            echo "wrong option"
            echo "options:"
            echo "-r recursive"
            echo "-v verbose" 
            return 0
        ;;
    esac
}



if [ $# -eq 0 ] 
    then
    echo "usage: unpack [options: -r, -v] filename"
    echo "-r : recursive extrack"
    echo "-v : print current extracted file"
fi
for var in "$@"
do
    if [ ${#var} -lt 3 ]
    then
        options $var
        if [ $? -lt 1 ]
        then
            exit 1
        fi
    else
        if [ $rec = true ]
        then
            recExtract $var
        else
            extract $var
        fi
    fi
done

echo "Decompressed ($filesExtracted) files"
if [ $filesExtracted -gt 0 ]; then succ=0; else succ=1; fi 
exit $succ
