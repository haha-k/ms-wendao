package com.hahak.serviceContentColumn.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hahak.serviceContentColumn.dto.Column;
import com.hahak.serviceContentColumn.service.ColumnService;

import entity.BaseResponse;
import enums.BaseStatusCode;

/**
 * @ClassName columnController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/column")
public class ColumnController {

    @Autowired
    private ColumnService columnService;

    @GetMapping("")
    public BaseResponse getColumns(){
        List<Column> columns = columnService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),columns);
    }

    @GetMapping("/{columnId}")
    public BaseResponse getColumnDetail(@PathVariable Integer columnId){
        Column column = columnService.getById(columnId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),column);
    }

    @DeleteMapping("/{columnId}")
    public BaseResponse deleteColumnDetail(@PathVariable Integer columnId){
//        Column column = columnService.getById(columnId);
        Boolean isSuccess = columnService.removeById(columnId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postColumn(@RequestBody Column column){
//        Column column = columnService.getById(columnId);
        columnService.save(column);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }




}
