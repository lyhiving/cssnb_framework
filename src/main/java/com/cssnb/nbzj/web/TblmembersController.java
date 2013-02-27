package com.cssnb.nbzj.web;

import java.lang.reflect.Field;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.cssnb.commons.domain.JqgridPage;
import com.cssnb.commons.domain.JqgridResponse;
import com.cssnb.commons.domain.Page;
import com.cssnb.commons.domain.PageRequest;
import com.cssnb.nbzj.entity.Tblmembers;
import com.cssnb.nbzj.service.TblmembersManager;
import com.cssnb.nbzj.utils.PageRequestUtils;

@RequestMapping("/tbl/members")
@Controller
public class TblmembersController {
	private static final Logger logger = LoggerFactory.getLogger(YgController.class);
    
	@Autowired
	private TblmembersManager tblmembersManager;
	@RequestMapping(value="list")
	public String list(Model mode,Tblmembers member){
		logger.info("Welcome yg index! ");
		long i=System.currentTimeMillis();
		System.out.println(i);
		List<Tblmembers> list=tblmembersManager.selectByMember(member);
		long j=System.currentTimeMillis();
		System.out.println(j);
//		Page<Tblmembers> list=tblmembersManager.selectAll();
//		System.out.println("***********");
		mode.addAttribute("list", list);
		System.out.println(j-i);
		return "tbl/member_list1";
	}
//	@RequestMapping(value="add")
//	public String addMember(Tblmembers member){
//		System.out.println(member.getName());
//		tblmembersManager.insertSelective(member);
//		return "redirect:/tbl/members/list";
//	}
//	@RequestMapping(value="delete")
//	public String delete(Tblmembers record){
//		tblmembersManager.deleteById(record);
//		return "redirect:/tbl/members/list";
//	}
	@RequestMapping(value="member")
	public String insert(){
		return "example/hjqy_new";
	}
//	@RequestMapping(value="show")
//	public String show(Tblmembers members,Model mode){
//		Tblmembers member=tblmembersManager.selectById(members);
//		mode.addAttribute("member", member);
//		return "tbl/member_update";
//	}
	@RequestMapping(value="update")
	public String update(Tblmembers member){
		tblmembersManager.update(member);
		return "redirect:/tbl/members/list";
	}
	@RequestMapping(value="form")
	public @ResponseBody Tblmembers form(Tblmembers member,Model model){
		int id=member.getId();
		System.out.println(id);
		if(id>0){
			tblmembersManager.update(member);
			return member;
		}else{
			tblmembersManager.insertSelective(member);
			List<Tblmembers> list=tblmembersManager.selectByMember(member);
			member=list.get(0);
			return member;
		}
	}
	@RequestMapping( value = "delete")
	public @ResponseBody Tblmembers delete(@RequestParam(value="id") String id, Model model) {
		 int id1=Integer.parseInt(id);
		 System.out.println(id);
		 Tblmembers member=new Tblmembers();
		 member.setId(id1);
		 tblmembersManager.deleteById(member);
		 return member;
	 }
	@RequestMapping(value = "show")
	public @ResponseBody Tblmembers show(@RequestParam(value="id") String id, Model model) throws Exception {
		 int id1=Integer.parseInt(id);
		 System.out.println(id);
		 Tblmembers member=new Tblmembers();
		 member.setId(id1);
		 member=tblmembersManager.selectById(member);
		 return member;
//		 response.reset();
//		 response.setContentType("text/html;charset=utf-8");
//		 PrintWriter pw = response.getWriter();
//		 pw.print(member);
//		 System.out.println(member.getName());
//		 pw.flush();
//		 pw.close(); 
	 }
	@RequestMapping(value = "check")
	public @ResponseBody boolean check(@RequestParam(value="name") String name){
		Tblmembers member=new Tblmembers();
		member.setName(name);
		member=tblmembersManager.selectByName(member);
		if(member!=null){
			return false;
		}else{
			return true;
		}
	}
	@RequestMapping(value = "automatic")
	public String member(Model model,Tblmembers member,HttpServletRequest request){
		Field[] fields=member.getClass().getDeclaredFields();
		fields[1].setAccessible(true);
		for(int i=0;i<fields.length;i++){
			fields[i].setAccessible(true);
		}
		model.addAttribute("fields", fields);
//		request.setAttribute("fields", fields);
		return "automatic/automatic_form";
	}
	@RequestMapping(value="list2")
	public @ResponseBody JqgridResponse<Tblmembers> jqlist(WebRequest request,JqgridPage jqpage,  Model model) {
		logger.info("Welcome yg list2! ");
		//PageRequest pageRequest = PageRequestUtils.newJqgridPageRequest(jqpage);
		PageRequest pageRequest = PageRequestUtils.newPageRequest(request,jqpage);
//		Page<Tblmembers> tblmembers = tblmembersManager.selectAll();
		Page<Tblmembers> tblmembers = tblmembersManager.findByPage(pageRequest);
		
		JqgridResponse<Tblmembers> response = new JqgridResponse<Tblmembers>();
		response.setRows(tblmembers.getResult());
		response.setPage(Integer.valueOf(tblmembers.getPageNumber()).toString());
		response.setRecords(Long.valueOf(tblmembers.getTotalElements()).toString());
		response.setTotal(Integer.valueOf(tblmembers.getTotalPages()).toString());
		
		return response;
	}
}
