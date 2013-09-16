package org.eacan.server.event.impl;

import org.eacan.server.event.IEventContext;
import org.eacan.server.model.ISession;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-16
 * 类描述:
 * 版本:
 */
public class BaseEventContext implements IEventContext{
    protected Object attachment;
    protected ISession session;


    @Override
    public ISession getSession() {
        return session;
    }

    @Override
    public void setSession(ISession session) {
        this.session = session;
    }

    @Override
    public Object getAttachment() {
        return attachment;
    }

    @Override
    public void setAttachment(Object attachment) {
        this.attachment = attachment;
    }
}
