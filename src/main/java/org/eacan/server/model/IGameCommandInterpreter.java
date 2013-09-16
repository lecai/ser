package org.eacan.server.model;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述: 游戏注入接口 map<Class,commandID></>
 * 版本:
 */
public interface IGameCommandInterpreter {

    public void interpretCommand(Object command) throws InvalidCommandException;
}
