#include<stdio.h>

void main() {
    FILE *fp;
    char sysUsr[20];
    char sysPwd[20];
    fp = fopen("logindb.txt","r");
    if(fp == NULL) {
        printf("File Not Found!");
        exit(0);
    }

    // first pair
    //fscanf(fp, "%s%s", sysUsr, sysPwd);

    //printf("%d",fscanf(fp, "%s%s", sysUsr, sysPwd));

    // all values
    /*while(fscanf(fp, "%s%s", sysUsr, sysPwd) == 2) {
        puts(sysUsr);
        puts(sysPwd);
    }*/

    // last pair
    while(fscanf(fp, "%s%s", sysUsr, sysPwd) == 2);
    puts(sysUsr);
    puts(sysPwd);

    fclose(fp);

}
