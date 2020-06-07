package org.ms.module.supper.internal;

import org.ms.module.supper.inter.aliyun.log.IAliyuLog;
import org.ms.module.supper.inter.aliyun.log.IAliyuLogAdapter;
import org.ms.module.supper.inter.module.ModuleAdapter;

public class AliyuLogModule extends ModuleAdapter {
    private static final String CLASSPATH = "org.ms.module.impl.aliyun.LogImpl";
    private IAliyuLog aliyuLog;

    @Override
    public IAliyuLog get() {
        if (aliyuLog == null) {
            Object o = loaderClass(CLASSPATH);
            if (o != null) {
                if (o instanceof IAliyuLog) {
                    aliyuLog = (IAliyuLog) o;
                    if (aliyuLog != null) {
                        return aliyuLog;
                    } else {
                        aliyuLog = new IAliyuLogAdapter();
                        return aliyuLog;
                    }
                } else {
                    aliyuLog = new IAliyuLogAdapter();
                    return aliyuLog;
                }
            } else {
                aliyuLog = new IAliyuLogAdapter();
                return aliyuLog;
            }
        }
        return aliyuLog;
    }

    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }
}