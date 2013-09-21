package org.eacan.server.event.impl;

import com.google.protobuf.Message;
import io.netty.channel.Channel;
import org.apache.log4j.Logger;
import org.eacan.server.Dao.Model.Account;
import org.eacan.server.event.Events;
import org.eacan.server.event.IEvent;
import org.eacan.server.event.IEventHandler;
import org.eacan.server.model.Player;
import org.eacan.server.service.ILookupService;
import org.eacan.server.util.LogUtil;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-18
 * 类描述:
 * 版本:
 */
public class BaseLoginEventHandler implements IEventHandler{
    private static final Logger logger = LogUtil.getDefaultInstance();
    private ILookupService lookupService;

    @Override
    public void onEvent(IEvent event) {
    }

    @Override
    public int getEventType() {
        return 0;
    }

    @Override
    public void doEventHandlerMethodLookUp(IEvent event){
        switch (event.getType()){
            case Events.LOG_IN:
                break;
            case Events.RECONNECT:
                break;
        }
    }

    protected Player lookupPlayer(Message message,Channel channel){
        Account account = new Account(message);
        Player player = lookupService.playerLookup(account);
        if (null == player){
            logger.error("Invalid player accross account:"+account.getName());
        }
        return player;
    }

    protected void handleLogin(Player player,Channel channel,Message message){
        if (player != null){
//            channel.write()
        }
    }


}
