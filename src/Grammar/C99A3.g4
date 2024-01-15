grammar C99A3;

// A.3 Preprocessing directives

import C99A11, C99A17, C99A1, C99A1G, C99A2;
	
preprocessing_file : group? ;
group : group_part+ ;
group_part
	: if_section
	| control_line
	| text_line
	| '#' non_directive ;
if_section : if_group elif_groups? else_group? endif_line ;
if_group
	: '#' 'if' constant_expression '\n' group?
	| '#' 'ifdef' Identifier '\n' group?
	| '#' 'ifndef' Identifier '\n' group? ;
elif_groups: elif_group+ ;
elif_group : '#' 'elif' constant_expression '\n' group? ;
else_group : '#' 'else' '\n' group? ;
endif_line : '#' 'endif' '\n' ;
control_line
	: '#' 'include' pp_token+ '\n'
	| '#' 'define' Identifier pp_token* '\n'
	| '#' 'define' Identifier '(' identifier_list? ')' '\n' pp_token* '\n'
	| '#' 'define' Identifier '(' '...' ')' '\n' pp_token* '\n'
	| '#' 'define' Identifier '(' identifier_list ',' '...' ')' '\n' pp_token* '\n'
	| '#' 'undef' Identifier '\n'
	| '#' 'line' pp_token* '\n'
	| '#' 'error' pp_token* '\n'
	| '#' 'pragma' pp_token* '\n'
	| '#' '\n' ;
text_line : pp_token* '\n' ;
non_directive : pp_token+ '\n' ;

pp_token
	: Header_name
	| Identifier
	| Pp_number
	| Character_constant
	| String_literal
	| keyword
	| punctuator
	;