/*
 * Copyright 2008-2009 the original author or authors.
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
package net.hasor.rsf.domain;
/**
 * Server:Unknown、Message、MovedPermanently、Unauthorized
 * Client:
 * @version : 2014年9月20日
 * @author 赵永春(zyc@hasor.net)
 */
public interface ProtocolStatus {
    /**未定义*/
    public static final short Unknown            = 0;
    /**不支持的协议版本。*/
    public static final short ProtocolUndefined  = 505;
    /**协议编码解码错误。*/
    public static final short ProtocolError      = 505;
    /**序列化异常。*/
    public static final short SerializeError     = 511;
    /**序列化类型未定义。*/
    public static final short SerializeForbidden = 210;
    /**客户端错误。*/
    public static final short NetworkError       = 600;
    //
    //-----------------------------------------------------Server(Response)
    //
    /**内容正确返回。*/
    public static final short OK                 = 200;
    /**服务资源不可用。*/
    public static final short Forbidden          = 403;
    /**服务资源不可用。*/
    public static final short QueueFull          = 403;
    /**调用服务执行出错，通常是遭到异常抛出。*/
    public static final short InvokeError        = 500;
    //-----------------------------------------------------Client(Request)
    //
    /**达到发送限制。*/
    public static final short SendLimitPolicy    = 408;
    /**超出允许的时间。*/
    public static final short Timeout            = 408;
    //
    //
    //
    //    /**试图调用受保护的服务。*/
    //    Unauthorized(401, ""), //
    //    /**找不到服务*/
    //    NotFound(404, ""), //
    //-----------------------------------------------------
}