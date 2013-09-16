package org.eacan.server.common;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;
import org.eacan.server.util.LogUtil;

import java.net.InetAddress;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public abstract class AbstractChannelHandler extends SimpleChannelInboundHandler {
    private static final Logger log = LogUtil.getDefaultInstance();
    /**
     * 客户端ip
     */
    protected InetAddress inetAddress;

    /**
     * 客户端对应的channel
     */
    protected Channel channel;

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
           log.info("Channel disconnected IP:" + inetAddress.getHostAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause) throws Exception{
          log.error("NETTY:Exception Caught:"+cause.getCause());
          ctx.channel().close();
    }


}
