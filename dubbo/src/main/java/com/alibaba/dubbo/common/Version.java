/*
 * Copyright 1999-2011 Alibaba Group.
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
package com.alibaba.dubbo.common;

import java.net.URL;
import java.security.CodeSource;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.alibaba.dubbo.common.utils.ClassHelper;

/**
 * Version
 * 
 * @author william.liangf
 */
public final class Version {

    private Version() {}

    private static final Logger logger = LoggerFactory.getLogger(Version.class);

    private static final String VERSION = getVersion(Version.class, "2.0.0");

    private static final boolean INTERNAL = hasResource("com/alibaba/dubbo/registry/internal/RemoteRegistry.class");

    private static final boolean COMPATIBLE = hasResource("com/taobao/remoting/impl/ConnectionRequest.class");

    static {
        // 妫�鏌ユ槸鍚﹀瓨鍦ㄩ噸澶嶇殑jar鍖�
    	Version.checkDuplicate(Version.class);
	}

    public static String getVersion(){
    	return VERSION;
    }
    
    public static boolean isInternalVersion() {
        return INTERNAL;
    }

    public static boolean isCompatibleVersion() {
        return COMPATIBLE;
    }
    
    private static boolean hasResource(String path) {
        try {
            return Version.class.getClassLoader().getResource(path) != null;
        } catch (Throwable t) {
            return false;
        }
    }
    
    public static String getVersion(Class<?> cls, String defaultVersion) {
        try {
            // 棣栧厛鏌ユ壘MANIFEST.MF瑙勮寖涓殑鐗堟湰鍙�
            String version = cls.getPackage().getImplementationVersion();
            if (version == null || version.length() == 0) {
                version = cls.getPackage().getSpecificationVersion();
            }
            if (version == null || version.length() == 0) {
                // 濡傛灉瑙勮寖涓病鏈夌増鏈彿锛屽熀浜巎ar鍖呭悕鑾峰彇鐗堟湰鍙�
                CodeSource codeSource = cls.getProtectionDomain().getCodeSource();
                if(codeSource == null) {
                    logger.info("No codeSource for class " + cls.getName() + " when getVersion, use default version " + defaultVersion);
                }
                else {
                    String file = codeSource.getLocation().getFile();
                    if (file != null && file.length() > 0 && file.endsWith(".jar")) {
                        file = file.substring(0, file.length() - 4);
                        int i = file.lastIndexOf('/');
                        if (i >= 0) {
                            file = file.substring(i + 1);
                        }
                        i = file.indexOf("-");
                        if (i >= 0) {
                            file = file.substring(i + 1);
                        }
                        while (file.length() > 0 && ! Character.isDigit(file.charAt(0))) {
                            i = file.indexOf("-");
                            if (i >= 0) {
                                file = file.substring(i + 1);
                            } else {
                                break;
                            }
                        }
                        version = file;
                    }
                }
            }
            // 杩斿洖鐗堟湰鍙凤紝濡傛灉涓虹┖杩斿洖缂虹渷鐗堟湰鍙�
            return version == null || version.length() == 0 ? defaultVersion : version;
        } catch (Throwable e) { // 闃插尽鎬у閿�
            // 蹇界暐寮傚父锛岃繑鍥炵己鐪佺増鏈彿
            logger.error("return default version, ignore exception " + e.getMessage(), e);
            return defaultVersion;
        }
    }

    public static void checkDuplicate(Class<?> cls, boolean failOnError) {
        checkDuplicate(cls.getName().replace('.', '/') + ".class", failOnError);
    }

	public static void checkDuplicate(Class<?> cls) {
		checkDuplicate(cls, false);
	}

	public static void checkDuplicate(String path, boolean failOnError) {
		try {
			// 鍦–lassPath鎼滄枃浠�
			Enumeration<URL> urls = ClassHelper.getCallerClassLoader(Version.class).getResources(path);
			Set<String> files = new HashSet<String>();
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				if (url != null) {
					String file = url.getFile();
					if (file != null && file.length() > 0) {
						files.add(file);
					}
				}
			}
			// 濡傛灉鏈夊涓紝灏辫〃绀洪噸澶�
			if (files.size() > 1) {
                String error = "Duplicate class " + path + " in " + files.size() + " jar " + files;
                if (failOnError) {
                    throw new IllegalStateException(error);
                } else {
				    logger.error(error);
                }
			}
		} catch (Throwable e) { // 闃插尽鎬у閿�
			logger.error(e.getMessage(), e);
		}
	}

}
