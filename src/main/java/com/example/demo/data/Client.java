package com.example.demo.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "TICKET",
        "USER_ID",
        "CLOSE_TIME",
        "COMMISSION",
        "SWAPS",
        "PROFIT",
        "COMMENT"
})
public class Client {

    @Id
    @JsonProperty("TICKET")
    private int ticket;
    @JsonProperty("USER_ID")
    private int userId;
    @JsonProperty("CLOSE_TIME")
    private String closeTime;
    @JsonProperty("COMMISSION")
    private float commission;
    @JsonProperty("SWAPS")
    private float swaps;
    @JsonProperty("PROFIT")
    private float profit;
    @JsonProperty("COMMENT")
    private String comment;
}
