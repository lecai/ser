package org.eacan.server.model;

import java.util.Set;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-14
 * 类描述:
 * 版本:
 */
public interface GameRoom {

    /**
     *
     * @param player
     * @return
     */
    public PlayerSession createPlayerSession(Player player);

    /**
     *
     * @param playerSession
     */
    public void onLogin(PlayerSession playerSession);

    /**
     *
     * @param playerSession
     * @return
     */
    public abstract boolean connectSession(PlayerSession playerSession);

    /**
     *
     * @param playerSession
     */
    public void afterSessionConnect(PlayerSession playerSession);

    /**
     *
     * @param playerSession
     * @return
     */
    public abstract boolean disconnectSession(PlayerSession playerSession);

    /**
     *
     * @return
     */
    public abstract Set<PlayerSession> getSessions();

    /**
     *
     * @param gameRoomName
     */
    public abstract void setGameRoomName(String gameRoomName);

    /**
     *
     * @return
     */
    public abstract Game getParentGame();

    /**
     * gameroom broadcast (主要是用于游戏下对所有玩家广播)
     */
    public abstract void sendBroadcast();

    /**
     *
     */
}
