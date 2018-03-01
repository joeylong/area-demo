package com.area.areademo.dao;

import com.area.areademo.entity.Area;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AreaDao {
    List<Area> getAreas();
    Area getAreaById(int  areaId);
    int insertArea(Area area);
    int updateArea(Area area);
    int deleteArea(int areaId);
}
