package com.tony.sample.clone;

import com.tony.sample.clone.Professor;
import com.tony.sample.clone.Student;
import lombok.SneakyThrows;
import org.junit.Test;

/**
 * @author www.yamibuy.com
 * @desc :
 * @date 2019/10/18
 * <b>版权所有：</b>版权所有(C) 2018，www.yamibuy.com<br>
 */
public class SampleTest {

    /**
     * Professor对象没有实现clonable接口, 实现的是浅复制
     */
    @Test
    @SneakyThrows
    public void test1() {
        Professor professor = new Professor().setName("li");
        Student studentA = new Student().setName("张三").setProfessor(professor);

        System.out.println(studentA.toString()); //Student(name=张三, professor=Professor(name=li))
        System.out.println("开始复制");

        Student studentB = (Student) studentA.clone();
        studentB.setProfessor(studentB.getProfessor().setName("wang"));

        System.out.println(studentA.toString()); //Student(name=张三, professor=Professor(name=wang))
        System.out.println(studentB.toString()); //Student(name=张三, professor=Professor(name=wang))

    }

    /**
     * Student对象实现了Clonable对象, 实现的是深复制
     */
    @Test
    @SneakyThrows
    public void test2() {
        Professor professor = new Professor().setName("li");
        Student studentA = new Student().setName("张三").setProfessor(professor);

        System.out.println(studentA.toString()); //Student(name=张三, professor=Professor(name=li))
        System.out.println("开始复制");

        Student studentB = (Student) studentA.clone();
        studentB.setName("abcd");

        System.out.println(studentA.toString()); //Student(name=张三, professor=Professor(name=li))
        System.out.println(studentB.toString()); //Student(name=abcd, professor=Professor(name=li))
    }


}
