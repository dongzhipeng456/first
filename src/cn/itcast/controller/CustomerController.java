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
	 * 画面初期显示
	 */
	@RequestMapping("/list")
	public String getCustomerList(CustomerQueryVo vo, Model model) throws Exception {
		
		// 解决get提交乱码问题
		if (vo != null) {
			String custName = vo.getCustName();
			if (custName != null && !"".equals(custName)) {
				vo.setCustName(new String(custName.getBytes("iso8859-1"), "utf-8"));
			}
		}
		
		// 计算当前页的开始行号
		if (vo.getPage() <= 1) {
			vo.setStart(0);
		} else {
			vo.setStart((vo.getPage() - 1) * vo.getSize());
		}
		
		// 根据查询条件查询客户信息
		List<Customer> custList = custService.findCustomerByQueryVo(vo);
		Integer totalCount = custService.findCustomerByQueryVoCount(vo);
		
		
		// 创建分页对象page
		Page<Customer> page = new Page<Customer>();
		page.setPage(vo.getPage());
		page.setRows(custList);
		page.setSize(vo.getSize());
		page.setTotal(totalCount);
		
		// 将分页对象返回给前台
		model.addAttribute("page", page);
		// 查询条件的保持
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());
		
		return "customer";
	}
	
	/**
	 * 根据id查询客户信息
	 */
	@RequestMapping("/toEdit")
	@ResponseBody
	public Customer getCustomerById(Long id) throws Exception {
		Customer customer = custService.findCustomerById(id);
		return customer;
	}
	
	/**
	 * 根据id更新客户信息
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String updateCustomerById(Customer cust) throws Exception {
		custService.updateCustomerById(cust);
		return "ok";
	}
	
	
	/**
	 * 根据id删除客户信息
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String deleteCustomerById(Long id) throws Exception {
		custService.deleteCustomerById(id);
		return "ok";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
