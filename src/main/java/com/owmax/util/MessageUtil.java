package com.owmax.util;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsRequest;
import com.aliyuncs.sms.model.v20160927.SingleSendSmsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by dello on 2016/11/30.
 */

@Component("messageUtil")
public class MessageUtil {

    private static final Logger log = LoggerFactory.getLogger(MessageUtil.class);

    public static final String address="cn-hangzhou";
    public static final String accessKey="LTAI27jFzuRwKEJX";
    public static final String accessSecret="GrAgxO8X2tJYCLi1XCl3OnDPYD0jgJ";

    public void sendMessage(String signName,String templateCode ,String ParamString ,String number) throws ClientException {
        IClientProfile profile = DefaultProfile.getProfile(address, accessKey, accessSecret);
        DefaultProfile.addEndpoint(address, address, "Sms",  "sms.aliyuncs.com");
        IAcsClient client = new DefaultAcsClient(profile);
        SingleSendSmsRequest request = new SingleSendSmsRequest();
        try {
            request.setSignName(signName);
            request.setTemplateCode(templateCode);
            request.setParamString(ParamString);
            request.setRecNum(number);
            SingleSendSmsResponse httpResponse = client.getAcsResponse(request);
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
    }

    public static String generateCheckNum(){
        String str="";
        Random random=new Random();
        for(int i=0;i<4;i++){
            str+=String.valueOf(random.nextInt(10));
        }
        return str;
    }

//    public static void main(String[] args) throws ClientException {
//        String checkNum=generateCheckNum();
//        log.info(checkNum);
//        new MessageUtil().sendMessage("及应","SMS_31795073","{'check':'"+checkNum+"'}","13072783289");
//    }
}
