<%-- 
    Document   : upload-file
    Created on : Sep 9, 2025, 2:36:24 PM
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
                        <h4 class="mb-3">Upload file</h4>
                        <form method="POST" action="${pageContext.servletContext.contextPath}/mvc/files/uploader-servlet"
                              enctype="multipart/form-data"> 
                            <div class="row g-3"> 

                                <div class="col-12"> 
                                    <label for="codigo-evento" class="form-label">Codigo de Evento:</label>
                                    <input id="codigo-evento" name="codigo-evento" class="form-control" placeholder="Codigo de evento" required/>
                                </div> 
                                <div class="col-12"> 
                                    <label for="file-data" class="form-label">Archivo:</label>
                                    <input type="file" id="file-data" name="file-data" class="form-control"/>
                                </div> 
                            </div>
                            <hr class="my-4">
                            <button class="w-100 btn btn-primary btn-lg" type="submit">Guardar</button>
                        </form> 
                    </div>
                </div>


            </div>
            <jsp:include page="/includes/footer.jsp"/>
        </main>
    </body>
</html>
