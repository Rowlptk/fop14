#include<stdio.h>

void checkBalance();
void deposit(double amount);
void withdraw(double amount);
double readAccount();
void writeIntoAccount(double balance);
double readAmountFromUser();


double mainBalance;

void main() {
    checkBalance();
    deposit(readAmountFromUser());
    withdraw(readAmountFromUser());
}

double readAmountFromUser(){
    double amount;
    printf("Enter Amount : ");
    scanf("%lf",&amount);
    return amount;
}


void writeIntoAccount(double balance) {
    FILE *fp;
    fp = fopen("my_account.txt","w");
    fprintf(fp, "%lf", balance);
    fclose(fp);
}

double readAccount() {
    FILE *fp;
    double balance;
    fp = fopen("my_account.txt","r");
    if(fp == NULL) {
        printf("Internal Error!");
        exit(0);
    }
    fscanf(fp, "%lf", &balance);
    fclose(fp);
    return balance;
}


void withdraw(double amount) {
    mainBalance -= amount;
    writeIntoAccount(mainBalance);
    printf("\nAmount Deducted : $%.2lf\n",amount);
    checkBalance();
}

void deposit(double amount) {
    mainBalance += amount;
    writeIntoAccount(mainBalance);
    printf("\nAmount Deposited : $%.2lf\n",amount);
    checkBalance();
}

void checkBalance() {
    mainBalance = readAccount();
    printf("\nYour Available Balance : $%.2lf\n",mainBalance);
}


//login ==> menu
// deposit ==> limit
// withdraw ==>


