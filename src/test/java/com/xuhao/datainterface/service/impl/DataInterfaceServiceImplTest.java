package com.xuhao.datainterface.service.impl;

import org.junit.Test;

import java.time.LocalDate;

/**
 * @author xuhao
 * @create 2024-05-15 10:34
 */
public class DataInterfaceServiceImplTest {
    @Test
    public void test1(){
        String s = LocalDate.now().toString();
        System.out.println(s);
    }
}
