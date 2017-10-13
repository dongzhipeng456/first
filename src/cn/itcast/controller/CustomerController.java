package cn.itcast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.pojo.BaseDict;
import cn.itcast.pojo.Customer;
import cn.itcast.pojo.CustomerQueryVo;
import cn.itcast.service.CustomerService;
import cn.itcast.service.DictService;
import cn.itcast.utils.Page;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	private DictService dictService;
	
	@Autowired
	private CustomerService custService;
	
	/**
	 * ���������ʾ
	 */
	@RequestMapping("/list")
	public String getCustomerList(CustomerQueryVo vo, Model model) throws Exception {
		
		// ���get�ύ��������
		if (vo != null) {
			String custName = vo.getCustName();
			if (custName != null && !"".equals(custName)) {
				vo.setCustName(new String(custName.getBytes("iso8859-1"), "utf-8"));
			}
		}
		
		// ���㵱ǰҳ�Ŀ�ʼ�к�
		if (vo.getPage() <= 1) {
			vo.setStart(0);
		} else {
			vo.setStart((vo.getPage() - 1) * vo.getSize());
		}
		
		// ���ݲ�ѯ������ѯ�ͻ���Ϣ
		List<Customer> custList = custService.findCustomerByQueryVo(vo);
		Integer totalCount = custService.findCustomerByQueryVoCount(vo);
		
		
		// ������ҳ����page
		Page<Customer> page = new Page<Customer>();
		page.setPage(vo.getPage());
		page.setRows(custList);
		page.setSize(vo.getSize());
		page.setTotal(totalCount);
		
		// ����ҳ���󷵻ظ�ǰ̨
		model.addAttribute("page", page);
		// ��ѯ�����ı���
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	/**
	 * ����id��ѯ�ͻ���Ϣ
	 */
	@RequestMapping("/toEdit")
	@ResponseBody
	public Customer getCustomerById(Long id) throws Exception {
		Customer customer = custService.findCustomerById(id);
		return customer;
	}
	
	/**
	 * ����id���¿ͻ���Ϣ
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateCustomerById(Customer cust) throws Exception {
		custService.updateCustomerById(cust);
		return "ok";
	}
	
	
	/**
	 * ����idɾ���ͻ���Ϣ
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteCustomerById(Long id) throws Exception {
		custService.deleteCustomerById(id);
		return "ok";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
