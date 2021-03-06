package cn.edu.xmu.oneonezero.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import cn.edu.xmu.oneonezero.entity.News;
import cn.edu.xmu.oneonezero.service.NewsService;

/**
 * 软文
 * @author DELL
 *
 */
@Controller
@RequestMapping("news")
public class NewsController {
	@Resource(name="newsService")
	public NewsService newsService;
	
	/**
	 * 进入查看软文界面
	 * @param newsId 软文id
	 * @param type 
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/showNews")
	public String showNews(long newsId,String type,HttpServletRequest request){
		News news=newsService.getNews(newsId);
		request.setAttribute("news",news);
//		System.out.println("shownews:"+news.getName());
		request.setAttribute("type",type);
		return "showNews";
	}
	
	/**
	 * 返回
	 * @param type 
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping(value="/goback")
	public String goback(String type,HttpServletRequest request){
		System.out.println("goback");
		if(type.equals("1")){//主页
			return "redirect:/init/home";
		}
		else if(type.equals("2")){//主编-未审核
			return "redirect:/chiefEditor/getUnexamined";
		}
		else if(type.equals("3")){//主编-已审核
			return "redirect:/chiefEditor/getExamined";
		}
		else if(type.equals("4")){//采编-未审核
			return "redirect:/editor/getUnexamined";
		}
		else if(type.equals("5")){//采编-未通过
			return "redirect:/editor/getUnPassed";
		}
		else{//采编-已通过
			return "redirect:/editor/getPassed";
		}
//		else {//采编-草稿
//			return "redirect:/editor/getDraft";
//		}
	}
}
