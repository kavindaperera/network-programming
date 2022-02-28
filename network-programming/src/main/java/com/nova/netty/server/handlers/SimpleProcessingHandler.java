package com.nova.netty.server.handlers;

import com.nova.netty.models.RequestData;
import com.nova.netty.models.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class SimpleProcessingHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf tmp;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        tmp = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        tmp.release();
        tmp = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);
        ByteBuf m = (ByteBuf) msg;
        tmp.writeBytes(m);
        m.release();
        if (tmp.readableBytes() >= 4){
            //  request processing
            RequestData requestData = new RequestData();
            requestData.setIntValue(tmp.readInt());
            ResponseData responseData = new ResponseData();
            requestData.setIntValue(requestData.getIntValue() * 2);
            ChannelFuture future = ctx.writeAndFlush(responseData);
            future.addListener(ChannelFutureListener.CLOSE);
        }

    }


}
