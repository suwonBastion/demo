package com.example.demo.controller;

import com.example.demo.service.XmlTestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.xml.bind.JAXBException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "XMLTest환경 API", description = "XMLTest환경 API 입니다.")
public class XmlTestController {
    private final XmlTestService xmlTestService;

    @GetMapping(value = "/xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> test() throws JAXBException {
        return xmlTestService.test();
    }

    @GetMapping("/xml1")
    public ResponseEntity<?> test1(){
        return xmlTestService.test1();
    }
}
