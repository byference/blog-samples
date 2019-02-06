package com.github.baifenghe.controller;

import com.github.baifenghe.util.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * @author bfh
 * @since 2019/01/30
 */
@RestController
public class ResponseEntityController {

    @GetMapping("test")
    public ResponseEntity test() {

        return ResponseHelper.status(HttpStatus.ACCEPTED).body(1, "");
    }

    @GetMapping("test1")
    public ResponseEntity test1() {

        Map<String, Object> result = new HashMap<>(16);
        result.put("id", 1);
        result.put("message", "test1");
        result.put("date", new Date());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @GetMapping("test2")
    public ResponseEntity test2() {

        return ResponseHelper.ok().body(null);
    }


}
