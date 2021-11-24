package com.example.demo.entity;

import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class Order {
    private String docNum;
    private Integer nomId;
    private Integer cnt;
    private Integer statusId;
    private  Integer storId;
}