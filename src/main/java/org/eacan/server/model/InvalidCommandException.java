package org.eacan.server.model;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public class InvalidCommandException extends Exception {
    /**
     * Eclipse generated serial id.
     */
    private static final long serialVersionUID = 6458355917188516937L;

    public InvalidCommandException(String message)
    {
        super(message);
    }
    public InvalidCommandException(String message, Exception e)
    {
        super(message,e);
    }
}
