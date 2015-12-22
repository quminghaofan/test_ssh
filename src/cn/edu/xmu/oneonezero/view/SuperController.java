package cn.edu.xmu.oneonezero.view;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.DataDictionaryService;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/super")
public class SuperController {
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "dataDictionaryService")
	private DataDictionaryService dataDictionaryService;

	@RequestMapping("/adminManage")
	public String adminManage(HttpServletRequest request) {
		// request.setAttribute("ADIMLIST", arg1);
		return "super_admin";
	}

	@RequestMapping("/roleManege")
	public String roleManege(HttpServletRequest request){
//		request.setAttribute("ROLELIST", arg1);
		return "super_role";
	}
	
	@RequestMapping("/artTypeManage")
	public String artTypeManage(HttpServletRequest request){
//		request.setAttribute("TYPELIST", arg1);
		return "super_type";
	}
	@RequestMapping("/goToAddAdmin")
	public String goToAddAdmin(HttpServletRequest request) {
		// request.setAttribute("ROLELIST", );
		request.setAttribute("type", 1);
		return "super_admin_add";
	}

	@ResourceMapping("/goToEdit")
	public String goToEdit(Long userId,HttpServletRequest request) {
		request.setAttribute("admin",userService.getUser(userId));
		// request.setAttribute("ROLELIST", );
		return "super_admin_add";
	}
	
	@ResourceMapping("/getAdmin")
	public String getAdmin(HttpServletRequest request){
		List<User> admin=new ArrayList();
//		admin.add(request.getParameter("rolename"));
		 request.setAttribute("ADIMLIST", admin);
		return "super_admin";
	}

	@RequestMapping("/delAdmin")
	public String delAdmin(Long userId,HttpServletRequest request){
		userService.delUser(userId);
		return "redirect:/super/adminManage";
	}
	@RequestMapping("/addAdmin")
	public String addAdmin(Long adminId, HttpServletRequest request) {
		String nameString=request.getParameter("adminname");
		String realnameString=request.getParameter("realname");
		DataDictionary dataDictionary = dataDictionaryService
				.getDataDictionaryByName(request.getParameter("role"));
		if (adminId==null) {
			User user = new User();
			user.setName(nameString);
			user.setRealName(realnameString);
			user.setRole(dataDictionary);
			user.setPassword("123456");
			userService.insertUser(user);
		} else {
			User user=userService.getUser(adminId);
			user.setName(nameString);
			user.setRealName(realnameString);
			user.setRole(dataDictionary);
			user.setPassword("123456");
			userService.updateUser(user);
		}
		return "redirect:/super/adminManage";
	}
	
	@RequestMapping("/delArtType")
	public String delArtType(Long typeId,HttpServletRequest request){
		//TODO 删除
		return "redirect:/super/artTypeManage";
	}
	
	@RequestMapping("/addArtType")
	public String addArtType(HttpServletRequest request){
		DataDictionary dataDictionary=new DataDictionary();
		dataDictionary.setNumber("02"+request.getParameter(""));
		dataDictionary.setName(request.getParameter(""));
//		添加
		return "redirect:/super/artTypeManage";
	}

}
