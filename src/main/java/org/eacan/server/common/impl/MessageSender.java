package org.eacan.server.common.impl;

import com.google.protobuf.Message;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import org.apache.log4j.Logger;
import org.eacan.server.common.IMessageSender;
import org.eacan.server.event.Events;
import org.eacan.server.event.IEvent;
import org.eacan.server.util.LogUtil;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-18
 * 类描述:
 * 版本:
 */
public class MessageSender implements IMessageSender{
    private final Channel channel;
    private static final Logger logger = LogUtil.getDefaultInstance();

    public MessageSender(Channel channel) {
        super();
        this.channel = channel;
    }

    @Override
    public Object sendMessage(Message message) {
        return channel.write(message);
    }

    @Override
    public void close() {
        logger.debug("Going to close tcp connection in class: {}"+this
                .getClass().getName());
        IEvent event = Events.event(null, Events.DISCONNECT);
        if (channel.isActive())
        {
            channel.write(event).addListener(ChannelFutureListener.CLOSE);
        }
        else
        {
            channel.close();
            logger.trace("Unable to write the Event"+event +"with type "+event.getType()+ "to socket");
        }
    }

    @Override
    public String toString(){
        String channelId = "TCP channel with Id: ";
        if (null != channel)
        {
            channelId += channel.toString();
        }
        else
        {
            channelId += "0";
        }
        String sender = "Netty " + channelId;
        return sender;
    }

    public Channel getChannel() {
        return channel;
    }
}
