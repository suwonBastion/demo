package com.example.demo.xml.dto;

import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "XmlListTag")
@Data @Builder
@NoArgsConstructor
@AllArgsConstructor
public class XmlListTag {

    @XmlElement(name = "smartPhoneTags")
    @XmlElementWrapper(name = "smartPhoneTags")
    private List<SmartPhoneTag> smartPhoneTags;

    @XmlAccessorType(XmlAccessType.FIELD)
    @Data @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SmartPhoneTag {
        @XmlElement(name = "model")
        private String model;
        @XmlElement(name = "price")
        private String price;
        @XmlElement(name = "color")
        private String color;
    }
}


