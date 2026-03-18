/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.jsp.app.mvc.controller.files;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
 * Part filePart = request.getPart("file-data");
 *
 * @author jose
 */
@MultipartConfig
@WebServlet(name = "UploaderServlet", urlPatterns = {"/mvc/files/uploader-servlet"})
public class UploaderServlet extends HttpServlet {

    public static final String PATH = "/media/jose/DATA/CUNOC/IPC2/server";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Part filePart = request.getPart("file-data");
        System.out.println("getName: " + filePart.getName());
        System.out.println("getContentType: " + filePart.getContentType());
        System.out.println("getSubmittedFileName: " + filePart.getSubmittedFileName());
        System.out.println("getSize: " + filePart.getSize());

        Scanner scanner = new Scanner(filePart.getInputStream());

        try {

            /*while (true) {
                String line = scanner.nextLine();
                System.out.println(line);
            }*/
            filePart.write(PATH + File.separator + filePart.getSubmittedFileName());
            System.out.println(PATH + File.separator + filePart.getSubmittedFileName());

            RequestDispatcher dispatcher = getServletContext()
                    .getRequestDispatcher(String.format("/mvc/files/download-file.jsp?path=%s&contentType=%s&fileName=%s",
                            PATH + File.separator + filePart.getSubmittedFileName(),
                            filePart.getContentType(),
                            filePart.getSubmittedFileName()));
            dispatcher.forward(request, response);

        } catch (Exception e) {
            //ya se finalizo de leer el texto
            e.printStackTrace();
        }

    }

}
