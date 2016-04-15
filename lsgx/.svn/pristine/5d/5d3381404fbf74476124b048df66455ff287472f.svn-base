package com.lsgx.admin.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;

import com.lsgx.admin.scheduling.SmsSendThread;


public class TaskCache {
    private static Logger logger = Logger.getLogger(TaskCache.class);

    public final static Map<String, String> LISTEN_MAPS = new ConcurrentHashMap<String, String>();
    public final static Map<String, String> FACTORY_INIT_MAPS = new ConcurrentHashMap<String, String>();
    private static AtomicInteger lastSmsId = new AtomicInteger(0);
    private static AtomicLong lastSmsSendTime = new AtomicLong(System.currentTimeMillis());
    public static SmsSendThread smsThread = null;
    
	public static Map<String, String> getListenMaps() {
		return LISTEN_MAPS;
	}
	public static Map<String, String> getFactoryInitMaps() {
		return FACTORY_INIT_MAPS;
	}
	public static Integer getLastSmsId() {
		return lastSmsId.get();
	}
	public static void setLastSmsId(Integer lastSmsId) {
		TaskCache.lastSmsId.set(lastSmsId);
	}
	public static long getLastSmsSendTime() {
		return lastSmsSendTime.get();
	}
	public static void setLastSmsSendTime(long lastSmsSendTime) {
		TaskCache.lastSmsSendTime.set(lastSmsSendTime);
	}
   

}

