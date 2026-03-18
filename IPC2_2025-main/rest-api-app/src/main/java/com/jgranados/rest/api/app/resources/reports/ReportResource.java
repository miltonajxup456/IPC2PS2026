/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jgranados.rest.api.app.resources.reports;

import com.jgranados.rest.api.app.dtos.events.report.EventAndDetailsDto;
import com.jgranados.rest.api.app.dtos.events.report.EventDetailDto;
import com.jgranados.rest.api.app.services.events.EventsCrudService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.StreamingOutput;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author jose
 */
@Path("reports")
public class ReportResource {

    public static final String PATH = "/media/jose/DATA/CUNOC/IPC2/server";

    

    @GET
    @Path("report1")
    public Response downloadPdfFile() throws JRException {
        
        EventsCrudService crudService = new EventsCrudService();
        
        InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("com/jgranados/rest/api/app/reports/SimpleListBeans.jasper");
        
        JRDataSource source = new JRBeanCollectionDataSource(crudService.getAllEvents());

        JasperPrint printer = JasperFillManager.fillReport(compiledReport, null, source);

        JasperExportManager.exportReportToPdfFile(printer, PATH + "/" + "report1");
        

        StreamingOutput fileStream = (java.io.OutputStream output) -> {
            try {
                java.nio.file.Path path = Paths.get(PATH + "/" + "report1");
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception e) {
                throw new WebApplicationException("File Not Found !!");
            }
        };

        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename = report1.pdf")
                .build();
    }
    
    @GET
    @Path("report2")
    public Response downloadPdfFileReport2() throws JRException {
        
        List<EventAndDetailsDto> list = Arrays.asList(
                new EventAndDetailsDto(
                        "evet-001",
                        "Nombre evt-001",
                        25.50,
                        Arrays.asList(
                                new EventDetailDto("detail1", LocalDate.now(), 15)
                        )
                ),
                new EventAndDetailsDto(
                        "evet-002",
                        "Nombre evt-003",
                        125.50,
                        Arrays.asList(
                                new EventDetailDto("detail2", LocalDate.now(), 22),
                                new EventDetailDto("detail3", LocalDate.now(), 33)
                        )
                ),
                new EventAndDetailsDto(
                        "evet-003",
                        "Nombre evt-004",
                        250.50,
                        Arrays.asList(
                                new EventDetailDto("detail4", LocalDate.now(), 44),
                                new EventDetailDto("detail5", LocalDate.now(), 55),
                                new EventDetailDto("detail6", LocalDate.now(), 66)
                        )
                )
        );
        
        InputStream compiledReport = getClass().getClassLoader().getResourceAsStream("com/jgranados/rest/api/app/reports/ReportMaster.jasper");
        
        JRDataSource source = new JRBeanCollectionDataSource(list);

        JasperPrint printer = JasperFillManager.fillReport(compiledReport, null, source);

        JasperExportManager.exportReportToPdfFile(printer, PATH + "/" + "report2");
        

        StreamingOutput fileStream = (java.io.OutputStream output) -> {
            try {
                java.nio.file.Path path = Paths.get(PATH + "/" + "report2");
                byte[] data = Files.readAllBytes(path);
                output.write(data);
                output.flush();
            } catch (Exception e) {
                throw new WebApplicationException("File Not Found !!");
            }
        };

        return Response
                .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
                .header("content-disposition", "attachment; filename = report2.pdf")
                .build();
    }
}
