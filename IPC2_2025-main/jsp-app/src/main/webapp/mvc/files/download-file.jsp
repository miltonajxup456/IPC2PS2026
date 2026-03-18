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
                        <h4 class="mb-3">Download file</h4>

                        <a href="${pageContext.servletContext.contextPath}/mvc/files/downloader-servlet?path=${param.path}&contentType=${param.contentType}&fileName=${param.fileName}">Descargar ${param.path}</a>

                    </div>
                </div>


            </div>
            <jsp:include page="/includes/footer.jsp"/>
        </main>
    </body>
</html>
