package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Customer;
import cn.itcast.pojo.CustomerQueryVo;

public interface CustomerService {
	
	// 根据查询条件查询客户信息
	public List<Customer> findCustomerByQueryVo(CustomerQueryVo vo) throws Exception;
	// 根据查询条件查询客户信息总件数
	public Integer findCustomerByQueryVoCount(CustomerQueryVo vo) throws Exception;
	
	// 根据id查询客户信息
	public Customer findCustomerById(Long id) throws Exception;
	
	// 根据id更新客户信息
	public void updateCustomerById(Customer cust) throws Exception;
	
	// 根据id删除客户信息
	public void deleteCustomerById(Long id) throws Exception;

}
