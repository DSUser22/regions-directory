package com.dsuser22.regionsdirectory;

import com.dsuser22.regionsdirectory.config.BatisConfiguration;
import com.dsuser22.regionsdirectory.dao.RegionMapper;
import com.dsuser22.regionsdirectory.model.Region;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BatisConfiguration.class)
@Sql(scripts = "/schema_with_data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/clean.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@SpringBootTest
public class RepoTest {
    static List<Region> regions = new ArrayList<>(Arrays.asList(
            new Region("FINLAND", "FI"),
            new Region("CANADA", "CA"),
            new Region("GERMANY", "DE"),
            new Region("FRANCE", "FR")));

    @Autowired
    RegionMapper regionMapper;


    @Test
    public void shouldGetAllRegions(){
        List<Region> list = regionMapper.getRegions();
        assertThat(list.size()).isEqualTo(regions.size());
    }

    @Test
    public void shouldGetRegionById(){
        Region region = regionMapper.getRegionById(1L);
        region.setId(null);
        assertThat(region).isEqualTo(regions.get(0));
    }

    @Test
    public void shouldAddRegion(){
        Region newRegion = new Region("TURKEY", "TR");
        regionMapper.addRegion(newRegion);
        Region regionFromDB = regionMapper.getRegionById(5L);
        assertThat(regionFromDB).isEqualTo(newRegion);
    }


    @Test
    public void shouldUpdateRegionById(){
        Long id = 3L;
        Region newRegion = new Region("TURKEY", "TR");
        regionMapper.updateRegionById(newRegion, id);
        newRegion.setId(id);
        Region regionFromDB = regionMapper.getRegionById(id);
        assertThat(regionFromDB).isEqualTo(newRegion);
    }


    @Test
    public void shouldDeleteRegionById(){
        Long id = 3L;
        regionMapper.deleteRegionById(id);
        Region regionFromDB = regionMapper.getRegionById(id);
        assertThat(regionFromDB).isNull();
    }

    @Test
    public void shouldDeleteRegions(){
        regionMapper.deleteRegions();
        List<Region> list = regionMapper.getRegions();
        assertThat(list.size()).isEqualTo(0);
    }

}
