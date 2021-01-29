#include<stdio.h>

void main() {
    int num1, num2;
    char op;
    printf("Enter two Numbers : ");
    scanf("%d%d",&num1,&num2);
    printf("Operation:\n+\n-\n*\n/\n : ");
    scanf(" %c",&op);
    switch(op) {
    case '+':
        printf("%d + %d = %d", num1, num2, num1+num2);
        break;
    case '-':
        printf("%d - %d = %d", num1, num2, num1-num2);
        break;
    case '*':
        printf("%d * %d = %d", num1, num2, num1*num2);
        break;
    case '/':
        printf("%d / %d = %d", num1, num2, num1/num2);
        break;
    default:
        printf("No such Operation!");
    }
}
