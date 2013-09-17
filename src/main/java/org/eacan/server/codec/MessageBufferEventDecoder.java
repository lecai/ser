package org.eacan.server.codec;

import com.google.protobuf.Message;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import org.apache.log4j.Logger;
import org.eacan.server.event.Events;
import org.eacan.server.event.IEvent;
import org.eacan.server.util.LogUtil;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Adler32;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-17
 * 类描述:
 * 版本:
 */
public class MessageBufferEventDecoder extends ByteToMessageDecoder{

    private Map<String,Message> knownType = new HashMap<String, Message>();
    private static final Logger logger = LogUtil.getDefaultInstance();
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in == null)
        {
            logger.error("Null Message Received in MessageBufferEventDecoder");
            return;
        }
        byte opcode = in.readByte();
        if (opcode == Events.NETWORK_MESSAGE)
        {
            opcode = Events.SESSION_MESSAGE;
        }
        if (in.readableBytes() >= 10 && checksum(in))
        {
            int nameLen = in.readInt();
            String typeName = in.toString(in.readerIndex(), nameLen - 1, Charset.defaultCharset());
            in.readerIndex(in.readerIndex()+nameLen);
            Message message = knownType.get(typeName);
            if (message!=null)
            {
                message.newBuilderForType().mergeFrom(in.array(),in.arrayOffset()+in.readerIndex(),
                        in.readableBytes()-4).build();
            }
            IEvent event = Events.event(message,opcode);
            out.add(event);
        }
    }

    private boolean checksum(ByteBuf byteBuf){
        Adler32 adler32 = new Adler32();
        adler32.update(byteBuf.array(),byteBuf.arrayOffset()+byteBuf.readerIndex(),
                byteBuf.readableBytes()-4);
        byteBuf.markReaderIndex();
        byteBuf.readerIndex(byteBuf.writerIndex()-4);
        int checksum = byteBuf.readInt();
        return checksum == (int)adler32.getValue();
    }
}
