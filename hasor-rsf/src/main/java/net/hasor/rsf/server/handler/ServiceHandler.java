/*
 * Copyright 2008-2009 the original 赵永春(zyc@hasor.net).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.hasor.rsf.server.handler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import net.hasor.rsf.metadata.RequestMetaData;
import net.hasor.rsf.metadata.ResponseMetaData;
import net.hasor.rsf.transfer.TWrite;
import net.hasor.rsf.transfer.TrackManager;
/**
 * 
 * @version : 2014年11月4日
 * @author 赵永春(zyc@hasor.net)
 */
public class ServiceHandler extends ChannelInboundHandlerAdapter {
    private static final int CAPACITY     = 4096;
    private TrackManager     trackManager = new TrackManager(TMEnum.values(), 20, CAPACITY);
    private static enum TMEnum {
        MsgIn
    }
    //
    //
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        TWrite write = this.trackManager.waitForWrite(TMEnum.MsgIn);
        if (msg instanceof RequestMetaData) {
            write.pushGood(msg);//Request
        } else if (msg instanceof ResponseMetaData) {
            write.pushGood(msg);//Response
        }
        this.trackManager.switchNext(TMEnum.MsgIn);
    }
}