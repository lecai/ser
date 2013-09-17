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

    private boolean isShuttingDown = false;
    private static int size = 50000;
    private static DoubleBufferedQueue<IEvent> readQueue = new DoubleBufferedQueue<IEvent>(size);
    private static ReaderPacketHandler readerPacketHandler;

    static {
        readerPacketHandler = new ReaderPacketHandler();
        Thread t = new Thread(readerPacketHandler);
        t.start();
    }

    @Override
    public void run() {
        while (!isShuttingDown){
            try {
                IEvent event = readQueue.poll();
                if (event!=null){
                    //TODO:进入eventDispatcher 具体分发
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void receive(IEvent event){
        if (event == null)
        {
            return;
        }
        try {
            readQueue.put(event);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }








}
