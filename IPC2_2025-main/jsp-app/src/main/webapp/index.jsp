<%-- 
    Document   : index
    Created on : Aug 26, 2025, 4:11:03 PM
    Author     : jose
    se debe incluir un query string como el siguiente:
        ?valor=55&opcion=1&num1=7&num2=3
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="/includes/resources.jsp"/>
    </head>
    <body>
        <main>
            <jsp:include page="/includes/header.jsp"/>
            <div class="container">
                <h1>Hello World!</h1>


                <a href="crear-eventos-get/crear-form.jsp">Ir a Crear Evento GET</a>
                <br/>
                <a href="crear-eventos-post/crear-form.jsp">Ir a Crear Evento POST</a>
                <%! int valor = 50;%>
                <p id="p1" class="parrafo-rojo">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse imperdiet eleifend turpis vitae aliquam. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Vivamus finibus malesuada orci eget tincidunt. Phasellus at est aliquam, molestie sem a, tincidunt arcu. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin tincidunt lacus non arcu tempor dignissim. Ut accumsan faucibus magna, et ullamcorper quam rutrum ut. Nam lorem nisl, suscipit a tempus eget, pellentesque id nulla.</p>
                <p> este es el valor: <%=valor%></p>

                <%
                    String paramValor = request.getParameter("valor");
                    if (paramValor != null && Integer.valueOf(paramValor) > 25) {

                %>

                <p> este es el valor del parametro valor: <%=paramValor%></p>

                <%
                    }
                %>

                <h1>funcionamiento para el parametro opcion</h1>
                <%
                    String paramOpcion = request.getParameter("opcion");
                    if (paramOpcion != null && paramOpcion.equals("1")) {
                        out.print("<p>la opcion seleccionada fue la uno</p>");
                    }
                %>

                <%
                    if (request.getParameter("num1") != null && request.getParameter("num2") != null) {
                        Integer num1 = Integer.valueOf(request.getParameter("num1"));
                        Integer num2 = Integer.valueOf(request.getParameter("num2"));
                %>
                <h1>Resultado de la suma usando parametros es=<%=suma(num1, num2)%></h1>
                <%
                    }
                %>
                <%!

                    int suma(int num1, int num2) {
                        return num1 + num2;
                    }
                %>
                <jsp:include page="/includes/footer.jsp"/>
            </div>
        </main>

    </body>
</html>
