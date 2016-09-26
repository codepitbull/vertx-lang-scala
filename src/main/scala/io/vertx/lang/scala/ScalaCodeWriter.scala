package io.vertx.lang.scala

import java.util

import com.sun.source.tree.LambdaExpressionTree.BodyKind
import io.vertx.codegen.`type`.{ApiTypeInfo, ClassTypeInfo, EnumTypeInfo, TypeInfo}
import io.vertx.codetrans.{CodeModel, CodeWriter}
import io.vertx.codetrans.expression.{DataObjectLiteralModel, ExpressionModel, JsonArrayLiteralModel, JsonObjectLiteralModel}
import io.vertx.codetrans.statement.StatementModel


class ScalaCodeWriter extends CodeWriter{
  override def renderNewMap(): Unit = ???

  override def renderNew(expression: ExpressionModel, `type`: TypeInfo, argumentModels: util.List[ExpressionModel]): Unit = ???

  override def renderSystemOutPrintln(expression: ExpressionModel): Unit = ???

  override def renderAsyncResultFailed(resultType: TypeInfo, name: String): Unit = ???

  override def renderListGet(list: ExpressionModel, index: ExpressionModel): Unit = ???

  override def renderSystemErrPrintln(expression: ExpressionModel): Unit = ???

  override def renderMethodReference(expression: ExpressionModel, methodName: String): Unit = ???

  override def renderApiType(apiType: ApiTypeInfo): Unit = ???

  override def renderListLiteral(arguments: util.List[ExpressionModel]): Unit = ???

  override def renderJsonObjectMemberSelect(expression: ExpressionModel, name: String): Unit = ???

  override def renderDataObjectMemberSelect(expression: ExpressionModel, name: String): Unit = ???

  override def renderEnumConstant(`type`: EnumTypeInfo, constant: String): Unit = ???

  override def renderJsonObjectAssign(expression: ExpressionModel, name: String, value: ExpressionModel): Unit = ???

  override def renderListSize(list: ExpressionModel): Unit = ???

  override def renderLambda(bodyKind: BodyKind, parameterTypes: util.List[TypeInfo], parameterNames: util.List[String], body: CodeModel): Unit = ???

  override def renderMapGet(map: ExpressionModel, key: ExpressionModel): Unit = ???

  override def renderNewList(): Unit = ???

  override def renderAsyncResultCause(resultType: TypeInfo, name: String): Unit = ???

  override def renderJavaType(apiType: ClassTypeInfo): Unit = ???

  override def renderMapPut(map: ExpressionModel, key: ExpressionModel, value: ExpressionModel): Unit = ???

  override def renderThrow(throwableType: String, reason: ExpressionModel): Unit = ???

  override def renderMapForEach(map: ExpressionModel, keyName: String, keyType: TypeInfo, valueName: String, valueType: TypeInfo, bodyKind: BodyKind, block: CodeModel): Unit = ???

  override def renderJsonObject(jsonObject: JsonObjectLiteralModel): Unit = ???

  override def renderTryCatch(tryBlock: StatementModel, catchBlock: StatementModel): Unit = ???

  override def renderJsonObjectToString(expression: ExpressionModel): Unit = ???

  override def renderJsonArray(jsonArray: JsonArrayLiteralModel): Unit = ???

  override def renderDataObject(model: DataObjectLiteralModel): Unit = ???

  override def renderListAdd(list: ExpressionModel, value: ExpressionModel): Unit = ???

  override def renderStatement(statement: StatementModel): Unit = ???

  override def renderThis(): Unit = ???

  override def renderJsonArrayToString(expression: ExpressionModel): Unit = ???

  override def renderAsyncResultValue(resultType: TypeInfo, name: String): Unit = ???

  override def renderAsyncResultSucceeded(resultType: TypeInfo, name: String): Unit = ???

  override def renderDataObjectAssign(expression: ExpressionModel, name: String, value: ExpressionModel): Unit = ???
}
