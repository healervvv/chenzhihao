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


import com.dao.KuanshifenleiDao;
import com.entity.KuanshifenleiEntity;
import com.service.KuanshifenleiService;
import com.entity.vo.KuanshifenleiVO;
import com.entity.view.KuanshifenleiView;

@Service("kuanshifenleiService")
public class KuanshifenleiServiceImpl extends ServiceImpl<KuanshifenleiDao, KuanshifenleiEntity> implements KuanshifenleiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KuanshifenleiEntity> page = this.selectPage(
                new Query<KuanshifenleiEntity>(params).getPage(),
                new EntityWrapper<KuanshifenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KuanshifenleiEntity> wrapper) {
		  Page<KuanshifenleiView> page =new Query<KuanshifenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KuanshifenleiVO> selectListVO(Wrapper<KuanshifenleiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KuanshifenleiVO selectVO(Wrapper<KuanshifenleiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KuanshifenleiView> selectListView(Wrapper<KuanshifenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KuanshifenleiView selectView(Wrapper<KuanshifenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
