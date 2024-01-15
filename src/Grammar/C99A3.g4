grammar C99A3;

// A.3 Preprocessing directives

import C99A11, C99A17, C99A1, C99A1G, C99A2;
	
preprocessing_file : group? ;
group : group_part+ ;
group_part
	: if_section
	| control_line
	| text_line
	| HashTg non_directive ;
if_section : if_group elif_groups? else_group? endif_line ;
if_group
	: HashTg If constant_expression NL group?
	| HashTg Ifdef Identifier NL group?
	| HashTg Ifndef Identifier NL group? ;
elif_groups: elif_group+ ;
elif_group : HashTg Elif constant_expression NL group? ;
else_group : HashTg Else NL group? ;
endif_line : HashTg Endif NL ;
control_line
	: HashTg Include pp_token+ NL
	| HashTg Define Identifier pp_token* NL
	| HashTg Define Identifier LeRoBr identifier_list? RiRoBr NL pp_token* NL
	| HashTg Define Identifier LeRoBr ThreeP RiRoBr NL pp_token* NL
	| HashTg Define Identifier LeRoBr identifier_list Comma ThreeP RiRoBr NL pp_token* NL
	| HashTg Undef Identifier NL
	| HashTg Line pp_token* NL
	| HashTg Error pp_token* NL
	| HashTg Pragma pp_token* NL
	| HashTg NL ;
text_line : pp_token* NL ;
non_directive : pp_token+ NL ;

pp_token
	: Header_name
	| Identifier
	| Pp_number
	| Character_constant
	| String_literal
	| keyword
	| punctuator
	;