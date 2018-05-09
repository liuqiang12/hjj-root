package com.scgxdz.controller;


import com.scgxdz.EurekaRegisterApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by yls on 2017/11/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)//junnit支持
@SpringBootTest(classes = EurekaRegisterApplication.class)//启动类
@WebAppConfiguration//开启web配置，模拟slerverContext
public class HelloActionTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloAction()).build();
    }

    @Test
    public void hello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/h").accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).andExpect(content().string(equalTo("热烈欢迎")));
    }
}
