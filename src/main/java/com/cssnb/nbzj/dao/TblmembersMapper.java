package com.cssnb.nbzj.dao;

import java.util.List;

import com.cssnb.commons.domain.Page;
import com.cssnb.nbzj.entity.Tblmembers;



public interface TblmembersMapper {
	public void insertSelective(Tblmembers record);
	public Page<Tblmembers> selectAll();
	public List<Tblmembers> selectAll1();
	public Tblmembers selectById(Tblmembers member);
	public int count();
	public List<Tblmembers> selectByMember(Tblmembers member);
	public void deleteById(Tblmembers record);
	public void updateMember(Tblmembers record);
	public Tblmembers selectByName(Tblmembers member);
}
