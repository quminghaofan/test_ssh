


import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.xmu.oneonezero.dao.AccountDao;
import cn.edu.xmu.oneonezero.dao.ArtworkDao;
import cn.edu.xmu.oneonezero.dao.ArtworkOrderDao;
import cn.edu.xmu.oneonezero.dao.CommodityArtworkDao;
import cn.edu.xmu.oneonezero.dao.CommodityArtworkOrderDao;
import cn.edu.xmu.oneonezero.dao.CustomizedArtworkOrderDao;
import cn.edu.xmu.oneonezero.dao.DataDictionaryDao;
import cn.edu.xmu.oneonezero.dao.NewsDao;
import cn.edu.xmu.oneonezero.dao.UserDao;
import cn.edu.xmu.oneonezero.entity.Account;
import cn.edu.xmu.oneonezero.entity.Artwork;
import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;
import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.News;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.ArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkService;
import cn.edu.xmu.oneonezero.service.NewsService;
import cn.edu.xmu.oneonezero.service.UserService;

@ContextConfiguration(locations={"classpath*:config/spring/spring-beans.xml","classpath*:config/spring/spring-hibernate.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration()
@Transactional
public class Test {
	
	@Autowired
	private CommodityArtworkDao commodityArtworkDao;
	
	@Resource
	private UserService userService;
	
	@Autowired
	private NewsDao newsDao;
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private ArtworkOrderDao artworkOrderDao;
	
	@Autowired
	private ArtworkDao artworkDao;
	
	@Resource
	private ArtworkOrderService artworkOrderService;
	
	@Autowired
	private DataDictionaryDao d;
	
	@Resource
	private NewsService nService;
	
	@Autowired
	private CommodityArtworkDao commodityArtDao;
	
	@Autowired
	private CustomizedArtworkOrderDao cusOrderDao;

	@Resource
	private CommodityArtworkService commodityArtworkService;
	
	@Resource
	private CustomizedArtworkService customizedArtworkService;
	
	@Resource
	private CustomizedArtworkOrderService customizedArtworkOrderService;
	
	@Resource
	private CommodityArtworkOrderDao commodityArtworkOrderDao;
	
	@Resource
	private CommodityArtworkOrderService  commodityArtworkOrderService;
	
	@Resource
	private AccountDao accountDao;
	
	@org.junit.Test
	@Rollback(false)
	public void test()
	{
		
		Calendar cal1=Calendar.getInstance();
		Calendar cal2=Calendar.getInstance();
		cal1.set(2017,1,1);
		cal2.set(2016,1,1);
		
		Date d1=cal1.getTime();
		Date d2=cal2.getTime();
		
		java.sql.Date dateSql=new java.sql.Date(d1.getTime());
		java.sql.Date dateSql1=new java.sql.Date(d1.getTime());
		java.sql.Date dateSql2=new java.sql.Date(d2.getTime());
		
		System.out.println(commodityArtworkOrderDao.getByOrderId("", "", dateSql1, null).size());
//		System.out.println(newsDao.getNewsByEditorIdAndTimespace(1, null, dateSql1, dateSql2, "", "未审核").size());
	}

}
