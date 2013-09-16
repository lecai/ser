package org.eacan.server.model;

import org.eacan.server.common.AbstractChannelHandler;
import org.eacan.server.util.IdFactory;
import org.eacan.server.work.DefaultChannelHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public class DefaultSession implements ISession{
    /**
     * session id
     */
    protected  Object id;

    /**
     * channel handler
     */
    protected DefaultChannelHandler channelHandler;

    /**
     * session参数
     */
    protected  Map<String,Object> sessionAttributes;

    protected  long createTime;

    protected  long lastReadWriteTime;

    protected Status status;

    public DefaultSession(SessionBuilder builder){

    }

    public DefaultSession() {
    }

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public void setId(Object id) {
        this.id = id;
    }

    @Override
    public void setAttribute(String key, Object value) {
        sessionAttributes.put(key,value);
    }

    @Override
    public Object getAttribute(String key) {
        return sessionAttributes.get(key);
    }

    @Override
    public void removeAttribute(String key) {
        sessionAttributes.remove(key);
    }

    @Override
    public DefaultChannelHandler getChannelHandler() {
        return channelHandler;
    }

    @Override
    public long getCreationTime() {
        return createTime;
    }

    @Override
    public long getLastReadWriteTime() {
        return lastReadWriteTime;
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public Map<ChannelType, Channel> getChannelList() {
        return null;
    }


    public static class SessionBuilder
    {
        protected Object id = null;
        protected AbstractChannelHandler channelHandler = null;
        protected Map<String,Object> sessionAttributes;
        protected long creationTime = 0l;
        protected long lastReadWriteTime = 0l;
        protected Status status = Status.NOT_CONNECTED;

        public ISession build()
        {
            return new DefaultSession(this);
        }

        protected void initAndSetValues(){
            if (null == id)
            {
                id = IdFactory.getInstance().nextIdFor(DefaultSession.class);
            }
            if (null == channelHandler)
            {

            }
            if (null == sessionAttributes)
            {
                sessionAttributes=new HashMap<String, Object>();
            }
            creationTime = System.currentTimeMillis();
        }

        public Object getId()
        {
            return id;
        }

        public SessionBuilder id(final String id)
        {
            this.id = id;
            return this;
        }

        public SessionBuilder sessionAttributes(final Map<String,Object> sessionAttributes)
        {
            this.sessionAttributes = sessionAttributes;
            return this;
        }

        public SessionBuilder creationTime(long creationTime)
        {
            this.creationTime = creationTime;
            return this;
        }

        public SessionBuilder status(Status status)
        {
            this.status = status;
            return this;
        }
    }


    public synchronized void close(){
       //TODO:
    }


}
