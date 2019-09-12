package cn.pipilu.tensquare.friend.service.impl;

import cn.pipilu.plus.common.exception.AppException;
import cn.pipilu.plus.common.util.JwtUtil;
import cn.pipilu.tensquare.friend.entity.FriendEntity;
import cn.pipilu.tensquare.friend.mapper.FriendMapper;
import cn.pipilu.tensquare.friend.service.FriendService;
import io.jsonwebtoken.Claims;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private FriendMapper friendMapper;
    @Override
    public List<FriendEntity> findListByUserId(String userId) {
        String token = (String) request.getAttribute("claims_user");
        if (StringUtils.isBlank(token)){
            throw new AppException("3001","权限不足");
        }

        Claims claims = jwtUtil.parseJWT(token);
        FriendEntity friendEntity = new FriendEntity();
        friendEntity.setUserId(claims.getId());

        return friendMapper.select(friendEntity);
    }
}
