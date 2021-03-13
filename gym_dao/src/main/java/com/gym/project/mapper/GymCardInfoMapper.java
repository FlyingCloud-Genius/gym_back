package com.gym.project.mapper;


import com.gym.project.domain.entity.GymCardInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GymCardInfoMapper {
    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insert(GymCardInfo record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insertSelective(GymCardInfo record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    GymCardInfo selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKeySelective(GymCardInfo record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKey(GymCardInfo record);
}