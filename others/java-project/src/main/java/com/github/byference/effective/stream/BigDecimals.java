package com.github.byference.effective.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link BigDecimal} util
 *
 * @author byference
 * @since 2019-09-16
 */
public class BigDecimals {

    private BigDecimals() {}

    /**
     * 求最小值
     */
    public static BigDecimal min(BigDecimal b1, BigDecimal b2) {

        Assert.isTrue(b1 != null && b2 != null, "arguments of BigDecimals#min is not allowed be null.");
        return b1.compareTo(b2) < 0 ? b1 : b2;
    }


    /**
     * 求最大值
     */
    public static BigDecimal max(BigDecimal b1, BigDecimal b2) {

        Assert.isTrue(b1 != null && b2 != null, "arguments of BigDecimals#max is not allowed be null.");
        return b1.compareTo(b2) > 0 ? b1 : b2;
    }


    /**
     * 求和
     */
    public static BigDecimal sum(BigDecimal b1, BigDecimal b2) {

        Assert.isTrue(b1 != null && b2 != null, "arguments of BigDecimals#sum is not allowed be null.");
        return b1.add(b2);
    }


    /**
     * get list of {@link Person}
     */
    public static List<Person> getPersons() {

        Random random = new Random();
        return Stream.generate(() -> random.nextInt(6)).limit(20).map(num -> {
            Person person = new Person();
            person.setId(num);
            person.setUsername("name" + num);
            person.setAccount(BigDecimal.valueOf(num));
            return person;
        }).collect(Collectors.toList());
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {

        private int id;

        private String username;

        private BigDecimal account;
    }

}
