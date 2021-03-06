package cn.edu.xmu.oneonezero.view;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cn.edu.xmu.oneonezero.entity.CustomizedArtwork;
import cn.edu.xmu.oneonezero.entity.CustomizedArtworkOrder;
import cn.edu.xmu.oneonezero.entity.User;
import cn.edu.xmu.oneonezero.service.AccountService;
import cn.edu.xmu.oneonezero.service.ArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CommodityArtworkOrderService;
import cn.edu.xmu.oneonezero.service.CustomizedArtworkOrderService;
import cn.edu.xmu.oneonezero.service.UserService;

/**
 * 普通用户
 * @author DELL
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name = "commodityArtworkOrderService")
	private CommodityArtworkOrderService commodityArtworkOrderService;
	@Resource(name = "customizedArtworkOrderService")
	private CustomizedArtworkOrderService customizedArtworkOrderService;
	@Resource(name = "accountService")
	private AccountService accountService;
	@Resource(name = "userService")
	private UserService userService;
	@Resource(name="artworkOrderService")
	private ArtworkOrderService artworkOrderService;

	/**
	 * 我的制成品订单
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/myOrder")
	public String myOrder(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("orderList", commodityArtworkOrderService
				.getCommodityArtworkOrdersByUserId(user.getId()));
		return "user_order";
	}

	/**
	 * 我的定制订单
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/myCustomized")
	public String myCustomized(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		request.setAttribute("orderlist", customizedArtworkOrderService
				.getCustomizedArtworkOrdersByUserId(user.getId()));
		return "user_customizedorder";
	}

	/**
	 * 进入订单支付界面
	 * @param orderId 订单id
	 * @param type 1：制成品支付 0：订制品支付
	 * @param stage 订单状态
	 * @param total 订单总价
	 * @param request 
	 * @return String
	 * @throws UnsupportedEncodingException 编码异常
	 */
	@RequestMapping("/goToOrderPay")
	public String goToOrderPay(Long orderId, String type, String stage,String total,
			HttpServletRequest request) throws UnsupportedEncodingException {
		request.setAttribute("total",total);
		request.setAttribute("picUrl", "/test_ssh/user/myOrderPayment?orderId="
				+ orderId + "&type=" + type + "&stage=" + new String(stage.getBytes("ISO-8859-1"),"UTF-8"));
		return "payment_login";
	}

	/**
	 * 订单支付
	 * @param orderId 订单id
	 * @param type 1：制成品支付 0：订制品支付
	 * @param stage 订单状态
	 * @param request 
	 * @return String
	 * @throws UnsupportedEncodingException 编码异常
	 */
	@RequestMapping("/myOrderPayment")
	public String myOrderPayment(Long orderId, String type, String stage,
			HttpServletRequest request) throws UnsupportedEncodingException {
		String total = request.getParameter("price");
		String name = request.getParameter("username");
		String psw = request.getParameter("psw");
		int pay = accountService.payMoney(name, psw, Double.parseDouble(total));
		if (pay == 1) {
			if (type.equals("1")) {
				commodityArtworkOrderService.updateCommodityArtworkOrderState(
						orderId, "已支付未发货");
			} else {
//				System.out.println("!null:" + new String(stage.getBytes("ISO-8859-1"),"UTF-8"));
				if (stage != null) {
//					System.out.println("null:" + stage);
					customizedArtworkOrderService
							.updateCustomizedArtworkOrderStage(orderId, new String(stage.getBytes("ISO-8859-1"),"UTF-8"));
				}
			}
			return "pay_success";
		} else {
			request.setAttribute("result", pay);
			request.setAttribute("total", request.getParameter("total"));
			request.setAttribute("picUrl",
					"/test_ssh/user/myOrderPayment?orderId=" + orderId
							+ "&type=" + type + "&stage=" + new String(stage.getBytes("ISO-8859-1"),"UTF-8"));
			return "payment_login";
		}
	}

	/**
	 * 取消订单
	 * @param orderId 订单id
	 * @param type 1：进入我的制成品订单界面 0：进入我的订制品订单界面
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/cancelOrder")
	public String cancelOrder(Long orderId, String type,
			HttpServletRequest request) {
		System.out.println("取消订单"+orderId);
		artworkOrderService.cancelArtworkOrder(orderId);
		if (type.equals("1")) {
			return "redirect:/user/myOrder";
		} else {
			return "redirect:/user/myCustomized";
		}
	}

	/**
	 * 收货
	 * @param orderId 订单id
	 * @param type 1：进入我的制成品订单界面 0：进入我的订制品订单界面
	 * @param request 
	 * @return String
	 */
	@RequestMapping("/getItem")
	public String getItem(Long orderId, String type, HttpServletRequest request) {
		artworkOrderService.updateArtworkOrderState(orderId, "已支付已收货");
		if (type.equals("1")) {
			return "redirect:/user/myOrder";
		} else {
			return "redirect:/user/myCustomized";
		}
	}

	/**
	 * 修改个人信息
	 * @param filedata 文件数据
	 * @param request 
	 * @return String
	 */
	@RequestMapping("changeInfo")
	public String changeInfo(
			@RequestParam(value = "img", required = false) MultipartFile filedata,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		String path = CommonMethod.getPicUrl(request);

		if (filedata != null&& !filedata.isEmpty()) {
			if (user.getHeadPhoto() != null) {
				String temp = (user.getHeadPhoto()).replaceAll(
						"../attached", "");
				PicUpload.deleteFile(temp, path);
			}

			String picurl = PicUpload.saveFile(filedata, path);
			user.setHeadPhoto(picurl);
		}
		user.setNickName(request.getParameter("username"));
		user.setAddress(request.getParameter("address"));
		user.setMobile(request.getParameter("mobile"));
		user.setBankCardAccount(request.getParameter("card"));
		user.setDescription(request.getParameter("description"));
		userService.updateUser(user);
		return "redirect:/init/home";
	}
}
