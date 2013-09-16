package org.eacan.server.event.impl;

import com.google.protobuf.Message;
import org.eacan.server.event.IEvent;
import org.eacan.server.event.IEventContext;

import java.io.Serializable;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-16
 * 类描述:
 * 版本:
 */
public class BaseEvent implements IEvent,Serializable{
    protected IEventContext eventContext;
    protected int type;
    protected Message message;
    protected long timeStamp;


    @Override
    public int getType() {
        return type;
    }

    @Override
    public void setType(int type) {
        this.type = type;
    }

    @Override
    public Message getMessage() {
        return message;
    }

    @Override
    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public IEventContext getEventContext() {
        return eventContext;
    }

    @Override
    public void setEventContext(IEventContext eventContext) {
        this.eventContext = eventContext;
    }

    @Override
    public long getTimeStamp() {
        return timeStamp;
    }

    @Override
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
