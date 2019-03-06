#include <stdio.h>
#include <string.h>
int func(char *str1,char *str2)
{
    int i,j;
    for (i=0,j=0;str1[i]!='\0'&&str2[j]!='\0';i++)
        if (str2[j]==str1[i])
            j++;
    return (!str2[j]);
}
int main()
{
    char str1[] = "str question";
    char str2[] = "str two";
    char c;
    int i,index;
    for (i=0;i<3;i++)
        {
            index = strlen(str2) - i;
            c = str2[index];
            str2[index] = '\0';
            printf ("%s %s\n",str1,str2);
            if (func(str1,str2))
                printf("Yes!!\n");
            else
                printf("No!!\n");
            str2[index] = c;
        }
    return 0;
}