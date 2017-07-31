package com.gewara.untrans.monitor.job;

import org.hibernate.Session;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.MySQLDialect;
import org.hibernate.dialect.PostgreSQL92Dialect;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.gewara.support.GewaOracleDialect;
import com.gewara.untrans.monitor.AbstractSysSelfCheckingJob;

public class DBstatusCheckingJob extends AbstractSysSelfCheckingJob {

	private String hbTemplateName="hibernateTemplate";

	@Override
	public String getCheckName() {
		return hbTemplateName;
	}

	@Override
	public String getCheckStatus() {
		String status = "false";
		try {
			if (hbTemplateName == null) {
				hbTemplateName = "hibernateTemplate";
			}
			HibernateTemplate hibernateTemplate = null;
			try {
				hibernateTemplate = (HibernateTemplate) applicationContext.getBean(hbTemplateName);
			} catch (Exception e) {
			}
			if (hibernateTemplate == null) {
				return "notexist";
			}
			hibernateTemplate.execute(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session)  {

					Dialect dialect = ((SessionFactoryImplementor) session.getSessionFactory()).getDialect();
					String sql = "select user from dual";
					if (dialect instanceof GewaOracleDialect) {
						sql = "select user from dual";
					} else if (dialect instanceof MySQLDialect) {
						sql = "select '123' ";
					} else if (dialect instanceof PostgreSQL92Dialect) {
						sql = "select current_timestamp";
					}
					session.createSQLQuery(sql).list();
					return null;
				}
			});
			status = "true";
		} catch (Exception e) {
		}
		return status;
	}

	public String getHbTemplateName() {
		return hbTemplateName;
	}

	public void setHbTemplateName(String hbTemplateName) {
		this.hbTemplateName = hbTemplateName;
	}

}
