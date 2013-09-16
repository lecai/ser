package org.eacan.server.model;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-14
 * 类描述:
 * 版本:
 */
public class PlayerSession extends DefaultSession{
    /**
     * 该session对应的player
     */
    final protected Player player;

    /**
     *  每个用户 被连接到  指定 游戏服（GameRoom）下
     */
    protected GameRoom parentGameRoom;

    public PlayerSession(PlayerSessionBuilder builder) {
        super(builder);
        this.player = builder.player;
        this.parentGameRoom = builder.parentGameRoom;
    }

    public PlayerSession(Player player, GameRoom parentGameRoom) {
        this.player = player;
        this.parentGameRoom = parentGameRoom;
    }


    public Player getPlayer() {
        return player;
    }

    public GameRoom getParentGameRoom() {
        return parentGameRoom;
    }

    public void setParentGameRoom(GameRoom parentGameRoom) {
        this.parentGameRoom = parentGameRoom;
    }

    public static class PlayerSessionBuilder extends SessionBuilder
    {
        protected Player player = null;
        protected GameRoom parentGameRoom;

        public PlayerSession build(){
            return new PlayerSession(this);
        }

        public PlayerSessionBuilder player(Player player)
        {
            this.player = player;
            return this;
        }

        public PlayerSessionBuilder parentGameRoom(GameRoom parentGameRoom)
        {
            if (null == parentGameRoom){
                throw new IllegalArgumentException(
                        "GameRoom instance is null,session will not be constructed"
                );
            }
            this.parentGameRoom = parentGameRoom;
            return this;
        }

        @Override
        protected void initAndSetValues()
        {
           if (null == channelHandler){

           }
            super.initAndSetValues();
        }
    }

    public synchronized void close(){
        //TODO:
        super.close();
        parentGameRoom.disconnectSession(this);
    }

    @Override
    public String toString()
    {
        return "PlayerSession [id=" + id + "player=" + player
                + ", parentGameRoom=" + parentGameRoom + "]";
    }
}
