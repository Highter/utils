package com.yjw.utils.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.net.SMTPAppender;

/**
 * 测试通过log4j代码来发送邮件
 *@author Higher
 *@date 上午11:37:11,2016年7月14日
 *@vesion 1.0
 *@see yjwsmileatlife@126.com
 */

public class TestSendMail {

	static Logger logger = Logger.getLogger(TestSendMail.class);
	static SMTPAppender appender = new SMTPAppender();
	public static void main(String[] args) {
		appender.setSMTPUsername("yjwsmileatlife@126.com");
        appender.setSMTPPassword("密码");
        appender.setTo("yjwsmileatlife@126.com");
        appender.setFrom("yjwsmileatlife@126.com");
        appender.setSMTPHost("smtp.126.com");
        appender.setLocationInfo(true);
        appender.setSubject("发生重大事故了！！！");
        appender.setLayout(new PatternLayout());
        appender.activateOptions();
        logger.addAppender(appender);
        logger.error("Hello World");
	}
}
