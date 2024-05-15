package com.xuhao.datainterface.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xuhao
 * @create 2024-05-15 9:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderStats {
    private String dt;
    private Integer orderAmount;
    private Integer orderNum;
}
