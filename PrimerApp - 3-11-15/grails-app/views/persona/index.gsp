<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 06/10/2015
  Time: 12:13 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main"/>
    <title></title>
    <style type="text/css" media="screen">
    #status {
        background-color: #eee;
        border: .2em solid #fff;
        margin: 2em 2em 1em;
        padding: 1em;
        width: 12em;
        float: left;
        -moz-box-shadow: 0px 0px 1.25em #ccc;
        -webkit-box-shadow: 0px 0px 1.25em #ccc;
        box-shadow: 0px 0px 1.25em #ccc;
        -moz-border-radius: 0.6em;
        -webkit-border-radius: 0.6em;
        border-radius: 0.6em;
    }

    .ie6 #status {
        display: inline; /* float double margin fix http://www.positioniseverything.net/explorer/doubled-margin.html */
    }

    #status ul {
        font-size: 0.9em;
        list-style-type: none;
        margin-bottom: 0.6em;
        padding: 0;
    }

    #status li {
        line-height: 1.3;
    }

    #status h1 {
        text-transform: uppercase;
        font-size: 1.1em;
        margin: 0 0 0.3em;
    }

    #page-body {
        margin: 2em 1em 1.25em 18em;
    }

    h2 {
        margin-top: 1em;
        margin-bottom: 0.3em;
        font-size: 1em;
    }

    p {
        line-height: 1.5;
        margin: 0.25em 0;
    }

    #controller-list ul {
        list-style-position: inside;
    }

    #controller-list li {
        line-height: 1.3;
        list-style-position: inside;
        margin: 0.25em 0;
    }

    @media screen and (max-width: 480px) {
        #status {
            display: none;
        }

        #page-body {
            margin: 0 1em 1em;
        }

        #page-body h1 {
            margin-top: 0;
        }
    }
    </style>
</head>

<body>

<g:form controller="persona" action="create">
    <button type="submit" onclick="crear()">Nuevo</button>
</g:form>

<g:form controller="persona" action="buscar">
    <br><br>

    <SELECT NAME="combo" SIZE=1 onChange="buscar">
        <OPTION VALUE="nombre">Nombre</OPTION>
        <OPTION VALUE="apellidoPaterno">Apellido Paterno</OPTION>
        <OPTION VALUE="apellidoMaterno">Apellido Materno</OPTION>
        <OPTION VALUE="fechaNacimiento">Fecha Nacimiento</OPTION>
    </SELECT>

        <g:datePicker name="buscar1" value="${new Date()}" precision="day" years="${1940..2015}"/>

        <g:textField name="buscar"/>
        %{--required="true"--}%


    <button type="submit" onclick="filtrar()">Buscar</button>

   %{--<div id="contenido">
        <g:render template="lista" model="[personas:personas]"/>
    </div>--}%
</g:form>

<g:javascript>
    function crear(){
        ${remoteFunction(controller: 'persona', action: 'create')}
    }
</g:javascript>

<g:javascript>
    function filtrar(){
        ${remoteFunction(controller:'persona', action: 'buscar(VALUE)', params:'fecha:+ document.getElement()', update:"datosPaginados")}
    }
</g:javascript>

<div id="datosPaginados">
    <g:render template="lista" model="[personas:personas]"/>
</div>
<div>
    <util:remotePaginate controller="persona" action="updateList" total="${primerapp.Persona.count()}" update="datosPaginados" max="2"/>
</div>
</body>
</html>