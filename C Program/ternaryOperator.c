// 18 or above

#include<stdio.h>

void main() {
    int age, birthYear;
    printf("Enter your BirthYear : ");
    scanf("%d",&birthYear);
    age = 2021 - birthYear;
    (age>=18)?printf("Your age = %d\nYou can vote", age)
        :printf("Your age = %d\nSorry! Try after %d Years", age, 18-age);
}
/*
Enter your birthyear ==> 1980 => year
age = 2021-year =>41
(age>=18)
*/
// conditionals ==> if if else ...
