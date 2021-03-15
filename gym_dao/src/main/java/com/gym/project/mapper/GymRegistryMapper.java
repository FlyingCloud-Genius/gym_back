package com.gym.project.mapper;


import com.gym.project.domain.gym.GymRegistry;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GymRegistryMapper {
    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int deleteByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insert(GymRegistry record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int insertSelective(GymRegistry record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    GymRegistry selectByPrimaryKey(Long id);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKeySelective(GymRegistry record);

    /**
     *
     * @mbg.generated 2021-03-14 00:26:58
     */
    int updateByPrimaryKey(GymRegistry record);
}