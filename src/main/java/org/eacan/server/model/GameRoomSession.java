package org.eacan.server.model;

import org.apache.log4j.Logger;
import org.eacan.server.util.IdFactory;
import org.eacan.server.util.LogUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-15
 * 类描述:
 * 版本:
 */
public abstract class GameRoomSession extends DefaultSession implements GameRoom{
    private Logger logger = LogUtil.getDefaultInstance();

    /**
     * 游戏房间名 对应着游戏服名(类比魔兽世界下的米奈希尔)
     */
    protected String gameRoomName;

    /**
     *游戏名字(魔兽世界)
     */
    protected Game parentGame;

    /**
     * 服里的在线用户session
     */
    protected Set<PlayerSession> sessions;

    protected GameRoomSession(GameRoomSessionBuilder builder) {
        super(builder);
        this.gameRoomName = builder.gameRoomName;
        this.parentGame = builder.parentGame;
        this.sessions = builder.sessions;
    }

    protected GameRoomSession(String gameRoomName, Game parentGame, Set<PlayerSession> sessions) {
        this.gameRoomName = gameRoomName;
        this.parentGame = parentGame;
        this.sessions = sessions;
    }

    public static class GameRoomSessionBuilder extends SessionBuilder{
        protected Set<PlayerSession> sessions;
        protected Game parentGame;
        protected String gameRoomName;

        @Override
        protected void initAndSetValues(){
            if (null == id)
            {
                id = IdFactory.getInstance().nextIdFor(GameRoomSession.class);
            }
            if (null == sessionAttributes)
            {
                sessionAttributes = new HashMap<String, Object>();
            }
            if (null == sessions)
            {
                sessions = new HashSet<PlayerSession>();
            }
            creationTime = System.currentTimeMillis();
        }

        public GameRoomSessionBuilder sessions(Set<PlayerSession> sessions)
        {
            this.sessions = sessions;
            return this;
        }

        public GameRoomSessionBuilder parentGame(Game parentGame)
        {
            this.parentGame = parentGame;
            return this;
        }

        public GameRoomSessionBuilder gameRoomName(String gameRoomName)
        {
            this.gameRoomName = gameRoomName;
            return this;
        }
    }

    public PlayerSession createPlayerSession(Player player){
        PlayerSession playerSession = getSessionInstance(player);
        return playerSession;
    }

    public abstract void onLogin(PlayerSession playerSession);

    public synchronized boolean connectSession(PlayerSession playerSession){
        playerSession.setStatus(Status.CONNECTING);
        sessions.add(playerSession);
        playerSession.setParentGameRoom(this);
        //TODO: 创建playersession对应的handler

        playerSession.setStatus(Status.CONNECTED);
        afterSessionConnect(playerSession);
        return true;
        //TODO: 通知其它session (如用户上线后续操作)


    }

    public void afterSessionConnect(PlayerSession playerSession){

    }

    public synchronized boolean disconnectSession(PlayerSession playerSession){
        //TODO:从 readHandler(缓存队列) 删除对应的handler
        final boolean removeHandlers = true;
        return (removeHandlers && sessions.remove(playerSession));
    }

    public PlayerSession getSessionInstance(Player player){
        PlayerSession playerSession = Sessions.newPlayerSession(this,player);
        return playerSession;
    }

    @Override
    public void sendBroadcast(){

    }
    public String getGameRoomName() {
        return gameRoomName;
    }

    public void setGameRoomName(String gameRoomName) {
        this.gameRoomName = gameRoomName;
    }

    public Game getParentGame() {
        return parentGame;
    }

    public void setParentGame(Game parentGame) {
        this.parentGame = parentGame;
    }

    public Set<PlayerSession> getSessions() {
        return sessions;
    }

    public void setSessions(Set<PlayerSession> sessions) {
        this.sessions = sessions;
    }


}
