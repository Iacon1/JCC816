grammar C816;

WS : [ \t\r]+ -> skip ; // skip spaces, tabs

Operation
	: 'ADC'	| 'AND'	| 'ASL'
	| 'BCC'	| 'BCS'	| 'BEQ'	| 'BIT'	| 'BMI'	| 'BNE'	| 'BPL'	| 'BRA'	| 'BRK'	| 'BRL'	| 'BVC'	| 'BVS'
	| 'CLC'	| 'CLD'	| 'CLI'	| 'CLV'	| 'CMP'	| 'CPX'	| 'CPY'	| 'COP'
	| 'DEC'	| 'DEX' | 'DEY'
	| 'EOR'
	| 'INC'	| 'INX' | 'INY'
	| 'JMP'	| 'JML'	| 'JSL'
	| 'LDA'	| 'LDX'	| 'LDY'	| 'LSR'
	| 'MVN'	| 'MVP'
	| 'NOP'
	| 'ORA'
	| 'PEA'	| 'PEI'	| 'PER'	| 'PHA'	| 'PHD'	| 'PHK'	| 'PHX'	| 'PHY'	| 'PLA'	| 'PLD'	| 'PLP'	| 'PLX' | 'PLY'
	| 'REP' | 'ROL' | 'ROR' | 'RTI' | 'RTS' | 'RTL'
	| 'SBC' | 'SEC' | 'SED' | 'SEI' | 'SEP' | 'STA' | 'STX' | 'STY' | 'STP' | 'STZ'
	| 'TAX' | 'TAY' | 'TCD' | 'TCS' | 'TDC' | 'TSC' | 'TSX' | 'TXA' | 'TXS' | 'TXY' | 'TYA' | 'TYX' | 'TRB' | 'TSB'
	| 'WAI' | 'XCE'
	;
fragment PpFunc // Preprocessor function
	: '.loWord'
	| '.loByte'
	| '.bankByte'
	;
Symbol
	: [a-zA-Z_] [0-9a-zA-Z@_]*
	| PpFunc '(' Symbol ')'
	;
Number
	: [0-9]+
	|  '$' [0-9a-fA-F]+ 
	;
Comment : ';' ~[\n]* ;
Preproc
	: '.' ~[\n]* 
	| ~[\n=]+ '=' ~[\n]+; 
parameter
	: '(' address ')'  (',' ('x'|'y'))?
	| '(' address ',' ('x'|'y') ')'
	| '[' address']' (',' 'x')?
	| '[' address ']' (',' ('x'|'y'))?
	| '(' address ',' 's' ')' (',' ('x'|'y')?)
	| address ',' ('x'|'y')
	| address ',' address
	| address
	| '#' address
	;
address
	: Symbol ('+' Number)?
	| Number
	| ':' '+'+
	| ':' '-'+
	;	
instruction : Operation parameter? ;
preprocInstruction : Preproc Comment? ;
label : Symbol? ':' Comment? ;

program
	: (( label
	   | label? instruction
	   | label? preprocInstruction
	   )? Comment? '\n'
	  )+
	;