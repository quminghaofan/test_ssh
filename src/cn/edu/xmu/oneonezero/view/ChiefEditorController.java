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
    /**
     * 进入审核软文界面
     * @param type 1：审核通过 0：审核不通过
     * @param newsId 软文id
     * @param request 请求
     * @return String
     */
    @RequestMapping("/getNews")
    public String getNews(String type,long newsId,HttpServletRequest request){
        request.getSession().setAttribute("news",newsService.getNews(newsId));
        request.setAttribute("typeExamine",type);
        return "chiefEditor_checks";
    }

    /**
     * 审核软文
     * @param type 1：审核通过 0：审核不通过
     * @param typeExamine 1：进入未审核界面 0：进入已审核界面
     * @param request 请求
     * @return String
     */
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
    
    /**
     * 返回列表
     * @param type 1：进入未审核界面 0：进入已审核界面
     * @param request 请求
     * @return String
     */
    @RequestMapping("/goback")
    public String goback(String type,HttpServletRequest request){
    	System.out.println("go:"+type);
    	if(type.equals("1")){
    		return "redirect:/chiefEditor/getUnexamined";
    	}
    	return "redirect:/chiefEditor/getExamined";
    }

    /**
     * 获取所有已审核的软文
     * @param request 请求
     * @return String
     */
    @RequestMapping(value="/getExamined")
    public String getExamined(HttpServletRequest request){
        request.setAttribute("RRLIST", newsService.getExaminedNews());
        return "chiefEditor_rr_2";
    }

    /**
     * 获取所有未审核的软文
     * @param request 请求
     * @return String
     */
    @RequestMapping(value="/getUnexamined")
    public String getUnexamined(HttpServletRequest request){
        request.setAttribute("RRLIST",newsService.getUnexaminedNews());
        return "chiefEditor_rr_1";
    }
    
    /**
     *搜索软文 
     * @param type 1：进入未审核界面 0：进入已审核界面
     * @param request 请求
     * @return String
     * @throws ParseException 时间转换异常
     */
    @RequestMapping("/search")
    public String search(String type,HttpServletRequest request) throws ParseException{
    	Date start,end;
    	String newsType=request.getParameter("category");
    	String startTime=request.getParameter("txtDate time1");
//    	System.out.println(startTime);
    	String newsName=request.getParameter("RRname");
    	
    	if(startTime==null||startTime.equals("")){
    		start=null;
    	}else {
			start=format.parse(startTime);
		}
    	
    	String endTime=request.getParameter("txtDate time2");
    	if(endTime==null||endTime.equals("")){
    		end=null;
    	}else {
    		end=format.parse(endTime);

		}
//    	System.out.println("搜索："+newsService.getNewsByTimespace(newsType,start, end, newsName,type).size());
    	request.setAttribute("RRLIST",newsService.getNewsByTimespace(newsType,start, end, newsName,type));
    	if(type.equals("1")){
    	return "chiefEditor_rr_1";
    	}
    	else {
			return "chiefEditor_rr_2";
		}
    }
}
