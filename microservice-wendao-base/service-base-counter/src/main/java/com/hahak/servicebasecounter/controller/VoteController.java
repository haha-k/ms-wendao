package com.hahak.servicebasecounter.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hahak.servicebasecounter.dto.Vote;
import com.hahak.servicebasecounter.service.VoteService;

import entity.BaseResponse;
import enums.BaseStatusCode;

/**
 * @ClassName voteController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @GetMapping("")
    public BaseResponse getVotes(){
        List<Vote> votes = voteService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),votes);
    }

    @GetMapping("/{voteId}")
    public BaseResponse getVoteDetail(@PathVariable Integer voteId){
        Vote vote = voteService.getById(voteId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),vote);
    }

    @DeleteMapping("/{voteId}")
    public BaseResponse deleteVoteDetail(@PathVariable Integer voteId){
//        Vote vote = voteService.getById(voteId);
        Boolean isSuccess = voteService.removeById(voteId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postVote(@RequestBody Vote vote){
//        Vote vote = voteService.getById(voteId);
        voteService.save(vote);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

}
