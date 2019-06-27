package com.ertgamgam.logging.Logger;

import com.couchbase.client.java.repository.annotation.Field;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogMessage {

   @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private String id;

    @Field
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown=true) //ignore properties if it is null
    private Date createdTime;

    public void onCreated(){
        this.createdTime=new Date();
    }

    @Field
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown=true) //ignore properties if it is null
    private String logTitle;

    @Field
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown=true) //ignore properties if it is null
    private String logContent;
}
