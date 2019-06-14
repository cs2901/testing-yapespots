# Requirements

For this release v0.1 we want to satisfy these requirements
## Functional requirements:
- Receive and translate a text.utton.
19
​
- Translate from English to Spanish and vice versa.

## Non-functional requirements:
- Translate on online mode.

# User Guide

## User Stories

- As a user, I can input a word
- as a user, I can select an input language
- As a user, I can select an output language
- As a user, I can translate a word

## Use Cases

### Use Case - Translate a Word to Spanish
#### System: Translator
#### User: user
#### Mss:
1. User input text in English
2. User picks translate to Spanish
3. Translator transalte input text to spanish
4. User receives the tranlated text


# Developer Guide

## Features

- Input a text
This feature is to enable the user to input his query to the program
- Select an input language
This feature is to select the language of the input query
- Select an output language
This feature is to select the language of the output query
- Translate a word
This feature is to translate and get the result

## Class Diagram
[Class Diagram](ClassDiagramDictionary.png)
# Testing

We want to program a dictionary to translate a English text into a language of our choice, say Spanish.  This dictionary, in the form of a class, Dictionary, is initialized with a word file and allows us to query the translation of a English word.  The program should allow several translation alternatives
