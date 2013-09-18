package org.eacan.server.event.impl;

import org.apache.log4j.Logger;
import org.eacan.server.event.Events;
import org.eacan.server.event.IEvent;
import org.eacan.server.event.ISessionEventHandler;
import org.eacan.server.model.ISession;
import org.eacan.server.model.PlayerSession;
import org.eacan.server.util.LogUtil;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-16
 * 类描述:
 * 版本:
 */
public class BaseSessionEventHandler implements ISessionEventHandler{
    private static final Logger logger = LogUtil.getDefaultInstance();

    private final ISession session;

    public BaseSessionEventHandler(ISession session) {
        this.session = session;
    }


    @Override
    public ISession getSession() {
        return null;
    }

    @Override
    public void setSession(ISession session) throws UnsupportedOperationException {
    }

    @Override
    public void onEvent(IEvent event) {
    }

    @Override
    public int getEventType() {
        return Events.ANY;
    }

    protected void doEventHandlerMethodLookUp(IEvent event){
        switch (event.getType()){
            case Events.SESSION_MESSAGE:
                break;
            case Events.NETWORK_MESSAGE:
                break;
            case Events.LOG_IN_SUCCESS:
                break;
            case Events.LOG_IN_FAILED:
                break;
            case Events.CONNECT:
                break;
            case Events.START:
                break;
            case Events.STOP:
                break;
            case Events.CONNECT_FAILED:
                break;
            case Events.DISCONNECT:
                break;
            case Events.CHANGE_ATTRIBUTE:
                break;
            case Events.EXCEPTION:
                break;
            case Events.RECONNECT:
                break;
            case Events.LOG_OUT:
                break;
            default:
                break;
        }
    }

    protected void onDataIn(IEvent event){
        if (null != getSession()){
            PlayerSession pSession = (PlayerSession)getSession();
            IEvent networkEvent =new BaseEvent();
            pSession.getParentGameRoom().sendBroadcast();
        }
    }

    protected void onLoginSuccess(IEvent event){
//        getSession().
    }



}
