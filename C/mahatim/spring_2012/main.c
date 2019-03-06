#include <stdio.h>

void func(int a,int b);
int brace(char * str);
void main()
{
    func(18234,345);
    func(7231,6123);
    char *str ="{()}\0"; 
    char *str2 ="{())}}"; 
    printf(brace(str) == 0 ?"ok\n":"not ok\n");
    printf(brace(str2) == 0 ?"ok\n":"not ok\n");
}

void func(int a,int b)
{
    if (a < 0 || b < 0 || a - b > 0)
        return;
    int temp = 0,final = 0, multi = 1, tempa ,tempb;
    while(a)
    {
        tempa = a % 10;
        a/=10;
        if(b)
        {
            tempb = b % 10;
            b/=10;
            if (tempa > tempb) 
                final += tempa * multi;
            else
                final += tempb*multi;
        }
        else
            final += tempa*multi;
        multi *= 10;
    }
    printf("%d\n",final);
}
int brace(char * str)
{
    int curBrace = 0,roundBrace = 0;
        while(*str)
        {
            switch (*(str))
            {
                case '(':
                    roundBrace++;
                    break;
                case ')':
                    roundBrace--;
                    break;
                case '{':
                    curBrace++;
                    break;
                case '}':
                    curBrace--;
                    break;
            
                default:
                    break;
            }
            *str++;
        }
        printf("%d\n",curBrace + roundBrace == 0 ? 0 : 1);
        return curBrace + roundBrace == 0 ? 0 : 1;
}