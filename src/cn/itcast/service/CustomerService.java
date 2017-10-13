package cn.itcast.service;

import java.util.List;

import cn.itcast.pojo.Customer;
import cn.itcast.pojo.CustomerQueryVo;

public interface CustomerService {
	
	// ���ݲ�ѯ������ѯ�ͻ���Ϣ
	public List<Customer> findCustomerByQueryVo(CustomerQueryVo vo) throws Exception;
	// ���ݲ�ѯ������ѯ�ͻ���Ϣ�ܼ���
	public Integer findCustomerByQueryVoCount(CustomerQueryVo vo) throws Exception;
	
	// ����id��ѯ�ͻ���Ϣ
	public Customer findCustomerById(Long id) throws Exception;
	
	// ����id���¿ͻ���Ϣ
	public void updateCustomerById(Customer cust) throws Exception;
	
	// ����idɾ���ͻ���Ϣ
	public void deleteCustomerById(Long id) throws Exception;

}
