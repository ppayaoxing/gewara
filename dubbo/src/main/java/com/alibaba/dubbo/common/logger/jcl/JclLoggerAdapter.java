package com.alibaba.dubbo.common.logger.jcl;

import java.io.File;

import org.apache.commons.logging.LogFactory;

import com.alibaba.dubbo.common.logger.Level;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerAdapter;

public class JclLoggerAdapter implements LoggerAdapter {

	@Override
    public Logger getLogger(String key) {
		return new JclLogger(LogFactory.getLog(key));
	}

    @Override
    public Logger getLogger(Class<?> key) {
        return new JclLogger(LogFactory.getLog(key));
    }

    private Level level;
    
    private File file;

    @Override
    public void setLevel(Level level) {
        this.level = level;
    }

    @Override
    public Level getLevel() {
        return level;
    }

    @Override
    public File getFile() {
        return file;
    }

    @Override
    public void setFile(File file) {
        this.file = file;
    }

}
