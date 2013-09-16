package org.eacan.server.model;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public class Game {
    /**
     * 游戏id
     */
    private final Object id;

    /**
     * 游戏名
     */
    private final String gameName;

    /**
     * 游戏特殊命令触发相关的events(如dota里 -rm -swap )
     */
    private final IGameCommandInterpreter gameCommandInterpreter;

    public Game(String gameName, Object id) {
        this(id,gameName,null);
    }

    public Game(Object id, String gameName, IGameCommandInterpreter gameCommandInterpreter) {
        this.id = id;
        this.gameName = gameName;
        this.gameCommandInterpreter = gameCommandInterpreter;
    }

    /**
     * 数据库主键
     * @return
     */
    public Object getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public IGameCommandInterpreter getGameCommandInterpreter() {
        return gameCommandInterpreter;
    }

    public synchronized Object unload(){
        return null;
    }

    @Override
    public int hashCode(){
        final int prime = 31;
        int result = 1;
        result = prime * result + ((gameName == null)? 0:gameName.hashCode());
        result = prime *result + ((id == null)? 0:id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Game other = (Game) obj;
        if (gameName == null) {
            if (other.gameName != null)
                return false;
        } else if (!gameName.equals(other.gameName))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
