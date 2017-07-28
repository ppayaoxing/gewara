/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.gewara.model.BaseObject;
import com.gewara.untrans.GcacheNotifier;
import org.apache.commons.lang.StringUtils;
import org.hibernate.event.spi.PostCommitInsertEventListener;
import org.hibernate.event.spi.PostDeleteEvent;
import org.hibernate.event.spi.PostDeleteEventListener;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class GcacheInvalidator
		implements
			PostCommitInsertEventListener,
			PostDeleteEventListener,
			PostUpdateEventListener {
	private static final long serialVersionUID = -2006186028324037021L;
	private GcacheNotifier gcacheNotifier;
	public static boolean PROPAGATE_EXCEPTION = false;

	public GcacheInvalidator(GcacheNotifier gcacheNotifier) {
		this.gcacheNotifier = gcacheNotifier;
	}

	public void onPostInsert(PostInsertEvent event) {
		if (event.getEntity() instanceof BaseObject) {
			this.addCacheNotifier((BaseObject) event.getEntity(), event.getId().toString(), "I");
		}

	}

	public void onPostInsertCommitFailed(PostInsertEvent event) {
	}

	public boolean requiresPostCommitHanding(EntityPersister persister) {
		return true;
	}

	public void onPostDelete(PostDeleteEvent event) {
		if (event.getEntity() instanceof BaseObject) {
			this.addCacheNotifier((BaseObject) event.getEntity(), event.getId().toString(), "D");
		}

	}

	public void onPostUpdate(PostUpdateEvent event) {
		if (event.getEntity() instanceof BaseObject) {
			this.addCacheNotifier((BaseObject) event.getEntity(), event.getId().toString(), "U");
		}

	}

	private void addCacheNotifier(BaseObject o, final String id, final String op) {
		if (o.cachable() && TransactionSynchronizationManager.isSynchronizationActive() && StringUtils.isNotBlank(id)) {
			final Class entityClass = o.getClass();
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
				public void afterCommit() {
					GcacheInvalidator.this.gcacheNotifier.notifyChangesAsynch(entityClass, id, op);
				}
			});
		}

	}
}