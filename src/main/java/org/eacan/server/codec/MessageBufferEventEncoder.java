package org.eacan.server.codec;

import com.google.protobuf.Message;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import org.apache.log4j.Logger;
import org.eacan.server.event.IEvent;
import org.eacan.server.util.LogUtil;

import java.util.List;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-17
 * 类描述:
 * 版本:
 */
public class MessageBufferEventEncoder extends MessageToMessageEncoder<IEvent>{
    private static final Logger logger = LogUtil.getDefaultInstance();

    @Override
    protected void encode(ChannelHandlerContext ctx, IEvent msg, List<Object> out) throws Exception {
        if (null == msg)
        {
           logger.error("Null message received in MessageBufferEventEncoder");
        }
        ByteBuf opcode = Unpooled.buffer(1);
        opcode.writeByte(msg.getType());
        ByteBuf buf = null;
        if (null != msg.getMessage())
        {
            Message message = msg.getMessage();
            int size = message.getSerializedSize();
//            ByteBuf byteBuf = new
        }

    }
}
