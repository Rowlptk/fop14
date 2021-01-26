#include<stdio.h>

void main()
{
    int num1, num2;
    printf("Enter two Number : ");
    scanf("%d%d",&num1, &num2);
    if(num1>num2)
    {
        printf("%d is Greater!",num1);
    }
    else if(num1 == num2)
    {
        printf("Both have same value i.e. %d",num1);
    }
    else
    {
        printf("%d is Greater!", num2);
    }
}


70-80 (n>=70 && n<=80) ==>
user==> mark
80-100 ==>A
60-79 ==> B
40-59 ==> C
0-39 ==> Fail
100+, 0- ==> invalid


