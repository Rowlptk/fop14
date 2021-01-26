#include<stdio.h>
#define PI 3.1415

void main() {
    float radius, area, dia;
    //radius = 5;
    //printf("Enter the radius of circle : ");
    //scanf("%f",&radius);
    printf("Enter a diameter : ");
    scanf("%f",&dia);
    radius = dia/2;
    area = PI*radius*radius;
    printf("Area of circle is %.2f",area);
}

//radius = dia/2;

