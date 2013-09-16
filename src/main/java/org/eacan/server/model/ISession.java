package org.eacan.server.model;

import org.eacan.server.work.DefaultChannelHandler;

import java.util.Map;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public interface ISession {
    /**
     * session状态类型
     */
    enum Status
    {
        NOT_CONNECTED,CONNECTING,CONNECTED,CLOSED
    }

    Object getId();

    void setId(Object id);

    void setAttribute(String key,Object value);

    Object getAttribute(String key);

    void removeAttribute(String key);

    DefaultChannelHandler getChannelHandler();

    long getCreationTime();

    long getLastReadWriteTime();

    void setStatus(Status status);

    Status getStatus();

    boolean isConnected();

    Map<ChannelType,Channel> getChannelList();
}
