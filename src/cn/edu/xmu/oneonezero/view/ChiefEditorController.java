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
    public String getNews(long newsId,HttpServletRequest request){
        request.setAttribute("RR",newsService.getNews(newsId));
        return "chiefEditor_checks";
    }

    @RequestMapping(value="/examineNews",method=RequestMethod.GET)
    public String examineNews(News news,String type,HttpServletRequest request){
        if(type.equals("1")) {
        	news.setIsExamined(true);
        	news.setIsPassed(true);
            newsService.updateNews(news);
            request.getSession().setAttribute("news", news);//TODO 点击通过时设置是否合理
            return "chiefEditor_rr_edit";
        }
        else {
            news.setIsExamined(true);
            news.setIsPassed(false);
            newsService.updateNews(news);
            return "chiefEditor_rr_2";
        }
    }

    @RequestMapping(value="/setNews",method=RequestMethod.POST)
    public String setNews(HttpServletRequest request){
    	News news=(News) request.getSession().getAttribute("news");
        news.setRank(request.getParameter("rank"));
        news.setOnShowTime(request.getParameter("txtDate"));
        newsService.updateNews(news);
        return "redirect:/chiefEditor/getAllExamined";
    }

<<<<<<< HEAD
    @RequestMapping("/getExamined")
    public String getExamined(HttpServletRequest request){
=======
    @RequestMapping("/getAllExamined")
    public String getAllExamined(HttpServletRequest request){
>>>>>>> origin/master
        request.setAttribute("examineNewsList", newsService.getExaminedNews());
        return "chiefEditor_rr_2";
    }
    @RequestMapping("/getExaminedByNewsName")
    public String getExaminedByNewsName(HttpServletRequest request){
        request.setAttribute("examineNewsList", newsService.getExaminedNewsByName(request.getParameter("RRname")));
        return "chiefEditor_rr_2";
    }

<<<<<<< HEAD
    @RequestMapping("/getUnexamined")
    public String getUnexamined(HttpServletRequest request){
=======
    @RequestMapping("/getAllUnreviewed")
    public String getAllUnreviewed(HttpServletRequest request){
>>>>>>> origin/master
        request.setAttribute("RRLIST",newsService.getUnexaminedNews());
        return "chiefEditor_rr_1";
    }

<<<<<<< HEAD
    @RequestMapping("/getUnexaminedByNewsName")
    public String getUnexaminedByNewsName(HttpServletRequest request){
=======
    @RequestMapping("/getUnreviewedByNewsName")
    public String getUnreviewedByNewsName(HttpServletRequest request){
>>>>>>> origin/master
        request.setAttribute("RRLIST",newsService.getUnexaminedNewsByName(request.getParameter("RRname")));
        return "chiefEditor_rr_1";
    }
}
