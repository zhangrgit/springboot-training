package com.rz.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rz.entity.User;
import com.rz.service.UserService;

@Controller
public class UserController {

	@Resource
	UserService userService;
	
	@RequestMapping("/")
    public String index() {
       return "redirect:/list";
	}
	
	@RequestMapping("/list")
	public String list(Model model) {
		
	    List<User> users=userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
        
	}
	
    @RequestMapping("/toAdd")
	public String toAdd() {
		 return "user/userAdd";
	}
	
    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }
    /**
     * @param model
     * @param id
     * @return "user/userEdit"; 代表会直接去resources目录下找相关的文件。
     */
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }
    /**
     * @param user
     * @return "redirect:/list"; 代表转发到对应的controller，这个示例就相当于编辑内容之后自动调整到list请求，然后再输出到页面。
     */
    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }
    
    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/list";
    }
    
    
}
