package org.eacan.server.handlers;

import org.apache.log4j.Logger;
import org.eacan.server.event.IEvent;
import org.eacan.server.util.DoubleBufferedQueue;
import org.eacan.server.util.LogUtil;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-15
 * 类描述:
 * 版本:
 */
public class ReaderPacketHandler implements Runnable{
    private static final Logger logger = LogUtil.getDefaultInstance();

    private static int size = 50000;
    private static DoubleBufferedQueue<IEvent> readQueue = new DoubleBufferedQueue<IEvent>(size);
    private static ReaderPacketHandler readerPacketHandler;

    static {
        readerPacketHandler = new ReaderPacketHandler();

    }

    @Override
    public void run() {
    }


}
