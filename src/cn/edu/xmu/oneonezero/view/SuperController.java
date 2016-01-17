package cn.edu.xmu.oneonezero.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.DataDictionaryService;
import cn.edu.xmu.oneonezero.service.UserService;

/**
 * 超级管理员
 * @author DELL
 *
 */
@Controller
@RequestMapping("/super")
public class SuperController {
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "dataDictionaryService")
	private DataDictionaryService dataDictionaryService;

	/**
	 * 普通管理员管理
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/adminManage")
	public String adminManage(HttpServletRequest request) {
		System.out.println("adminManage:"+(userService.getAllManager()).size());
		request.setAttribute("ADMINLIST",userService.getAllManager());
		return "super_admin";
	}

	/**
	 * 角色管理
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/roleManege")
	public String roleManege(HttpServletRequest request){
		request.setAttribute("ROLELIST",dataDictionaryService.getAllRoles());
		return "super_role";
	}
	
	/**
	 * 艺术品类型管理
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/artTypeManage")
	public String artTypeManage(HttpServletRequest request){
		request.setAttribute("TYPELIST",dataDictionaryService.getAllArtworkTypes());
		return "super_type";
	}
	
	/**
	 * 进入添加普通管理员界面
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/goToAddAdmin")
	public String goToAddAdmin(HttpServletRequest request) {
		request.setAttribute("ROLELIST",dataDictionaryService.getAllRoles());
		request.setAttribute("type", 1);
		return "super_admin_add";
	}

	/**
	 * 进入编辑普通管理员界面
	 * @param userId 普通管理员id
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/goToEdit")
	public String goToEdit(Long userId,HttpServletRequest request) {
		request.setAttribute("admin",userService.getUser(userId));
		request.setAttribute("ROLELIST",dataDictionaryService.getAllRoles());
		return "super_admin_add";
	}
	
	/**
	 * 获取普通管理员
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/getAdmin")
	public String getAdmin(HttpServletRequest request){
		 request.setAttribute("ADMINLIST",userService.getUserByUserName(request.getParameter("rolename"),"0"));
		return "super_admin";
	}

	/**
	 * 禁用普通管理员
	 * @param userId 普通管理员id
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/delAdmin")
	public String delAdmin(Long userId,HttpServletRequest request){
		userService.setUserState(userId,false);
		return "redirect:/super/adminManage";
	}
	
	/**
	 * 添加或更新普通管理员
	 * @param adminId 普通管理员id
	 * @param request
	 * @return
	 */
	@RequestMapping("/addAdmin")
	public String addAdmin(Long adminId, HttpServletRequest request) {
		String nameString=request.getParameter("username");
		String realnameString=request.getParameter("realname");
		DataDictionary dataDictionary = dataDictionaryService
				.getDataDictionaryByName(request.getParameter("role"));
		if (adminId==null) {
			User user = new User();
			user.setName(nameString);
			user.setRealName(realnameString);
			user.setRole(dataDictionary);
			user.setPassword("123456");
			user.setState(true);
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
	
	/**
	 * 删除艺术品类型
	 * @param typeId 艺术品类型
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/delArtType")
	public String delArtType(Long typeId,HttpServletRequest request){
		dataDictionaryService.deleteArtworkType(typeId);
		return "redirect:/super/artTypeManage";
	}
	
	/**
	 * 添加艺术品类型
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/addArtType")
	public String addArtType(HttpServletRequest request){
		DataDictionary dataDictionary=new DataDictionary();
		dataDictionary.setName(request.getParameter("typename"));
		dataDictionaryService.insertArtworkTypeDataDictionary(dataDictionary);
		return "redirect:/super/artTypeManage";
	}
	
	/**
	 * 修改密码
	 * @param userId 用户id
	 * @param type 1：进入用户个人资料界面 0:进入普通管理员资料界面
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/changePsw")
	public String changePsw(Long userId,String type,HttpServletRequest request){
		userService.updatePasswordByUserId(userId,request.getParameter("password"));
		if(type.equals("1")){
			return "personalInfoChange";
		}
		else {
			return "admin_info";
		}
	}

}
