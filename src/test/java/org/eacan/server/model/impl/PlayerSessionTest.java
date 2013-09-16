package org.eacan.server.model.impl;

import org.eacan.server.model.*;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-16
 * 类描述:
 * 版本:
 */
public class PlayerSessionTest {

    private static final AtomicLong COUNTER = new AtomicLong(0l);
    private static final int NUM_OF_GAME_ROOMS = 1000;
    private static final int SESSIONS_PER_GAME_ROOM = 50;
    private Game game;
    private List<GameRoom> gameRoomList;
    private List<ISession> sessionList;

    @Before
    public void setUp(){
        game = new Game("test",1);
        gameRoomList = new ArrayList<GameRoom>(NUM_OF_GAME_ROOMS);
        sessionList = new ArrayList<ISession>(NUM_OF_GAME_ROOMS * SESSIONS_PER_GAME_ROOM);
        for (int i =0;i<NUM_OF_GAME_ROOMS;i++){
            GameRoomSession.GameRoomSessionBuilder gameRoomSessionBuilder = new GameRoomSession.GameRoomSessionBuilder();
            gameRoomSessionBuilder.parentGame(game).gameRoomName("WOW_GAME_"+i);
        }
    }

    private static class TestGameRoom extends GameRoomSession{

        protected TestGameRoom(GameRoomSessionBuilder builder) {
            super(builder);
        }

        @Override
        public void onLogin(PlayerSession playerSession) {
        }
    }
}
