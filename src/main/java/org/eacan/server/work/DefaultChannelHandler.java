package org.eacan.server.work;

import io.netty.channel.ChannelHandlerContext;
import org.apache.log4j.Logger;
import org.eacan.server.common.AbstractChannelHandler;
import org.eacan.server.model.Player;
import org.eacan.server.util.LogUtil;

import java.net.InetSocketAddress;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public class DefaultChannelHandler extends AbstractChannelHandler{
    private static final Logger logger = LogUtil.getDefaultInstance();

    private State  state;
    private Player player;


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);

        state = State.CONNECTED;
        inetAddress = ((InetSocketAddress)ctx.channel().remoteAddress()).getAddress();
        channel = ctx.channel();
        logger.info("Channel connected Ip:"+inetAddress.getHostAddress());
    }
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);


    }

    public static enum State
    {
        /**
         * player connected
         */
        CONNECTED,
        /**
         * player authenticated
         */
        AUTHED,
    }
}
