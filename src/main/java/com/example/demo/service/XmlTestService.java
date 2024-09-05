package com.example.demo.service;

import com.example.demo.webclient.XmlTestAPI;
import com.example.demo.xml.dto.XmlListTag;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.util.Arrays;

import static com.example.demo.xml.dto.XmlListTag.*;

@Service
@RequiredArgsConstructor
public class XmlTestService {
    private final XmlTestAPI xmlTestAPI;

    public ResponseEntity<?> test() throws JAXBException {
        SmartPhoneTag build = SmartPhoneTag.builder()
                .model("엘지")
                .price("10000")
                .color("빨")
                .build();

        SmartPhoneTag build2 = SmartPhoneTag.builder()
                .model("삼송")
                .price("13000")
                .color("파")
                .build();

        XmlListTag xml = XmlListTag.builder()
                .smartPhoneTags(Arrays.asList(build, build2))
                .build();

        return ResponseEntity.ok(xml);
    }

    public ResponseEntity<?> test1() {
        return ResponseEntity.ok(xmlTestAPI.get("xml",XmlListTag.class));
    }
}
