package com.java.spring.service.impl;

import com.java.spring.entity.Vip;
import com.java.spring.service.VipService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 2020/2/22   11:18
 * Author:W.铭
 */
@Service
@Transactional(readOnly = false)
public class VipServiceImpl extends BaseServiceImpl<Vip> implements VipService {
}
