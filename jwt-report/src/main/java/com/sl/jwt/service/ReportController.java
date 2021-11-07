package com.sl.jwt.service;

import com.sl.jwt.Report;
import net.sf.jasperreports.engine.JRException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class ReportController {

    @GetMapping(value = "/report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> getReport() throws JRException {

        Report report = new Report();
        report.exportReport();

        String userDir = System.getProperty("user.dir");

        Path path = Paths.get(userDir + "\\report.pdf");
        byte[] pdfContents = null;
        try {
            pdfContents = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        String filename = "report.pdf";
        headers.setContentDispositionFormData(filename, filename);
        //View in Browser: headers.add("Content-Disposition", "inline; filename=" + "example.pdf");
        //Download: headers.add("Content-Disposition", "attachment; filename=" + "example.pdf");
        headers.add("content-disposition", "inline;filename=" + filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<byte[]>(pdfContents,HttpStatus.OK);

        return response;

    }

}
