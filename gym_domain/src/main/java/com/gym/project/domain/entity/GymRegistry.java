package com.gym.project.domain.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * null
 * @TableName gym_registry
 */
@Data
public class GymRegistry implements Serializable {
    /**
     * self-increment id
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    private Long id;

    /**
     * foreign key
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    private Long customerId;

    /**
     * 创建者
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    private String createBy;

    /**
     * 创建时间
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    private Date createdTime;

    /**
     * 更新者
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    private String updateBy;

    /**
     * 更新时间
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    private Date modifiedTime;

    /**
     * 有效性
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    private Integer yn;

    /**
     * 备注信息
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    private String remark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table gym_registry
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    private static final long serialVersionUID = 1L;
}