package org.eacan.server.event;

import org.eacan.server.model.ISession;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-16
 * 类描述:
 * 版本:
 */
public interface ISessionEventHandler extends IEventHandler{
    ISession getSession();

    /**
     * 此方法不能被调用 Session是由构造函数传进
     * @param session
     * @throws UnsupportedOperationException
     */
    public void setSession(ISession session) throws UnsupportedOperationException;
}
