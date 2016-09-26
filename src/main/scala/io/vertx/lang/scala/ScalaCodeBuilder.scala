package io.vertx.lang.scala

import com.sun.source.tree.LambdaExpressionTree.BodyKind
import io.vertx.codegen.`type`.ApiTypeInfo
import io.vertx.codegen.`type`.ClassTypeInfo
import io.vertx.codegen.`type`.EnumTypeInfo
import io.vertx.codegen.`type`.ParameterizedTypeInfo
import io.vertx.codegen.`type`.TypeInfo
import io.vertx.codetrans._
import io.vertx.codetrans.expression.ApiTypeModel
import io.vertx.codetrans.expression.EnumExpressionModel
import io.vertx.codetrans.expression.ExpressionModel
import io.vertx.codetrans.expression.LambdaExpressionModel
import io.vertx.codetrans.expression.VariableScope
import io.vertx.codetrans.lang.groovy.GroovyWriter
import io.vertx.codetrans.statement.StatementModel
import java.util.Collections
import java.util.Iterator
import java.util.LinkedHashSet
import java.util.Map.Entry
import java.util.function.Consumer

import scala.compat.java8.FunctionConverters._

class ScalaCodeBuilder extends CodeBuilder {

  def newWriter: ScalaCodeWriter = new ScalaCodeWriter(this)

  def render(unit: RunnableCompilationUnit): String = {
    val writer: ScalaCodeWriter = this.newWriter
    var var3: util.Iterator[_] = null
    var it: String = null
    var3 = this.imports.iterator
    while (var3.hasNext) {
      {
        val method: ClassTypeInfo = var3.next.asInstanceOf[ClassTypeInfo]
        it = method.getName
        if (method.isInstanceOf[ApiTypeInfo]) it = method.translateName("groovy")
      }
      writer.append("import ").append(it).append('\n')
    }
    var3 = unit.getFields.entrySet.iterator
    var method1: util.Map.Entry[_, _] = null
    while (var3.hasNext) {
      method1 = var3.next.asInstanceOf[util.Map.Entry[_, _]]
      writer.append("@Field ")
      method1.getValue.asInstanceOf[StatementModel].render(writer)
      writer.append("\n")
    }
    var3 = unit.getMethods.entrySet.iterator
    while (var3.hasNext) {
      method1 = var3.next.asInstanceOf[util.Map.Entry[_, _]]
      writer.append("def ").append(method1.getKey.asInstanceOf[CharSequence]).append("(")
      val it1: util.Iterator[_] = method1.getValue.asInstanceOf[MethodModel].getParameterNames.iterator
      while (it1.hasNext) {
        val paramName: String = it1.next.asInstanceOf[String]
        writer.append(paramName)
        if (it1.hasNext) writer.append(", ")
      }
      writer.append(") {\n")
      writer.indent
      method1.getValue.asInstanceOf[MethodModel].render(writer)
      writer.unindent
      writer.append("}\n")
    }
    unit.getMain.render(writer)
    writer.getBuffer.toString
  }

  override def enumType(`type`: EnumTypeInfo): EnumExpressionModel = {
    this.imports.add(`type`)
    super.enumType(`type`)
  }

  override def apiType(`type`: ApiTypeInfo): ApiTypeModel = {
    this.imports.add(`type`)
    super.apiType(`type`)
  }

  def asyncResultHandler(bodyKind: LambdaExpressionTree.BodyKind, resultType: ParameterizedTypeInfo, resultName: String, body: CodeModel): ExpressionModel = new LambdaExpressionModel(this, bodyKind, Collections.singletonList(resultType), Collections.singletonList(resultName), body)

  def variableDecl(scope: VariableScope, `type`: TypeInfo, name: String, initializer: ExpressionModel): StatementModel = {
    new StatementModel() {
      override def render(renderer: CodeWriter): Unit = {
        renderer.append("def ").append(name)
        if (initializer != null) {
          renderer.append(" = ")
          initializer.render(renderer)
        }
      }
    }
  }

  def enhancedForLoop(variableName: String, expression: ExpressionModel, body: StatementModel): StatementModel = {
    new StatementModel() {
      override def render(renderer: CodeWriter): Unit = {
        expression.render(renderer)
        renderer.append(".each { ").append(variableName).append(" ->\n")
        renderer.indent()
        body.render(renderer)
        renderer.unindent()
        renderer.append("}")
      }
    }
  }

  def forLoop(initializer: StatementModel, condition: ExpressionModel, update: ExpressionModel, body: StatementModel): StatementModel = {
    new StatementModel() {
      override def render(renderer: CodeWriter): Unit = {
        renderer.append("for (")
        initializer.render(renderer)
        renderer.append(';')
        condition.render(renderer)
        renderer.append(';')
        update.render(renderer)
        renderer.append(") {\n")
        renderer.indent()
        body.render(renderer)
        renderer.unindent()
        renderer.append("}")
      }
    }
  }
}
