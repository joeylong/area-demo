package com.area.areademo.service.impl;

import com.area.areademo.dao.AreaDao;
import com.area.areademo.entity.Area;
import com.area.areademo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreas() {
        return areaDao.getAreas();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.getAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean insertArea(Area area) {
       if (!StringUtils.isEmpty(area.getAreaName())){
           area.setCreateTime(new Date());
           area.setEditTime(new Date());
           try{
               int i = areaDao.insertArea(area);
               if(i>0){
                   return  true;
               }else{
                   throw new RuntimeException("插入区域信息失败");
               }
           }catch (Exception e){
               throw new RuntimeException("插入区域信息失败"+e.getMessage());
           }
       }else{
           throw new RuntimeException("区域名称不能为空");
       }
    }

    @Override
    public boolean updateArea(Area area) {
        if(StringUtils.isEmpty(area.getAreaName())){
            throw new RuntimeException("区域名称不能为空");
        }
        if(StringUtils.isEmpty(area.getAreaId())){
            throw new RuntimeException("区域Id不能为空");
        }
        area.setEditTime(new Date());
        area.setAreaId(area.getAreaId());
        area.setAreaName(area.getAreaName());
        try {
            int i = areaDao.updateArea(area);
            if(i>0){
                return true;
            }else{
                throw new RuntimeException("更新区域信息失败");
            }
        }catch (Exception e){
            throw new RuntimeException("更新区域信息失败"+e.getMessage());
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if(areaId>0){
            try{
                int i = areaDao.deleteArea(areaId);
                if(i>0){
                    return true;
                }else{
                    throw new RuntimeException("删除区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败"+e.getMessage());
            }
        }else {
            throw new RuntimeException("删除区域信息Id不能为空");
        }
    }
}
