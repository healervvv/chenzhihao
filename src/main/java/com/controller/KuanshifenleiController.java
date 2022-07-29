package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.KuanshifenleiEntity;
import com.entity.view.KuanshifenleiView;

import com.service.KuanshifenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 款式分类
 * 后端接口
 * @author 
 * @email 
 * @date 2022-04-08 12:04:33
 */
@RestController
@RequestMapping("/kuanshifenlei")
public class KuanshifenleiController {
    @Autowired
    private KuanshifenleiService kuanshifenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KuanshifenleiEntity kuanshifenlei, 
		HttpServletRequest request){

        EntityWrapper<KuanshifenleiEntity> ew = new EntityWrapper<KuanshifenleiEntity>();
    	PageUtils page = kuanshifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuanshifenlei), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KuanshifenleiEntity kuanshifenlei, 
		HttpServletRequest request){
        EntityWrapper<KuanshifenleiEntity> ew = new EntityWrapper<KuanshifenleiEntity>();
    	PageUtils page = kuanshifenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuanshifenlei), params), params));
		request.setAttribute("data", page);
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KuanshifenleiEntity kuanshifenlei){
       	EntityWrapper<KuanshifenleiEntity> ew = new EntityWrapper<KuanshifenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kuanshifenlei, "kuanshifenlei")); 
        return R.ok().put("data", kuanshifenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KuanshifenleiEntity kuanshifenlei){
        EntityWrapper< KuanshifenleiEntity> ew = new EntityWrapper< KuanshifenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kuanshifenlei, "kuanshifenlei")); 
		KuanshifenleiView kuanshifenleiView =  kuanshifenleiService.selectView(ew);
		return R.ok("查询款式分类成功").put("data", kuanshifenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KuanshifenleiEntity kuanshifenlei = kuanshifenleiService.selectById(id);
        return R.ok().put("data", kuanshifenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KuanshifenleiEntity kuanshifenlei = kuanshifenleiService.selectById(id);
        return R.ok().put("data", kuanshifenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KuanshifenleiEntity kuanshifenlei, HttpServletRequest request){
    	kuanshifenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kuanshifenlei);

        kuanshifenleiService.insert(kuanshifenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KuanshifenleiEntity kuanshifenlei, HttpServletRequest request){
    	kuanshifenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(kuanshifenlei);

        kuanshifenleiService.insert(kuanshifenlei);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody KuanshifenleiEntity kuanshifenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kuanshifenlei);
        kuanshifenleiService.updateById(kuanshifenlei);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kuanshifenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<KuanshifenleiEntity> wrapper = new EntityWrapper<KuanshifenleiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = kuanshifenleiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	
	





}
