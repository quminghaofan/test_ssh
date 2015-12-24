package cn.edu.xmu.oneonezero.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.edu.xmu.oneonezero.entity.News;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.NewsService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    private SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    
    @RequestMapping("/getNews")
    public String getNews(String type,long newsId,HttpServletRequest request){
        request.getSession().setAttribute("news",newsService.getNews(newsId));
        request.setAttribute("typeExamine",type);
        return "chiefEditor_checks";
    }

    @RequestMapping(value="/examineNews")
    public String examineNews(String type,String typeExamine,HttpServletRequest request){
        News news=(News)request.getSession().getAttribute("news");
        User user=(User)request.getSession().getAttribute("user");
    	if(type.equals("1")) {
    		news.setRank(request.getParameter("rank"));
        	news.setState("审核通过");
        }
        else {
            news.setState("审核不通过");
        }
    	news.setChiefEditor(user);
        newsService.updateNews(news);
        if(typeExamine.equals("1")){
        	return "redirect:/chiefEditor/getUnexamined";
        }
        else{
        	return "redirect:/chiefEditor/getExamined";
        }
    }
    
    @RequestMapping("/goback")
    public String goback(String type,HttpServletRequest request){
    	System.out.println("go:"+type);
    	if(type.equals("1")){
    		return "redirect:/chiefEditor/getUnexamined";
    	}
    	return "redirect:/chiefEditor/getExamined";
    }
    
    @RequestMapping(value="/setNews")
    public String setNews(HttpServletRequest request) throws ParseException{
    	News news=(News) request.getSession().getAttribute("news");
        news.setRank(request.getParameter("rank"));
        news.setOnShowTime(format.parse(request.getParameter("txtDate")));
        newsService.updateNews(news);
        return "redirect:/chiefEditor/getUnexamined";
    }

    @RequestMapping(value="/getExamined")
    public String getExamined(HttpServletRequest request){
        request.setAttribute("RRLIST", newsService.getExaminedNews());
        return "chiefEditor_rr_2";
    }

    @RequestMapping(value="/getUnexamined")
    public String getUnexamined(HttpServletRequest request){
        request.setAttribute("RRLIST",newsService.getUnexaminedNews());
        return "chiefEditor_rr_1";
    }
    @RequestMapping("/search")
    public String search(String type,HttpServletRequest request) throws ParseException{
    	Date start,end;
    	String newsType=request.getParameter("category");
    	String startTime=request.getParameter("onShowTime");
//    	System.out.println(startTime);
    	String newsName=request.getParameter("RRname");
    	
    	if(startTime.equals("")){
    		start=null;
    	}else {
			start=format.parse(startTime);
		}
    	String endTime=request.getParameter("offShowTime");
    	if(endTime.equals("")){
    		end=null;
    	}else {
    		end=format.parse(endTime);
		}
    	request.setAttribute("RRLIST",newsService.getNewsByTimespace(newsType,start, end, newsName,type));
    	if(type.equals("1")){
    	return "chiefEditor_rr_1";
    	}
    	else {
			return "chiefEditor_rr_2";
		}
    }
}
