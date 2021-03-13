package com.gym.project.mapper;

import com.gym.project.domain.entity.GymCustomerPhoto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GymCustomerPhotoMapper {
    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insert(GymCustomerPhoto record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insertSelective(GymCustomerPhoto record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    GymCustomerPhoto selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKeySelective(GymCustomerPhoto record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKey(GymCustomerPhoto record);
}