package cn.edu.xmu.oneonezero.view;


import cn.edu.xmu.oneonezero.entity.News;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.NewsService;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 采编
 * Created by Fernando on 2015/12/1.
 */
@Controller
@RequestMapping("/editor")
public class EditorController {

    @Resource(name="newsService")
    private NewsService newsService;

    @RequestMapping(value="/addNews")
    public String addNews(String type,HttpServletRequest request){
    	News news=new News();
    	User user=((User)request.getSession().getAttribute("user"));
    	news.setEditor(user);
    	news.setName(request.getParameter("RRname"));
    	news.setContent(request.getParameter("content"));
    	System.out.println(request.getParameter("content"));
    	news.setPicUrl(request.getParameter("img"));
    	news.setOnShowTime(request.getParameter("txtDate time1"));
    	news.setOffShowTime(request.getParameter("txtDate time2"));
    	news.setPrice(Double.parseDouble(request.getParameter("price")));
    	if(type.equals("1")){
    		news.setState("草稿");
    	}
    	else {
			news.setState("未审核");
		}
        newsService.insertNews(news);
        return "redirect:/editor/getDraft"; 
    }

    @RequestMapping(value="/editNews")
    public String editNews(String type,HttpServletRequest request){
    	News news=(News) request.getSession().getAttribute("news");
    	User user=(User)request.getSession().getAttribute("user");
    	news.setEditor(user);
    	news.setName(request.getParameter("RRname"));
    	news.setContent(request.getParameter("content"));
    	System.out.println(request.getParameter("content"));
    	news.setPicUrl(request.getParameter("img"));
    	news.setOnShowTime(request.getParameter("txtDate time1"));
    	news.setOffShowTime(request.getParameter("txtDate time2"));
//    	System.out.println(request.getParameter("price"));
    	news.setPrice(Double.parseDouble(request.getParameter("price")));
//    	System.out.println(type);
    	if(type.equals("1")){//保存
    		news.setState("草稿");
    	}else {//发送
			news.setState("未审核");
		}
        newsService.updateNews(news);
        return "redirect:/editor/getDraft"; 
    }
//    
//    @RequestMapping("/getNewsToCheck")
//    public String getNewsToCheck(long newsId,HttpServletRequest request){
//        request.setAttribute("RR",newsManager.getNews(newsId));
//        return "chiefEditor_checks";
//    }

    @RequestMapping("/getNewsToEdit")
    public String getNewsToEdit(long newsId,HttpServletRequest request){
    	News news=newsService.getNews(newsId);
        request.getSession().setAttribute("news",news);
        return "editor_rr_edit";
    }
//    
//    @RequestMapping("/examineNews")
//    public String examineNews(News news,String type,HttpServletRequest request){
//        if(type.equals("1")) {
//        	news.setState("");
//            newsService.updateNews(news);
//            request.setAttribute("RR", news);
//            return "chiefEditor_rr_edit";
//        }
//        else {
//            news.setIsExamined(true);
//            news.setIsPassed(true);
//            newsService.updateNews(news);
//            return "chiefEditor_rr_2";
//        }
//    }

//    @RequestMapping("/setNews")
//    public String setNews(HttpServletRequest request){
//    	News news=(News) request.getAttribute("RR");
//        news.setRank(request.getParameter("rank"));
//        news.setOnShowTime(request.getParameter("txtDate"));
//        newsService.updateNews(news);
//        return "redirect:/editor/getUnexamined";
//    }

    @RequestMapping("/delNews")
    public String delNews(String type,long newsId,HttpServletRequest request){
        newsService.delNews(newsId);
        if(type!=null&&type.equals("1")){//未通过
        	return "redirect:/editor/getUnPassed";//TODO 只能删除未审核的和审核未通过的
        }
        else return "redirect:/editor/getDraft";
    }


    //获取所有未审核
    @RequestMapping("/getUnexamined")
    public String getUnexamined(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
        request.setAttribute("RRLIST",newsService.getUnexaminedNewsByEditorName(user.getName()));
        return "editor_rr_1";
    }

    @RequestMapping("/getUnexaminedByNewsName")
    public String getUnexaminedByNewsName(HttpServletRequest request){
        User user=(User)request.getSession().getAttribute("user");
    	request.setAttribute("RRLIST",newsService.getUnexaminedNewsByEditorNameAndVagueNewsName(user.getName(),request.getParameter("RRname")));
        return  "editor_rr_1";
    }

    //不通过
    @RequestMapping("/getUnPassed")
    public String getUnPassed(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
        request.setAttribute("RRLIST",newsService.getUnPassedNewsByEditorName(user.getName()));
        return "editor_rr_2";
    }

    @RequestMapping("/getUnPassedByNewsName")
    public String getUnPassedByNewsName(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
    	request.setAttribute("RRLIST",newsService.getUnpassedNewsByEditorNameAndVagueNewsName(user.getName(),request.getParameter("RRname")));
        return  "editor_rr_2";
    }

    //已通过
    @RequestMapping("/getPassed")
    public String getPassed(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
        request.setAttribute("RRLIST",newsService.getPassedNewsByEditorName(user.getName()));
        return "editor_rr_3";
    }

    @RequestMapping("/getPassedByNewsName")
    public String getPassedByNewsName(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
        request.setAttribute("RRLIST",newsService.getPassedNewsByEditorNameAndVagueNewsName(user.getName(),request.getParameter("RRname")));
        return  "editor_rr_3";
    }
    
    @RequestMapping(value="getDraft")
    public String getDraft(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
    	request.setAttribute("RRLIST",newsService.getDraftByEditorName(user.getName()));
    	return "editor_rr_4";
    }
    
    @RequestMapping(value="getDraftByNewsName")
    public String getDraftByNewsName(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
    	request.setAttribute("RRLIST",newsService.getDraftByEditorNameAndVagueNewsName(user.getName(),request.getParameter("RRname")));
    	return "editor_rr_4";
    }
    //撤回
    @RequestMapping("withdraw")
    public String withdraw(String type,long newsId,HttpServletRequest request){
    	newsService.updateStateToDraft(newsId);
    	if(type.equals("0")){
    		return "redirect:/editor/getUnexamined";
    	}
    	else if(type.equals("1")){
    		return "redirect:/editor/getUnPassed";
    	}
    	else {
			return "redirect:/editor/getPassed";
		}
    }
    
    @RequestMapping("/search")
    public String search(String type,HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
    	String newsType=request.getParameter("category");
    	String startTime=request.getParameter("onShowTime");
    	System.out.println(startTime);
    	String endTime=request.getParameter("offShowTime");
    	String newsName=request.getParameter("RRname");
    	request.setAttribute("RRLIST","");
    	return "";
    }
}
