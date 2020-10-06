package com.ace.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // <annotation-driven/> 을 사용하였기 때문에 사용 가능.
public class HomeController {

	// 이 클래스에서 사용할 로그 작성기.
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		// logger를 이용하여 info 수준의 로그 출력.
		logger.info("Welcome home! The client locale is {}.", locale);
		// Date 객체 생성 - 오늘 날짜, 시간.
		Date date = new Date();
		// 날짜 출력 포멧 만들기 위한 DateFormat 객체 생성. SimpleDateFormat
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		// date를 포맷에 맞는 문자열로 만듬.
		String formattedDate = dateFormat.format(date);
		// Model 객체에 serverTime 이라는 속성으로 날짜 문자열 붙여줌.
		model.addAttribute("serverTime", formattedDate);
		// model 달고 /WEB-INF/views/home.jsp로 이동 -> DispatcherServlet이 하는 일.
		return "home";
	}

}
