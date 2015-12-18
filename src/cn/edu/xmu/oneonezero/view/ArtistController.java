package cn.edu.xmu.oneonezero.view;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("artist")
public class ArtistController {

	@Qualifier("userService")
	private UserService userService;
	
	@RequestMapping("/artistApply")
	public String artistApply(HttpServletRequest request){
		User user=(User)request.getSession().getAttribute("user");
		user.setBankCardAccount(request.getParameter("account"));
		DataDictionary dataDictionary=user.getRole();;
		dataDictionary.setName("预备艺术家");
		user.setRole(dataDictionary);
		user.setRealName(request.getParameter("realname"));
		userService.updateUser(user);
		return "redirect:/init/home";
	}
}
