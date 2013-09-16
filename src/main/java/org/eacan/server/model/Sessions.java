package org.eacan.server.model;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-15
 * 类描述:
 * 版本:
 */
public class Sessions {
    public static ISession newSession()
    {
        return new DefaultSession.SessionBuilder().build();
    }

    public static PlayerSession newPlayerSession(GameRoom gameRoom,Player player)
    {
        return new PlayerSession.PlayerSessionBuilder().parentGameRoom(gameRoom).player(player).build();
    }
}
