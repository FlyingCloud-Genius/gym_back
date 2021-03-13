package com.gym.project.mapper;

import com.gym.project.domain.entity.GymUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GymUserMapper {
    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insert(GymUser record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insertSelective(GymUser record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    GymUser selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKeySelective(GymUser record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKey(GymUser record);
}