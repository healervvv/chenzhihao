package com.dao;

import com.entity.CheliangguihaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CheliangguihaiVO;
import com.entity.view.CheliangguihaiView;


/**
 * 车辆归还
 * 
 * @author 
 * @email 
 * @date 2022-04-08 12:04:33
 */
public interface CheliangguihaiDao extends BaseMapper<CheliangguihaiEntity> {
	
	List<CheliangguihaiVO> selectListVO(@Param("ew") Wrapper<CheliangguihaiEntity> wrapper);
	
	CheliangguihaiVO selectVO(@Param("ew") Wrapper<CheliangguihaiEntity> wrapper);
	
	List<CheliangguihaiView> selectListView(@Param("ew") Wrapper<CheliangguihaiEntity> wrapper);

	List<CheliangguihaiView> selectListView(Pagination page,@Param("ew") Wrapper<CheliangguihaiEntity> wrapper);
	
	CheliangguihaiView selectView(@Param("ew") Wrapper<CheliangguihaiEntity> wrapper);
	

}
