/**
 * 
 */

if (document.location.search.match(/type=embed/gi)) {
  window.parent.postMessage('resize', "*");
}
function add2Cart(index,self,event) {
	$.ajax({
		type : "POST",
		data : {
			"itemId" : index
		},
		dataType : "text",
		url : "/test_ssh/cart/add2Cart",
		success : function(data) {
			//alert("添加成功！");
			var offset = $('#end').offset(), flyer = $('<img width="5%" class="u-flyer" src="../images/mengna.jpg"/>');
			flyer.fly({
			    start: {
			        left: event.clientX,
			        top: event.clientY
			    },
			    end: {
			        left: offset.left,
			        top: offset.top-$(window).scrollTop(),
			        width: 20,
			        height: 20
			    }
			});
		},
		error : function(e) {
			alert("添加失败！");
			
		}
	});

}

$(function() {
	$("#slider").responsiveSlides({
		auto : true,
		nav : false,
		speed : 500,
		namespace : "callbacks",
		pager : true,
	});
});
$(function() {
	$("#updown").css("top", window.screen.availHeight / 2 - 100 + "px");
	$(window).scroll(function() {
		if ($(window).scrollTop() >= 100) {
			$('#updown').fadeIn(300);
			
		} else {
			$('#updown').fadeOut(300);
		}
		$('#end').fadeIn(100);
	});
	$('#updown .up').click(function() {
		$('html,body').animate({
			scrollTop : '0px'
		}, 800);
	});
	$('#updown .down').click(function() {
		$('html,body').animate({
			scrollTop : document.body.clientHeight + 'px'
		}, 800);
	});
});