package com.zx.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
import com.zx.Pojo.Message;

public class ShortMessageUnit {
	public static String url="http://gw.api.taobao.com/router/rest";
//	public static String url="http://localhost:8080/login";
	public Message sendShortMessage(String tel,String code) throws Exception
	{
//		String url="http://gw.api.taobao.com/router/rest";  
		//成为开发者，创建应用后系统自动生成  
		String appkey="23707333";  
		String secret="b72fd7204d077062ce908016db3fab56";  
		//短信模板的内容  
//		String tel="18310137178";
		String json="{\"code\":\""+code+"\",\"product\":\"高米店街道全媒体微信公众平台\"}";  
		TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);  
		AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();  
//		req.setExtend("123456");  
		req.setSmsType("normal");  
		req.setSmsFreeSignName("助力出品");  
		req.setSmsParamString(json);  
		req.setRecNum(tel);  
		req.setSmsTemplateCode("SMS_56675298");  
		try {  
		    AlibabaAliqinFcSmsNumSendResponse rsp = client.execute(req);  
		    System.out.println(rsp.getBody());  
		    return new Message("success", "发送成功！", new Date());  
		} catch (Exception e) {  
		    // TODO: handle exception  
			return new Message("fail", "发送失败！", new Date());  
		}  
	}
}
