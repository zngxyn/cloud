package com.tom.cloud.starter.common;

import lombok.Data;

import java.util.Date;

/**
 * BaseModel
 *
 * @author Tom.Zeng
 * @date 2019/4/26 10:22
 */
@Data
public class BaseModel {
    /**
     * 创建者ID
     */
    private String creatorId;
    /**
     * 创建者名
     */
    private String creatorName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改者ID
     */
    private String modifierId;
    /**
     * 修改者名
     */
    private String modifierName;
    /**
     * 修改时间
     */
    private Date modifyTime;
}
