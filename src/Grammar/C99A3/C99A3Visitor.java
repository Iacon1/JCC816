// Generated from I:/Coding Projects/JCC816/src/Grammar/C99A3.g4 by ANTLR 4.13.1
package Grammar.C99A3;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link C99A3Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface C99A3Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#preprocessing_file}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreprocessing_file(C99A3Parser.Preprocessing_fileContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup(C99A3Parser.GroupContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#group_part}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroup_part(C99A3Parser.Group_partContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#if_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_section(C99A3Parser.If_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#if_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_group(C99A3Parser.If_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#elif_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElif_group(C99A3Parser.Elif_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#else_group}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_group(C99A3Parser.Else_groupContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#endif_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndif_line(C99A3Parser.Endif_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#control_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl_line(C99A3Parser.Control_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#text_line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitText_line(C99A3Parser.Text_lineContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#non_directive}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_directive(C99A3Parser.Non_directiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#pp_token}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPp_token(C99A3Parser.Pp_tokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(C99A3Parser.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#punctuator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPunctuator(C99A3Parser.PunctuatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expression(C99A3Parser.Primary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix_expression(C99A3Parser.Postfix_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#argument_expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_expression_list(C99A3Parser.Argument_expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expression(C99A3Parser.Unary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#cast_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast_expression(C99A3Parser.Cast_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(C99A3Parser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointer(C99A3Parser.PointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expression(C99A3Parser.Multiplicative_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_expression(C99A3Parser.Additive_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expression(C99A3Parser.Shift_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expression(C99A3Parser.Relational_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expression(C99A3Parser.Equality_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expression(C99A3Parser.And_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#xor_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor_expression(C99A3Parser.Xor_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expression(C99A3Parser.Or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#land_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLand_expression(C99A3Parser.Land_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#lor_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLor_expression(C99A3Parser.Lor_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_expression(C99A3Parser.Conditional_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#assignment_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_expression(C99A3Parser.Assignment_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(C99A3Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#constant_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_expression(C99A3Parser.Constant_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#attributes_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes_declaration(C99A3Parser.Attributes_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(C99A3Parser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#declaration_specifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_specifiers(C99A3Parser.Declaration_specifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#storage_class_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorage_class_specifier(C99A3Parser.Storage_class_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#function_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_specifier(C99A3Parser.Function_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#init_declarator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_declarator_list(C99A3Parser.Init_declarator_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#init_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_declarator(C99A3Parser.Init_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#type_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_specifier(C99A3Parser.Type_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#struct_or_union_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_or_union_specifier(C99A3Parser.Struct_or_union_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#struct_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_declaration_list(C99A3Parser.Struct_declaration_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#struct_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_declaration(C99A3Parser.Struct_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#specifier_qualifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecifier_qualifier_list(C99A3Parser.Specifier_qualifier_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#struct_declarator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_declarator_list(C99A3Parser.Struct_declarator_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#struct_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_declarator(C99A3Parser.Struct_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#enum_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnum_specifier(C99A3Parser.Enum_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#enumerator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerator_list(C99A3Parser.Enumerator_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#enumerator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerator(C99A3Parser.EnumeratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#type_qualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_qualifier(C99A3Parser.Type_qualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#direct_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirect_declarator(C99A3Parser.Direct_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#type_qualifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_qualifier_list(C99A3Parser.Type_qualifier_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#parameter_type_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_type_list(C99A3Parser.Parameter_type_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(C99A3Parser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#parameter_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_declaration(C99A3Parser.Parameter_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#identifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_list(C99A3Parser.Identifier_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#type_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_name(C99A3Parser.Type_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#abstract_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstract_declarator(C99A3Parser.Abstract_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#direct_abstract_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirect_abstract_declarator(C99A3Parser.Direct_abstract_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#typedef_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedef_name(C99A3Parser.Typedef_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(C99A3Parser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#initializer_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer_list(C99A3Parser.Initializer_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#designation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignation(C99A3Parser.DesignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#designator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignator_list(C99A3Parser.Designator_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#designator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignator(C99A3Parser.DesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(C99A3Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#labeled_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeled_statement(C99A3Parser.Labeled_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement(C99A3Parser.Compound_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#block_item_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_item_list(C99A3Parser.Block_item_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#block_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_item(C99A3Parser.Block_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#expression_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_statement(C99A3Parser.Expression_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#selection_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_statement(C99A3Parser.Selection_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#iteration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration_statement(C99A3Parser.Iteration_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#jump_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_statement(C99A3Parser.Jump_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#asm_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_statement(C99A3Parser.Asm_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#translation_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslation_unit(C99A3Parser.Translation_unitContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#external_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternal_declaration(C99A3Parser.External_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(C99A3Parser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99A3Parser#declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_list(C99A3Parser.Declaration_listContext ctx);
}