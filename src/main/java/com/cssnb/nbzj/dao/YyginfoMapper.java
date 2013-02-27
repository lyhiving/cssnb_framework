/**
 * 
 */
package com.cssnb.nbzj.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import com.cssnb.commons.domain.Page;
import com.cssnb.commons.domain.PageRequest;
import com.cssnb.nbzj.entity.Yyginfo;

/**
 * @author xuning email:xuningnb@163.com
 * @version creation time:2012-5-28下午3:03:50
 * 类说明：预告信息处理
 * 
 */
@Repository
public interface YyginfoMapper {

	public List<Map<String,Object>> getYyginfoList();

	public Page<Yyginfo> getYyginfoList(PageRequest pageRequest);
	
	public Page<Yyginfo> listPage(@Param("params")Map<String,Object> params, @Param("page")PageRequest pageRequest) ;
}
