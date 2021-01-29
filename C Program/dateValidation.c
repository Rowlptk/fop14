#include<stdio.h>

void main() {
    int y,m,d;
    printf("Enter Date(format:[YYYY-MM-DD]) : ");
    scanf("%d-%d-%d",&y,&m,&d);
    //printf("Y=%d\nM=%d\nD=%d",y,m,d);
    if(y>=1000 && y<=9999)
    {
        printf("\nValid Year");
        if(m>=1 && m<=12)
        {
            printf("\nValid Month");
            if(d>=1 && d<=30)
            {
                printf("\nDate is Valid");
            }
            else
            {
                printf("\nDay is Invalid");
            }
        }
        else
        {
            printf("\nInvalid Month");
        }
    }
    else
    {
        printf("\nInvalid Year");
    }

}
