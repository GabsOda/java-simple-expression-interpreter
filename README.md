# Java Simple Expression Interpreter

This folder contain a simple java implementation of a simple expression interpreter

## Grammar

The grammar used to construct the parser: 

```
prog  ::= stmt EOL lines
lines ::= prog | ε
stmt  ::= atr | imp
atr   ::= VAR expr
imp   ::= PRINT OPEN VAR CLOSE
expr  ::= fact SUM expr | fact SUB expr | fact
fact  ::= term MULT fact | term DIV fact | term
term  ::= OPEN expr CLOSE | NUM | VAR
```

## Tokens

The recognized tokens: 

```
<EOL>   ::= ;
<PRINT> ::= print
<OPEN>  ::= (
<VAR>   ::= $ followed by a set of alphanumeric symbols
<CLOSE> ::= )
<EQ>    ::= =
<MULT>  ::= *
<DIV>   ::= /
<SUM>   ::= +
<SUB>   ::= -
<NUM>   ::= 0 | 1 | ... | 8 | 9
```
## Program entries 

The program allows two types of input, selected at the start of execution: 

1. ```.txt``` files, like the file `input.txt` in this folder
2. `typing` the pseudocode into the program

## Pseudocode 

This only support simple code like: 

- variable assignment 
- basic equations such as adding, subtracting, multiplying and dividing
- print a variable
