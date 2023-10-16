// Created by Iacon1 on 10/15/2023.
// Defines the C99 grammar.
// Note: Rules that are capitalized are lexical, rules that aren't are parsed.

grammar C99;
import C99A1, C99A2;

// A.3 Preprocessing directives
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
	: '#' 'include' pp_tokens '\n'
	| '#' 'define' Identifier replacement_list '\n'
	| '#' 'define' Identifier '(' identifier_list? ')' '\n' replacement_list '\n'
	| '#' 'define' Identifier '(' '...' ')' '\n' replacement_list '\n'
	| '#' 'define' Identifier '(' identifier_list ',' '...' ')' '\n' replacement_list '\n'
	| '#' 'undef' Identifier '\n'
	| '#' 'line' pp_tokens '\n'
	| '#' 'error' pp_tokens? '\n'
	| '#' 'pragma' pp_tokens? '\n'
	| '#' '\n' ;
text_line : pp_tokens? '\n' ;
non_directive : pp_tokens '\n' ;
replacement_list : pp_tokens? ;
pp_tokens : Preprocessing_token+ ;
