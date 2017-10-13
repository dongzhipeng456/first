package cn.itcast.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.pojo.BaseDict;
import cn.itcast.service.DictService;

public class Interceptor1 implements HandlerInterceptor {
	@Autowired
	private DictService dictService;

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse arg1, Object arg2, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub

		// 下拉列表的内容查询
		String requestURI = request.getRequestURI();
		if ("/crm265/customer/list.action".equals(requestURI)
				|| "/crm265/customer/list2.action".equals(requestURI)
				|| "/crm265/customer/list3.action".equals(requestURI)
				|| "/crm265/customer/list4.action".equals(requestURI)
				|| "/crm265/customer/list5.action".equals(requestURI)) {
			// 客户来源
			List<BaseDict> custSourceList = dictService.findCodeInfoByTypeCode("002");
			
			// 所属行业
			List<BaseDict> custIndustryList = dictService.findCodeInfoByTypeCode("001");
			
			// 客户级别
			List<BaseDict> custLevelList = dictService.findCodeInfoByTypeCode("006");

			// 将下拉列表的内容返回给画面
			modelAndView.addObject("fromType", custSourceList);
			modelAndView.addObject("industryType", custIndustryList);
			modelAndView.addObject("levelType", custLevelList);
			
		}

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
