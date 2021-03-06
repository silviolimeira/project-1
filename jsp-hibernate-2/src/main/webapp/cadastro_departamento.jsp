<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/mytags.tld" prefix="m" %>
<%@ page import="com.sl.tool.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Cadastrar Departamentos</title>
    <script><%@include file="/WEB-INF/string_utils.js"%></script>
    <script><%@include file="/WEB-INF/valida_departamento.js"%></script>
    <style><%@include file="/WEB-INF/config.css"%></style>
    <jsp:include page="/header.jsp" />
</head>
<body>
    Current Date and Time is: <m:date/>
    <div id="principal">
        <h1>Cadastro de Departamentos - Acentuação</h1>

        <div id="topo">
            <div id="mensagem">
            </div>
            <%
              if (request.getAttribute("mensagem") != null) {
                String mensagem = request.getAttribute("mensagem").toString();
                out.println("xi" + mensagem);
              }
              //String unEscapedString = "<java>public static void main(String[] args) { ... }</java>";
              //String unEscapedString = "Teste de Acentuação";
              //String escapedHTML = StringUtils.encodeHtml(unEscapedString);

              //out.println(escapedHTML);  //Browser can now parse this and print
            %>
        </div>
        <div id="direito">
            <fieldset>
                <legend>Departamento</legend>
                <form action="controle" method="post" name="form" class="form" onsubmit="javascript:return verificarTelefone();">
                    <input type="hidden" id="comando" name="comando" value="cadastrarDepartamento" />
                    <label for="nome">Nome*</label>
                    <div class="campotexto">
                        <input type="text" name="nome" id="nome" value="" size=50 />
                    </div>
                    <br />
                    <label for="telefone">Telefone</label>
                    <div class="campotexto">
                        <input type="text" name="telefone" id="telefone" value="" size=15 />
                        <span id="explica">Formato (XX) XXXX-XXXX</span>
                    </div>
                    <div class="button">
                        <input name="salvar" type="submit" value="Salvar" />
                        <input name="limpar" type="reset" value="Limpar" />
                    </div>
                </form>
            </fieldset>
        </div>
        <div id="esquerdo">
            <%@include file="/WEB-INF/jspf/menu.jspf"%>
        </div>
    </div>
</html>