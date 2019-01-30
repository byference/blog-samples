package com.github.baifenghe.controller;

import com.github.baifenghe.util.R;
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

        Map<String, Object> result = new HashMap<>(16);
        result.put("id", 1);
        result.put("message", "test1");
        result.put("date", new Date());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
    }

    @GetMapping("test1")
    public ResponseEntity test1() {

        Map<String, Object> result = new HashMap<>(16);
        result.put("id", 2);
        result.put("message", "test2");
        result.put("date", new Date());
        return new R(HttpStatus.FOUND).body(1, "", result);
    }


}
