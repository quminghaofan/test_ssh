package cn.edu.xmu.oneonezero.view;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customized")
public class CustomizedController {
	
	@RequestMapping("enterCustomized")
	public String enterCustomized(HttpServletRequest request){
//		request.setAttribute("itemlist", arg1);
		return "customized";
	}

}
