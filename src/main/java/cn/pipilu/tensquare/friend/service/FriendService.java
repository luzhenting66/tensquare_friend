package cn.pipilu.tensquare.friend.service;

import cn.pipilu.tensquare.friend.entity.FriendEntity;

import java.util.List;

public interface FriendService {
    List<FriendEntity> findListByUserId(String userId);
}
