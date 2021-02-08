#include<stdio.h>
#include<string.h>

void main() {
    char sysUser[20] = "Admin";
    char sysPwd[20] = "pass";

    char usr[20], pwd[20];

    printf("Enter username : ");
    gets(usr);

    printf("Enter password : ");
    gets(pwd);

    //printf("The length of string usr = %d",strlen(usr));
    //printf("\n%d",strcmp(sysUser, usr));
    if((strcmp(strlwr(sysUser), strlwr(usr)) == 0) &&(strcmp(sysPwd, pwd) == 0)) {
        printf("Login SuccessFull!");
    } else {
        printf("username or password is incorrect!");
    }
}




