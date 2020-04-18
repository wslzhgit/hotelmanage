package com.java.spring.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *   七牛云上传的工具类
 */
public class QiNiuUtil {

    //设置好账号的ACCESS_KEY和SECRET_KEY;这两个登录七牛账号里面可以找到 ,必须改
    static String ACCESS_KEY = "nC4RRMeypYmswfvMGN6Rsy8ObwzOITaP90kiuTok";
    static String SECRET_KEY = "LppazER-yLxYZOuiznAt9oQ22difCthyJIvKrLTF";
    //要上传的空间;对应到七牛上（自己建文件夹 注意设置公开）
    static String bucketname = "hapa"; //必须改
    //访问此空间的域名
    static String yName = "http://q6jzflwi2.bkt.clouddn.com";
    //密钥配置
    static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
    //创建上传对象
    static UploadManager uploadManager = new UploadManager(new Configuration(Zone.zone2()));
    //简单上传，使用默认策略，只需要设置上传的空间名就可以了
    static public String getUpToken(){
        return auth.uploadToken(bucketname);
    }

    //普通上传
    public static Map<String,Object> fileUpload(MultipartFile myFile) throws IOException {
        //上传到七牛后保存的文件名
        String key = UUID.randomUUID().toString().replace("-", "");
        //新建map集合
        Map<String,Object> map = new HashMap<String, Object>();
        //我们项目中上传文件是直接获取整个源文件，而不是源文件的绝对路径
        try {
            //调用put方法上传
            Response res = uploadManager.put(myFile.getBytes(),key,getUpToken());
            //上传成功将新文件访问路径传入到页面中
            map.put("newFileName",yName+"/"+key);
            map.put("code",0);  //成功
        } catch (QiniuException e) {
            e.printStackTrace();
            map.put("code",200);  //失败
        }
        return map;
    }

}
