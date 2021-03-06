package com.reco.cn.util;

/**
 * Created by cpf on 2018/4/26.
 */
public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091600521712";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCuDd1G2HDQtmc//WBK4u+mGsM/OHCB5G/SuTlgSMGMyc0ZDxM7U+5x+0IISAhK9NdLVzOTCs3oF5HyvaeuHdFAQkS5atPbs3jE3M62ldv7upo6CWKfHF64ywCzlVCmGNGNd8PFMHjEHZlQEjg3KsFO/5myR9/8W0QeXhu4dAM0RGTYgHVRj+5x9HCGv/gFKLvfueYArICd1JRl/HsKRDAwA4M6pZCy/n1cUjBNc6HUKIyGQBkVg/pOFzYtTamIXMfQ1moXRljuRzJ9cMU3+UdxFX3U7la5eIb82wE7B9evPP4MdhbZqK3j5B2nAqZ936tumBuJwhU6/ojxTBb7cgwPAgMBAAECggEAMn9nQZSuNn+VOSWD+HYa3XBKUV9IlQb3woVmth6luPkbfje3drEFLyCcqdZsQYMDq6IjHng2AS5Fc82+hm+0NBaF5d2ulcFeOo9tkd+ssT4UXN44NL2AZdDP5Upe2bG9qnOi4uULRKrpvidrE+Zdq1PQ/b6Ip6i6/KyFEmDmRRVQLTevECrJBr5uXfTKbhPpi+nc34GO679NCVWkLZxQucRKgkb6sgLCixqvgZRAIntp38DGZdefk7lKHxTIO+NbuwBcaTYCL0bouayEO2iOzxvKCVFfjwhaZIJqI+tDgr7SgIvGuyaW0cHjIb2QhlavHcvc0RkdOQK3u0OJb9Hh0QKBgQDcEziT4xcmtp/mIwz0fQ6j4qTSFzxZy2ZscFtdEJEL3dcxayxiZSk3F5MskmRZJ2y9iLYVC8KnQopff0ZScV0goDv1JGlyLlSUcrIRpQw8G3Xf+W/5KYWXkfGyRKFj5nsDM6xdF0j3m5CG/hvNprlOZBeOvk4Dlk2zlOkxiuuwywKBgQDKd3ZMxEPTGfzgZAijXJv/RX+XrT/PnPMBhn2GhKOgiVxhqcE50NDgugaiMhUobsCmlVkIVpRBape4Knm80CGBkTfURyPxvu/KOOHKDzZ5A8helviT5YadD8caC6CK6jJ+QvyFSr54bOJ0OXddDk7eqeZhsqCMgw8fp3hZGhi9TQKBgQDGnE4eIP6+wGfz4MQLTWVN//exZqjffNIVoRzDE3VjWTSg89Ddh+A3SP5YZlFLqGnZbyysN63XFxUb9Bf5xTc/f3w80zyagDdytUQA6ovtHvc1R76HBbL7xAl1Uby5FMMFc7flV2NRmsJHIcLjyMhJd8lO2G49jILZQ9VkEbR9GwKBgCWTZEY9CqVsJk1y41OGRYFr4ZFB2xzp8QOwdS15AnEx7Q5HFhBn28xJWh/SEbEuVNzVzO9KOjulz8CjSXKsYfuM+wKPrXEZUaGDSwxYJHDzLcW4WSwBpikSG46O593AN1zNi9YlGBJ7is+tNqTzmdmjSJmLMFbDoBPs3d4ThNHlAoGBALXH9lq1dKETmHtyUz8t+Yh5duss0f1CT2HlUUppbH/8xihNs7I/2MknI7vUXqVCHM7Tx4i2OgnepEfFZakIlqDSTWvlwAwprgKMS7DBDUMdpFVR8WrNK+yicy+MAm9S1usnFxOhRP7UjNY0/uMwkdPgPx+uQryfYecWG9JbPV94";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzL01+tSfeAYuiB1G5/baujnPkPJo7CetxyuXNJ22IVGY2no+zN//gNhCwAFJRvhxxwDS78DRT9giBJ+RDOeHyBOOR5U9AYYAexOzkNibYi6I1pfod8IlskuR2s/flcb9DVU053cFXIsHiVP1sw+FErJ1cm5gf6VJx7JwQJtqIHF68cd4Qs6D7DJmgM09hWN6kTN7itMu10yZU7+hGQgvR1I3M2lCW9i/7ySs1Ni8Azb3yIDZg2fn7MKjsRU3VgtqDd8R+oaMKMlFavcs6lx8qj9RXkyj4E3L/o9M0lIq0SNXyT/aFFA4n9rybz+DFl5uen4Jej7g1zPTa5LuzQElEQIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://test.zijinwenchuang.com/pages/front/sales/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://mycpfzt.vipgz1.idcfengye.com/sales/zffshd";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "D:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑


}
