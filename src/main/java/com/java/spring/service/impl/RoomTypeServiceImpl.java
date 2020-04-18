package com.java.spring.service.impl;

import com.java.spring.entity.RoomType;
import com.java.spring.service.RoomTypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2020/2/22   11:18
 * Author:W.铭
 */
@Service
@Transactional(readOnly = false)
public class RoomTypeServiceImpl extends BaseServiceImpl<RoomType> implements RoomTypeService {
}
