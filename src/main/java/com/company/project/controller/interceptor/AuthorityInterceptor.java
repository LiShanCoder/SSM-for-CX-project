package com.company.project.controller.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.company.project.utils.ResourcesUtil;

public class AuthorityInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		System.out.println(
//		request.getRequestURL() +"\n"+
//		request.getRequestURI() +"\n"+
//		request.getContextPath() +"\n"+
//		request.getServletPath()
//			);

		// 用户请求的servlet地址
		String reqPath = request.getServletPath().substring(1);
		
		//一：匿名即可访问 (配置文件形式：anonymousURL.properties)
		List<String> anonymousURLs = ResourcesUtil.getkeyList("urlAccess/anonymousURL");
		if(isPermittedUrl(anonymousURLs, reqPath))
			return true;
		
		// 不是匿名访问url，且未登陆
		HttpSession session = request.getSession();
		if(session==null || session.getAttribute("account")==null) {
			request.setAttribute("error", "无访问权限");
			request.getRequestDispatcher("errPage.jsp").forward(request, response);
			return false;								
//			throw new Exception("请登陆后访问");
		}
		
		//二：登陆后可访问 (配置文件形式：commonURL.properties)
		List<String> commonURLs = ResourcesUtil.getkeyList("urlAccess/commonURL");
		if(isPermittedUrl(commonURLs, reqPath))
			return true;
		
		//三：授权后可访问 (从数据库中取出：人-角色-资源 模式 Resource based access control)
		//获取授权路径列表
		@SuppressWarnings("unchecked")
		List<String> rbac = (List<String>) session.getAttribute("urls");
		if(isPermittedUrl(rbac, reqPath))
			return true;
		
		//无权限访问当前页面，跳转到无权限提示
		request.setAttribute("error", "无访问权限");
		request.getRequestDispatcher("errPage.jsp").forward(request, response);
		return false;
//		throw new Exception("无访问权限");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}
	
	/**
	 * 注意：匹配规则列表中，正则字符串必须以"regex-"打头，后接正则规则
	 * @param checkList 匹配规则列表：全字符匹配，也可是正则匹配
	 * @param url 验证对象
	 * @return 验证结果
	 */
	private static boolean isPermittedUrl(List<String> checkList, String url) {
		List<String> urls = new ArrayList<String>();
		List<String> regexUrls = new ArrayList<String>();
		//把：equals全等、正则匹配，所需String分类
		for(String s : checkList) {
			if(s.startsWith("regex-"))
				regexUrls.add(s.substring(6));
			else
				urls.add(s);
		}
		//equals全等、正则匹配
		for(String s : urls) {
			if(s.equals(url))
				return true;
		}
		for(String regex : regexUrls) {
			if(Pattern.matches(regex, url))
				return true;
		}
		
		return false;
	}
	
}
