package com.dao;

import com.entity.KuanshifenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KuanshifenleiVO;
import com.entity.view.KuanshifenleiView;


/**
 * 款式分类
 * 
 * @author 
 * @email 
 * @date 2022-04-08 12:04:33
 */
public interface KuanshifenleiDao extends BaseMapper<KuanshifenleiEntity> {
	
	List<KuanshifenleiVO> selectListVO(@Param("ew") Wrapper<KuanshifenleiEntity> wrapper);
	
	KuanshifenleiVO selectVO(@Param("ew") Wrapper<KuanshifenleiEntity> wrapper);
	
	List<KuanshifenleiView> selectListView(@Param("ew") Wrapper<KuanshifenleiEntity> wrapper);

	List<KuanshifenleiView> selectListView(Pagination page,@Param("ew") Wrapper<KuanshifenleiEntity> wrapper);
	
	KuanshifenleiView selectView(@Param("ew") Wrapper<KuanshifenleiEntity> wrapper);
	

}
