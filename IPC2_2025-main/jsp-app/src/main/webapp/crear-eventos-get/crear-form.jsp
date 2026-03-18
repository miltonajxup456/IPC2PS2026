<%-- 
    Document   : crear
    Created on : Aug 26, 2025, 4:47:43 PM
    Author     : jose
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

                <div class="row">
                    <div class="col"> 
                        <h4 class="mb-3">Crear Evento</h4> 
                        <form class="needs-validation" novalidate="" method="GET" action="${pageContext.servletContext.contextPath}/crear-eventos-get/crear.jsp"> 
                            <div class="row g-3"> 

                                <div class="col-12"> 
                                    <label for="codigo" class="form-label">Codigo:</label> 
                                    <input type="text" class="form-control" id="codigo" name="codigo" required>
                                    <div class="invalid-feedback">
                                        Please enter a valid code.
                                    </div> 
                                </div> 
                                <div class="col-12"> 
                                    <label for="nombre" class="form-label">Nombre:</label> 
                                    <input type="text" class="form-control" id="nombre" name="nombre" required>
                                    <div class="invalid-feedback">
                                        Please enter a valid name for the event.
                                    </div> 
                                </div> 

                                <div class="col-md-3"> <label for="limite" class="form-label">Limite:</label> 
                                    <input type="number" class="form-control" id="limite" name="limite" placeholder="" required>
                                    <div class="invalid-feedback">
                                        Limit required
                                    </div> 
                                </div> 
                            </div>
                            <hr class="my-4">
                            <button class="w-100 btn btn-primary btn-lg" type="submit">Crear</button>
                        </form> 
                    </div>
                </div>


            </div>
            <jsp:include page="/includes/footer.jsp"/>
        </main>
    </body>
</html>
