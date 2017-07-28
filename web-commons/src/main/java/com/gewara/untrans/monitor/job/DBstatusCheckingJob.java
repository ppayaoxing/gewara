/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.untrans.monitor.job;

import com.gewara.support.GewaOracleDialect;
import com.gewara.untrans.monitor.AbstractSysSelfCheckingJob;
import org.hibernate.Session;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.PostgreSQL92Dialect;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class DBstatusCheckingJob extends AbstractSysSelfCheckingJob {
	private String hbTemplateName = "hibernateTemplate";

	public String getCheckName() {
		return this.hbTemplateName;
	}

	public String getCheckStatus() {
		String status = "false";

		try {
			if (this.hbTemplateName == null) {
				this.hbTemplateName = "hibernateTemplate";
			}

			HibernateTemplate hibernateTemplate = null;

			try {
				hibernateTemplate = (HibernateTemplate) this.applicationContext.getBean(this.hbTemplateName);
			} catch (Exception arg3) {
				;
			}

			if (hibernateTemplate == null) {
				return "notexist";
			}

			hibernateTemplate.execute(new HibernateCallback() {
				public Object doInHibernate(Session session) {
					Dialect dialect = ((SessionFactoryImplementor) session.getSessionFactory()).getDialect();
					String sql = "select user from dual";
					if (dialect instanceof GewaOracleDialect) {
						sql = "select user from dual";
					} else if (dialect instanceof MySQLDialect) {
						sql = "select \'123\' ";
					} else if (dialect instanceof PostgreSQL92Dialect) {
						sql = "select current_timestamp";
					}

					session.createSQLQuery(sql).list();
					return null;
				}
			});
			status = "true";
		} catch (Exception arg4) {
			;
		}

		return status;
	}

	public String getHbTemplateName() {
		return this.hbTemplateName;
	}

	public void setHbTemplateName(String hbTemplateName) {
		this.hbTemplateName = hbTemplateName;
	}
}