from sys import argv, exit
from csv import DictReader
import re

def main():
    # Check argument number
    if len(argv) != 3:
        print("Usage: python dna.py data.csv sequence.txt")
        exit(1)

    dictionary = []

    # Load csv file
    with open(argv[1]) as database:
        dbreader = DictReader(database)
        for row in dbreader:
            dictionary.append(row)

    # Get STD names
    STR = list(dictionary[0].keys())
    # remove 'name' element
    STR.remove('name')

    # Load dna sequence
    with open(argv[2]) as seq_file:
        sequence = seq_file.read()

    target = {}
    for element in STR:
        target[element] = 0
        target[element] = count_matches(element, sequence)

    found = False

    for person in dictionary:
        counter = 0
        for element in STR:
            if int(person[element]) == int(target[element]):
                counter += 1
        if counter == len(STR):
            print(person['name'])
            found = True

    if found != True:
        print("No match")

def count_matches(pattern, sequence):
    ## Use regex and lambda expression to find maximum number of consecutive STR
    n_matches = [len(x) // len(pattern) for x in re.findall(fr'((?:{pattern})+)', sequence)]
    if not n_matches:
        n_matches = 0
    else:
        n_matches = max(n_matches)
    return n_matches


if __name__=="__main__":
    main()
