package com.springmvc.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * LogUtil
 * 
 * @author zhanbiao
 */
public class Log {

    private static final Logger LOG = Logger.getLogger(Log.class);
    private static final String callerFQCN = Log.class.getName();

    public static void debug(Object message) {
        LOG.log(callerFQCN, Level.DEBUG, message, null);
    }

    public static void debug(Object message, Throwable t) {
        LOG.log(callerFQCN, Level.DEBUG, message, t);
    }

    public static void info(Object message) {
        LOG.log(callerFQCN, Level.INFO, message, null);
    }

    public static void info(Object message, Throwable t) {
        LOG.log(callerFQCN, Level.INFO, message, t);
    }

    public static void warn(Object message) {
        LOG.log(callerFQCN, Level.WARN, message, null);
    }

    public static void warn(Object message, Throwable t) {
        LOG.log(callerFQCN, Level.WARN, message, t);
    }

    public static void error(Object message) {
        LOG.log(callerFQCN, Level.ERROR, message, null);
    }

    public static void error(Object message, Throwable t) {
        LOG.log(callerFQCN, Level.ERROR, message, t);
    }

    public static void fatal(Object message) {
        LOG.log(callerFQCN, Level.FATAL, message, null);
    }

    public static void fatal(Object message, Throwable t) {
        LOG.log(callerFQCN, Level.FATAL, message, t);
    }
}
