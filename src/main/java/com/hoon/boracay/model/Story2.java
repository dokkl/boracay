package com.hoon.boracay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Story2 {
    private long id;
    private String plot;
    private String writer;
    private int upvotes;
    private boolean editing = true;
}
