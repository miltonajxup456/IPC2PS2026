/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.dtos.files;

/**
 *
 * @author jose
 */
public class InfoFileResponse {
    private String fileName;
    private String filePath;
    private String fileContentType;

    public InfoFileResponse(String fileName, String filePath, String fileContentType) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileContentType = fileContentType;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getFileContentType() {
        return fileContentType;
    }
    
    
}
