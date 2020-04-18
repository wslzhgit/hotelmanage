package com.java.spring.utils;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName: WebAppConfig
 * @Description: 配置虚拟路径
 * @author djin
 * @date 2018年10月11日
 */
@Configuration  //项目启动的时候，自动加载此自定义的工具类
public class WebAppConfigResource extends WebMvcConfigurerAdapter {
    //获取application.yml配置文件中图片的真实路径
    //file:C:\Users\Administrator\Pictures\goodHeader\
    @Value("${ws.imagesPath}")
    private String mImagesPath;
    //访问图片方法
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("执行了配置虚拟路径的工具类。。");
        if(mImagesPath.equals("") || mImagesPath.equals("${cbs.imagesPath}")){
            String imagesPath = WebAppConfigResource.class.getClassLoader().getResource("").getPath();
            if(imagesPath.indexOf(".jar")>0){
                imagesPath = imagesPath.substring(0, imagesPath.indexOf(".jar"));
            }else if(imagesPath.indexOf("classes")>0){
                imagesPath = "file:"+imagesPath.substring(0, imagesPath.indexOf("classes"));
            }
            imagesPath = imagesPath.substring(0, imagesPath.lastIndexOf("/"))+"/img/";
            mImagesPath = imagesPath;
        }
        LoggerFactory.getLogger(WebAppConfigResource.class).info("imagesPath="+mImagesPath);
        ///img/**就是为我们的虚拟的访问路径
        registry.addResourceHandler("/img/**").addResourceLocations(mImagesPath);
        super.addResourceHandlers(registry);
        
    }
}
