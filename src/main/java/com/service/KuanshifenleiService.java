package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KuanshifenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KuanshifenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KuanshifenleiView;


/**
 * 款式分类
 *
 * @author 
 * @email 
 * @date 2022-04-08 12:04:33
 */
public interface KuanshifenleiService extends IService<KuanshifenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KuanshifenleiVO> selectListVO(Wrapper<KuanshifenleiEntity> wrapper);
   	
   	KuanshifenleiVO selectVO(@Param("ew") Wrapper<KuanshifenleiEntity> wrapper);
   	
   	List<KuanshifenleiView> selectListView(Wrapper<KuanshifenleiEntity> wrapper);
   	
   	KuanshifenleiView selectView(@Param("ew") Wrapper<KuanshifenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KuanshifenleiEntity> wrapper);
   	

}

