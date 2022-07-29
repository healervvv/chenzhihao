package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CheliangguihaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CheliangguihaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CheliangguihaiView;


/**
 * 车辆归还
 *
 * @author 
 * @email 
 * @date 2022-04-08 12:04:33
 */
public interface CheliangguihaiService extends IService<CheliangguihaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CheliangguihaiVO> selectListVO(Wrapper<CheliangguihaiEntity> wrapper);
   	
   	CheliangguihaiVO selectVO(@Param("ew") Wrapper<CheliangguihaiEntity> wrapper);
   	
   	List<CheliangguihaiView> selectListView(Wrapper<CheliangguihaiEntity> wrapper);
   	
   	CheliangguihaiView selectView(@Param("ew") Wrapper<CheliangguihaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CheliangguihaiEntity> wrapper);
   	

}

