package com.java.spring.controller;

import com.java.spring.entity.Rooms;
import com.java.spring.utils.QiNiuUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * 2020/2/22   11:15
 * Author:W.铭
 */
@Controller
@RequestMapping("/rooms")
public class RoomsController extends BaseController<Rooms> {

    //房间图片上传
    @RequestMapping("/uploadRoomPic")
    public @ResponseBody Map<String,Object> uploadRoomPic(MultipartFile myFile) {
        try {
            return QiNiuUtil.fileUpload(myFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
}
