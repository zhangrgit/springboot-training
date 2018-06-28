package com.rz.web;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class SessionController {

	@RequestMapping("/uid")
	@ResponseBody
	public String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
//		System.out.println(session.getAttribute("uid"));
		return session.getId();
	}

	@RequestMapping("/")
	public String i18n() {
		return "i18n";
	}

	@RequestMapping("/changeSessionLanauage")
	public String changeSessionLanauage(HttpServletRequest request, HttpServletResponse response, String lang) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		if ("zh".equals(lang)) {
			localeResolver.setLocale(request, response, new Locale("zh", "CN"));
		} else if ("en".equals(lang)) {
//			localeResolver.setLocale(request, response, new Locale("en", "US"));
			localeResolver.setLocale(request, response, Locale.US);
		}
		return "redirect:/";
	}
}
