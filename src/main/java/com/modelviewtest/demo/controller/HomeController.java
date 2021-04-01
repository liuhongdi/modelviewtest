package com.modelviewtest.demo.controller;

import com.modelviewtest.demo.pojo.Goods;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping("/home")
public class HomeController {

    //返回单个商品
    @GetMapping("/one")
    public String one(Model model) {

        Goods goods31 = new Goods();
        goods31.setGoodsId(31L);
        goods31.setGoodsName("纯色真丝睡袍");

        //把list传递给模板
        model.addAttribute("goodsOne",goods31);
        return "home/one.html";
    }

    //返回商品列表
    @GetMapping("/list")
    public String list(Model model) {

        ArrayList<Goods> listGoods1 = new ArrayList<Goods>();

        Goods goods1 = new Goods();
        goods1.setGoodsId(1L);
        goods1.setGoodsName("无线智能感应灯");
        listGoods1.add(goods1);
        Goods goods2 = new Goods();
        goods2.setGoodsId(2L);
        goods2.setGoodsName("朱之光落地灯");
        listGoods1.add(goods2);
        Goods goods3 = new Goods();
        goods3.setGoodsId(3L);
        goods3.setGoodsName("儿童抗首菌枕头");
        listGoods1.add(goods3);

        //把list传递给模板
        model.addAttribute("list",listGoods1);
        return "home/list.html";
    }

}
