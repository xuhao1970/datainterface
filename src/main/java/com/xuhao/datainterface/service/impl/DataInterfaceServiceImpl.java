package com.xuhao.datainterface.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.xuhao.datainterface.bean.OrderStats;
import com.xuhao.datainterface.mapper.MysqlMapper;
import com.xuhao.datainterface.service.DataInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xuhao
 * @create 2024-05-15 10:13
 */
@Service
public class DataInterfaceServiceImpl implements DataInterfaceService {
    @Autowired
    private MysqlMapper mysqlMapper;

    @Override
    public JSONObject queryOrderStatsByDate(String dt) {
        if(null==dt){
            dt= LocalDate.now().toString();
        }
        List<OrderStats> data = mysqlMapper.queryOrderStatsByDate(dt);
        System.out.println(data);
        Integer orderNum = data.stream().map(OrderStats::getOrderNum).reduce(0, Integer::sum);
        Integer orderAmount = data.stream().map(OrderStats::getOrderAmount).reduce(0,Integer::sum);
        List<String> orderDt = data.stream().map(OrderStats::getDt).collect(Collectors.toList());
        JSONObject nowOrderNum = new JSONObject();
        nowOrderNum.put("name","当日订单数");
        nowOrderNum.put("data",orderNum);
        JSONObject nowOrderAmount = new JSONObject();
        nowOrderAmount.put("name","当日订单金额");
        nowOrderAmount.put("data",orderAmount);
        ArrayList<JSONObject> series = new ArrayList<>();
        series.add(nowOrderNum);
        series.add(nowOrderAmount);
        JSONObject nowData = new JSONObject();
        nowData.put("categories",orderDt);
        nowData.put("series",series);
        JSONObject nowResult = new JSONObject();
        nowResult.put("status",0);
        nowResult.put("msg","");
        nowResult.put("data",nowData);
        return nowResult;


    }

    @Override
    public JSONObject queryVisitStatsTop5() {
        return null;
    }

    @Override
    public JSONObject querySalesAmountToday() {
        return null;
    }

    @Override
    public JSONObject querySalesAmount() {
        return null;
    }

    @Override
    public JSONObject querySourceData() {
        return null;
    }

    @Override
    public JSONObject queryIndustryStats() {
        return null;
    }

    @Override
    public JSONObject queryProvinceStatToday() {
        return null;
    }

    @Override
    public JSONObject queryProviceCompletion(String city) {
        return null;
    }
}
