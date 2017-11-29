package com.springboot.controller;

import com.springboot.dao.QuestionTypeDao;
import com.springboot.domain.QuestionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller     //等同于同时加上了@Controller和@ResponseBody
public class HelloController {

    @Autowired
    private QuestionTypeDao questionTypeDao;

    //访问/hello或者/hi任何一个地址，都会返回一样的结果
    @RequestMapping(value = {"/hello", "/hi"}, method = RequestMethod.GET)
    @ResponseBody
    public String say() {
        return "hi you!!!";
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    @ResponseBody
    public List<QuestionType> getGirlList() {
        return questionTypeDao.getAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    @ResponseBody
    public int save() {
        QuestionType type = new QuestionType();
        type.setName(UUID.randomUUID().toString().substring(0, 9));
        questionTypeDao.save(type);
        return type.getId();
    }

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    @ResponseBody
    public QuestionType getById(int id) {
        return questionTypeDao.getById(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public int update(int id, String name) {
        QuestionType type = new QuestionType();
        type.setId(id);
        type.setName(name);
        return questionTypeDao.update(type);
    }

    @RequestMapping("/index")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("name", "bbbbbbbbb");
        map.addAttribute("bookTitle", "aaaaaaaaa");
        // return模板文件的名称，对应src/main/resources/templates/welcome.html
        return "controller";
    }

}
