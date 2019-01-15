    #include <stdio.h>
    #include <stdlib.h>
    
    int *func(int *a,int *b);
    
    
    void main()
    {
        int a[] = {1,1,1,3,1,1,1,1,-1};
        int b[] = {1,1,1,1,1,4,1,1,1,8,-1};
        int *test = func(a,b);
        while(*(test+=1) > 0 )
            printf("%d ",*(test));
        printf("\n");
    }
    int *func(int *a,int *b)
    {
        //init final
        int fSize = 1;
        int *final = (int*)malloc(sizeof(int)*fSize);
        int aFlag = 1,bFlag = 1 ;
        int count,temp;
    
        for(int i = 0; aFlag+bFlag > 0; i++)
        {
            if((*(a+i)) < 0) 
                aFlag--;
            if((*(b+i)) < 0) 
                bFlag--;


            if(aFlag)
            {
                count = 0;
                temp = *(a+i);
                for(int x = 0; x < fSize; x++)
                {
                    if(temp == *(final+x))
                    {
                        count++;
                    }
                }
                if(count<1)
                {
                    fSize++;
                    final = (int *)realloc(final,sizeof(int)*fSize);
                    *(final+fSize-1) = temp;
                }
            }

            if(bFlag)
            {
                count = 0;
                temp = *(b+i);
                for(int x = 0; x < fSize; x++)
                {
                    if(temp == *(final+x))
                    {
                        count++;
                    }
                }
                if(count<1)
                {
                    fSize++;
                    final = (int *)realloc(final,sizeof(int)*fSize);
                    *(final+fSize-1) = temp;
                }
            }
        }
        fSize++;
        final = (int *)realloc(final,sizeof(int)*fSize);
        *(final+fSize-1) = -1;
        printf("%d\n",fSize);
        return final;
    }
