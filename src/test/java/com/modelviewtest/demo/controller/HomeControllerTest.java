package com.modelviewtest.demo.controller;

import com.modelviewtest.demo.pojo.Goods;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

@AutoConfigureMockMvc
@SpringBootTest
class HomeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("测试显示单个商品")
    void one() throws Exception {
        ModelAndView mv=mockMvc.perform(get("/home/one"))
                .andExpect(status().isOk())
                .andReturn().getModelAndView();
        //view
        String viewName=mv.getViewName();
        assertThat(viewName,equalTo("home/one.html"));
        //model
        Goods goods = (Goods)mv.getModel().get("goodsOne");
        assertThat(goods.getGoodsId(),equalTo(31L));
        assertThat(goods.getGoodsName(),equalTo("纯色真丝睡袍"));

    }

    @Test
    @DisplayName("测试显示商品列表")
    void list() throws Exception {
        ModelAndView mv=mockMvc.perform(get("/home/list"))
                .andExpect(status().isOk())
                .andReturn().getModelAndView();
        //view
        String viewName=mv.getViewName();
        assertThat(viewName,equalTo("home/list.html"));


        Map<String, Object> model = mv.getModel();
        ArrayList<Goods> list = (ArrayList) model.get("list");
        //检查列表数量
        assertThat(list.size(),greaterThan(0));
        //检查第一个商品的id
        Goods one = list.get(0);
        assertThat(one.getGoodsId(),greaterThan(0L));
    }
}