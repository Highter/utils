package com.yjw.utils.memcache;

import java.io.IOException;


import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.impl.KetamaMemcachedSessionLocator;
import net.rubyeye.xmemcached.transcoders.SerializingTranscoder;
import net.rubyeye.xmemcached.utils.AddrUtil;


/**
 * 0004:memcached缓存工具类
 * @author Orange
 * @date 下午3:32:50,2016年3月4日
 * @vesion V1.0
 * @see yjwsmileatlife@126.com
 */
public class MemcachedUtils {
	
	//创建MemCachedClient全局对象
	public static MemcachedClient memcachedClient;
	
	static{
		//缓存服务器地址
		String memcachedURL = "192.168.10.171:11211";//测试服务器
//		String memcachedURL = "203.195.168.151:11211";//外包服务器
		
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses(memcachedURL));
	    try {
			 memcachedClient = builder.build();
			 memcachedClient.setOptimizeMergeBuffer(false); 
			 memcachedClient.setEnableHeartBeat(false);
			 builder.getConfiguration().setStatisticsServer(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    //设置连接池大小，即客户端个数
	    builder.setConnectionPoolSize(5);
	    
	    // 宕机报警
	    builder.setFailureMode(true);
	    
	    // 使用二进制文件
	 	builder.setCommandFactory(new BinaryCommandFactory());
	 	
		// 使用一致性哈希算法（Consistent Hash Strategy）
		builder.setSessionLocator(new KetamaMemcachedSessionLocator());
		
		// 使用序列化传输编码
		builder.setTranscoder(new SerializingTranscoder());
		
		// 进行数据压缩，大于1KB时进行压缩
		builder.getTranscoder().setCompressionThreshold(1024);
	}
	
}
