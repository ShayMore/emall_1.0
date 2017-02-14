package com.emall.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.emall.web.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
//	Logger logger = Logger.getLogger(UserController.class.getName());
	private static Log logger = LogFactory.getLog(UserController.class);
	
	Map<Integer, User> users = new HashMap<Integer, User>();	
	private int i = 0;;
	
	public UserController(){
		User u1 = new User();
		u1.setId(0);
		u1.setUsername("tom");
		u1.setAge("18");
		u1.setSex("male");
		User u2 = new User();
		u2.setId(1);
		u2.setUsername("momo");
		u2.setAge("22");
		u2.setSex("female");
		users.put(i++, u1);
		users.put(i++, u2);
	}
	
	/**
	 * 用户列表显示
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public String users(Model model){
		model.addAttribute("users", users);
		return "/user/users";		
	}
	
//	@RequestMapping(value="/add",method=RequestMethod.GET)
//	public String add(Model model) {
//		model.addAttribute(new User());
//		return "/add";
//	}
	
	/**
	 * 添加界面显示
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(@ModelAttribute("user") User user) {
		return "/user/add";
	}
//	
//	/**
//	 * 添加
//	 * @param user
//	 * @param br
//	 * @param ufiles
//	 * @param request
//	 * @return
//	 * @throws IOException
//	 */
//	@RequestMapping(value="/add",method=RequestMethod.POST)
//	public String add(@Valid User user,BindingResult br, @RequestParam("ufiles") MultipartFile[] ufiles,
//			HttpServletRequest request) throws IOException {
//		if(br.hasErrors()) {
//			logger.info("<添加用户> 错误数" + br.getErrorCount());
//			return "/user/add";
//		}
//		user.setId(i);
//		users.put(i++, user);
//		// /resource/upload/这里最后的斜杠可有可无。因为获取的路径不带最后的斜杠
//		String realpath = request.getSession().getServletContext().getRealPath("/resources/upload/");
////		String path = "D:/momoIT/myspring/resources/upload/";
//		logger.info("<添加用户> 上传头像地址 ：" + realpath);
//		for(MultipartFile ufile : ufiles) {
//			if(ufile.isEmpty()) continue;
//			File file = new File(realpath +"/"+ RandomGenerator.generateFilename()+".jpg");
//			FileUtils.copyInputStreamToFile(ufile.getInputStream(), file);
//			logger.info("<添加用户> " + ufile.getName() + "  " + ufile.getOriginalFilename() + 
//					"  " + ufile.getContentType());		
//		}
//		
//		return "redirect:/user/users";
//	}
	
	/**
	 * 显示详情
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{userid}",method=RequestMethod.GET)
	public String show(@PathVariable int userid,Model model){
		System.out.println("id="+userid);
//		System.out.println(users.get(userid)getUsername());
		model.addAttribute("user",users.get(userid));
		return "/user/show";
	}
	
	/**
	 * 一个返回Json的例子
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/{userid}",method=RequestMethod.GET,params="json")
	@ResponseBody
	public User show(@PathVariable int userid){
		return users.get(userid);
	}
	
	/**
	 * 修改界面
	 * @param userid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/{userid}/update",method=RequestMethod.GET)
	public String update(@PathVariable int userid, Model model) {
		model.addAttribute("user",users.get(userid));
		return "/user/update";
	}
	
	/**
	 * 修改
	 * @param user
	 * @param br
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/{userid}/update",method=RequestMethod.POST)
	public String update(@Validated User user, BindingResult br,@PathVariable int userid) {//@Validated User user, BindingResult br,必须挨着才能验证通过
		if(br.hasErrors()){
			return "/user/update";
		}
		users.put(userid, user);
		return "redirect:/user/users";
	}
	
	/**
	 * 删除
	 * @param userid
	 * @return
	 */
	@RequestMapping(value="/{userid}/delete",method=RequestMethod.GET)
	public String delete(@PathVariable int userid) {
		System.out.println("删除的id "+userid);
		users.remove(userid);
		return "redirect:/user/users";
	}
	
	/**
	 * 登录页面
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login(){
		return "/login";	
	}
	
	/**
	 * 登录
	 * @param username
	 * @param password
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username, String password, Model model){
		
		if(username != null && username != "") {
			for(User u : users.values()) {
				if(u.getUsername().equals(username)) {
					if(u.getAge().equals(password)) {
						return "redirect:/user/users";
					} else {
						logger.info("<用户登录> 密码错误");
						model.addAttribute("logintips", "密码错误");
						return "/login";
					}
				}
			}
			logger.info("<用户登录> 用户不存在");
			model.addAttribute("logintips", "用户不存在");
			return "/login";
		} else {
//			throw new MyException("用户名为空！");
			throw new RuntimeException("用户名为空！");
		}		
	}
}
