package cn.edu.xmu.oneonezero.view;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import cn.edu.xmu.oneonezero.entity.News;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.NewsService;







import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    public String addNews(@RequestParam(value = "img", required = false) MultipartFile filedata,String type,HttpServletRequest request){
    	String path = request.getSession().getServletContext().getRealPath("\\attached");
    	News news=new News();
    	User user=((User)request.getSession().getAttribute("user"));
    	news.setEditor(user);
    	news.setNewsType(request.getParameter("category"));
    	news.setName(request.getParameter("RRname"));
    	news.setContent(request.getParameter("content"));
//    	System.out.println("newstype"+request.getParameter("category"));
    	
    	news.setPicUrl("..\\attached\\"+PicUpload.saveFile(filedata,path));
    	
    	news.setOnShowTime(request.getParameter("txtDate time1"));
    	news.setOffShowTime(request.getParameter("txtDate time2"));
    	news.setPrice(Double.parseDouble(request.getParameter("price")));
    	System.out.println("type:"+type);
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
    public String editNews(@RequestParam(value = "img", required = false) MultipartFile filedata,String type,HttpServletRequest request){
    	String path = request.getSession().getServletContext().getRealPath("\\attached");
    	News news=(News) request.getSession().getAttribute("news");
    	User user=(User)request.getSession().getAttribute("user");
    	news.setEditor(user);
    	news.setNewsType(request.getParameter("category"));
//    	System.out.println("newstype:"+news.getNewsType());
    	news.setName(request.getParameter("RRname"));
    	news.setContent(request.getParameter("content"));
    	
    	if(news.getPicUrl()!=null){
    		String temp=(news.getPicUrl()).replaceAll("..\\\\attached", "");
    		PicUpload.deleteFile(temp,path);
    		System.out.println("picUrl:"+temp);
    	}
    	
    	news.setPicUrl("..\\attached\\"+PicUpload.saveFile(filedata,path));
    	
    	news.setOnShowTime(request.getParameter("txtDate time1"));
    	news.setOffShowTime(request.getParameter("txtDate time2"));
//    	System.out.println(request.getParameter("price"));
    	news.setPrice(Double.parseDouble(request.getParameter("price")));
//    	type=type.replaceAll(",", "");
//    	System.out.println("editNews-type:"+type);
    	if(type.equals("1")){//保存
    		System.out.print("草稿");
    		news.setState("草稿");
    	}else{//发送
    		System.out.print("发送");
			news.setState("未审核");
		}
        newsService.updateNews(news);
        return "redirect:/editor/getDraft"; 
    }

    @RequestMapping("/getNewsToEdit")
    public String getNewsToEdit(Long newsId,HttpServletRequest request){
//    	System.out.println("getNewsToEdit-newsId:"+newsId);
    	News news=newsService.getNews(newsId);
        request.getSession().setAttribute("news",news);
        return "editor_rr_edit";
    }

    @RequestMapping("/delNews")
    public String delNews(String type,Long newsId,HttpServletRequest request){
        newsService.delNews(newsId);
        if(type!=null&&type.equals("1")){//未通过
        	return "redirect:/editor/getUnexamined";
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

    //不通过
    @RequestMapping("/getUnPassed")
    public String getUnPassed(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
        request.setAttribute("RRLIST",newsService.getUnPassedNewsByEditorName(user.getName()));
        return "editor_rr_2";
    }

    //已通过
    @RequestMapping("/getPassed")
    public String getPassed(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
        request.setAttribute("RRLIST",newsService.getPassedNewsByEditorName(user.getName()));
        return "editor_rr_3";
    }
    
    @RequestMapping(value="getDraft")
    public String getDraft(HttpServletRequest request){
    	User user=(User)request.getSession().getAttribute("user");
    	request.setAttribute("RRLIST",newsService.getDraftByEditorName(user.getName()));
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
    public String search(String type,HttpServletRequest request) throws ParseException{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
    	User user=(User)request.getSession().getAttribute("user");
    	String newsType=request.getParameter("category");
    	String startTime=request.getParameter("onShowTime");
    	String endTime=request.getParameter("offShowTime");
    	String newsName=request.getParameter("RRname");
    	if(type.equals("1")){
        	request.setAttribute("RRLIST",newsService.getNewsByUserIdAndTimespace(user.getId(),
        			newsType, sdf.parse(startTime), sdf.parse(endTime), newsName, "未审核"));
        	return "editor_rr_1";
    	}
    	else if(type.equals("2")){
        	request.setAttribute("RRLIST",newsService.getNewsByUserIdAndTimespace(user.getId(),
        			newsType, sdf.parse(startTime), sdf.parse(endTime), newsName, "审核不通过"));
        	return "editor_rr_2";
    	}
    	else if(type.equals("3")){
        	request.setAttribute("RRLIST",newsService.getNewsByUserIdAndTimespace(user.getId(),
        			newsType, sdf.parse(startTime), sdf.parse(endTime), newsName, "审核通过"));
        	return "editor_rr_3";
    	}
    	else{
        	request.setAttribute("RRLIST",newsService.getNewsByUserIdAndTimespace(user.getId(),
        			newsType, sdf.parse(startTime), sdf.parse(endTime), newsName, "草稿"));
        	return "editor_rr_4";
    	}
    }
}
