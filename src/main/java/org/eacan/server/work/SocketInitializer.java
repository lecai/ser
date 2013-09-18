package org.eacan.server.work;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import org.eacan.server.codec.MessageBufferEventDecoder;
import org.eacan.server.codec.MessageBufferEventEncoder;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-17
 * 类描述:
 * 版本:
 */
public class SocketInitializer extends ChannelInitializer<SocketChannel>{
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline p = ch.pipeline();
        //Up handlers or encoders (i.e towards server)

        p.addLast("protobufDecoder",new MessageBufferEventDecoder());
        p.addLast("eventHandler",new DefaultChannelHandler());

        //Down handlers or decoders()
        p.addLast("protobufEncoder",new MessageBufferEventEncoder());
    }
}
