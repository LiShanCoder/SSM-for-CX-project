package com.company.project.unified;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.company.project.vo.JsonMsg;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UnifiedHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse resp, 
			Object obj, Exception ex) {
//		System.out.println("Exception: "+ex.getMessage());
		
		//登陆相关Exception
		if(ex instanceof Exception) {						
			try {
				//转成json串
				JsonMsg errorVo = new JsonMsg(false, ex.getMessage());
				String jsonStr = new ObjectMapper().writeValueAsString(errorVo);
				//响应json串
				resp.setContentType("application/json; charset=UTF-8");
				PrintWriter writer = resp.getWriter();
				writer.write(jsonStr);	
				writer.flush();									//使用resp.getWriter().println()，不flush()，造成500错误，会触发ajax.error:function(){}
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}else {
			//TODO 未发觉的错误，需后期处理
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forward:login.jsp");
		return modelAndView;
	}

}
