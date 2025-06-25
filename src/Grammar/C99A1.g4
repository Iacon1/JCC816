// Created by Iacon1 on 10/15/2023.
// Defines the C99 lexical grammar.
// Note: Rules that are capitalized are lexical, rules that aren't are parsed.

lexer grammar C99A1;
// import C99A11, C99A17;

WS : [ \t\r]+ -> skip ; // skip spaces, tabs
NLS : [\n]+ {!Grammar.GrammarFlags.isPreproc}? -> skip ; // Skip newlines
NL : '\n' {Grammar.GrammarFlags.isPreproc}? ; // Preproc newline

// A.1.3 Identifiers
Identifier : ([a-zA-Z_]|Universal_character_name) ([0-9a-zA-Z_]|Universal_character_name)* ;

// A.1.4 Universal character names
fragment Universal_character_name
	: '\\u' [0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F]
	| '\\U' [0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F][0-9a-fA-F] ;

// A.1.5 Constants
Constant
	: Integer_constant
	| Floating_constant
	| Enumeration_constant {!Grammar.GrammarFlags.isPreproc}?
	| Character_constant ;
fragment Integer_constant : ([1-9][0-9]* | '0' [0-7]* | ('0x'|'0X') [0-9a-fA-F]+ | ('0b'|'0B') [0-1]+) Integer_suffix?;
fragment Integer_suffix
	: [uU] ([lL]|'ll'|'LL'|[hH]|'hh'|'HH')?
	| ([lL]|'ll'|'LL'|[hH]|'hh'|'HH')
	| [uU] ([lL]|'ll'|'LL'|[hH]|'hh'|'HH')? [uU];
fragment Floating_constant
	: Decimal_floating_constant
	| Hexadecimal_floating_constant  ;
fragment Decimal_floating_constant
	: Fractional_constant Exponent_part? [flFL]?
	| [0-9]+ Exponent_part [flFL]? ;
fragment Hexadecimal_floating_constant
	: ('0x'|'0X') Hexadecimal_fractional_constant Exponent_part? [flFL]?
	| ('0x'|'0X') [0-9a-fA-F]+ Exponent_part [flFL]? ;
fragment Fractional_constant : [0-9]+ '.' | [0-9]* '.' [0-9]+ ;
fragment Hexadecimal_fractional_constant : [0-9a-fA-F]+ '.' | [0-9a-fA-F]* '.' [0-9a-fA-F]+ ;
fragment Exponent_part : [eE] [+-]? [0-9]+ ;
fragment Binary_exponent_part : 'p' [+-]? [0-9]+ ;
fragment Enumeration_constant : Identifier;
Character_constant : 'L'? '\'' (~('\''|'\\'|'\n')|Escape_sequence)+ '\'';
fragment Escape_sequence
	: ('\\\''|'\\"'|'\\?'|'\\\\'|'\\a'|'\\b'|'\\f'|'\\n'|'\\r'|'\\t'|'\\v')
	| '\\' [0-7][0-7]?[0-7]?
	| '\\x' [0-9a-fA-F]+ ;

// A.1.6 String literals
String_literal : 'L'? '"' (~('"'|'\\'|'\n')|Escape_sequence)+ '"' ;
	
// A.1.8 Header names
Header_name
	: '<' ~[\n>]+ '>' {Grammar.GrammarFlags.isPreproc}?
	| '"' ~[\n"]+ '"' {Grammar.GrammarFlags.isPreproc}?
	;