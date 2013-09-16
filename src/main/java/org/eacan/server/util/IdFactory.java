package org.eacan.server.util;

import java.util.BitSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public class IdFactory {
    private final BitSet idList = new BitSet();
    private final ReentrantLock lock		= new ReentrantLock();
    private AtomicInteger nextMinId	= new AtomicInteger(1);

    protected static IdFactory instance = new IdFactory();

    public static IdFactory getInstance(){
        return instance;
    }

    public Object nextId(){
        try {
            lock.lock();
            int id = idList.nextClearBit(nextMinId.intValue());
            idList.set(id);
            nextMinId.incrementAndGet();
            return id;
        }
        finally
        {
            lock.unlock();
        }
    }

    public Object nextIdFor(@SuppressWarnings("rawtypes") Class klass){
        try
        {
            lock.lock();
            int id = idList.nextClearBit(nextMinId.intValue());
            idList.set(id);
            nextMinId.incrementAndGet();
            return klass.getSimpleName()+id;
        }
        finally
        {
            lock.unlock();
        }
    }

}
