package cn.pipilu.tensquare.friend.controller;

import cn.pipilu.plus.common.response.Response;
import cn.pipilu.plus.common.util.ResponseUtil;
import cn.pipilu.tensquare.friend.entity.FriendEntity;
import cn.pipilu.tensquare.friend.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tensquare-firend/friend")
public class FirendController {
    @Autowired
    private FriendService friendService;
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET)
    public Response<List<FriendEntity>> findListByUserId(@PathVariable("userId")String userId){

        Response<List<FriendEntity>> response = new Response<>() ;
        try {
            response.setRespData(friendService.findListByUserId(userId));
            ResponseUtil.setRespParam(response);
        }catch (Exception e){
            ResponseUtil.setRespParam(response,e);
        }
        return response;
    }

}
