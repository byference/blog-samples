package com.github.byference.effective.stream;

import com.github.byference.common.entity.Person;
import com.github.byference.common.entity.Student;
import com.github.byference.common.util.StudentsUtil;
import lombok.AllArgsConstructor;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link java.util.stream.Stream} in action
 *
 * @author byference
 * @since 2019/04/21
 */
public class StreamTest {

    private static final List<Student> STUDENTS = StudentsUtil.genStudents();


    @Test
    public void customBigDecimalReduce() {

        // simple
        BigDecimal sum = Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE)).limit(20).reduce(BigDecimals::sum).orElse(BigDecimal.ZERO);
        BigDecimal max = Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE)).limit(20).reduce(BigDecimals::max).orElse(BigDecimal.ZERO);
        BigDecimal min = Stream.iterate(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE)).limit(20).reduce(BigDecimals::min).orElse(BigDecimal.ZERO);

        // complex
        List<BigDecimals.Person> persons = BigDecimals.getPersons();
        System.out.println("persons: " + persons);
        Map<String, BigDecimal> complexSum = persons.stream()
                .filter(person -> person.getId() != 0)
                .collect(Collectors.toMap(BigDecimals.Person::getUsername, BigDecimals.Person::getAccount, BigDecimals::sum));

        // print
        System.out.println("sum: " + sum);
        System.out.println("max: " + max);
        System.out.println("min: " + min);
        System.out.println("complexSum: " + complexSum);
    }


    /**
     * 将list转成 {@link TreeMap}
     * 通过 {@link BinaryOperator} 处理重复(key冲突)情况
     */
    @Test
    public void toTreeMapTest() {

        Map<String, String> collect = STUDENTS.stream()
                .collect(Collectors.toMap(Student::getStudentNo, Student::getName, (s1, s2) -> s1, TreeMap::new));

        collect.forEach((k, v) -> System.out.printf("key: %s , value: %s \n", k, v));
    }


    /**
     * 将list转成map
     * 通过 {@link BinaryOperator} 处理重复(key冲突)情况
     */
    @Test
    public void toMapTest() {

        Map<String, String> collect = STUDENTS.stream()
                .collect(Collectors.toMap(Student::getStudentNo, Student::getName, (s1, s2) -> s1));

        collect.forEach((k, v) -> System.out.printf("key: %s , value: %s \n", k, v));
    }


    /**
     * 自定义去重: 根据学生编号去重
     */
    @Test
    public void distinctTest() {

        List<Student> collect = STUDENTS.stream().collect(Collectors.collectingAndThen(
                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Student::getStudentNo))),
                ArrayList::new));
        collect.forEach(System.out::println);
    }


    /**
     * 根据学生编号分组，value为学生的姓名
     */
    @Test
    public void groupingTest() {

        Map<String, List<String>> collect = STUDENTS.stream().collect(Collectors.groupingBy(
                Student::getStudentNo,
                Collectors.mapping(Student::getName, Collectors.toList())));
        collect.forEach((k, v) -> System.out.printf("studentNo: [%s], name: %s \n", k, v));
    }


    /**
     * 根据学生年龄排序
     */
    @Test
    public void sortTest() {

        STUDENTS.stream().sorted(Comparator.comparing(Student::getAge))
                .forEach(System.out::println);
    }


    /**
     * 学生年龄最大的人的名字
     */
    @Test
    public void maxTest() {

        STUDENTS.stream()
                .sorted(Comparator.comparing(Student::getAge).reversed())
                .limit(1)
                .forEach(System.out::println);
    }


    /**
     * 学生年龄大于15的总和
     */
    @Test
    public void sumTest() {

        int sum = STUDENTS.stream()
                .filter(student -> student.getAge() > 15)
                .mapToInt(Student::getAge).sum();
        System.out.println("sum: " + sum);
    }


    /**
     * 归组
     */
    @Test
    public void partitioningTest1() {

        AtomicInteger count = new AtomicInteger();
        Stream.generate(new PersonGenerate(count))
                .limit(20)
                .collect(Collectors.partitioningBy(person -> person.getId() < 5))
                .forEach((k, v) -> System.out.printf("key:%s ,value:%s\n", k, v));
    }


    /**
     * 去重
     */
    @Test
    public void generateTest2() {

        AtomicInteger count = new AtomicInteger();
        Stream.generate(new PersonGenerate(count))
                .limit(50)
                .filter(person -> person.getId() < 10)
                .collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getId))))
                .forEach(System.out::println);
    }


    /**
     * 去重
     */
    @Test
    public void generateTest1() {

        AtomicInteger count = new AtomicInteger();
        Stream.generate(new PersonGenerate(count))
                .limit(50)
                .filter(person -> person.getId() < 10)
                .collect(Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getId))),
                        ArrayList::new
                )).forEach(System.out::println);
    }



    @AllArgsConstructor
    class PersonGenerate implements Supplier<Person> {

        private AtomicInteger count;

        @Override
        public Person get() {
            int id = count.incrementAndGet();
            return new Person(new Random().nextInt(10), "name_" + id);
        }
    }

}
