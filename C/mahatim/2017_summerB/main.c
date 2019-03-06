#include <stdio.h>

int cor_func(unsigned short num1,char num2);

void main()
{
    printf("%d \n",cor_func(0x1234,0x1));
    printf("%d \n",cor_func(0xe378,0x7));
    printf("%d \n",cor_func(0xaaaa,0x5));

}
int cor_func(unsigned short num1,char num2)
{
    unsigned short num2s,mask = 0xf;
    int i,j,res=0;

    num2s = num2&0xf;
    for(i=0;i<sizeof(num1)*8;i++)
    {
        res+=(((num1&mask)>>1)==num2s);
        mask= mask<<1;
    }
    return res;
}