package cn.edu.xmu.oneonezero.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkService;
import cn.edu.xmu.oneonezero.service.UserService;

@Controller
@RequestMapping("/customized")
public class CustomizedController {
	@Resource(name="userService")
	private UserService userService;
	
	@Resource(name="customizedArtworkService")
	private CustomizedArtworkService customizedArtworkService;
	
	@RequestMapping("seeMore")
	public String seeMore(Long artistId,HttpServletRequest request){
//		request.setAttribute("itemlist",customizedArtworkService.get);
		return "artistInfoAndCommondity";
	}

}
