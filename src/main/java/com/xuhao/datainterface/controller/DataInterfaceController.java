package com.xuhao.datainterface.controller;

import com.xuhao.datainterface.service.DataInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xuhao
 * @create 2024-05-15 10:52
 */
@RestController
public class DataInterfaceController {
    @Autowired
    private DataInterfaceService dIService;

    @RequestMapping(value="/orderStats")
    public Object queryOrderStats(@RequestParam("dt") String date){
        return dIService.queryOrderStatsByDate(date);
    }
}
