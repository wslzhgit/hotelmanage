package com.java.spring.utils;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：  ksfxhw3818@sandbox.com   111111
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101800717407";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQClhp5J47T+5tt2FHHiksZa0nuGBldQOiXd3y9xAaBulnxhzYy92GhFldhYpJx0ERwHs6AIrJeFhcp0DwOwyx1NztTAAfzmJqjvyN5WZjlKzZGK6rKwhE70b5t6rUKHQI4UqTPq9UJmgucQj9W/L0rA3Pnzr0Yp2jn65mqVDlz3b/PIEAO1CO4QFLiIeJhldAz2wcrw7ltW+upVXP1PsIyt+eETLQcbh/RGbLtNroP9PkO14BHuRR+t+kF1u4kEKVBliIoLOIDdD4dKFFjB7OgKrvlS0kCBe96BkhA0uWk45ZjJaKLmSe0uxMpx1p3LjrepuVAc/zd3FOEhdGIbLyhvAgMBAAECggEAP7CxvVqprR8lOKUbQQQa4J12vBY6iHsnUNzswz3N/l9XEsblrbLURFoo+cq1DI/8yhXasRu/3beiM9AHKoKtDuBTymG5btFXVZRjwLjquJaqttoh0XvHaZR8LdL281XqlZaZjIG8f/dEc4H0y/ClgdpFLve1NqtqfdklD5+MNAS1hZCiewj1jSiWl5tcjDVQCLUki3FRbyMeh6rkqJUQbwpExLV5oKg5OiaNlg5tySs3HmOy7KcVXu4zRh1ZePGh3wO2qmZ7h9zlUhqulaj1ScSrqq3oIrznF44GGtziTxeUydZSbjglmQNqn8wd0Crb3lz8XBgDhR97uTLxzUZpoQKBgQD4NFwKyfvMMgg71KG/n50zfcTgpTdMdHoFIz9MV00z/whZS4bgcVODw7gZnA1JqAuGuigSbkJPYh+DImiuD1zI99hYF/W8BE3EX+ZZPWTBxMNI16o6r4648PPiP3PtJR4cTcqR+x26w5++MHjq/T+v6RhuhTehMjY8sliCwTKsnwKBgQCquX8z0AXEJ3c8l2Tmhdfcuy0qH/Y8C762pswjTltlt6LyVZHibC2owiMEBNBs8atMjiGLQebVt578xtNPrfp1QAJOiWpxdKUUmMgoWFhn3gGku1dC5bjdxCMz/U06k9tDajdLvkkKUSVGX2h2of/DlyjT8BOwfW0A84slsREiMQKBgBBVmc0X99s7W7FcT/zFa1oNJ9zE4rvEWpdl9291u131pb4Cq3Cv5JgiVEZTL8iuJ3wJWkPEP9brlTlTFWKHHksXjIRXp1NlURzgVs9+q9fYtCViFBDiptji+pnkJSPxMmcYc4Fh7lXxM90XYY3NdtiD1ZjIaZ3RKSKbdhm8zzHvAoGAeJir6Ber2xHdwmlXFxe4ke2OS9FkCKprP263iMETAtkjO3eCo6Sy5CCux2n3KN3VmTBVNZ+JxbH9lqWEIybMYwKiHoQnMpmo+tGpogY1/LjwBENpspG/crfX/iOR6C0Fl6tyAAkcYzNK11kR26s3lhwy9PMDlYoj86YVxrw7VCECgYAj02gEvcHBG4Xj6in9XzGaj6THR627a9pHvp4uQQSKr04tEhwMUhMOV/wurwb955F86px32sPcYK52+/XaFm0EahZwfXhwdd9IFSbLPoIzP+Q/Llct8miKhw+6+p9keSpsK2PvgXLzJv16Yo9CJ9cn+mVWFBQY8kWLFojmCwz13w==";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApYaeSeO0/ubbdhRx4pLGWtJ7hgZXUDol3d8vcQGgbpZ8Yc2MvdhoRZXYWKScdBEcB7OgCKyXhYXKdA8DsMsdTc7UwAH85iao78jeVmY5Ss2RiuqysIRO9G+beq1Ch0COFKkz6vVCZoLnEI/Vvy9KwNz5869GKdo5+uZqlQ5c92/zyBADtQjuEBS4iHiYZXQM9sHK8O5bVvrqVVz9T7CMrfnhEy0HG4f0Rmy7Ta6D/T5DteAR7kUfrfpBdbuJBClQZYiKCziA3Q+HShRYwezoCq75UtJAgXvegZIQNLlpOOWYyWii5kntLsTKcdady463qblQHP83dxThIXRiGy8obwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/orders/myOrdersPay";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

