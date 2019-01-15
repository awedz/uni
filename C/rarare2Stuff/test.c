#include <stdio.h>
#include <stdio.h>
#include <string.h>
int main(int argc, char **argv)
{
	printf("give me a bottle of rum!\n");
	char aaaa[] = "asdasd";
	int count = 0;
	for(int i = 0;i<strlen(aaaa);i++)
	{
		count+=(int)aaaa[i];
	}
	if(count < 100)
		printf("too small\n");
	else
		printf("all good\n");
	return 0;
}
