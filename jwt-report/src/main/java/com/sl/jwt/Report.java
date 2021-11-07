package com.sl.jwt;

import com.sl.jwt.model.Periodo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRCsvDataSource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RequiredArgsConstructor
@Slf4j
public class Report {

    private void processLines(List<Periodo> listPeriodo, String titulo, List<String> lines, Integer seq) {

        for (int i = 0; i < listPeriodo.size(); i++) {
            Periodo p = listPeriodo.get(i);
            String[] tmp = p.toString().split(" ");
            if (tmp.length == 2) {
                String line = "\"" + titulo + "\"," + seq + ",\"" + tmp[0] + "\",\"" + tmp[1] + "\"";
                lines.add(line);
            }
            System.out.println(p.toString());
        }
        seq++;

    }


    private void processReport() {
        String userDir = System.getProperty("user.dir");
        File file = new File(userDir + "\\RelatorioApontamentos.txt");
        List<String> lines = new ArrayList<>();
        Integer seq = 1;

//        "Horario de Trabalho",1,"08:00","12:00"
//        "Horario de Trabalho",1,"13:30","17:30"
//        "Marcações Feitas",1,"08:00","11:30"
//        "Atrasos",1,"11:30","12:00"
//        "Atrasos",1,"13:30","17:30"

        List<Periodo> listPeriodo = new ArrayList<>();
        listPeriodo.add(new Periodo("08:00 12:00", "13:30 17:30"));
        listPeriodo.add(new Periodo("08:01 12:01", "13:31 17:31"));
        listPeriodo.add(new Periodo("08:02 12:02", "13:32 17:32"));

        processLines(listPeriodo, "Horario de Trabalho", lines, seq);

        try (FileOutputStream fos = new FileOutputStream(file);
             OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
             BufferedWriter writer = new BufferedWriter(osw)) {

            for (String line : lines) {
                writer.append(line);
                writer.newLine();
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportReport() throws JRException {

        processReport();

        String userDir = System.getProperty("user.dir");
        System.out.println(userDir);
        // userDir = "d:\\temp";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("ReportTitle", "Relatório de Apontamentos");
        parameters.put("DataFile", "Horário de Trabalho, Marcações, Horas Extras e Atrasos");
        Set<String> states = null; // new HashSet<String>();
        // states.add("Active");
        // states.add("Trial");
        parameters.put("IncludedStates", states);

        String[] columnNames = new String[] { "periodo", "id", "entrada", "saida" };
        JRCsvDataSource dataSource = null;
        try {
            dataSource = new JRCsvDataSource(userDir + "\\RelatorioApontamentos.txt", "utf8");
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        dataSource.setRecordDelimiter("\r\n");
        dataSource.setColumnNames(columnNames);
        JasperReport jasperReport = JasperCompileManager.compileReport(userDir + "\\RelatorioApontamentos.jrxml");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        jasperPrint.setLocaleCode("utf8");

        JasperExportManager.exportReportToPdfFile(jasperPrint, userDir + "\\report.pdf");

        File file = new File(userDir + "\\report.pdf");
        //HostServices hostServices = getHostServices();
        //hostServices.showDocument(file.getAbsolutePath());
    }


}
