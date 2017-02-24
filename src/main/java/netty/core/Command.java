package netty.core;

import io.netty.channel.Channel;
import netty.core.bean.FlagBean;
import netty.core.bean.ProtocolHeader;
import netty.core.bean.ProtocolMsg;

import com.alibaba.fastjson.JSONObject;

public class Command {

	public static void authLogin(Channel channel,String userName,String password,short seq){
		JSONObject auth = new JSONObject();
		auth.put("userName", userName);
		auth.put("password", password);
		ProtocolHeader header = new ProtocolHeader();
		FlagBean flag = new FlagBean((byte)1,(byte)4, (byte)8);
		header.setFlag(flag.getFlagBean());
		header.setType(CommandTypeEnum.REQUEST_TYPE.getValue());
		header.setError((byte)0);
		header.setSeq(seq);
		header.setCommand((short)1);
		header.setLength((short)auth.toJSONString().length());
		ProtocolMsg msg = new  ProtocolMsg();
		msg.setHeader(header);
		msg.setBody(auth.toJSONString());
		channel.writeAndFlush(msg);
		
	}
}
