package com.ssm.controller;

import com.ssm.pojo.Items;
import com.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
public class controllertest {

    @Autowired
    private ItemService itemService;

    @RequestMapping("test")
    public String test(Model model) {

        List<Items> items = itemService.selectList();

        model.addAttribute("itemList",items);

       /* ModelAndView view = new ModelAndView();
        view.addObject("itemList", items);
        *//**
         * 跳转到itemList。jsp页面
         *//*
        view.setViewName("itemList");*/
        return "itemList";
    }

    @RequestMapping("itemEdit")
    public ModelAndView to(Integer id, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

      /*  //servlet开发
        String id = request.getParameter("id");
        Items items = itemService.selectbyid(Integer.parseInt(id));*/

        Items items = itemService.selectbyid(id);
        ModelAndView View = new ModelAndView();
        View.addObject("item", items);
        View.setViewName("editItem");

        return View;
    }

    @RequestMapping("updateitem")
    /**
     *<form id="itemForm"	action="${pageContext.request.contextPath }/updateitem.action" method="post">
     *     经过提交页面，action直接到这个RequestMapping，实行这段代码
     */
    public String update(Model model, Items items, MultipartFile pictureFile) throws Exception {



      /*  ModelAndView View = new ModelAndView();
        *//**
         *         将pojo的值存到页面，并取名为item好方便传值
         *         想相当于request.setattribute(),存数据只放到request作用域中
         *//*
        View.addObject("item", items);
        *//**
         * 跳转到某页面去
         *//*
        View.setViewName("success");*/

        //获取文件原始名称
        String name =    pictureFile.getOriginalFilename();
        //文件扩展名,经过测试完全不需要嘛
      //  String ext = FilenameUtils.getExtension(name);
        //保存图片到
       // pictureFile.transferTo(new File("F:\\pic\\"+name+"."+ext));
        pictureFile.transferTo(new File("F:\\pic\\"+name));
        items.setPic(name);

        itemService.update(items);
        System.out.println(name);
        model.addAttribute("item",items);
        return "success";
/**
 * 问题：
 * 页面跳转成功，但是数据插入不到数据库里去
 * 解决：
 * editItem.jsp中input标签的name="pojo类的属性名要一 一对 应" 而el表法式的${item.id/name/...},则是 View.addObject("item", items);的作用，具体请看el
 */

    }
/**
 * 删除待定
 */
/*
    @RequestMapping("delete")
    public ModelAndView delete(QueryVo vo) {

        itemService.delete(vo);
        ModelAndView View = new ModelAndView();
        View.addObject("itemList",vo);
        View.setViewName("delete");

        return View;
    }
*/


}
