package com.world.fucking.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.world.fucking.domain.CityCode;
import com.world.fucking.service.CityCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 城市编码
 * @author Ciao
 * @version 1.0
 */
@RestController
@RequestMapping("cityCode")
@Api(value = "/cityCode", tags = "城市编码")
public class CityCodeController {
    @Resource
    private CityCodeService cityCodeService;

    /**
     * 查询所有城市编码
     * @return {@link IPage<CityCode>}
     */
    @ApiOperation(value = "列表", notes = "查询所有城市编码")
    @PostMapping("/queryAll")
    public IPage<CityCode> queryAll() {
        return cityCodeService.queryAll();
    }

    /**
     *
     * @param cityCodeList 城市编码集合
     * @author Ciao
     */
    @ApiOperation("批量保存城市编码")
    @PostMapping("/saveCityCode")
    public void saveCityCode(@RequestBody List<CityCode> cityCodeList){
        cityCodeService.saveBatch(cityCodeList);
    }

    /**
     * @param cityCode 城市编码
     * @author Ciao
     */
    @ApiOperation("修改城市编码")
    @PostMapping("/updateCityCode")
    public void updateCityCode(@RequestBody CityCode cityCode){
        cityCodeService.updateById(cityCode);
    }

    /**
     *
     * @param cityId 城市id
     * @return {@link CityCode}
     * @author Ciao
     */
    @ApiOperation("查询详情")
    @PostMapping("/queryById")
    public CityCode queryById(String cityId){
        return cityCodeService.queryById(cityId);
    }
}
