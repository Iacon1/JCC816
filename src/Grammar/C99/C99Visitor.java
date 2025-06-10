// Generated from I:/Coding Projects/JCC816/src/Grammar/C99.g4 by ANTLR 4.13.1
package Grammar.C99;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link C99Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface C99Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link C99Parser#dummy}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDummy(C99Parser.DummyContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#primary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary_expression(C99Parser.Primary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#postfix_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix_expression(C99Parser.Postfix_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#argument_expression_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_expression_list(C99Parser.Argument_expression_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#unary_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expression(C99Parser.Unary_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#cast_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCast_expression(C99Parser.Cast_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarator(C99Parser.DeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#pointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPointer(C99Parser.PointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#multiplicative_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicative_expression(C99Parser.Multiplicative_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#additive_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_expression(C99Parser.Additive_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#shift_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expression(C99Parser.Shift_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#relational_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expression(C99Parser.Relational_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#equality_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_expression(C99Parser.Equality_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#and_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expression(C99Parser.And_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#xor_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitXor_expression(C99Parser.Xor_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#or_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_expression(C99Parser.Or_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#land_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLand_expression(C99Parser.Land_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#lor_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLor_expression(C99Parser.Lor_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#conditional_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional_expression(C99Parser.Conditional_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#assignment_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_expression(C99Parser.Assignment_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(C99Parser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#constant_expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant_expression(C99Parser.Constant_expressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#attributes_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttributes_declaration(C99Parser.Attributes_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(C99Parser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#declaration_specifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_specifiers(C99Parser.Declaration_specifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#storage_class_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorage_class_specifier(C99Parser.Storage_class_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#function_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_specifier(C99Parser.Function_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#init_declarator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_declarator_list(C99Parser.Init_declarator_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#init_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit_declarator(C99Parser.Init_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#type_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_specifier(C99Parser.Type_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#struct_or_union_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_or_union_specifier(C99Parser.Struct_or_union_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#struct_declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_declaration_list(C99Parser.Struct_declaration_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#struct_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_declaration(C99Parser.Struct_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#specifier_qualifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpecifier_qualifier_list(C99Parser.Specifier_qualifier_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#struct_declarator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_declarator_list(C99Parser.Struct_declarator_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#struct_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStruct_declarator(C99Parser.Struct_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#enum_specifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnum_specifier(C99Parser.Enum_specifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#enumerator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerator_list(C99Parser.Enumerator_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#enumerator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumerator(C99Parser.EnumeratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#type_qualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_qualifier(C99Parser.Type_qualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#direct_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirect_declarator(C99Parser.Direct_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#type_qualifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_qualifier_list(C99Parser.Type_qualifier_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#parameter_type_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_type_list(C99Parser.Parameter_type_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(C99Parser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#parameter_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_declaration(C99Parser.Parameter_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#identifier_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier_list(C99Parser.Identifier_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#type_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_name(C99Parser.Type_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#abstract_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbstract_declarator(C99Parser.Abstract_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#direct_abstract_declarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirect_abstract_declarator(C99Parser.Direct_abstract_declaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#typedef_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedef_name(C99Parser.Typedef_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(C99Parser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#initializer_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer_list(C99Parser.Initializer_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#designation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignation(C99Parser.DesignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#designator_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignator_list(C99Parser.Designator_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#designator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDesignator(C99Parser.DesignatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(C99Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#labeled_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabeled_statement(C99Parser.Labeled_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#compound_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompound_statement(C99Parser.Compound_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#block_item_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_item_list(C99Parser.Block_item_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#block_item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_item(C99Parser.Block_itemContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#expression_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression_statement(C99Parser.Expression_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#selection_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_statement(C99Parser.Selection_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#iteration_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration_statement(C99Parser.Iteration_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#jump_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_statement(C99Parser.Jump_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#asm_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsm_statement(C99Parser.Asm_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#translation_unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslation_unit(C99Parser.Translation_unitContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#external_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternal_declaration(C99Parser.External_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#function_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_definition(C99Parser.Function_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link C99Parser#declaration_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration_list(C99Parser.Declaration_listContext ctx);
}