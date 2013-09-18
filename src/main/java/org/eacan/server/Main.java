package org.eacan.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.apache.log4j.Logger;
import org.eacan.server.util.LogUtil;
import org.eacan.server.work.SocketInitializer;

import java.util.Date;

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

    public void run() throws Exception
    {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new SocketInitializer());
            // Start the server.
            ChannelFuture f = b.bind(port).sync();

            // Wait until the server socket is closed.
            f.channel().closeFuture().sync();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
        if (debug)
        {
           log.info("当前为测试模式");
           log.info("服务器主进程启动");
           log.info("服务器监听TCP端口:"+port);
        }
        else
        {
            System.out.print("当前为运营模式");
            System.out.print("服务器主进程启动");
            System.out.print("服务器监听TCP端口:"+port);
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println("++++++++++++++++++++++++++++++++++");
        System.out.println("Date:"+new Date());
        System.out.println("Version:0.0.1");
        System.out.println("author: LECAI");
        System.out.println("++++++++++++++++++++++++++++++++++");
        new Main(8086,true).run();
    }
}
