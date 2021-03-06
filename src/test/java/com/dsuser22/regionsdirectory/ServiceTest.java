package com.dsuser22.regionsdirectory;

import com.dsuser22.regionsdirectory.dao.RegionMapper;
import com.dsuser22.regionsdirectory.model.Region;
import com.dsuser22.regionsdirectory.service.RegionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

    @Mock private RegionMapper regionMapper;

    @InjectMocks
    private RegionService regionService = new RegionService();


    @Test
    public void shouldGetRegions(){
        regionService.getRegions();
        verify(regionMapper).getRegions();
    }


    @Test
    public void shouldGetRegionById(){
        long id = 3L;
        regionService.getRegionById(id);
        verify(regionMapper).getRegionById(id);
    }

    @Test
    public void shouldAddRegion(){
        Region region = new Region("RUSSIA", "RU");
        regionService.addRegion(region);
        ArgumentCaptor<Region> argumentCaptor = ArgumentCaptor.forClass(Region.class);

        verify(regionMapper).addRegion(argumentCaptor.capture());
        Region capturedAppUser = argumentCaptor.getValue();

        capturedAppUser.setId(null);
        assertThat(capturedAppUser).isEqualTo(region);
    }

    @Test
    public void shouldUpdateRegionById(){
        long id = 3L;
        Region region = new Region("RUSSIA", "RU");
        regionService.updateRegionById(region, id);
        verify(regionMapper).updateRegionById(region, id);
    }

    @Test
    public void shouldDeleteRegionById(){
        long id = 3L;
        regionService.deleteRegionById(id);
        verify(regionMapper).deleteRegionById(id);
    }


    @Test
    public void shouldDeleteRegions(){
        regionService.deleteRegions();
        verify(regionMapper).deleteRegions();
    }

}
