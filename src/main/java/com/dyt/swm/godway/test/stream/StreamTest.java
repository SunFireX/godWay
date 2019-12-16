package com.dyt.swm.godway.test.stream;

import com.alibaba.fastjson.JSON;
import com.dyt.swm.godway.GodwayApplication;
import com.dyt.swm.godway.test.model.Staff;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/9/9 13:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GodwayApplication.class)//这里的Application是springboot的启动类名
@WebAppConfiguration
public class StreamTest {



    @Test
    public void testSend() throws Exception {
        List<Staff> staffList = new ArrayList();
        for (int i = 0; i < 10; i++) {
            Staff build = Staff.builder().name("小明" + i).age(new Random().nextInt(10) + 15).bool(true).salary(new BigDecimal(new Random().nextInt(100))).build();
            System.out.println("for->"+JSON.toJSONString(build));
            staffList.add(build);
        }



    }






}
