// Created by Iacon1 on 10/15/2023.
// Defines the C99 phrase grammar.
// Note: Rules that are capitalized are lexical, rules that aren't are parsed.

grammar C99A2;
import C99A1;

// A.2.1 Expressions
primary_expression
	: Identifier
	| Constant
	| String_literal
	| '(' expression ')' ;	
postfix_expression
	: primary_expression
	| postfix_expression '[' expression ']'
	| postfix_expression '(' argument_expression_list? ')'
	| postfix_expression '.' Identifier
	| postfix_expression '->' Identifier
	| postfix_expression '++'
	| postfix_expression '--'
	| '(' type_name ')' '{' initializer_list ','? '}' ;	
argument_expression_list : assignment_expression (',' assignment_expression)* ;	
unary_expression
	: postfix_expression
	| '++' unary_expression
	| '--' unary_expression
	| ('&'|'*'|'+'|'-'|'~'|'!') cast_expression
	| 'sizeof' unary_expression
	| 'sizeof' '(' type_name ')' ;	
cast_expression
	: unary_expression
	| '(' type_name ')' cast_expression ;	
multiplicative_expression
	: cast_expression
	| multiplicative_expression ('*'|'/'|'%') cast_expression ;	
additive_expression
	: multiplicative_expression
	| additive_expression ('+'|'-') multiplicative_expression ;
shift_expression
	: additive_expression
	| shift_expression ('<<'|'>>') additive_expression ;	
relational_expression
	: shift_expression
	| relational_expression ('<'|'>'|'<='|'>=') shift_expression ;	
equality_expression
	: relational_expression
	| equality_expression ('=='|'!=') relational_expression ;
and_expression
	: equality_expression
	| and_expression '&' equality_expression ;	
xor_expression
	: and_expression
	| xor_expression '^' and_expression ;
or_expression
	: xor_expression
	| or_expression '|' xor_expression ;	
land_expression
	: or_expression
	| land_expression '&&' or_expression ;	
lor_expression
	: land_expression
	| lor_expression '||' land_expression ;
conditional_expression
	: lor_expression
	| lor_expression '?' expression ':' conditional_expression ;
assignment_expression
	: conditional_expression
	| unary_expression ('='|'*='|'/='|'%='|'+='|'-='|'<<='|'>>='|'&='|'^='|'|=') assignment_expression ;
expression : assignment_expression (',' assignment_expression)* ;
constant_expression : conditional_expression ;

// A.2.2 Declarations
declaration : declaration_specifiers init_declarator_list? ';' ;
declaration_specifiers
	: (storage_class_specifier
	| type_specifier
	| type_qualifier
	| function_specifier)+? ;
storage_class_specifier:'typedef'|'extern'|'static'|'auto'|'register';
function_specifier : 'inline' ;
init_declarator_list : init_declarator (',' init_declarator)* ;
init_declarator: declarator ('=' initializer)? ;
type_specifier
	: ('void'|'char'|'short'|'int'|'long'|'float'|'double'|'signed'|'unsigned'|'_Bool'|'_Complex')
	| struct_or_union_specifier
	| enum_specifier
	| typedef_name ;
struct_or_union_specifier
	: ('struct'|'union') Identifier? '{' struct_declaration_list '}'
	| ('struct'|'union') Identifier ;
struct_declaration_list : struct_declaration+ ;
struct_declaration : specifier_qualifier_list struct_declarator_list ';' ;
specifier_qualifier_list : (type_specifier|type_qualifier) specifier_qualifier_list? ;
struct_declarator_list : struct_declarator (',' struct_declarator)* ;
struct_declarator
	: declarator
	| declarator? ':' constant_expression ;
enum_specifier
	: 'enum' Identifier? '{' enumerator_list ','? '}'
	| 'enum' Identifier ;
enumerator_list : enumerator (',' enumerator)* ;
enumerator : Identifier ('=' constant_expression)? ;
type_qualifier : ('const'|'restrict'|'volatile') ;
declarator : pointer? direct_declarator ;
direct_declarator
	: Identifier
	| '(' declarator ')'
	| direct_declarator '[' type_qualifier_list? assignment_expression? ']'
	| direct_declarator '[' 'static' type_qualifier_list? assignment_expression ']'
	| direct_declarator '[' type_qualifier_list 'static' assignment_expression ']'
	| direct_declarator '[' type_qualifier_list? '*' ']'
	| direct_declarator '(' parameter_type_list ')'
	| direct_declarator '(' identifier_list? ')' ;
pointer : ('*' type_qualifier_list?)+ ;
type_qualifier_list : type_qualifier+ ;
parameter_type_list : parameter_list (',' '...')? ;
parameter_list : parameter_declaration (',' parameter_declaration)* ;
parameter_declaration : declaration_specifiers (declarator|abstract_declarator?) ;
identifier_list : Identifier (',' Identifier)* ;
type_name : specifier_qualifier_list abstract_declarator? ;
abstract_declarator
	: pointer
	| pointer? direct_abstract_declarator ;
direct_abstract_declarator
	: '(' declarator ')'
	| direct_abstract_declarator '[' type_qualifier_list? assignment_expression? ']'
	| direct_abstract_declarator '[' 'static' type_qualifier_list? assignment_expression ']'
	| direct_abstract_declarator '[' type_qualifier_list 'static' assignment_expression ']'
	| direct_abstract_declarator '[' type_qualifier_list? '*' ']'
	| direct_abstract_declarator '(' parameter_type_list ')'
	| direct_abstract_declarator '(' identifier_list? ')' ;
typedef_name : Identifier ;
initializer
	: assignment_expression
	| '{' initializer_list ','? '}' ;
initializer_list : designation? initializer (',' designation? initializer)+ ;
designation : designator_list '=' ;
designator_list : designator+ ;
designator
	: '[' constant_expression ']'
	| '.' Identifier ;
attributes_declaration : '[[' identifier_list ']]' ;

// A.2.3 Statements
statement
	: labeled_statement
	| compound_statement
	| expression_statement
	| selection_statement
	| iteration_statement
	| jump_statement 
	| asm_statement ;
labeled_statement
	: Identifier ':' statement
	| 'case' constant_expression ':' statement
	| 'default' ':' statement ;
compound_statement : '{' block_item_list? '}' ;
block_item_list : block_item+ ;
block_item
	: statement
	| declaration ;
expression_statement : expression? ';' ;
selection_statement
	: 'if' '(' expression ')' statement
	| 'if' '(' expression ')' statement 'else' statement
	| 'switch' '(' expression ')' statement ;
iteration_statement
	: 'while' '(' expression ')' statement
	| 'do' statement 'while' '(' expression ')' ';'
	| 'for' '(' expression? ';' expression? ';' expression? ')' statement
	| 'for' '(' declaration expression? ';' expression? ')' statement ;
jump_statement
	: 'goto' Identifier ';'
	| 'continue' ';'
	| 'break' ';'
	| 'return' expression? ';' ;
asm_statement : 'asm' '(' String_literal ')' ';' ; // As per J.5.10

// A.2.4 External definitions 
translation_unit: external_declaration+ ;
external_declaration
	: function_definition
	| declaration ;
function_definition : attributes_declaration* declaration_specifiers declarator declaration_list? compound_statement ;
declaration_list : declaration+ ;