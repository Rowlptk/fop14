// user defined functions

#include<stdio.h>

//function declaration
void add();
// parameterless function
void addv2(int num1, int num2);
// parameterized function
int addv3(int num1, int num2);
// void ==> auto return

void main() {
    //add();
    //addv2(45,105);
    int res = addv3(5,10);
    printf("%d\n",res);
    printf("%d\n",addv3(20,80));
}

int addv3(int num1, int num2) {
    return num1+num2;
}







void addv2(int num1, int num2) {
    printf("\nsum = %d",num1+num2);
}

void add() {
    int num1, num2;
    printf("Enter two numbers : ");
    scanf("%d%d",&num1,&num2);
    //addv2(num1, num2);
    printf("sum = %d",num1+num2);
}

