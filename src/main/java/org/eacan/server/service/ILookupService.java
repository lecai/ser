package org.eacan.server.service;

import org.eacan.server.Dao.Model.Account;
import org.eacan.server.model.Game;
import org.eacan.server.model.GameRoom;
import org.eacan.server.model.Player;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-18
 * 类描述:
 * 版本:
 */
public interface ILookupService {

    /**
     * connection service to connect to a game room of game through a gameObjectKey
     * connection -> gameroom
     * @param gameObjectKey
     * @return
     */
    abstract GameRoom gameRoomLookup(Object gameObjectKey);

    /**
     * playsession -> game
     * @param gameObjectKey
     * @return
     */
    abstract Game gameLookup(Object gameObjectKey);

    /**
     * lookup a player through account
     * @param account
     * @return
     */
    abstract Player playerLookup(Account account);
}
