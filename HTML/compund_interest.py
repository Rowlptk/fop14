#welcome message
print("Coding Challenge 1, compound_interest.py")
print("Name:Madhur Bist")
print("Student No: np03cs4s210101")
print("Welcome to Compond Interest Calculation Program")

#Prompt for requirement
#Principle Amount
P =  input("Enter principal amount : ")

#Time
t = input("Enter Numbers of Years : ")

#Annual Interest Rate
r = input("Enter rate of interest in % : ")

#Number of times interest Compunded per year
n = input("Enter the number of times compunded per year : ")

#Converting values to suitable types
P = float(P)

#Format P to two decimal place
P = round(P,2)

t = int(t)
r = float(r)

#Converting % values to normal value
r = r/100

n = int(n)

#Perfoming the compound interest calculation
A = P*(1+(r/n))**(n*t)

#Format A to two decimal place
A = round(A,2)

newLine = '\n';
print(f'£{P} invested at {r*100}% for {t} years compunded {n} times per year is : £{A}{newLine}')

print("Year         Period          Old Balance         Interest            New Balance");
print("------------------------------------------------------------------------------------")
oldBalance = P
for year in range(1,t+1):
    count = 1
    for period in range(1, n+1):
        I = oldBalance*(r/n)
        newBalance = oldBalance + I #qqq
        if(count == 1):
            print(f"{year}           {period}                £{oldBalance:.2f}            £{I:.2f}                £{newBalance:.2f}")
        else:
            print(f"            {period}                £{oldBalance:.2f}            £{I:.2f}                £{newBalance:.2f}")

        oldBalance = newBalance
        count += 1
        
        
