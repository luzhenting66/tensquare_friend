package cn.pipilu.tensquare.friend.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@ToString
@Table(name = "tb_friend")
public class FriendEntity implements Serializable{
    private static final long serialVersionUID = -5806583170715810743L;
    @Column(name = "user_id")
    private String userId;//'用户ID',
    @Column(name = "friend_id")
    private String friendId; // '好友ID',
    private String flag; //是否互相喜欢 1-单向喜欢、2-互相喜欢',
}
