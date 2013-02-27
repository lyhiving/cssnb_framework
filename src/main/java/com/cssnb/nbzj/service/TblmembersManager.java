package com.cssnb.nbzj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cssnb.commons.domain.Page;
import com.cssnb.commons.domain.PageRequest;
import com.cssnb.nbzj.dao.TblmembersDAO;
import com.cssnb.nbzj.dao.TblmembersMapper;
import com.cssnb.nbzj.entity.Tblmembers;
@Service
public class TblmembersManager {
	@Autowired
	private TblmembersMapper tblmembersMapper;
	@Autowired
	private TblmembersDAO tblmembersDAO;
	public void insertSelective(Tblmembers record){
		tblmembersMapper.insertSelective(record);
	}
	public Page<Tblmembers> selectAll(){
		return tblmembersMapper.selectAll();
	}
	public List<Tblmembers> selectAll1(){
		return tblmembersMapper.selectAll1();
	}
	public Page<Tblmembers> findByPage(PageRequest pageRequest) {
		return tblmembersDAO.findByPageRequest(pageRequest);
	}
	public void deleteById(Tblmembers record){
		tblmembersMapper.deleteById(record);
	}
	public List<Tblmembers> selectByMember(Tblmembers member){
		System.out.println(System.currentTimeMillis());
		return tblmembersMapper.selectByMember(member);
	}
	public Tblmembers selectById(Tblmembers member){
		return tblmembersMapper.selectById(member);
	}
	public void update(Tblmembers record){
		tblmembersMapper.updateMember(record);
	}
	public Tblmembers selectByName(Tblmembers member){
		return tblmembersMapper.selectByName(member);
	}
}
