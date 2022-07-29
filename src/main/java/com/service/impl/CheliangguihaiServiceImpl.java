package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CheliangguihaiDao;
import com.entity.CheliangguihaiEntity;
import com.service.CheliangguihaiService;
import com.entity.vo.CheliangguihaiVO;
import com.entity.view.CheliangguihaiView;

@Service("cheliangguihaiService")
public class CheliangguihaiServiceImpl extends ServiceImpl<CheliangguihaiDao, CheliangguihaiEntity> implements CheliangguihaiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CheliangguihaiEntity> page = this.selectPage(
                new Query<CheliangguihaiEntity>(params).getPage(),
                new EntityWrapper<CheliangguihaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<CheliangguihaiEntity> wrapper) {
		  Page<CheliangguihaiView> page =new Query<CheliangguihaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<CheliangguihaiVO> selectListVO(Wrapper<CheliangguihaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public CheliangguihaiVO selectVO(Wrapper<CheliangguihaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<CheliangguihaiView> selectListView(Wrapper<CheliangguihaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public CheliangguihaiView selectView(Wrapper<CheliangguihaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
