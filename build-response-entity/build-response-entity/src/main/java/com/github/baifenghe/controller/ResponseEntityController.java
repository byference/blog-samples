package com.github.baifenghe.controller;

import com.github.baifenghe.util.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bfh
 * @since 2019/01/30
 */
@RestController
public class ResponseEntityController {

    @GetMapping("test")
    public ResponseEntity test() {

        return ResponseHelper.status(HttpStatus.BAD_REQUEST).body(100400, "Bad Request");
    }

    @GetMapping("test1")
    public ResponseEntity test1() {

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @GetMapping("test2")
    public ResponseEntity test2() {

        return ResponseHelper.ok().body(null);
    }

}
