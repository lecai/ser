package org.eacan.server.event;

import com.google.protobuf.Message;
import org.eacan.server.event.impl.BaseEvent;
import org.eacan.server.event.impl.BaseEventContext;
import org.eacan.server.model.ISession;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-16
 * 类描述:
 * 版本:
 */
public class Events {

    /**
     * protobuf 参照陈硕 可不需要协议版本号 ,但此处预留
     */
    public static final byte PROTO_VERSION = 0x01;

    /**
     * 该type 应该 不出现.但是出现此type 对应的 handler 处理所有的incoming events
     */
    public final static byte ANY = 0x00;

    /************************************************************************************
     *针对于event下的 session 同时该type可以作为数据包中的opcode
     ***********************************************************************************/

    /**
     * 表示该event连接,同时作为该event存活的生命周期
     */
    public final static byte CONNECT = 0x02;

    /**
     * 类似于LOG_IN type 但是区别于LOG_IN RECONNECT只能client to server.
     */
    public final static byte RECONNECT  = 0x03;
    public final static byte CONNECT_FAILED = 0x04;

    public final static byte LOG_IN = 0x08;
    public final static byte LOG_OUT = 0x0a;
    public final static byte LOG_IN_SUCCESS = 0X0b;
    public final static byte LOG_IN_FAILED = 0x0c;
    public final static byte LOG_OUT_SUCCESS = 0x0e;
    public final static byte LOG_OUT_FAILURE = 0x0f;

    //Metadata Events
    public static final byte GAME_LIST = 0x10;
    public static final byte ROOM_LIST = 0x12;
    public static final byte GAME_ROOM_JOIN = 0x14;
    public static final byte GAME_ROOM_LEAVE = 0x16;
    public static final byte GAME_ROOM_JOIN_SUCCESS = 0x18;
    public static final byte GAME_ROOM_JOIN_FAILURE = 0x19;

    /**
     * 该类别 表示 server发送event 通知 client 可以开始发送消息了
     */
    public static final byte START = 0x1a;

    /**
     * 该类别 表示 server发送event 通知 client 停止发送消息
     */
    public static final byte STOP = 0x1b;

    /**
     * 服务器间(machine/JVM) to this JVM message(client or server)
     */
    public static final byte SESSION_MESSAGE = 0x1c;

    /**
     *
     */
    public static final byte NETWORK_MESSAGE = 0x1d;

    public static final byte CHANGE_ATTRIBUTE = 0x20;

    /**
     * 如何一个远程连接断开 触发此类别对应的event
     */
    public static final byte DISCONNECT = 0x22;

    /**
     * 网络故障,触发此类别对应的event
     */
    public static final byte EXCEPTION = 0x24;

    public static IEvent event(Message message,int eventType){
        return event(message, eventType,(ISession)null);
    }

    public static IEvent event(Message message,int eventType,ISession session){
        IEventContext context = null;
        if (null != session){
            context = new BaseEventContext();
            context.setSession(session);
        }
        return event(message,eventType,context);
    }

    public static IEvent event(Message message,int eventType,IEventContext eventContext){
        BaseEvent event = new BaseEvent();
        event.setEventContext(eventContext);
        event.setMessage(message);
        event.setType(eventType);
        event.setTimeStamp(System.currentTimeMillis());
        return event;
    }

    public static IEvent networkEvent(Message message){
        IEvent event = event(message,Events.NETWORK_MESSAGE);
        return event;
    }

    public static IEvent dataInEvent(Message message){
        return event(message,Events.SESSION_MESSAGE);
    }

//    public static IEvent changeAttributeEvent()






}
