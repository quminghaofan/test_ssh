package cn.edu.xmu.oneonezero.view;

import cn.edu.xmu.oneonezero.entity.News;
import cn.edu.xmu.oneonezero.service.NewsService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 主编
 * Created by Fernando on 2015/12/1.
 */
@Controller
@RequestMapping("/chiefEditor")
public class ChiefEditorController {
    @Resource(name="newsService")
    private NewsService newsService;

    @RequestMapping("/getNews")
    public String getNews(String type,long newsId,HttpServletRequest request){
        request.getSession().setAttribute("news",newsService.getNews(newsId));
        if(type.equals("1")){
        	return "chiefEditor_checks";
        }
        else {
			return "chiefEditor_rechecks";
		}
    }

    @RequestMapping(value="/examineNews")
    public String examineNews(String type,HttpServletRequest request){
        News news=(News)request.getSession().getAttribute("news");
    	if(type.equals("1")) {
    		news.setRank(request.getParameter("rank"));
        	news.setState("审核通过");
        }
        else {
            news.setState("审核不通过");
        }
        newsService.updateNews(news);
    	return "redirect:/chiefEditor/getUnexamined";
    }

    @RequestMapping(value="/reExamineNews")
    public String reExamineNews(String type,HttpServletRequest request){
        News news=(News)request.getSession().getAttribute("news");
    	if(type.equals("1")) {
    		news.setRank(request.getParameter("rank"));
        	news.setState("审核通过");
        }
        else {
            news.setState("审核不通过");
        }
        newsService.updateNews(news);
    	return "redirect:/chiefEditor/getExamined";
    }
    
    @RequestMapping(value="/setNews")
    public String setNews(HttpServletRequest request){
    	News news=(News) request.getSession().getAttribute("news");
        news.setRank(request.getParameter("rank"));
        news.setOnShowTime(request.getParameter("txtDate"));
        newsService.updateNews(news);
        return "redirect:/chiefEditor/getUnexamined";
    }

    @RequestMapping(value="/getExamined")
    public String getExamined(HttpServletRequest request){
        request.setAttribute("RRLIST", newsService.getExaminedNews());
        return "chiefEditor_rr_2";
    }
    @RequestMapping(value="/getExaminedByNewsName")
    public String getExaminedByNewsName(HttpServletRequest request){
        request.setAttribute("RRLIST", newsService.getExaminedNewsByVagueNewsName(request.getParameter("RRname")));
        return "chiefEditor_rr_2";
    }

    @RequestMapping(value="/getUnexamined")
    public String getUnexamined(HttpServletRequest request){
        request.setAttribute("RRLIST",newsService.getUnexaminedNews());
        return "chiefEditor_rr_1";
    }

    @RequestMapping(value="/getUnexaminedByNewsName")
    public String getUnexaminedByNewsName(HttpServletRequest request){
        request.setAttribute("RRLIST",newsService.getUnexaminedNewsByVagueNewsName(request.getParameter("RRname")));
        return "chiefEditor_rr_1";
    }
}
