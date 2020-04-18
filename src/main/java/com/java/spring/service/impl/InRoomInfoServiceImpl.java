package com.java.spring.service.impl;

import com.java.spring.entity.InRoomInfo;
import com.java.spring.entity.Rooms;
import com.java.spring.service.InRoomInfoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2020/2/20   16:02
 * Author:W.铭
 */
@Service
@Transactional(readOnly = false)
public class InRoomInfoServiceImpl extends BaseServiceImpl<InRoomInfo> implements InRoomInfoService {
    @Override
    public String save(InRoomInfo inRoomInfo) throws Exception {
        Integer add = baseMapper.insert(inRoomInfo);
        Rooms rooms = new Rooms();
        rooms.setId(inRoomInfo.getRoomId());
        rooms.setRoomStatus("1");
        Integer updRooms = roomsMapper.updateByPrimaryKeySelective(rooms);
        if (add > 0 && updRooms > 0) {
            return "success";
        }else {
            return "fail";
        }
    }
}
