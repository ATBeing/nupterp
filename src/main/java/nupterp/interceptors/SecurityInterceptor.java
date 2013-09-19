package nupterp.interceptors;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nupterp.pageModel.SessionInfo;
import nupterp.util.ConfigUtil;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 权限拦截器
 */
public class SecurityInterceptor implements HandlerInterceptor {

	private List<String> excludeUrls;// 不需要拦截的资源

	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	/**
	 * 完成页面的render后调用
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
			Exception exception) throws Exception {

	}

	/**
	 * 在调用controller具体方法后拦截
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在调用controller具体方法前拦截
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
			throws Exception {


		String requestUri = request.getRequestURI();// 返回的是包括项目名称的路径，但是没有http这类的地址
		String contextPath = request.getContextPath();// 返回的是项目名称
		
	    String url = requestUri.substring(contextPath.length());// 从项目名称的长度截取剩下的字符串，最终得到资源路径
	    
	    if(url.contains(contextPath)){//remove contextPath
	    	url = url.replaceFirst(contextPath, "");
	    }//此后的requestUri就可以按照正常逻辑来判断了
	    
	    
	    request.setAttribute("requestUri", requestUri);
		request.setAttribute("contextPath", contextPath);
		request.setAttribute("url", url);
	    
		/**
		 * 新浪的实验结果 
		 * <% out.print(request.getAttribute("requestUri"));%> <br>
		 * <% out.print(request.getAttribute("contextPath"));%> <br>
		 * <% out.print(request.getAttribute("url"));%> <br>
		 * 
		 * 下面是页面返回的结果 /userController/login <br>
		 * /1/nyerp <br>
		 * troller/login <br>
		 */
//		if (url.indexOf("/baseController/") > -1 || excludeUrls.contains(requestUri)) {// 如果要访问的资源是不需要验证的
//			return true;
//		}

		 if (url.indexOf("/baseController/") > -1 || excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			 return true;
		 }

		SessionInfo sessionInfo = (SessionInfo) request.getSession().getAttribute(
				ConfigUtil.getSessionInfoName());
		if (sessionInfo == null || sessionInfo.getId().equalsIgnoreCase("")) {// 如果没有登录或登录超时
			request.getRequestDispatcher("/error/noSession.jsp").forward(request, response);
			return false;
		}

		if (!sessionInfo.getName().equals("admin")) {// 如果当前用户没有访问此资源的权限
			request.setAttribute("msg", "您没有访问此资源的权限！<br/>请联系超管赋予您<br/>[" + url + "]<br/>的资源访问权限！");
			request.getRequestDispatcher("/error/noAuth.jsp").forward(request, response);
			return false;
		}

		return true;
	}
}
