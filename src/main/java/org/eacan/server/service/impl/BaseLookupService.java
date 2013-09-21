package org.eacan.server.service.impl;

import org.eacan.server.Dao.Model.Account;
import org.eacan.server.model.Game;
import org.eacan.server.model.GameRoom;
import org.eacan.server.model.Player;
import org.eacan.server.service.ILookupService;

import java.util.HashMap;
import java.util.Map;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-18
 * 类描述:
 * 版本:
 */
public class BaseLookupService implements ILookupService {
    private final Map<String,GameRoom> refGameRoomMap;

    public BaseLookupService(Map<String, GameRoom> refGameRoomMap) {
        this.refGameRoomMap = refGameRoomMap;
    }

    public BaseLookupService(){
        refGameRoomMap = new HashMap<String, GameRoom>();
    }

    public Map<String, GameRoom> getRefGameRoomMap() {
        return refGameRoomMap;
    }

    @Override
    public GameRoom gameRoomLookup(Object gameObjectKey) {
        return refGameRoomMap.get((String)gameObjectKey);
    }

    @Override
    public Game gameLookup(Object gameObjectKey) {
        //TODO:::
        return null;
    }

    @Override
    public Player playerLookup(Account account) {
        return new Player();
    }
}
