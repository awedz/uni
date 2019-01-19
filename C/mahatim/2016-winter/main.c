#include <stdio.h>
#include <ctype.h>
#include <stdlib.h>

#define n 10

void func(int *arr1,int *arr2);
float avg_word_len(char *str);
void funckMatrix(int mat[n][n]);
void main()
{
    int a[] = {25,20,15,10,9,7,5,3,2,-1};
    int b[] = {30,4,15,1,-1};
    char str[] = "C exam year  2016 \0";
    func(a,b);
    // for(int i = 0; *(b + i) != -1;i++)
    //     printf("%d ",*(b+i));
    float c = avg_word_len(str);
    printf("%.3f",c);
    getchar();
}
float avg_word_len(char *str)
{
    float charCount = 0, wordCount = 0;
    while(*str)
    {
        if(!isalpha(*(str)) && !isdigit(*str) && *(str)!= ' ')
            return 0.0f;

        if(*(str) == ' ')
        {
            if(*(str+1) == ' ')
                *str++;
        }
        else
        {
            charCount++;
            if(*(str+1) == ' ' || *(str+1) =='\0')
                wordCount++;
        }

        *str++;
    }


    printf("%f %f\n",charCount,wordCount);
    return charCount/wordCount;
}
void func(int *arr1,int *arr2)
{
    int j,x;
    for(int i = 1;*(arr1 + i) > 0;i++)
        if(*(arr1 + i) > *(arr1 + i - 1))
            return;

    for(x = 0; *(arr2 + x)  != -1; x++)
    {
        for(j = 0; *(arr1 + j) != -1;j++)
        {
            if(*(arr2 + x) > *(arr1 + j))
            {
                *(arr2 + x) = j;
                break;
            }
            if(*(arr1 + j+1) == -1)
            {
                *(arr2 + x) = j + 1;
            }
        }
    }
    printf("done\n");
}

void funckMatrix(int mat[n][n])
{
    int cordX,cordY,size = 0,tSize = 0;
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            if(mat[i][j] == 1 && mat[i+1][j+1] == 1 && i < n && j < n)
            {
                tSize++;
            }
            if(i>j)
            {
                if(tSize > size)
                {
                    size = tSize;
                }
                tSize=0;
            }


        }
    }
}
