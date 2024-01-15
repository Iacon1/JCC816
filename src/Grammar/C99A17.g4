// Created by Iacon1 on 1/14/2024.
// Defines the C99 lexical grammar's punctuators.
// Note: Rules that are capitalized are lexical, rules that aren't are parsed.

lexer grammar C99A17;

TwoMCo : '%:%:' ;

ThreeP : '...' ;

Arrow  : '->' ;

Incrmn : '++' ;
Decrmn : '--' ;

LssLss : '<<' ;
GrtGrt : '>>' ;
LessTh : '<' ;
GretTh : '>' ;
LessEq : '<=' ;
GretEq : '>=' ;
Equal  : '==' ;
NotEql : '!=' ;

AmpAmp : '&&' ;
OrOr   : '||' ;

MulAsg : '*=' ;
DivAsg : '/=' ;
ModAsg : '%=' ;
PluAsg : '+=' ;
SubAsg : '-=' ;
LShAsg : '<<=' ;
RShAsg : '>>=' ;
AndAsg : '&=' ;
XorAsg : '^=' ;
OrAsg  : '|=' ;

TwoHsh : '##' ;

LessCo : '<:' ;
GretCo : ':>' ;
LessMd : '<%' ;
GretMd : '%>' ;
ModCol : '%:' ;

TwoLSB : '[[' ;
TwoRSB : ']]' ; // These two are not C99-compliant and were added for the attribute functionality

Amper  : '&';
Star   : '*' ;
Plus   : '+' ;
Minus  : '-' ;
Tilde  : '~' ;
Excla  : '!' ;
BckSla : '/' ;
Percnt : '%' ;

Xor    : '^' ;
Or     : '|' ;

Colon  : ':' ;
Semico : ';' ;

Period : '.' ;

Questi : '?' ;

Assign : '=' ;

Comma  : ',' ;

HashTg : '#' ;

LeSqBr : '[' ;
RiSqBr : ']' ;

LeRoBr : '(' ;
RiRoBr : ')' ;

LeCuBr : '{' ;
RiCuBr : '}' ;
