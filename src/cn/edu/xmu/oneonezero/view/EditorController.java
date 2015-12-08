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

    @RequestMapping(value="/addNews",method = RequestMethod.POST)
    public String addNews(String type,HttpServletRequest request){
    	News news=new News();
    	news.setName(request.getParameter("RRname"));
    	User user=((User)request.getSession().getAttribute("user"));
    	news.setEditor(user);
    	news.setContent(request.getParameter("RRcontent"));
    	news.setPicUrl(request.getParameter("img"));
    	if(type.equals("1")){
    		news.setState("草稿");
    	}
    	else {
			news.setState("未审核");
		}
        newsService.insertNews(news);
        return "redirect:/editor/getUnexamined"; 
    }

    @RequestMapping(value="/editNews",method=RequestMethod.POST)
    public String editNews(String type,HttpServletRequest request){//TODO
    	News news=(News) request.getSession().getAttribute("news");
    	User user=(User)request.getSession().getAttribute("user");
    	news.setEditor(user);
    	news.setName(request.getParameter("RRname"));
    	news.setContent(request.getParameter("RRcontent"));
    	news.setPicUrl(request.getParameter("img"));
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
        if(type.equals("1")){//未通过
        	return "redirect:/editor/getUnPassed";//TODO 只能删除未审核的和审核未通过的
        }
        else return "redirect:/editor/getDraft";
    }

    @RequestMapping("/getNewsPush")
    public String getNewsPush(HttpServletRequest request){
//        request.setAttribute("newsList", newsManager.getNewsByCollector(userId));
        return "刚进入的界面";//TODO
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
    	request.setAttribute("RRLIST",newsService.getUnexaminedNewsByEditorNameAndNewsName(user.getName(),request.getParameter("RRname")));
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
    	request.setAttribute("RRLIST",newsService.getUnpassedNewsByEditorNameAndNewsName(user.getName(),request.getParameter("RRname")));
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
        request.setAttribute("RRLIST",newsService.getPassedNewsByEditorNameAndNewsName(user.getName(),request.getParameter("RRname")));
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
    	request.setAttribute("RRLIST",newsService.getDraftByEditorNameAndNewsName(user.getName(),request.getParameter("RRname")));
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
}
