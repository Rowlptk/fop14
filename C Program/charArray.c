#include<stdio.h>

void main() {
    char name[5] = {'a','p','p','l','e'};

    char str[50] = "Hello World!";
    //scanf("%s",str);
    gets(str);
    //printf("str = %s",str);
    puts(str);


    /*printf("Enter char array value : ");
    for(int i=0;i<5;i++) {
        //scanf(" %c",&name[i]);
        name[i] = getchar();
        getchar();
    }


    printf("Values of array : ");
    for(int i=0;i<5;i++) {
        //printf("%c",name[i]);
        putchar(name[i]);
    }*/
}
