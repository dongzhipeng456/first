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

		// �����б�����ݲ�ѯ
		String requestURI = request.getRequestURI();
		if ("/crm265/customer/list.action".equals(requestURI)
				|| "/crm265/customer/list2.action".equals(requestURI)
				|| "/crm265/customer/list3.action".equals(requestURI)
				|| "/crm265/customer/list4.action".equals(requestURI)
				|| "/crm265/customer/list5.action".equals(requestURI)) {
			// �ͻ���Դ
			List<BaseDict> custSourceList = dictService.findCodeInfoByTypeCode("002");
			
			// ������ҵ
			List<BaseDict> custIndustryList = dictService.findCodeInfoByTypeCode("001");
			
			// �ͻ�����
			List<BaseDict> custLevelList = dictService.findCodeInfoByTypeCode("006");

			// �������б�����ݷ��ظ�����
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
