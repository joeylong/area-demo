package com.area.areademo.service;

import com.area.areademo.entity.Area;

import java.util.List;

public interface AreaService {
    List<Area> getAreas();
    Area getAreaById(int  areaId);
    boolean insertArea(Area area);
    boolean updateArea(Area area);
    boolean deleteArea(int areaId);
}
