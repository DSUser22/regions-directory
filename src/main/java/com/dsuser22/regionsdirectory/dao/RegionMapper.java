package com.dsuser22.regionsdirectory.dao;

import com.dsuser22.regionsdirectory.model.Region;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionMapper{

    @Select("SELECT * FROM REGIONS")
    List<Region> getRegions();

    @Select("SELECT * FROM REGIONS WHERE id = #{id}")
    Region getRegionById(@Param("id") Long id);

    @Insert("INSERT INTO REGIONS (name, shortName) VALUES(#{region.name},#{region.shortName})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    int addRegion(@Param("region") Region region);

    @Update("UPDATE REGIONS SET name = #{region.name},shortName = #{region.shortName} WHERE id = #{id}")
    int updateRegionById(@Param("region") Region region, @Param("id") Long id);

    @Delete("DELETE FROM REGIONS WHERE id = #{id}")
    void deleteRegionById(@Param("id") Long id);

    @Delete("DELETE FROM REGIONS")
    void deleteRegions();
}
