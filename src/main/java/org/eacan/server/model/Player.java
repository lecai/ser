package org.eacan.server.model;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public class Player {
    /**
     * 玩家(client) id 数据库id
     */
      private Object id;
    /**
     * 玩家用户名
     */
    private String name;
    /**
     * 玩家的email id
     */
    private String emailId;

    /**
     * 玩家{@link Player}连接到服务器后产生的对应session
     */
    PlayerSession playerSession;

    public Player(){

    }
    public Player(Object id, String name, String emailId, PlayerSession playerSession) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.playerSession = playerSession;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result =1;
        result = prime * result +((id == null)?0:id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (id == null)
        {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public PlayerSession getPlayerSession() {
        return playerSession;
    }

    public void setPlayerSession(PlayerSession playerSession) {
        this.playerSession = playerSession;
    }


    public synchronized void logout(){
        this.playerSession.close();
    }
}
