package org.eacan.server.event;

import org.eacan.server.model.ISession;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-16
 * 类描述: event 上下文 主要是关联 {session}
 * 版本:
 */
public interface IEventContext {
    ISession getSession();
    void setSession(ISession session);

    /**
     * 通过该attachment 特殊找回该context
     * @return
     */
    Object getAttachment();
    void setAttachment(Object attachment);
}
