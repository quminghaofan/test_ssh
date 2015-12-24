package cn.edu.xmu.oneonezero.view;

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
		 request.setAttribute("ADIMLIST",userService.getAllManager());//TODO 
		return "super_admin";
	}

	@RequestMapping("/roleManege")
	public String roleManege(HttpServletRequest request){
		request.setAttribute("ROLELIST",dataDictionaryService.getAllRoles());
		return "super_role";
	}
	
	@RequestMapping("/artTypeManage")
	public String artTypeManage(HttpServletRequest request){
		request.setAttribute("TYPELIST",dataDictionaryService.getAllArtworkTypes());
		return "super_type";
	}
	@RequestMapping("/goToAddAdmin")
	public String goToAddAdmin(HttpServletRequest request) {
		request.setAttribute("ROLELIST",dataDictionaryService.getAllRoles());
		request.setAttribute("type", 1);
		return "super_admin_add";
	}

	@ResourceMapping("/goToEdit")
	public String goToEdit(Long userId,HttpServletRequest request) {
		request.setAttribute("admin",userService.getUser(userId));
		request.setAttribute("ROLELIST",dataDictionaryService.getAllRoles());
		return "super_admin_add";
	}
	
	@ResourceMapping("/getAdmin")
	public String getAdmin(HttpServletRequest request){
		 request.setAttribute("ADIMLIST",userService.getUserByUserName(request.getParameter("rolename")));
		return "super_admin";
	}

	@RequestMapping("/delAdmin")
	public String delAdmin(Long userId,HttpServletRequest request){
		userService.setUserStateFalse(userId);
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
		dataDictionaryService.deleteArtworkType(typeId);
		return "redirect:/super/artTypeManage";
	}
	
	@RequestMapping("/addArtType")
	public String addArtType(HttpServletRequest request){
		DataDictionary dataDictionary=new DataDictionary();
		dataDictionary.setNumber("02"+request.getParameter("typenumber"));
		dataDictionary.setName(request.getParameter("typename"));
		dataDictionaryService.insertDataDictionary(dataDictionary);
		return "redirect:/super/artTypeManage";
	}

}
