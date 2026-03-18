/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.jgranados.jsp.app.mvc.controller.files;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 *
 * @author jose
 */
@WebServlet(name = "DownloaderServlet", urlPatterns = {"/mvc/files/downloader-servlet"})
public class DownloaderServlet extends HttpServlet {

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream archivo = cargarArchivo(request);
        String fileName = request.getParameter("fileName");
        String contentType = request.getParameter("contentType");
        
        response.setHeader("Content-disposition", "filename="+fileName);
        response.setHeader("Content-type", contentType);
        
        archivo.transferTo(response.getOutputStream());
    }
    
    private InputStream cargarArchivo(HttpServletRequest request) throws FileNotFoundException {
        String path = request.getParameter("path");
        return new FileInputStream(new File(path));
        
    }

}
