/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.gewara.support.GcacheInvalidator;
import com.gewara.untrans.GcacheNotifier;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.TreeSet;
import javax.sql.DataSource;
import org.hibernate.Interceptor;
import org.hibernate.MappingException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.ImplicitNamingStrategy;
import org.hibernate.boot.model.naming.PhysicalNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.orm.hibernate5.HibernateExceptionTranslator;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

public class GewaSessionFactoryBean extends HibernateExceptionTranslator
		implements
			FactoryBean<SessionFactory>,
			ResourceLoaderAware,
			InitializingBean,
			DisposableBean {
	private DataSource dataSource;
	private Resource[] configLocations;
	private String[] mappingResources;
	private Resource[] mappingLocations;
	private Resource[] cacheableMappingLocations;
	private Resource[] mappingJarLocations;
	private Resource[] mappingDirectoryLocations;
	private Interceptor entityInterceptor;
	private ImplicitNamingStrategy implicitNamingStrategy;
	private PhysicalNamingStrategy physicalNamingStrategy;
	private Object jtaTransactionManager;
	private CurrentTenantIdentifierResolver currentTenantIdentifierResolver;
	private TypeFilter[] entityTypeFilters;
	private Properties hibernateProperties;
	private Class<?>[] annotatedClasses;
	private String[] annotatedPackages;
	private String[] packagesToScan;
	private ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
	private Configuration configuration;
	private SessionFactory sessionFactory;
	private GcacheNotifier gcacheNotifier;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setConfigLocation(Resource configLocation) {
		this.configLocations = new Resource[]{configLocation};
	}

	public void setConfigLocations(Resource... configLocations) {
		this.configLocations = configLocations;
	}

	public void setMappingResources(String... mappingResources) {
		this.mappingResources = mappingResources;
	}

	public void setMappingLocations(Resource... mappingLocations) {
		this.mappingLocations = mappingLocations;
	}

	public void setCacheableMappingLocations(Resource... cacheableMappingLocations) {
		this.cacheableMappingLocations = cacheableMappingLocations;
	}

	public void setMappingJarLocations(Resource... mappingJarLocations) {
		this.mappingJarLocations = mappingJarLocations;
	}

	public void setMappingDirectoryLocations(Resource... mappingDirectoryLocations) {
		this.mappingDirectoryLocations = mappingDirectoryLocations;
	}

	public void setEntityInterceptor(Interceptor entityInterceptor) {
		this.entityInterceptor = entityInterceptor;
	}

	public void setImplicitNamingStrategy(ImplicitNamingStrategy implicitNamingStrategy) {
		this.implicitNamingStrategy = implicitNamingStrategy;
	}

	public void setPhysicalNamingStrategy(PhysicalNamingStrategy physicalNamingStrategy) {
		this.physicalNamingStrategy = physicalNamingStrategy;
	}

	public void setJtaTransactionManager(Object jtaTransactionManager) {
		this.jtaTransactionManager = jtaTransactionManager;
	}

	public void setCurrentTenantIdentifierResolver(CurrentTenantIdentifierResolver currentTenantIdentifierResolver) {
		this.currentTenantIdentifierResolver = currentTenantIdentifierResolver;
	}

	public void setEntityTypeFilters(TypeFilter... entityTypeFilters) {
		this.entityTypeFilters = entityTypeFilters;
	}

	public void setHibernateProperties(Properties hibernateProperties) {
		this.hibernateProperties = hibernateProperties;
	}

	public Properties getHibernateProperties() {
		if (this.hibernateProperties == null) {
			this.hibernateProperties = new Properties();
		}

		return this.hibernateProperties;
	}

	public void setAnnotatedClasses(Class... annotatedClasses) {
		this.annotatedClasses = annotatedClasses;
	}

	public void setAnnotatedPackages(String... annotatedPackages) {
		this.annotatedPackages = annotatedPackages;
	}

	public void setPackagesToScan(String... packagesToScan) {
		this.packagesToScan = packagesToScan;
	}

	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
	}

	public void afterPropertiesSet() throws IOException {
		LocalSessionFactoryBuilder sfb = new LocalSessionFactoryBuilder(this.dataSource, this.resourcePatternResolver);
		Resource[] registry;
		int invalidate;
		int arg3;
		Resource resource;
		if (this.configLocations != null) {
			registry = this.configLocations;
			invalidate = registry.length;

			for (arg3 = 0; arg3 < invalidate; ++arg3) {
				resource = registry[arg3];
				sfb.configure(resource.getURL());
			}
		}

		if (this.mappingResources != null) {
			String[] arg9 = this.mappingResources;
			invalidate = arg9.length;

			for (arg3 = 0; arg3 < invalidate; ++arg3) {
				String arg12 = arg9[arg3];
				ClassPathResource file = new ClassPathResource(arg12.trim(),
						this.resourcePatternResolver.getClassLoader());
				sfb.addInputStream(file.getInputStream());
			}
		}

		if (this.mappingLocations != null) {
			registry = this.mappingLocations;
			invalidate = registry.length;

			for (arg3 = 0; arg3 < invalidate; ++arg3) {
				resource = registry[arg3];
				sfb.addInputStream(resource.getInputStream());
			}
		}

		if (this.cacheableMappingLocations != null) {
			registry = this.cacheableMappingLocations;
			invalidate = registry.length;

			for (arg3 = 0; arg3 < invalidate; ++arg3) {
				resource = registry[arg3];
				sfb.addCacheableFile(resource.getFile());
			}
		}

		if (this.mappingJarLocations != null) {
			registry = this.mappingJarLocations;
			invalidate = registry.length;

			for (arg3 = 0; arg3 < invalidate; ++arg3) {
				resource = registry[arg3];
				sfb.addJar(resource.getFile());
			}
		}

		if (this.mappingDirectoryLocations != null) {
			registry = this.mappingDirectoryLocations;
			invalidate = registry.length;

			for (arg3 = 0; arg3 < invalidate; ++arg3) {
				resource = registry[arg3];
				File arg13 = resource.getFile();
				if (!arg13.isDirectory()) {
					throw new IllegalArgumentException(
							"Mapping directory location [" + resource + "] does not denote a directory");
				}

				TreeSet sorted = new TreeSet();
				this.add2FileList(arg13, sorted);
				Iterator arg7 = sorted.iterator();

				while (arg7.hasNext()) {
					File hbm = (File) arg7.next();
					sfb.addFile(hbm);
				}
			}
		}

		if (this.entityInterceptor != null) {
			sfb.setInterceptor(this.entityInterceptor);
		}

		if (this.implicitNamingStrategy != null) {
			sfb.setImplicitNamingStrategy(this.implicitNamingStrategy);
		}

		if (this.physicalNamingStrategy != null) {
			sfb.setPhysicalNamingStrategy(this.physicalNamingStrategy);
		}

		if (this.jtaTransactionManager != null) {
			sfb.setJtaTransactionManager(this.jtaTransactionManager);
		}

		if (this.currentTenantIdentifierResolver != null) {
			sfb.setCurrentTenantIdentifierResolver(this.currentTenantIdentifierResolver);
		}

		if (this.entityTypeFilters != null) {
			sfb.setEntityTypeFilters(this.entityTypeFilters);
		}

		if (this.hibernateProperties != null) {
			sfb.addProperties(this.hibernateProperties);
		}

		if (this.annotatedClasses != null) {
			sfb.addAnnotatedClasses(this.annotatedClasses);
		}

		if (this.annotatedPackages != null) {
			sfb.addPackages(this.annotatedPackages);
		}

		if (this.packagesToScan != null) {
			sfb.scanPackages(this.packagesToScan);
		}

		this.configuration = sfb;
		this.sessionFactory = this.buildSessionFactory(sfb);
		if (this.gcacheNotifier != null) {
			EventListenerRegistry arg10 = (EventListenerRegistry) ((SessionFactoryImpl) this.sessionFactory)
					.getServiceRegistry().getService(EventListenerRegistry.class);
			GcacheInvalidator arg11 = new GcacheInvalidator(this.gcacheNotifier);
			arg10.getEventListenerGroup(EventType.POST_INSERT).appendListener(arg11);
			arg10.getEventListenerGroup(EventType.POST_UPDATE).appendListener(arg11);
			arg10.getEventListenerGroup(EventType.POST_DELETE).appendListener(arg11);
		}

	}

	private void add2FileList(File dir, TreeSet<File> fileList) throws MappingException {
		File[] files = dir.listFiles();
		File[] arg3 = files;
		int arg4 = files.length;

		for (int arg5 = 0; arg5 < arg4; ++arg5) {
			File file = arg3[arg5];
			if (file.isDirectory()) {
				this.add2FileList(file, fileList);
			} else if (file.getName().endsWith(".hbm.xml")) {
				fileList.add(file);
			}
		}

	}

	protected SessionFactory buildSessionFactory(LocalSessionFactoryBuilder sfb) {
		return sfb.buildSessionFactory();
	}

	public final Configuration getConfiguration() {
		if (this.configuration == null) {
			throw new IllegalStateException("Configuration not initialized yet");
		} else {
			return this.configuration;
		}
	}

	public SessionFactory getObject() {
		return this.sessionFactory;
	}

	public Class<?> getObjectType() {
		return this.sessionFactory != null ? this.sessionFactory.getClass() : SessionFactory.class;
	}

	public boolean isSingleton() {
		return true;
	}

	public void destroy() {
		this.sessionFactory.close();
	}

	public void setGcacheNotifier(GcacheNotifier gcacheNotifier) {
		this.gcacheNotifier = gcacheNotifier;
	}
}