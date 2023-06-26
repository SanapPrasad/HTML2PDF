package com.example.htmltopdf.controller;

import com.example.htmltopdf.document.DataMapper;
import com.example.htmltopdf.document.DocumentGenerator;
import com.example.htmltopdf.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.List;

@RestController
public class DocumentRestController {

    @Autowired
    private DocumentGenerator documentGenerator;

    @Autowired
    private SpringTemplateEngine springTemplateEngine;

    @Autowired
    private DataMapper dataMapper;

    @PostMapping(value="/generate/document")
    public String generateDocument(@RequestBody List<Employee> employeeList){
        String finalHtml=null;
        Context context= dataMapper.setData(employeeList);
        finalHtml=springTemplateEngine.process("Template",context);
        documentGenerator.htmlToPdf(finalHtml);
        return "success";

    }

}
