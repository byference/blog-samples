package com.github.byference.samples.controller;

import com.github.byference.samples.entity.Turnover;
import com.github.byference.samples.service.TransactionalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Transactional {@link RestController}
 *
 * @author byference
 * @since 2019/05/11
 */
@RestController
@Slf4j
@AllArgsConstructor
public class TransactionalController {

    private final TransactionalService transactionalService;


    /**
     * 转账
     */
    @PostMapping("/transfer")
    public String transfer(Turnover turnover) {

        log.info("转账: {}", turnover);
        String result;
        try {
            transactionalService.transfer(turnover);
            result = "转账成功";
        } catch (Exception e) {
            log.error("转账异常" + e.getMessage(), e);
            result = "转账失败";
        }
        return result;
    }


    /**
     * Echo
     */
    @GetMapping("/echo")
    public String echo(String message) {

        log.info("Echo: {}", message);
        return String.format("Echo: %s", message);
    }


}
