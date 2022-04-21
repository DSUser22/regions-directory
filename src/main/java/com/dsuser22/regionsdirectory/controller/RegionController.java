package com.dsuser22.regionsdirectory.controller;

import com.dsuser22.regionsdirectory.model.Region;
import com.dsuser22.regionsdirectory.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/regions")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping()
    public ResponseEntity<List<Region>> getRegions(){
        return new ResponseEntity<>(regionService.getRegions(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Region> getRegionById(@PathVariable("id") Long id){
        return new ResponseEntity<>(regionService.getRegionById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity addRegion(@RequestBody Region region){
        regionService.addRegion(region);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateRegionById(@RequestBody Region region, @PathVariable("id") Long id){
        regionService.updateRegionById(region, id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteRegionById(@PathVariable("id") Long id){
        regionService.deleteRegionById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping()
    public ResponseEntity deleteRegions(){
        regionService.deleteRegions();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
