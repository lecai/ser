package org.eacan.server.common;

import com.google.protobuf.Message;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-18
 * 类描述:
 * 版本:
 */
public interface IMessageSender {
    /**
     * this method delegates to the underlying native session object to send
     * a message to client
     *
     * @param message
     * @return
     */
    Object sendMessage(Message message);

    /**
     * message sender maybe have a network connection,it would require
     * some cleanup.
     */
    void close();
}
