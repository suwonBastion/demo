package com.example.demo.dto.godomall;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderSearchParam {
    @JsonProperty("order-search")
    private List<OrderSearchDetail> orderSearch;
}
