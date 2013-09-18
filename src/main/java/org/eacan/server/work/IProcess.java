package org.eacan.server.work;

import org.eacan.server.event.IEvent;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public interface IProcess {
    /**
     *
     * @param event
     */
    public abstract void process(final IEvent event);

    public abstract void onShutdown();

}
