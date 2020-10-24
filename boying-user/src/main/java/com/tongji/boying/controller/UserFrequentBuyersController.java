package com.tongji.boying.controller;

import com.tongji.boying.common.api.CommonResult;
import com.tongji.boying.model.FrequentBuyers;
import com.tongji.boying.service.UserFrequentBuyersService;
import com.tongji.boying.service.UserFrequentBuyersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 用户常用联系人管理Controller
 */
@Controller
@Api(tags = "UserFrequentBuyersController", description = "用户常用联系人管理")
@RequestMapping("/user/buyers")
public class UserFrequentBuyersController
{
    @Autowired
    private UserFrequentBuyersService userFrequentBuyersService;

    @ApiOperation("添加常用联系人")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult add(@RequestBody FrequentBuyers frequentBuyers)
    {
        int count = userFrequentBuyersService.add(frequentBuyers);
        if (count > 0)
        {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除常用联系人")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@PathVariable int id)
    {
        int count = userFrequentBuyersService.delete(id);
        if (count > 0)
        {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("修改常用联系人")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable int id, @RequestBody FrequentBuyers frequentBuyers)
    {
        int count = userFrequentBuyersService.update(id, frequentBuyers);
        if (count > 0)
        {
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    @ApiOperation("显示所有常用联系人")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<FrequentBuyers>> list()
    {
        List<FrequentBuyers> frequentBuyersList = userFrequentBuyersService.list();
        return CommonResult.success(frequentBuyersList);
    }

    @ApiOperation("获取常用联系人详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<FrequentBuyers> getItem(@PathVariable int id)
    {
        FrequentBuyers frequentBuyers = userFrequentBuyersService.getItem(id);
        if(frequentBuyers==null) return CommonResult.failed("当前用户无此常用联系人!");
        return CommonResult.success(frequentBuyers);
    }
}
