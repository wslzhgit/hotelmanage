package com.java.spring.service.impl;

import com.java.spring.entity.Rooms;
import com.java.spring.service.RoomsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2020/2/22   11:18
 * Author:W.铭
 */
@Service
@Transactional(readOnly = false)
public class RoomsServiceImpl extends BaseServiceImpl<Rooms> implements RoomsService {
}
