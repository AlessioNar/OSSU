from cs50 import get_string


def main():
    text = get_string("Text: ")
    length = len(text)
    text = text.lower()
    characters = 0
    words = 1
    sentences = 0

    for c in text:
        if c.isalpha():
            characters += 1
        if c is ' ':
            words += 1
        if c is '.' or c is '!' or c is '?':
            sentences += 1
    L = (characters / words) * 100
    S = (sentences / words) * 100
    index = round(0.0588 * L - 0.296 * S - 15.8)
    if index > 16:
        index = "16+"
    print(f"Grade {index}")

if __name__ == '__main__':
    main()
