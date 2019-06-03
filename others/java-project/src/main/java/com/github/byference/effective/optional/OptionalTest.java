package com.github.byference.effective.optional;

import lombok.Data;
import org.junit.Test;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author byference
 * @since 2019/06/03
 */
public class OptionalTest {


    @Test
    public void optionalTest01() {

        Person person = new Person();

        String wheelName = Optional.of(person)
                .map(Person::getCar)
                .map(Car::getWheel)
                .map(Wheel::getName)
                .orElse("null");

        String resolve = resolve(() -> person.getCar().getWheel().getName()).orElse("null");
    }


    /**
     * 自定义获取 {@link Optional} 内的数据
     * @param resolver 获取数据的行为 {@link Supplier}
     * @param <T> 获取数据的类型
     * @return 待获取的数据，空则返回 {@link Optional#empty}
     */
    private static <T> Optional<T> resolve(Supplier<T> resolver) {
        try {
            return Optional.ofNullable(resolver.get());
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }


    @Data
    static class Person {
        private Car car;
    }


    @Data
    static class Car {
        private Wheel wheel;
    }


    @Data
    static class Wheel {
        private String name;
    }
}
