#include<stdio.h>

void main() {
    char user[10] = "admin";
    char pwd[10] = "pass123";

    char myInput[10], myPwd[10];

    printf("Enter your username : ");
    gets(myInput);
    strlwr(myInput);
    if(strcmp(user, myInput) == 0)
    {
        printf("Enter your Password : ");
        gets(myPwd);
        if(strcmp(pwd, myPwd) == 0) {
            printf("Welcome %s!",myInput);
        }
        else
        {
            printf("Password is incorrect!");
        }
    }
    else
    {
        printf("User Name Does not Exist!");
    }

    // equal => 0
    // ASCII ==> second greatest ==> -ve
    // first ==> +ve

    //int x = strcmp(user, myInput);
    //printf("%d",x);
}




