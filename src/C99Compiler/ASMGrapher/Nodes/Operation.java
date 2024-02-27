// Created by Iacon1 on 11/30/2023.
// An assembly operation and what it depends on and what depends on it

package C99Compiler.ASMGrapher.Nodes;

public enum Operation
{		
	ADC(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagC,	// Affected by flags?
			InstructionNode.flagC | InstructionNode.flagZ | InstructionNode.flagV | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	AND(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	ASL(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagC,	// Affected by flags?
			InstructionNode.flagC | InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	BCC(
			0,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagC,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			true), // Is a branch?
	BCS(
			0,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagC,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			true), // Is a branch?
	BEQ(
			0,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagZ,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			true), // Is a branch?
	BIT(
			InstructionNode.registerA,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagC,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagV | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	BMI(
			0,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagN,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			true), // Is a branch?
	BNE(
			0,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagZ,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			true), // Is a branch?
	BPL(
			0,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagN,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			true), // Is a branch?
	BRA(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	BRK(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	BRL(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	BVC(
			0,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagV,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			true), // Is a branch?
	BVS(
			0,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagV,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			true), // Is a branch?
	CLC(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagC, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	CLD(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagD, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	CLI(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagI, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	CLV(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagV, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	CMP(
			InstructionNode.registerA,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			InstructionNode.flagC | InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	COP(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagD | InstructionNode.flagI, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	CPX(
			InstructionNode.registerX,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagC | InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	CPY(
			InstructionNode.registerY,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagC | InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	DEC(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	DEX(
			InstructionNode.registerX,	// Affected by registers?
			InstructionNode.registerX,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	DEY(
			InstructionNode.registerY,	// Affected by registers?
			InstructionNode.registerY,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	EOR(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	INC(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	INX(
			InstructionNode.registerX,	// Affected by registers?
			InstructionNode.registerX,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	INY(
			InstructionNode.registerY,	// Affected by registers?
			InstructionNode.registerY,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	JMP(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	JML(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	JSL(
			0,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	JSR(
			0,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	LDA(
			0,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	LDX(
			0,	// Affected by registers?
			InstructionNode.registerX,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	LDY(
			0,	// Affected by registers?
			InstructionNode.registerY,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	LSR(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagC,	// Affected by flags?
			InstructionNode.flagC | InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	MVN(
			InstructionNode.registerA | InstructionNode.registerX | InstructionNode.registerY,	// Affected by registers?
			InstructionNode.registerA | InstructionNode.registerX | InstructionNode.registerY,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagX,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			true, // Affects parameter?,
			false), // Is a branch?
	MVP(
			InstructionNode.registerA | InstructionNode.registerX | InstructionNode.registerY,	// Affected by registers?
			InstructionNode.registerA | InstructionNode.registerX | InstructionNode.registerY,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagX,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			true, // Affects parameter?,
			false), // Is a branch?
	NOP(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	ORA(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PEA(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PEI(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PER(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PHA(
			InstructionNode.registerA | InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PHB(
			InstructionNode.registerB | InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PHD(
			InstructionNode.registerD | InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PHK(
			InstructionNode.registerK | InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?,
	PHP(
			InstructionNode.registerP | InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PHX(
			InstructionNode.registerX | InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PHY(
			InstructionNode.registerY | InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PLA(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerA | InstructionNode.registerS,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PLB(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerB | InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PLD(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerD | InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PLP(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0xFF, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PLX(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerX | InstructionNode.registerS,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	PLY(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerY | InstructionNode.registerS,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	REP(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags? This one's special btw
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	ROL(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagC,	// Affected by flags?
			InstructionNode.flagC | InstructionNode.flagZ | InstructionNode.flagV | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	ROR(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagC,	// Affected by flags?
			InstructionNode.flagC | InstructionNode.flagZ | InstructionNode.flagV | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	RTI(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	RTS(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	RTL(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	SBC(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagC,	// Affected by flags?
			InstructionNode.flagC | InstructionNode.flagZ | InstructionNode.flagV | InstructionNode.flagN, // Affects flags?
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	SEC(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagC, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	SED(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagD, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	SEI(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagI, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	SEP(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags? This one's special btw
			true,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	STA(
			InstructionNode.registerA,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			true, // Affects parameter?
			false), // Is a branch?
	STX(
			InstructionNode.registerX,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			true, // Affects parameter?
			false), // Is a branch?
	STY(
			InstructionNode.registerY,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			true, // Affects parameter?
			false), // Is a branch?
	STP(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?,
			false), // Is a branch?
	STZ(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			true, // Affects parameter?
			false), // Is a branch?
	TAX(
			InstructionNode.registerA | InstructionNode.registerX,	// Affected by registers?
			InstructionNode.registerX,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TAY(
			InstructionNode.registerA | InstructionNode.registerX,	// Affected by registers?
			InstructionNode.registerY,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TCD(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerD,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TCS(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerS,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TDC(
			InstructionNode.registerD,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TSC(
			InstructionNode.registerS,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TSX(
			InstructionNode.registerA | InstructionNode.registerX,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TRB(
			InstructionNode.registerA,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			InstructionNode.flagZ, // Affects flags?
			true,	// Affected by parameter?
			true, // Affects parameter?
			false), // Is a branch?
	TSB(
			InstructionNode.registerA,	// Affected by registers?
			0,	// Affects registers??
			InstructionNode.flagM,	// Affected by flags?
			InstructionNode.flagZ, // Affects flags?
			true,	// Affected by parameter?
			true, // Affects parameter?
			false), // Is a branch?
	TXA(
			InstructionNode.registerA | InstructionNode.registerX,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TXS(
			InstructionNode.registerA | InstructionNode.registerX,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TXY(
			InstructionNode.registerX | InstructionNode.registerY,	// Affected by registers?
			InstructionNode.registerX,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TYA(
			InstructionNode.registerA | InstructionNode.registerY,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			InstructionNode.flagM | InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	TYX(
			InstructionNode.registerX | InstructionNode.registerY,	// Affected by registers?
			InstructionNode.registerX,	// Affects registers??
			InstructionNode.flagX,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	WAI(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	XBA(
			InstructionNode.registerA,	// Affected by registers?
			InstructionNode.registerA,	// Affects registers??
			0,	// Affected by flags?
			InstructionNode.flagZ | InstructionNode.flagN, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	XCE(
			0,	// Affected by registers?
			0,	// Affects registers??
			0,	// Affected by flags?
			0, // Affects flags?
			false,	// Affected by parameter?
			false, // Affects parameter?
			false), // Is a branch?
	;
	
	private byte affectingRegisters, affectingFlags; // Registers and flags we depend on
	private boolean affectedByParameter; // Do we depend on the parameter?
	private byte affectedRegisters, affectedFlags; // Registers and flags we affect
	private boolean affectsParameter; // Do we affect the parameter?
	private boolean isBranch;
	private Operation(int affectingRegisters, int affectedRegisters, int affectingFlags, int affectedFlags, boolean affectedByParameter, boolean affectsParameter, boolean isBranch)
	{
		this.affectingRegisters = (byte) affectingRegisters;
		this.affectedRegisters = (byte) affectedRegisters;
		
		this.affectingFlags = (byte) affectingFlags;
		this.affectedFlags = (byte) affectedFlags;
		
		this.affectedByParameter = affectedByParameter;
		this.affectsParameter = affectsParameter;
		
		this.isBranch = isBranch;
	}
	public byte affectingRegisters() {return affectingRegisters;}
	public byte affectingFlags() {return affectingFlags;}
	public boolean affectedByParameter() {return affectedByParameter;}
	
	public byte affectedRegisters() {return affectedRegisters;}
	public byte affectedFlags() {return affectedFlags;}
	public boolean affectsParameter()  {return affectsParameter;}
	
	public boolean isBranch() {return isBranch;}
}
