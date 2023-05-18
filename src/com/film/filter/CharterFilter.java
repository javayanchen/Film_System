package com.film.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @description:  value="/*"-过滤路径=过滤整个程序，所有资源， initParams = {@WebInitParam(name="encoding", value = "utf8"),@WebInitParam(name="keyOne", value="keyOne")}
 * @param: null
 * @return:
 * @author lzl
 * @date: 2023/5/8 19:03
 */
@WebFilter(filterName = "CharterFilter", value = "/*",initParams = @WebInitParam(name="encoding",value = "utf-8"))
public class CharterFilter implements Filter {
	String encoding;
	public CharterFilter(){
		System.out.println("过滤器已经被创建");
	}
	public void init(FilterConfig config) throws ServletException {
		encoding=config.getInitParameter("encoding");
		System.out.println(encoding);
		System.out.println("过滤器开始初始化");
	}

	public void destroy() {
		System.out.println("过滤器已经被销毁");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		System.out.println("过滤器开始过滤");
		System.out.println("放行请求");
		request.setCharacterEncoding(encoding);
		//放行请求
		chain.doFilter(request,response);
		response.setCharacterEncoding(encoding);
		System.out.println("服务器响应");
	}
}
