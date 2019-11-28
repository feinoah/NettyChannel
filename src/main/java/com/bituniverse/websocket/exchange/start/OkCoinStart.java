package com.bituniverse.websocket.exchange.start;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.bituniverse.websocket.netty.WebSocketService;
import com.bituniverse.websocket.netty.WebSoketClient;
import com.bituniverse.websocket.utils.PropertyUtils;
import com.google.gson.JsonObject;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Log4j2
public class OkCoinStart {
    public static void start(){
        log.info("okcoin订阅方法启动");
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        PropertyUtils pt = new PropertyUtils("serverUrl.properties");
        String okcoinServer = pt.getProperty("OKCOIN.WEBSOCKET");
        WebSocketService service = context.getBean(WebSocketService.class);
        // WebSocket客户端
        WebSoketClient client = new WebSoketClient(okcoinServer, service);
        log.info("websocket--okcoin链接建立");
        // 启动客户端
        try {
            client.start();
        } catch (Exception e) {
            e.printStackTrace();
            client.start();
        }
        //订阅最新价格
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("op", "subscribe");
        JSONArray jsonArray = new JSONArray();
        jsonArray.add("spot/depth5:ETH-USDT");
        jsonObject.put("args", jsonArray);
        client.addChannel(jsonObject.toJSONString());
    }
}