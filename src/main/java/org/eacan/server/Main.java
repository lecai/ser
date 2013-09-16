package org.eacan.server;

import org.apache.log4j.Logger;
import org.eacan.server.util.LogUtil;

/**
 * 项目名称:
 * 创建人: lecai
 * 创建时间: 13-9-13
 * 类描述:
 * 版本:
 */
public class Main {
    private static final Logger log = LogUtil.getDefaultInstance();
    private final int port;
    private final boolean debug;

    public Main(int port, boolean debug) {
        this.port = port;
        this.debug = debug;
    }

    public void run() throws Exception{

    }
}
