<%-- 
    Document   : buscarImagen
    Created on : Oct 13, 2021, 12:19:55 PM
    Author     : dani
--%>

<%@page import="java.nio.file.Paths"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>
    </head> 
    <body>
        <% if(session.getAttribute("user") == null) response.sendRedirect("login.jsp"); %>

        <h1>Busqueda de imagenes</h1>
        <form action = "buscarImagen" method="GET" >
           <label for ="titulo"> Titulo: </label>
            <input type ="text" name = "titulo"> 
            <br>
            <label for ="autor"> Autor: </label>
            <input type ="text" name = "autor">
            <br>
            <label for ="precio"> Precio (Introduzca un valor de menos de 10 digitos): </label>
            <input type ="number" name = "precio">
            <br>
             Reservado:
            <select name="reserved" id="reserved" >
                <option value="BLANK">BLANK</option>
                <option value="YES">SI</option>
                <option value="NO">NO</option>
            </select>
            <br>
            Orden de resultados:
            <select name="ordenar" id="ordenar" >
                <option value="BLANK">BLANK</option>
                <option value="asc">Ascendente</option>
                <option value="desc">Descendente</option> 
            </select>
            <br>
            Atributo segun el que ordenar:
              <select name="attribOrdenar" id="attribOrdenar" >
                <option value="BLANK">BLANK</option>
                <option value="titulo">titulo</option>
                <option value="autor">autor</option>
                <option value="precio">precio</option>
            </select>
            <br>
            
            
            <br>
            <input type="submit" value="Buscar">
        </form>
        <br>
        <a href ='menu.jsp'> Volver a menu </a>
    </body>
    
</html>
