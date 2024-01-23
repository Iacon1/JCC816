// Created by Iacon1 on 1/14/2024.
// Defines the C99 lexical grammar's keywords.
// Note: Rules that are capitalized are lexical, rules that aren't are parsed.

lexer grammar C99A11;

// A.1.1 Lexical elements
Auto : 'auto' ;
Break : 'break' ;
Case : 'case' ; 
Char : 'char' ; 
Const : 'const' ; 
Continue : 'continue' ; 
Default : 'default' ; 
Do : 'do' ; 
Double : 'double' ; 
Else : 'else' ; 
Enum : 'enum' ; 
Extern : 'extern' ; 
Float : 'float' ; 
For : 'for' ; 
Goto : 'goto' ; 
If : 'if' ; 
Inline : 'inline' ; 
Int : 'int' ; 
Long : 'long' ; 
Register : 'register' ; 
Restrict : 'restrict' ; 
Return : 'return' ; 
Short : 'short' ; 
Signed : 'signed' ; 
Sizeof : 'sizeof' ; 
Static : 'static' ; 
Struct : 'struct' ; 
Switch : 'switch' ; 
Typedef : 'typedef' ;
Union : 'union' ;  
Unsigned : 'unsigned' ; 
Void : 'void' ; 
Volatile : 'volatile' ; 
While : 'while' ; 
Bool : '_Bool' ; 
Complex : '_Complex' ; 
Imaginary : '_Imaginary' ; 
Asm : 'asm' ; // As per J.5.10

Defined : 'defined' {Grammar.GrammarFlags.isPreproc}? ;
Define : 'define' {Grammar.GrammarFlags.isPreproc}? ;
Ifdef : 'ifdef' {Grammar.GrammarFlags.isPreproc}? ;
Ifndef : 'ifndef' {Grammar.GrammarFlags.isPreproc}? ;
Elif : 'elif' {Grammar.GrammarFlags.isPreproc}? ;
Endif : 'endif' {Grammar.GrammarFlags.isPreproc}? ;
Include : 'include' {Grammar.GrammarFlags.isPreproc}? ;
Undef : 'undef' {Grammar.GrammarFlags.isPreproc}? ;
Line : 'line' {Grammar.GrammarFlags.isPreproc}? ;
Error : 'error' {Grammar.GrammarFlags.isPreproc}? ;
Pragma : 'pragma' {Grammar.GrammarFlags.isPreproc}? ;

HasEmbed : '__has_embed' {Grammar.GrammarFlags.isPreproc}? ; // Backported from C23
Embed : 'embed'  {Grammar.GrammarFlags.isPreproc}? ;

SRAM : '__SRAM' ; // Implementation-defined
