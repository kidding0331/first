package cn.ppj.sptdruiddemo.controller;

import cn.ppj.sptdruiddemo.dao.UserDao;
import cn.ppj.sptdruiddemo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDao userDao;

    @GetMapping("/index.html")
    public String index(Model model) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from et_user");
        model.addAttribute("users", maps);
        //123
        return "index";
    }

    @GetMapping("/user.html")
    @ResponseBody
    public String user(Model model) {
        User user = userDao.get(4);
        System.out.println("111" + user.toString());
        //123
        return user.toString();
    }
}
