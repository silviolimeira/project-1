package com.sl.jwt.dto;

import com.sl.jwt.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIResponse<T> {

    int recordCount;
    T response;

//    public APIResponse(int recordCount,  response) {
//        this.recordCount = recordCount;
//        this.response = response;
//    }
}
