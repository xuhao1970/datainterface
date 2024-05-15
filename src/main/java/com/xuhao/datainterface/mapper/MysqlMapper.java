package com.xuhao.datainterface.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.xuhao.datainterface.bean.OrderStats;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xuhao
 * @create 2024-05-15 10:00
 */
@DS("mysql")
@Mapper
public interface MysqlMapper {
    @Select("select \n" +
            "\tdate_format(create_time,'%Y-%m-%d') dt,\n" +
            "\tsum(total_amount) order_amount,\n" +
            "\tcount(1) order_num\n" +
            "from order_info oi \t\n" +
            "WHERE DATE(create_time)=#{date} " +
            "group by date_format(create_time,'%Y-%m-%d')")
    List<OrderStats> queryOrderStatsByDate(@Param("date") String dt);
}
