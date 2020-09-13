package com.example.demo.po;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@Document(indexName="robot")
public class RobotPo {
    @Id
    private Long id;

    @Field(type = FieldType.Text, fielddata=true)
    private String question;

    @Field(type = FieldType.Text, fielddata=true)
    private String answer;

    @Field(type = FieldType.Text, fielddata=true)
    private String label;


}
