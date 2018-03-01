package com.area.areademo.dao;

import com.area.areademo.entity.Area;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao dao;
    @Test
    public void getAreas() throws Exception {
        List<Area> areaList = dao.getAreas();
        System.out.println(areaList.get(0).getAreaName());
    }

    @Test
    public void getAreaById() throws Exception {
    }

    @Test
    public void insertArea() throws Exception {
    }

    @Test
    public void updateArea() throws Exception {
    }

    @Test
    public void deleteArea() throws Exception {
    }

}