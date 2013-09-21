package org.eacan.server.event;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-16
 * 类描述:
 * 版本:
 */
public interface IEventHandler {
    /**
     * on event
     * @param event
     */
    void onEvent(IEvent event);

    int getEventType();

    void doEventHandlerMethodLookUp(IEvent event);
}
