// Created by Iacon1 on 10/15/2023.
// Defines the C99 phrase grammar.
// Note: Rules that are capitalized are lexical, rules that aren't are parsed.

parser grammar C99A2;
// import C99A1, C99A11, C99A17;

// A.2.1 Expressions
primary_expression
	: Identifier
	| Constant
	| String_literal
	| LeRoBr expression RiRoBr ;	
postfix_expression
	: primary_expression
	| postfix_expression LeSqBr expression RiSqBr
	| postfix_expression LeRoBr argument_expression_list? RiRoBr
	| postfix_expression Period Identifier
	| postfix_expression Arrow Identifier
	| postfix_expression Incrmn
	| postfix_expression Decrmn
	| LeRoBr type_name RiRoBr LeCuBr initializer_list Comma? RiCuBr ;	
argument_expression_list : assignment_expression (Comma assignment_expression)* ;	
unary_expression
	: postfix_expression
	| Incrmn unary_expression
	| Decrmn unary_expression
	| (Amper|Star|Plus|Minus|Tilde|Excla) cast_expression
	| Sizeof unary_expression
	| Sizeof LeRoBr type_name RiRoBr
	| HasEmbed LeRoBr (Header_name|String_literal) RiRoBr
	| Defined Identifier
	| Defined LeRoBr Identifier RiRoBr
	| Offsetof LeRoBr type_name Comma Identifier RiRoBr
	;
cast_expression
	: LeRoBr type_name RiRoBr cast_expression
	| unary_expression
	;	
multiplicative_expression
	: cast_expression
	| multiplicative_expression (Star|BckSla|Percnt) cast_expression ;	
additive_expression
	: multiplicative_expression
	| additive_expression (Plus|Minus) multiplicative_expression ;
shift_expression
	: additive_expression
	| shift_expression (LssLss|GrtGrt) additive_expression ;	
relational_expression
	: shift_expression
	| relational_expression (LessTh|GretTh|LessEq|GretEq) shift_expression ;	
equality_expression
	: relational_expression
	| equality_expression (Equal|NotEql) relational_expression ;
and_expression
	: equality_expression
	| and_expression Amper equality_expression ;	
xor_expression
	: and_expression
	| xor_expression Xor and_expression ;
or_expression
	: xor_expression
	| or_expression Or xor_expression ;	
land_expression
	: or_expression
	| land_expression AmpAmp or_expression ;	
lor_expression
	: land_expression
	| lor_expression OrOr land_expression ;
conditional_expression
	: lor_expression
	| lor_expression Questi expression Colon conditional_expression ;
assignment_expression
	: conditional_expression
	| unary_expression (Assign|MulAsg|DivAsg|ModAsg|PluAsg|SubAsg|LShAsg|RShAsg|AndAsg|XorAsg|OrAsg) assignment_expression ;
expression : assignment_expression (Comma assignment_expression)* ;
constant_expression : conditional_expression ;

// A.2.2 Declarations
declaration : declaration_specifiers init_declarator_list? Semico ;
declaration_specifiers
	: (storage_class_specifier
	| type_specifier
	| type_qualifier
	| function_specifier)+? ;
storage_class_specifier:Typedef|Extern|Static|Auto|Register|SRAM;
function_specifier : Inline ;
init_declarator_list : init_declarator (Comma init_declarator)* ;
init_declarator: declarator (Assign initializer)? ;
type_specifier
	: (Void|Char|Short|Int|Long|Float|Double|Signed|Unsigned|Bool|Complex)
	| struct_or_union_specifier
	| enum_specifier
	| typedef_name ;
struct_or_union_specifier
	: (Struct|Union) Identifier? LeCuBr struct_declaration_list RiCuBr
	| (Struct|Union) Identifier ;
struct_declaration_list : struct_declaration+ ;
struct_declaration : specifier_qualifier_list struct_declarator_list Semico ;
specifier_qualifier_list : (type_specifier|type_qualifier) specifier_qualifier_list? ;
struct_declarator_list : struct_declarator (Comma struct_declarator)* ;
struct_declarator
	: declarator
	| declarator? Colon constant_expression ;
enum_specifier
	: Enum Identifier? LeSqBr enumerator_list Comma? RiCuBr
	| Enum Identifier ;
enumerator_list : enumerator (Comma enumerator)* ;
enumerator : Identifier (Assign constant_expression)? ;
type_qualifier : (Const|Restrict|Volatile) ;
declarator : pointer? direct_declarator ;
direct_declarator
	: Identifier
	| LeRoBr declarator RiRoBr
	| direct_declarator LeSqBr type_qualifier_list? assignment_expression? RiSqBr
	| direct_declarator LeSqBr Static type_qualifier_list? assignment_expression RiSqBr
	| direct_declarator LeSqBr type_qualifier_list Static assignment_expression RiSqBr
	| direct_declarator LeSqBr type_qualifier_list? Star RiSqBr
	| direct_declarator LeRoBr parameter_type_list RiRoBr
	| direct_declarator LeRoBr identifier_list? RiRoBr ;
pointer : (Star type_qualifier_list?)+ ;
type_qualifier_list : type_qualifier+ ;
parameter_type_list : parameter_list (Comma ThreeP)? ;
parameter_list : parameter_declaration (Comma parameter_declaration)* ;
parameter_declaration : declaration_specifiers (declarator|abstract_declarator?) ;
identifier_list : Identifier (Comma Identifier)* ;
type_name : specifier_qualifier_list abstract_declarator? ;
abstract_declarator
	: pointer
	| pointer? direct_abstract_declarator ;
direct_abstract_declarator
	: LeRoBr declarator RiRoBr
	| direct_abstract_declarator LeSqBr type_qualifier_list? assignment_expression? RiSqBr
	| direct_abstract_declarator LeSqBr Static type_qualifier_list? assignment_expression RiSqBr
	| direct_abstract_declarator LeSqBr type_qualifier_list Static assignment_expression RiSqBr
	| direct_abstract_declarator LeSqBr type_qualifier_list? Star RiSqBr
	| direct_abstract_declarator LeRoBr parameter_type_list RiRoBr
	| direct_abstract_declarator LeRoBr identifier_list? RiRoBr ;
typedef_name : Identifier ;
initializer
	: assignment_expression
	| LeCuBr initializer_list Comma? RiCuBr ;
initializer_list : designation? initializer (Comma designation? initializer)* ;
designation : designator_list Assign ;
designator_list : designator+ ;
designator
	: LeSqBr constant_expression RiSqBr
	| Period Identifier ;
attributes_declaration : TwoLSB identifier_list TwoRSB ;

// A.2.3 Statements
statement
	: asm_statement
	| labeled_statement
	| compound_statement
	| expression_statement
	| selection_statement
	| iteration_statement
	| jump_statement 
	;
labeled_statement
	: Identifier Colon statement
	| Case constant_expression Colon statement
	| Default Colon statement ;
compound_statement : LeCuBr block_item_list? RiCuBr ;
block_item_list : block_item+ ;
block_item
	: statement
	| declaration ;
expression_statement : expression? Semico ;
selection_statement
	: If LeRoBr expression RiRoBr statement
	| If LeRoBr expression RiRoBr statement Else statement
	| Switch LeRoBr expression RiRoBr statement ;
iteration_statement
	: While LeRoBr expression RiRoBr statement
	| Do statement While LeRoBr expression RiRoBr Semico
	| For LeRoBr expression? Semico expression? Semico expression? RiRoBr statement
	| For LeRoBr declaration expression? Semico expression? RiRoBr statement ;
jump_statement
	: Goto Identifier Semico
	| Continue Semico
	| Break Semico
	| Return expression? Semico ;
asm_statement : Asm LeRoBr String_literal RiRoBr Semico ; // As per J.5.10

// A.2.4 External definitions 
translation_unit: external_declaration+ ;
external_declaration
	: function_definition
	| declaration ;
function_definition : attributes_declaration* declaration_specifiers declarator declaration_list? compound_statement ;
declaration_list : declaration+ ;