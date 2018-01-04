
package com.gewara.support;

import java.io.File;
import java.io.IOException;
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

import com.gewara.untrans.GcacheNotifier;

public class GewaSessionFactoryBean extends HibernateExceptionTranslator
		implements FactoryBean<SessionFactory>, ResourceLoaderAware, InitializingBean, DisposableBean {

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
		this.configLocations = new Resource[] { configLocation };
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

	public void setAnnotatedClasses(Class<?>... annotatedClasses) {
		this.annotatedClasses = annotatedClasses;
	}

	public void setAnnotatedPackages(String... annotatedPackages) {
		this.annotatedPackages = annotatedPackages;
	}

	public void setPackagesToScan(String... packagesToScan) {
		this.packagesToScan = packagesToScan;
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
	}

	@Override
	public void afterPropertiesSet() throws IOException {
		LocalSessionFactoryBuilder sfb = new LocalSessionFactoryBuilder(this.dataSource, this.resourcePatternResolver);

		if (this.configLocations != null) {
			for (Resource resource : this.configLocations) {
				// Load Hibernate configuration from given location.
				sfb.configure(resource.getURL());
			}
		}

		if (this.mappingResources != null) {
			// Register given Hibernate mapping definitions, contained in
			// resource files.
			for (String mapping : this.mappingResources) {
				Resource mr = new ClassPathResource(mapping.trim(), this.resourcePatternResolver.getClassLoader());
				sfb.addInputStream(mr.getInputStream());
			}
		}

		if (this.mappingLocations != null) {
			// Register given Hibernate mapping definitions, contained in
			// resource files.
			for (Resource resource : this.mappingLocations) {
				sfb.addInputStream(resource.getInputStream());
			}
		}

		if (this.cacheableMappingLocations != null) {
			// Register given cacheable Hibernate mapping definitions, read from
			// the file system.
			for (Resource resource : this.cacheableMappingLocations) {
				sfb.addCacheableFile(resource.getFile());
			}
		}

		if (this.mappingJarLocations != null) {
			// Register given Hibernate mapping definitions, contained in jar
			// files.
			for (Resource resource : this.mappingJarLocations) {
				sfb.addJar(resource.getFile());
			}
		}

		if (this.mappingDirectoryLocations != null) {
			// Register all Hibernate mapping definitions in the given
			// directories.
			for (Resource resource : this.mappingDirectoryLocations) {
				File file = resource.getFile();
				if (!file.isDirectory()) {
					throw new IllegalArgumentException(
							"Mapping directory location [" + resource + "] does not denote a directory");
				}
				// 解决多台Hibernate生成sql语句不一致问题（org.hibernate.mapping.Table.uniqueInteger）
				TreeSet<File> sorted = new TreeSet<>();
				add2FileList(file, sorted);
				for (File hbm : sorted) {
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

		// Build SessionFactory instance.
		this.configuration = sfb;
		this.sessionFactory = buildSessionFactory(sfb);
		if (gcacheNotifier != null) {
			EventListenerRegistry registry = ((SessionFactoryImpl) this.sessionFactory).getServiceRegistry()
					.getService(EventListenerRegistry.class);
			GcacheInvalidator invalidate = new GcacheInvalidator(gcacheNotifier);
			registry.getEventListenerGroup(EventType.POST_INSERT).appendListener(invalidate);
			registry.getEventListenerGroup(EventType.POST_UPDATE).appendListener(invalidate);
			registry.getEventListenerGroup(EventType.POST_DELETE).appendListener(invalidate);
		}
	}

	private void add2FileList(File dir, TreeSet<File> fileList) throws MappingException {
		File[] files = dir.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				add2FileList(file, fileList);
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
		}
		return this.configuration;
	}

	@Override
	public SessionFactory getObject() {
		return this.sessionFactory;
	}

	@Override
	public Class<?> getObjectType() {
		return (this.sessionFactory != null ? this.sessionFactory.getClass() : SessionFactory.class);
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	@Override
	public void destroy() {
		this.sessionFactory.close();
	}

	public void setGcacheNotifier(GcacheNotifier gcacheNotifier) {
		this.gcacheNotifier = gcacheNotifier;
	}

}
