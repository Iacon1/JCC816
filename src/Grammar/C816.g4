grammar C816;

WS : [ \t\r]+ -> skip ; // skip spaces, tabs

Operation
	: 'ADC'	| 'AND'	| 'ASL'
	| 'BCC'	| 'BCS'	| 'BEQ'	| 'BIT'	| 'BMI'	| 'BNE'	| 'BPL'	| 'BRA'	| 'BRK'	| 'BRL'	| 'BVC'	| 'BVS'
	| 'CLC'	| 'CLD'	| 'CLI'	| 'CLV'	| 'CMP'	| 'CPX'	| 'CPY'	| 'COP'
	| 'DEC'	| 'DEX' | 'DEY'
	| 'EOR'
	| 'INC'	| 'INX' | 'INY'
	| 'JMP'	| 'JML'	| 'JSL' | 'JSR'
	| 'LDA'	| 'LDX'	| 'LDY'	| 'LSR'
	| 'MVN'	| 'MVP'
	| 'NOP'
	| 'ORA'
	| 'PEA'	| 'PEI'	| 'PER'	| 'PHA'	| 'PHB' | 'PHD'	| 'PHK'	| 'PHX'	| 'PHY'	| 'PLA'	| 'PLB' | 'PLD'	| 'PLP'	| 'PLX' | 'PLY'
	| 'REP' | 'ROL' | 'ROR' | 'RTI' | 'RTS' | 'RTL'
	| 'SBC' | 'SEC' | 'SED' | 'SEI' | 'SEP' | 'STA' | 'STX' | 'STY' | 'STP' | 'STZ'
	| 'TAX' | 'TAY' | 'TCD' | 'TCS' | 'TDC' | 'TSC' | 'TSX' | 'TXA' | 'TXS' | 'TXY' | 'TYA' | 'TYX' | 'TRB' | 'TSB'
	| 'WAI' | 'XBA' | 'XCE'
	;
Length
	: 'f:'
	| 'a:'
	| 'z:'
	;
PpFunc // Preprocessor thing
	: '.loWord'
	| '.loword'
	| '.loByte'
	| '.lobyte'
	| '.hiWord'
	| '.hiword'
	| '.hiByte'
	| '.hibyte'
	| '.bankByte'
	| '.bankbyte'
	;
fragment PpEndable
	: 'enum'
	| 'if'
	| 'macro'
	| 'scope'
	| 'proc'
	;
fragment PpZpable
	: 'export'
	| 'import'
	;
fragment PpDirective // Preprocessor thing
	: '.a8'
	| '.a16'
	| '.i8'
	| '.i16'
	| '.setcpu'
	| '.smart'
	| '.autoimport'
	| '.error'
	| '.define'
	| '.assert'
	| '.bss'
	| '.res'
	| '.segment'
	| '.else'
	| '.elseif'
	| '.zeropage'
	| '.dbg'
	| '.byte'
	| '.word'
	| '.' PpZpable 'zp'
	| '.' PpZpable
	| '.end' PpEndable
	| '.' PpEndable
	;

Symbol
	: [a-zA-Z@_] [0-9a-zA-Z@_]* (':' ':' [a-zA-Z@_] [0-9a-zA-Z@_]*)?
	;
Number
	: [0-9]+
	| '$' [0-9a-fA-F]+ 
	;
Comment : ';' ~[\n]* ;
Preproc
	: PpDirective ~[\n]*
	| ~[\n=]+ '=' ~[\n]+; 
parameter
	: '(' value ')'  (',' ('x'|'y'|'X'|'Y'))?
	| '(' value ',' ('x'|'y'|'X'|'Y') ')'
	| '[' value ']' (',' ('x'|'y'|'X'|'Y'))?
	| '(' value ',' 's' ')' (',' ('x'|'y'|'X'|'Y')?)
	| value ',' ('x'|'y'|'X'|'Y')
	| value ',' value
	| value
	;
value
	: Symbol
	| Number
	| value '+' value
	| value '|' value
	| value '^' value
	| value '<<' value
	| '#' value
	| Length value
	| PpFunc '(' value ')'
	| '(' value ')'
	| ':' '+'+
	| ':' '-'+
	;	
instruction : Operation parameter? ;
preprocInstruction : Preproc ;
macroInstruction : Symbol ;
label : Symbol? ':' ;
program
	: (( label
	   | label? instruction
	   | label? preprocInstruction
	   | label? macroInstruction
	   )? Comment? '\n'
	  )+
	;