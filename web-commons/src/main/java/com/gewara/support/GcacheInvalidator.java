/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package com.gewara.support;

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

import com.gewara.model.BaseObject;
import com.gewara.untrans.GcacheNotifier;

public class GcacheInvalidator implements
		PostCommitInsertEventListener, PostDeleteEventListener, PostUpdateEventListener {
	private static final long serialVersionUID = -2006186028324037021L;
	private GcacheNotifier gcacheNotifier;
	public GcacheInvalidator(GcacheNotifier gcacheNotifier){
		this.gcacheNotifier = gcacheNotifier;
	}

	/**
	 * Exposed for use in testing
	 */
	public static boolean PROPAGATE_EXCEPTION = false;

	@Override
	public void onPostInsert(PostInsertEvent event) {
		if(event.getEntity() instanceof BaseObject){
			addCacheNotifier((BaseObject) event.getEntity(), event.getId().toString(), "I");
		}
	}
	@Override
	public void onPostInsertCommitFailed(PostInsertEvent event) {
	}

	@Override
	public boolean requiresPostCommitHanding(EntityPersister persister) {
		return true;
	}

	@Override
	public void onPostDelete(PostDeleteEvent event) {
		if(event.getEntity() instanceof BaseObject){
			addCacheNotifier((BaseObject) event.getEntity(), event.getId().toString(), "D");
		}
	}

	@Override
	public void onPostUpdate(PostUpdateEvent event) {
		if(event.getEntity() instanceof BaseObject){
			addCacheNotifier((BaseObject) event.getEntity(), event.getId().toString(), "U");
		}
	}
	private void addCacheNotifier(BaseObject o, String id, String op){
		if(o.cachable() && TransactionSynchronizationManager.isSynchronizationActive()){
			if(StringUtils.isNotBlank(id) ){
				final Class<? extends BaseObject> entityClass = o.getClass();
				TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
					@Override
					public void afterCommit() {//afterCompletion
						gcacheNotifier.notifyChangesAsynch(entityClass, id, op);
					}
				});
			}
		}
	}

}
