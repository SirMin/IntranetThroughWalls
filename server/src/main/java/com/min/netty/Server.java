package com.min.netty;

import com.min.netty.handler.DispatcherHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Create By minzhiwei On 2018/12/25 13:42
 * TODO 功能描述
 */
public class Server {
    public static void main(String[] args) throws InterruptedException {
        final NioEventLoopGroup parent = new NioEventLoopGroup();
        final NioEventLoopGroup worker = new NioEventLoopGroup();
        final ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(parent, worker)
                .localAddress(9999)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new DispatcherHandler());
                    }
                })
                .option(ChannelOption.SO_BACKLOG, 128)          // (5)
                .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
        final ChannelFuture sync = serverBootstrap.bind().sync();
        sync.channel().closeFuture().sync();
    }
}
