package cn.edu.xmu.oneonezero.view;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import cn.edu.xmu.oneonezero.entity.CommodityArtwork;
import cn.edu.xmu.oneonezero.entity.CommodityArtworkOrder;
import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;
import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;
import cn.edu.xmu.oneonezero.entity.DataDictionary;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.ArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkOrderService;
import cn.edu.xmu.oneonezero.service.DataDictionaryService;
import cn.edu.xmu.oneonezero.service.UserService;
/**
 * 艺术家
 * @author DELL
 *
 */
@Controller
@RequestMapping("artist")
public class ArtistController {
	@Resource(name = "userService")
	private UserService userService;

	@Resource(name = "dataDictionaryService")
	private DataDictionaryService dataDictionaryService;

	@Resource(name = "commodityArtworkService")
	private CommodityArtworkService commodityArtworkService;

	@Resource(name = "commodityArtworkOrderService")
	private CommodityArtworkOrderService commodityArtworkOrderService;

	@Resource(name = "customizedArtworkOrderService")
	private CustomizedArtworkOrderService customizedArtworkOrderService;

	@Resource(name = "artworkOrderService")
	private ArtworkOrderService artworkOrderService;

	/**
	 * 申请成为艺术家
	 * @param filedata
	 * @param request
	 * @return String
	 */
	@RequestMapping("/artistApply")
	public String artistApply(
			@RequestParam(value = "img", required = false) MultipartFile filedata,
			HttpServletRequest request) {
		String path = CommonMethod.getPicUrl(request);
		User user = (User) request.getSession().getAttribute("user");
		user.setBankCardAccount(request.getParameter("account"));
		DataDictionary dataDictionary = dataDictionaryService
				.getDataDictionaryByName("预备艺术家");
		user.setRole(dataDictionary);
		user.setRealName(request.getParameter("realname"));
		user.setDescription(request.getParameter("intro"));

		String picurl = PicUpload.saveFile(filedata, path);
		user.setIdPhoto(picurl);

		userService.updateUser(user);
		request.getSession().setAttribute("user", user);
		return "redirect:/init/home";
	}

	/**
	 * 我的艺术品
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/myArt")
	public String myArtWork(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("commodityArtworkList", commodityArtworkService
				.getCommodityArtworksByArtistId(user.getId()));
		return "artist_shop";
	}

	/**
	 * 我的成品订单
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/mySale")
	public String mySale(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("orderList", commodityArtworkOrderService
				.getCommodityArtworkOrdersByArtistId(user.getId()));
		return "artist_saleorder";
	}

	/**
	 * 我的订制品订单
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("myCustomized")
	public String myCustomized(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("orderList", customizedArtworkOrderService
				.getCustomizedArtworkOrdersByOwnerId(user.getId()));
		return "artist_customizedorder";
	}

	/**
	 * 进入编辑或添加艺术品界面
	 * @param itemId 艺术品id
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/goToEditOrAdd")
	public String goToEdit(Long itemId, HttpServletRequest request) {
		if (itemId != null) {
			CommodityArtwork commodityArtwork = commodityArtworkService
					.getCommodityArtworkById(itemId);
			request.setAttribute("item", commodityArtwork);
		}
		request.setAttribute("TYPELIST",
				dataDictionaryService.getAllArtworkTypes());
		return "artwork_edit";
	}

	/**
	 * 订制品订单详情
	 * @param type 1：艺术家查看订制品订单详情 0：用户查看订制品订单详情
	 * @param orderId 订单id
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("customizedorderDetail")
	public String customizedorderDetail(String type,Long orderId, HttpServletRequest request) {
		request.setAttribute("order", customizedArtworkOrderService
				.getCustomedArtworkOrderByOrderId(orderId));
		if(type.equals("1"))
		return "artist_customizedorder_detail";
		else {
			return "user_customizedorder_detail";
		}
	}

	/**
	 * 编辑或添加艺术品
	 * @param filedata 文件数据
	 * @param itemId 艺术品id
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("/editOrAddArtwork")
	public String editOrAddArtwork(
			@RequestParam(value = "img", required = false) MultipartFile filedata,
			Long itemId, HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		String path = CommonMethod.getPicUrl(request);
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		DataDictionary dataDictionary = dataDictionaryService
				.getDataDictionaryByName(type);
		String model = request.getParameter("select2");
		boolean canSell;
		if (model.equals("1"))
			canSell = false;
		else {
			canSell = true;
		}
		String price = request.getParameter("price");
		if (price == null || price.equals(""))
			price = "0";
		String description = request.getParameter("description");
		if (itemId == null) {
			CommodityArtwork commodityArtwork = new CommodityArtwork();
			String picUrl = PicUpload.saveFile(filedata, path);
			commodityArtwork.setPicUrl(picUrl);
			commodityArtwork.setName(name);
			commodityArtwork.setType(dataDictionary);
			commodityArtwork.setCanSell(canSell);
			commodityArtwork.setPrice(Double.parseDouble(price));
			commodityArtwork.setArtworkDescription(description);
			commodityArtwork.setIsExist(true);
			commodityArtwork.setSellState(true);
			commodityArtwork.setOwner(user);
			commodityArtworkService.insertCommodityArtwork(commodityArtwork);
		} else {
			CommodityArtwork commodityArtwork = commodityArtworkService
					.getCommodityArtworkById(itemId);

			if (filedata != null&& !filedata.isEmpty()) {
				String picUrl = PicUpload.saveFile(filedata, path);
				System.out.println("测试编辑：" + picUrl);
				if (commodityArtwork.getPicUrl() != null) {
					String temp = (commodityArtwork.getPicUrl()).replaceAll(
							"../attached", "");
					PicUpload.deleteFile(temp, path);
				}
				commodityArtwork.setPicUrl(picUrl);
			}
			
			commodityArtwork.setName(name);
			commodityArtwork.setType(dataDictionary);
			commodityArtwork.setCanSell(canSell);
			commodityArtwork.setPrice(Double.parseDouble(price));
			commodityArtwork.setArtworkDescription(description);
			commodityArtworkService.updateCommodityArtwork(commodityArtwork);
//			System.out.println("测试编辑：" + picUrl);
		}
		return "redirect:/artist/myArt";
	}

	/**
	 * 删除艺术品
	 * @param itemId 艺术品id 
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("delArtwork")
	public String delArtwork(Long itemId, HttpServletRequest request) {
		System.out.println("commodityArtworkOrderService=" + itemId);
		commodityArtworkService.setCommodityArtworkIsExistByArtworkId(itemId,
				false);
		return "redirect:/artist/myArt";
	}

	/**
	 * 发货
	 * @param orderId 订单id
	 * @param type 1：进入订制品订单界面 0：进入制成品订单界面
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("deliverGoods")
	public String deliverGoods(Long orderId,String type, HttpServletRequest request) {
		artworkOrderService.updateArtworkOrderState(orderId,
				"已支付未收货");
		if(type.equals("1"))
		return "redirect:/artist/mySale";
		else
		return "redirect:/artist/myCustomized";
	}

	/**
	 * 艺术家接受订单
	 * @param orderId 订单id
	 * @param type 0：接受 1：拒绝
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("isAccept")
	public String isAccept(Long orderId, String type, HttpServletRequest request) {
		if (type.equals("0")) {// 接受
			CustomizedArtworkOrder customizedArtworkOrder = customizedArtworkOrderService
					.getCustomedArtworkOrderByOrderId(orderId);
			String start = request.getParameter("price1");
			String mid = request.getParameter("price2");
			String end = request.getParameter("price3");
			if (start != null) {
				customizedArtworkOrder.setStartPrice(Double.parseDouble(start));
			}
			if (mid != null) {
				customizedArtworkOrder.setMidPrice(Double.parseDouble(mid));
			}
			if (end != null) {
				customizedArtworkOrder.setEndPrice(Double.parseDouble(end));
			}
			customizedArtworkOrder.setIsAccept("1");
			customizedArtworkOrderService
					.updateCustomizedArtworkOrder(customizedArtworkOrder);
			request.setAttribute("order", customizedArtworkOrder);
			return "artist_customizedorder_detail";
		} else {// 拒绝
			artworkOrderService.setArtworkOrderIsAccept(orderId,"0");
			return "redirect:/artist/myCustomized";
		}
	}

	/**
	 * 进入上传订制品小样界面
	 * @param orderId 订单id
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("goToPicUp")
	public String goToPicUp(Long orderId, HttpServletRequest request) {
		request.setAttribute("orderId", orderId);
		return "customized_picupload";
	}

	/**
	 * 订制品小样上传
	 * @param filedata 文件数据
	 * @param orderId 订单id
	 * @param request 请求
	 * @return String
	 */
	@RequestMapping("picUpload")
	public String picUpload(
			@RequestParam(value = "img", required = false) MultipartFile filedata,
			Long orderId, HttpServletRequest request) {
		CustomizedArtworkOrder customizedArtworkOrder = customizedArtworkOrderService
				.getCustomedArtworkOrderByOrderId(orderId);
		CustomizedArtwork customizedArtwork = customizedArtworkOrder
				.getCustomizedArtwork();

		String path = CommonMethod.getPicUrl(request);
		String picurl = PicUpload.saveFile(filedata, path);

		String period = request.getParameter("period");
		if (period.equals("1")) {
			customizedArtwork.setStartImg(picurl);
		} else if (period.equals("2")) {
			customizedArtwork.setMidImg(picurl);
		} else {
			customizedArtwork.setEndImg(picurl);
		}
		customizedArtworkOrder.setCustomizedArtwork(customizedArtwork);
		customizedArtworkOrderService
				.updateCustomizedArtworkOrder(customizedArtworkOrder);
		request.setAttribute("order", customizedArtworkOrder);
		return "artist_customizedorder_detail";
	}
}
