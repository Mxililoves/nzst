package com.ruoyi.web;

import com.ruoyi.pill.domain.PillFactory;
import com.ruoyi.pill.service.IPillFactoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NzstTest {
    
    @Autowired
    private IPillFactoryService pillFactoryService;
    
    @Test
    void testSelectFactory() {
        PillFactory pillFactory = new PillFactory();
        pillFactory.setFactoryName("云南");
        System.out.println(pillFactoryService.selectPillFactoryList(pillFactory));
    }
    
}