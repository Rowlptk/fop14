#include<stdio.h>
#include<string.h>
void main() {
    char str1[20] = "Hello";
    char str2[20] = "World 2021";

    // string concatenation
    strcat(str1, " ");
    strcat(str1, str2);

    // rev string
    strrev(str1);

    // upr case
    strupr(str1);

    // lwr case
    strlwr(str1);

    // string copy
    //strcpy(str1, str2);
    puts(str1);

    /*int x = 2;
    int y = 3;
    x = y;
    printf("x = %d",x);*/
}
