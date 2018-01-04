package com.gewara.trace.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 如果方法中使用该注解，该方法将进入跟踪链<br/>
 * 如果为跟踪入口点,并且<b>需要产生traceid</b>，则需设置status值为begin,见{@link #status()}
 * <br>参详：<hr>http://wk.gewara.com/pages/viewpage.action?pageId=19147575</hr>
 * @author quzhuping
 *
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface GwTrace {
	/**
	 * 如果为跟踪入口点,并且<b>需要产生traceid</b>，则需设置值为begin
	 * <pre><code>@GwTrace(status="begin")</code></pre>
	 * @return
	 */
	String status() default "normal";
}
