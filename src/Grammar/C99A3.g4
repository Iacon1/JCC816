grammar C99A3;

// A.3 Preprocessing directives

import C99A11, C99A17, C99A1, C99A1G, C99A2;
	
preprocessing_file : group? ;
group : group_part+? ;
group_part
	: if_section
	| control_line
	| HashTg non_directive
	| text_line
	;
if_section : if_group elif_group* else_group? endif_line;
if_group
	: HashTg If pp_token+ NL group? // Not technically correct, grammatically, but important for macro purposes and we fix it
	| HashTg Ifdef Identifier NL group?
	| HashTg Ifndef Identifier NL group?
	;
elif_group : HashTg Elif pp_token+ NL group? ;
else_group : HashTg Else NL group? ;
endif_line : HashTg Endif NL ;
control_line
	: HashTg Include pp_token+ NL
	| HashTg Define Identifier LeRoBr identifier_list? RiRoBr pp_token* NL
	| HashTg Define Identifier LeRoBr ThreeP RiRoBr pp_token* NL
	| HashTg Define Identifier LeRoBr identifier_list Comma ThreeP RiRoBr pp_token* NL
	| HashTg Define Identifier pp_token* NL
	| HashTg Undef Identifier NL
	| HashTg Line pp_token* NL
	| HashTg Error pp_token* NL
	| HashTg Pragma pp_token* NL
	| HashTg NL
	;
text_line : pp_token* NL ;
non_directive : pp_token+? NL ;

pp_token
	: Header_name
	| Identifier
	| Constant
	| String_literal
	| keyword
	| punctuator
	;