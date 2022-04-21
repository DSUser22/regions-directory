package com.dsuser22.regionsdirectory.service;

import com.dsuser22.regionsdirectory.dao.RegionMapper;
import com.dsuser22.regionsdirectory.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegionService {

    @Autowired
    private RegionMapper regionMapper;

    public List<Region> getRegions(){
        return regionMapper.getRegions();
    }

    @Cacheable(cacheNames = "regions", key = "#id")
    public Region getRegionById(Long id){
        return regionMapper.getRegionById(id);
    }

    @CachePut(cacheNames = "regions")
    public Region addRegion(Region region){
        regionMapper.addRegion(region);
        return region;
    }

    @CachePut(cacheNames = "regions", key = "#id")
    public Region updateRegionById(Region region, Long id){
        regionMapper.updateRegionById(region, id);
        region.setId(id);
        return region;
    }

    @CacheEvict(cacheNames = "regions", key = "#id")
    public void deleteRegionById(Long id){
        regionMapper.deleteRegionById(id);
    }


    public void deleteRegions(){
        regionMapper.deleteRegions();
    }

}
