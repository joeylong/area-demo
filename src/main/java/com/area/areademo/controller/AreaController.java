package com.area.areademo.controller;

import com.area.areademo.entity.Area;
import com.area.areademo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping("/getAreas")
    public Map<String,Object> getareas(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Area> areaList = areaService.getAreas();
        modelMap.put("areaList",areaList);
        return modelMap;
    }

    @RequestMapping("/getAreaById")
    public Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    @PostMapping("/addArea")
    public Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.insertArea(area));
        return modelMap;
    }

    @PostMapping("/updateArea")
    public Map<String,Object> updateArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.updateArea(area));
        return modelMap;
    }

    @RequestMapping("/deleteArea")
    public Map<String,Object> deleteArea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }

}
