/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.resources.files;

import com.jgranados.rest.api.app.dtos.files.InfoFileResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author jose
 */
@Path("files")
public class FilesResource {

    public static final String PATH = "/media/jose/DATA/CUNOC/IPC2/server";

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@FormDataParam("name") String name,
            @FormDataParam("fileObject") InputStream uploadedFileStream,
            @FormDataParam("fileObject") FormDataBodyPart bodyPart,
            @FormDataParam("fileObject") FormDataContentDisposition fileDetails) throws IOException {
        Files.copy(uploadedFileStream, java.nio.file.Path.of(PATH + "/" + fileDetails.getFileName()), StandardCopyOption.REPLACE_EXISTING);

        return Response.ok(new InfoFileResponse(fileDetails.getFileName(), PATH + "/" + fileDetails.getFileName(), bodyPart.getMediaType().toString())).build();
    }

    @GET
    public Response downloadPdfFile( // estos datos por lo general  se obtienen 
            // en el lado del servidor porque se almacenan en la DB
            @QueryParam("pathFile") String pathFile,
            @QueryParam("fileName") String fileName) {

        StreamingOutput fileStream = (java.io.OutputStream output) -> {
            try {
                java.nio.file.Path path = Paths.get(pathFile);
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception e) {
                throw new WebApplicationException("File Not Found !!");
            }
        };

        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename = " + fileName)
                .build();
    }
}
