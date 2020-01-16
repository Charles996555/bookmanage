package com.jincheng.bookmanage.test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test01 {
    @Test
    public void test01(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date()));
    }


}
