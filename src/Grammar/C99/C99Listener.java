// Generated from D:/BBSnCC/src/Grammar/C99.g4 by ANTLR 4.13.1
package Grammar.C99;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link C99Parser}.
 */
public interface C99Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link C99Parser#preprocessing_file}.
	 * @param ctx the parse tree
	 */
	void enterPreprocessing_file(C99Parser.Preprocessing_fileContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#preprocessing_file}.
	 * @param ctx the parse tree
	 */
	void exitPreprocessing_file(C99Parser.Preprocessing_fileContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#group}.
	 * @param ctx the parse tree
	 */
	void enterGroup(C99Parser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#group}.
	 * @param ctx the parse tree
	 */
	void exitGroup(C99Parser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#group_part}.
	 * @param ctx the parse tree
	 */
	void enterGroup_part(C99Parser.Group_partContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#group_part}.
	 * @param ctx the parse tree
	 */
	void exitGroup_part(C99Parser.Group_partContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#if_section}.
	 * @param ctx the parse tree
	 */
	void enterIf_section(C99Parser.If_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#if_section}.
	 * @param ctx the parse tree
	 */
	void exitIf_section(C99Parser.If_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#if_group}.
	 * @param ctx the parse tree
	 */
	void enterIf_group(C99Parser.If_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#if_group}.
	 * @param ctx the parse tree
	 */
	void exitIf_group(C99Parser.If_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#elif_groups}.
	 * @param ctx the parse tree
	 */
	void enterElif_groups(C99Parser.Elif_groupsContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#elif_groups}.
	 * @param ctx the parse tree
	 */
	void exitElif_groups(C99Parser.Elif_groupsContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#elif_group}.
	 * @param ctx the parse tree
	 */
	void enterElif_group(C99Parser.Elif_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#elif_group}.
	 * @param ctx the parse tree
	 */
	void exitElif_group(C99Parser.Elif_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#else_group}.
	 * @param ctx the parse tree
	 */
	void enterElse_group(C99Parser.Else_groupContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#else_group}.
	 * @param ctx the parse tree
	 */
	void exitElse_group(C99Parser.Else_groupContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#endif_line}.
	 * @param ctx the parse tree
	 */
	void enterEndif_line(C99Parser.Endif_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#endif_line}.
	 * @param ctx the parse tree
	 */
	void exitEndif_line(C99Parser.Endif_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#control_line}.
	 * @param ctx the parse tree
	 */
	void enterControl_line(C99Parser.Control_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#control_line}.
	 * @param ctx the parse tree
	 */
	void exitControl_line(C99Parser.Control_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#text_line}.
	 * @param ctx the parse tree
	 */
	void enterText_line(C99Parser.Text_lineContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#text_line}.
	 * @param ctx the parse tree
	 */
	void exitText_line(C99Parser.Text_lineContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#non_directive}.
	 * @param ctx the parse tree
	 */
	void enterNon_directive(C99Parser.Non_directiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#non_directive}.
	 * @param ctx the parse tree
	 */
	void exitNon_directive(C99Parser.Non_directiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#replacement_list}.
	 * @param ctx the parse tree
	 */
	void enterReplacement_list(C99Parser.Replacement_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#replacement_list}.
	 * @param ctx the parse tree
	 */
	void exitReplacement_list(C99Parser.Replacement_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#pp_tokens}.
	 * @param ctx the parse tree
	 */
	void enterPp_tokens(C99Parser.Pp_tokensContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#pp_tokens}.
	 * @param ctx the parse tree
	 */
	void exitPp_tokens(C99Parser.Pp_tokensContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void enterPrimary_expression(C99Parser.Primary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#primary_expression}.
	 * @param ctx the parse tree
	 */
	void exitPrimary_expression(C99Parser.Primary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expression(C99Parser.Postfix_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#postfix_expression}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expression(C99Parser.Postfix_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#argument_expression_list}.
	 * @param ctx the parse tree
	 */
	void enterArgument_expression_list(C99Parser.Argument_expression_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#argument_expression_list}.
	 * @param ctx the parse tree
	 */
	void exitArgument_expression_list(C99Parser.Argument_expression_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expression(C99Parser.Unary_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#unary_expression}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expression(C99Parser.Unary_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void enterCast_expression(C99Parser.Cast_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#cast_expression}.
	 * @param ctx the parse tree
	 */
	void exitCast_expression(C99Parser.Cast_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicative_expression(C99Parser.Multiplicative_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#multiplicative_expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicative_expression(C99Parser.Multiplicative_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expression(C99Parser.Additive_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#additive_expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expression(C99Parser.Additive_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void enterShift_expression(C99Parser.Shift_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#shift_expression}.
	 * @param ctx the parse tree
	 */
	void exitShift_expression(C99Parser.Shift_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expression(C99Parser.Relational_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#relational_expression}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expression(C99Parser.Relational_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void enterEquality_expression(C99Parser.Equality_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#equality_expression}.
	 * @param ctx the parse tree
	 */
	void exitEquality_expression(C99Parser.Equality_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#and_expression}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expression(C99Parser.And_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#and_expression}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expression(C99Parser.And_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#xor_expression}.
	 * @param ctx the parse tree
	 */
	void enterXor_expression(C99Parser.Xor_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#xor_expression}.
	 * @param ctx the parse tree
	 */
	void exitXor_expression(C99Parser.Xor_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#or_expression}.
	 * @param ctx the parse tree
	 */
	void enterOr_expression(C99Parser.Or_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#or_expression}.
	 * @param ctx the parse tree
	 */
	void exitOr_expression(C99Parser.Or_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#land_expression}.
	 * @param ctx the parse tree
	 */
	void enterLand_expression(C99Parser.Land_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#land_expression}.
	 * @param ctx the parse tree
	 */
	void exitLand_expression(C99Parser.Land_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#lor_expression}.
	 * @param ctx the parse tree
	 */
	void enterLor_expression(C99Parser.Lor_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#lor_expression}.
	 * @param ctx the parse tree
	 */
	void exitLor_expression(C99Parser.Lor_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void enterConditional_expression(C99Parser.Conditional_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#conditional_expression}.
	 * @param ctx the parse tree
	 */
	void exitConditional_expression(C99Parser.Conditional_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_expression(C99Parser.Assignment_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#assignment_expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_expression(C99Parser.Assignment_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(C99Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(C99Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void enterConstant_expression(C99Parser.Constant_expressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#constant_expression}.
	 * @param ctx the parse tree
	 */
	void exitConstant_expression(C99Parser.Constant_expressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(C99Parser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(C99Parser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#declaration_specifiers}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_specifiers(C99Parser.Declaration_specifiersContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#declaration_specifiers}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_specifiers(C99Parser.Declaration_specifiersContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#init_declarator_list}.
	 * @param ctx the parse tree
	 */
	void enterInit_declarator_list(C99Parser.Init_declarator_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#init_declarator_list}.
	 * @param ctx the parse tree
	 */
	void exitInit_declarator_list(C99Parser.Init_declarator_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#init_declarator}.
	 * @param ctx the parse tree
	 */
	void enterInit_declarator(C99Parser.Init_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#init_declarator}.
	 * @param ctx the parse tree
	 */
	void exitInit_declarator(C99Parser.Init_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void enterType_specifier(C99Parser.Type_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#type_specifier}.
	 * @param ctx the parse tree
	 */
	void exitType_specifier(C99Parser.Type_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#struct_or_union_specifier}.
	 * @param ctx the parse tree
	 */
	void enterStruct_or_union_specifier(C99Parser.Struct_or_union_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#struct_or_union_specifier}.
	 * @param ctx the parse tree
	 */
	void exitStruct_or_union_specifier(C99Parser.Struct_or_union_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#struct_declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterStruct_declaration_list(C99Parser.Struct_declaration_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#struct_declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitStruct_declaration_list(C99Parser.Struct_declaration_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void enterStruct_declaration(C99Parser.Struct_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#struct_declaration}.
	 * @param ctx the parse tree
	 */
	void exitStruct_declaration(C99Parser.Struct_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#specifier_qualifier_list}.
	 * @param ctx the parse tree
	 */
	void enterSpecifier_qualifier_list(C99Parser.Specifier_qualifier_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#specifier_qualifier_list}.
	 * @param ctx the parse tree
	 */
	void exitSpecifier_qualifier_list(C99Parser.Specifier_qualifier_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#struct_declarator_list}.
	 * @param ctx the parse tree
	 */
	void enterStruct_declarator_list(C99Parser.Struct_declarator_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#struct_declarator_list}.
	 * @param ctx the parse tree
	 */
	void exitStruct_declarator_list(C99Parser.Struct_declarator_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#struct_declarator}.
	 * @param ctx the parse tree
	 */
	void enterStruct_declarator(C99Parser.Struct_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#struct_declarator}.
	 * @param ctx the parse tree
	 */
	void exitStruct_declarator(C99Parser.Struct_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#enum_specifier}.
	 * @param ctx the parse tree
	 */
	void enterEnum_specifier(C99Parser.Enum_specifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#enum_specifier}.
	 * @param ctx the parse tree
	 */
	void exitEnum_specifier(C99Parser.Enum_specifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#enumerator_list}.
	 * @param ctx the parse tree
	 */
	void enterEnumerator_list(C99Parser.Enumerator_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#enumerator_list}.
	 * @param ctx the parse tree
	 */
	void exitEnumerator_list(C99Parser.Enumerator_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#enumerator}.
	 * @param ctx the parse tree
	 */
	void enterEnumerator(C99Parser.EnumeratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#enumerator}.
	 * @param ctx the parse tree
	 */
	void exitEnumerator(C99Parser.EnumeratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#type_qualifier}.
	 * @param ctx the parse tree
	 */
	void enterType_qualifier(C99Parser.Type_qualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#type_qualifier}.
	 * @param ctx the parse tree
	 */
	void exitType_qualifier(C99Parser.Type_qualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#declarator}.
	 * @param ctx the parse tree
	 */
	void enterDeclarator(C99Parser.DeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#declarator}.
	 * @param ctx the parse tree
	 */
	void exitDeclarator(C99Parser.DeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#direct_declarator}.
	 * @param ctx the parse tree
	 */
	void enterDirect_declarator(C99Parser.Direct_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#direct_declarator}.
	 * @param ctx the parse tree
	 */
	void exitDirect_declarator(C99Parser.Direct_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#pointer}.
	 * @param ctx the parse tree
	 */
	void enterPointer(C99Parser.PointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#pointer}.
	 * @param ctx the parse tree
	 */
	void exitPointer(C99Parser.PointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#type_qualifier_list}.
	 * @param ctx the parse tree
	 */
	void enterType_qualifier_list(C99Parser.Type_qualifier_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#type_qualifier_list}.
	 * @param ctx the parse tree
	 */
	void exitType_qualifier_list(C99Parser.Type_qualifier_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#parameter_type_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_type_list(C99Parser.Parameter_type_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#parameter_type_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_type_list(C99Parser.Parameter_type_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(C99Parser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(C99Parser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#parameter_declaration}.
	 * @param ctx the parse tree
	 */
	void enterParameter_declaration(C99Parser.Parameter_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#parameter_declaration}.
	 * @param ctx the parse tree
	 */
	void exitParameter_declaration(C99Parser.Parameter_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#identifier_list}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier_list(C99Parser.Identifier_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#identifier_list}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier_list(C99Parser.Identifier_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#type_name}.
	 * @param ctx the parse tree
	 */
	void enterType_name(C99Parser.Type_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#type_name}.
	 * @param ctx the parse tree
	 */
	void exitType_name(C99Parser.Type_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#abstract_declarator}.
	 * @param ctx the parse tree
	 */
	void enterAbstract_declarator(C99Parser.Abstract_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#abstract_declarator}.
	 * @param ctx the parse tree
	 */
	void exitAbstract_declarator(C99Parser.Abstract_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#direct_abstract_declarator}.
	 * @param ctx the parse tree
	 */
	void enterDirect_abstract_declarator(C99Parser.Direct_abstract_declaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#direct_abstract_declarator}.
	 * @param ctx the parse tree
	 */
	void exitDirect_abstract_declarator(C99Parser.Direct_abstract_declaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#typedef_name}.
	 * @param ctx the parse tree
	 */
	void enterTypedef_name(C99Parser.Typedef_nameContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#typedef_name}.
	 * @param ctx the parse tree
	 */
	void exitTypedef_name(C99Parser.Typedef_nameContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(C99Parser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(C99Parser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#initializer_list}.
	 * @param ctx the parse tree
	 */
	void enterInitializer_list(C99Parser.Initializer_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#initializer_list}.
	 * @param ctx the parse tree
	 */
	void exitInitializer_list(C99Parser.Initializer_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#designation}.
	 * @param ctx the parse tree
	 */
	void enterDesignation(C99Parser.DesignationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#designation}.
	 * @param ctx the parse tree
	 */
	void exitDesignation(C99Parser.DesignationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#designator_list}.
	 * @param ctx the parse tree
	 */
	void enterDesignator_list(C99Parser.Designator_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#designator_list}.
	 * @param ctx the parse tree
	 */
	void exitDesignator_list(C99Parser.Designator_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#designator}.
	 * @param ctx the parse tree
	 */
	void enterDesignator(C99Parser.DesignatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#designator}.
	 * @param ctx the parse tree
	 */
	void exitDesignator(C99Parser.DesignatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(C99Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(C99Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#labeled_statement}.
	 * @param ctx the parse tree
	 */
	void enterLabeled_statement(C99Parser.Labeled_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#labeled_statement}.
	 * @param ctx the parse tree
	 */
	void exitLabeled_statement(C99Parser.Labeled_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void enterCompound_statement(C99Parser.Compound_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#compound_statement}.
	 * @param ctx the parse tree
	 */
	void exitCompound_statement(C99Parser.Compound_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#block_item_list}.
	 * @param ctx the parse tree
	 */
	void enterBlock_item_list(C99Parser.Block_item_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#block_item_list}.
	 * @param ctx the parse tree
	 */
	void exitBlock_item_list(C99Parser.Block_item_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#block_item}.
	 * @param ctx the parse tree
	 */
	void enterBlock_item(C99Parser.Block_itemContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#block_item}.
	 * @param ctx the parse tree
	 */
	void exitBlock_item(C99Parser.Block_itemContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void enterExpression_statement(C99Parser.Expression_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#expression_statement}.
	 * @param ctx the parse tree
	 */
	void exitExpression_statement(C99Parser.Expression_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void enterSelection_statement(C99Parser.Selection_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#selection_statement}.
	 * @param ctx the parse tree
	 */
	void exitSelection_statement(C99Parser.Selection_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void enterIteration_statement(C99Parser.Iteration_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#iteration_statement}.
	 * @param ctx the parse tree
	 */
	void exitIteration_statement(C99Parser.Iteration_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void enterJump_statement(C99Parser.Jump_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#jump_statement}.
	 * @param ctx the parse tree
	 */
	void exitJump_statement(C99Parser.Jump_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void enterTranslation_unit(C99Parser.Translation_unitContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#translation_unit}.
	 * @param ctx the parse tree
	 */
	void exitTranslation_unit(C99Parser.Translation_unitContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#external_declaration}.
	 * @param ctx the parse tree
	 */
	void enterExternal_declaration(C99Parser.External_declarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#external_declaration}.
	 * @param ctx the parse tree
	 */
	void exitExternal_declaration(C99Parser.External_declarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#function_definition}.
	 * @param ctx the parse tree
	 */
	void enterFunction_definition(C99Parser.Function_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#function_definition}.
	 * @param ctx the parse tree
	 */
	void exitFunction_definition(C99Parser.Function_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link C99Parser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration_list(C99Parser.Declaration_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link C99Parser#declaration_list}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration_list(C99Parser.Declaration_listContext ctx);
}