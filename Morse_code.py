# Coding Challenge 2
# Name: Madhur Bist
# Student No: np03cs4s210101

# A Morse code encoder/decoder

import os.path
MORSE_CODE = (
    ("-...", "B"), (".-", "A"), ("-.-.", "C"), ("-..", "D"), (".", "E"), ("..-.", "F"), ("--.", "G"),
    ("....", "H"), ("..", "I"), (".---", "J"), ("-.-", "K"), (".-..", "L"), ("--", "M"), ("-.", "N"),
    ("---", "O"), (".--.", "P"), ("--.-", "Q"), (".-.", "R"), ("...", "S"), ("-", "T"), ("..-", "U"),
    ("...-", "V"), (".--", "W"), ("-..-", "X"), ("-.--", "Y"), ("--..", "Z"), (".-.-.-", "."),
    ("-----", "0"), (".----", "1"), ("..---", "2"), ("...--", "3"), ("....-", "4"), (".....", "5"),
    ("-....", "6"), ("--...", "7"), ("---..", "8"), ("----.", "9"), ("-.--.", "("), ("-.--.-", ")"),
    (".-...", "&"), ("---...", ":"), ("-.-.-.", ";"), ("-...-", "="), (".-.-.", "+"), ("-....-", "-"),
    ("..--.-", "_"), (".-..-.", '"'), ("...-..-", "$"), (".--.-.", "@"), ("..--..", "?"), ("-.-.--", "!")
)
#print(MORSE_CODE[0][1])

def print_intro():
    print("Welcome to Wolmorse")
    print("This program encodes and decodes Morse code.")
    get_input()

def encode(message):
    text = ""
    for character in message:
        for code, char in MORSE_CODE:
            if character.upper() == char:
               text += code + " "

    print(text)

def decode(message):
    codeText = ""
    message = message.split("   ")
    for word in message:
        word = word.split()
        for code in word:
            for morse, char in MORSE_CODE:
                if code == morse:
                    if code == word[0]:
                        pass
                    else:
                        char = char.lower()
                    codeText += char
        codeText += " "
    print(codeText)


def get_input():
    userInput = input("Would you like to encode (e) or decode (d): ")
    if (userInput == "e"):
        encodeMessage = input("What message would you like to encode: ")
        encode(encodeMessage)

    elif (userInput == "d"):
        decodeMessage = input("Enter MORSE_CODE to decode: ")
        decode(decodeMessage)
    else:
        print("Invalid Mode")
        get_input()
# print_intro()






#---------- Challenge Functions (Optional) ----------


def process_lines(filename, mode):
    f = open("morse_input.txt", "r")
    print(f.read())
#process_lines("x","y")
    
    


def write_lines(lines):
    f = open("result.txt","w")
    f.write("Text hello")
    f.close()
#write_lines("x")



def check_file_exists(filename):
    if (os.path.exists("morse_input.txt")):
        print(True)
#check_file_exists("x")

#def get_file_input():
#    userInput = input("Would you like to encode (e) or decode (d): ")
#    if (userInput == "e"):
#        encodeMessage = input("What message would you like to encode: ")
#        encode(encodeMessage)
#
#    elif (userInput == "d"):
#        decodeMessage = input("Enter MORSE_CODE to decode: ")
#        decode(decodeMessage)
#    else:
#        print("Invalid Mode")
#        get_input()
#
#def choose_read_method():
#    method = input("Would you like to read from a file (f) or the console (c): ")
#    if method == 'f':



def main():
    print_intro()


# Program execution begins here
if __name__ == '__main__':
    main()
