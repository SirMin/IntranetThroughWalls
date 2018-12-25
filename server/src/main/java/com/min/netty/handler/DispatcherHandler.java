package com.min.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * Create By minzhiwei On 2018/12/25 13:42
 * TODO 功能描述
 */
public class DispatcherHandler extends SimpleChannelInboundHandler<ByteBuf> {

    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println(msg.toString(CharsetUtil.UTF_8));
    }
}
