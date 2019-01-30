package com.github.baifenghe.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.*;
import org.springframework.util.Assert;


/**
 * @author bfh
 * @since 2019/01/30
 */
@Getter
@Setter
public class R {

    private HttpStatus status;

    public R(HttpStatus status) {
        Assert.notNull(status, "HttpStatus must not be null");
        this.status = status;
    }


    public ResponseEntity<Result> body(Integer code, String message, Object data) {
        Result<Object> build = Result.builder().code(code).message(message).data(data).build();

        return new ResponseEntity<>(build, this.status);


    }
}
