package com.gym.project.mapper;


import com.gym.project.domain.entity.GymBodyInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GymBodyInfoMapper {
    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insert(GymBodyInfo record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insertSelective(GymBodyInfo record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    GymBodyInfo selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKeySelective(GymBodyInfo record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKey(GymBodyInfo record);
}