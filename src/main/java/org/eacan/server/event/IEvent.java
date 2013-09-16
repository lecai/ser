package org.eacan.server.event;

import com.google.protobuf.Message;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-16
 * 类描述: 通过该类 将 session 与 message 包装起来 并且提供向下handler的分发
 * 版本:
 */
public interface IEvent {
    int getType();
    void setType(int type);
    Message getMessage();
    void setMessage(Message message);
    IEventContext getEventContext();
    void setEventContext(IEventContext eventContext);
    long getTimeStamp();
    void setTimeStamp(long timeStamp);
}
