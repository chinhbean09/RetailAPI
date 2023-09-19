package com.rs.retailstore.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder //se dung ham builder nay de gang data vao Greeting
public class Greeting {
    private long id;
    private String content;

}
