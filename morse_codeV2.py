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
    

def encode(message):
    morse = ""
    message = message.upper()
    for char in message:
        if(char == " "):
            morse += "  "
        else:
            for code, ch in MORSE_CODE:
                if char == ch:
                    morse += code + " "
    return morse

def decode(message):
    codeText = ""
    if "\n" in message:
        message = message.split("\n")
    else:
        message = message.split("   ")
    for word in message:
        word = word.split()
        for code in word:
            for morse, char in MORSE_CODE:
                if code == morse:
                    codeText += char
        codeText += " "
    return codeText



def get_input():
    user_input = input("Would you like to encode (e) or decode (d): ")
    if(user_input == "e"):
        message = input("What message would you like to encode: ")
        message = message.upper()
    elif(user_input == "d"):
        message = input("What message would you like to decode: ")
    else:
        print("Invalid Mode")
        get_input()
    
    return (user_input, message)
    

def write_lines(lines):
    f = open("results.txt","w")
    if "   " in lines:
        lines = lines.split("   ")
    else:
        lines = lines.split(" ")
        
    for item in lines:
        item += "\n"
        f.write(item)
    
    f.close()


def process_lines(filename, mode):
    result = ""
    if(check_file_exists(filename)):
        f = open(filename, "r")
        lines = f.read()
        if(mode == "e"):
            result = encode(lines)
        elif(mode == "d"):
            result = decode(lines)
        
        write_lines(result)
        print("Output written to results.txt")
            
    else:
        print("Invalid Filename")
    
            
def check_file_exists(filename):
    if (os.path.exists(filename)):
        return True
    else:
        return False


def get_filename_input():
    filename = "None"
    message = "None"
    mode = input("Would you like to encode (e) or decode (d): ")
    if(mode == "e"):
        messageText = "What message would you like to encode: "
    elif(mode == "d"):
        messageText = "What message would you like to decode: "
       
    else:
        print("Invalid Mode")
        get_filename_input()
        
    while(True):
        method = input("Would you like to read from a file (f) or the console (c)? ")
        if(method == "c"):
            message = input(messageText)
            break
        elif(method == "f"):
            while(True):
                filename = input("Enter a filename: ")
                if(check_file_exists(filename)):
                    break
                else:
                    print("Invalid Filename")
        break
    return (mode, message, filename)
    

def main():
    print_intro()
    while(True):
        mode, message, filename = get_filename_input()
        if(message != "None"):
            if(mode == "e"):
                print(encode(message))
            elif(mode == "d"):
                print(decode(message))
        elif(filename != "None"):
            process_lines(filename, mode)
            
        while(True):
            x = input("Would you like to encode/decode another message? (y/n): ")
            if(x == "y"):
                break
            elif(x == "n"):
                print("Thanks for using the program, goodbye!")
                break
            else:
                pass
                
        if(x == "n"):
            break
            
    


# Program execution begins here
if __name__ == '__main__':
    main()
