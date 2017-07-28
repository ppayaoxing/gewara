/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.config;

import com.gewara.mdb.config.BsonTimestampTrans;
import com.gewara.mdb.config.SqlTimestampCodec;
import com.mongodb.DBDecoderFactory;
import com.mongodb.DBEncoderFactory;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.mongodb.MongoClientOptions.Builder;
import java.sql.Timestamp;
import java.util.HashMap;
import javax.net.SocketFactory;
import org.bson.BsonType;
import org.bson.codecs.BsonTypeClassMap;
import org.bson.codecs.Codec;
import org.bson.codecs.DocumentCodecProvider;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;

public class GwMongoClientOptions {
	private String description;
	private ReadPreference readPreference = ReadPreference.secondaryPreferred();
	private WriteConcern writeConcern;
	private CodecRegistry codecRegistry;
	private Integer minConnectionsPerHost;
	private Integer maxConnectionsPerHost;
	private Integer threadsAllowedToBlockForConnectionMultiplier;
	private Integer serverSelectionTimeout;
	private Integer maxWaitTime;
	private Integer maxConnectionIdleTime;
	private Integer maxConnectionLifeTime;
	private Integer connectTimeout;
	private Integer socketTimeout;
	private Boolean socketKeepAlive;
	private Boolean sslEnabled;
	private Boolean sslInvalidHostNameAllowed;
	private Boolean alwaysUseMBeans;
	private Integer heartbeatFrequency;
	private Integer minHeartbeatFrequency;
	private Integer heartbeatConnectTimeout;
	private Integer heartbeatSocketTimeout;
	private Integer localThreshold;
	private String requiredReplicaSetName;
	private DBDecoderFactory dbDecoderFactory;
	private DBEncoderFactory dbEncoderFactory;
	private SocketFactory socketFactory;
	private Boolean cursorFinalizerEnabled;

	public static GwMongoClientOptions getDefaultInstance() {
		return new GwMongoClientOptions();
	}

	public MongoClientOptions toMongoClientOptions() {
		MongoClientOptions defaultOptions = MongoClientOptions.builder().build();
		Builder builder = MongoClientOptions.builder();
		if (this.description != null) {
			builder.description(this.description);
		}

		if (this.readPreference != null) {
			builder.readPreference(this.readPreference);
		}

		if (this.writeConcern != null) {
			builder.writeConcern(this.writeConcern);
		}

		if (this.codecRegistry != null) {
			builder.codecRegistry(this.codecRegistry);
		} else {
			CodecRegistry defaultCodecRegistry = defaultOptions.getCodecRegistry();
			HashMap replacementsForDefaults = new HashMap();
			replacementsForDefaults.put(BsonType.TIMESTAMP, Timestamp.class);
			BsonTypeClassMap bsonTypeClassMap = new BsonTypeClassMap(replacementsForDefaults);
			DocumentCodecProvider documentCodecProvider = new DocumentCodecProvider(bsonTypeClassMap,
					new BsonTimestampTrans());
			this.codecRegistry = CodecRegistries.fromRegistries(
					new CodecRegistry[] { CodecRegistries.fromCodecs(new Codec[] { new SqlTimestampCodec() }),
							CodecRegistries.fromProviders(new CodecProvider[] { documentCodecProvider }),
							defaultCodecRegistry });
			builder.codecRegistry(this.codecRegistry);
		}

		if (this.minConnectionsPerHost != null) {
			builder.minConnectionsPerHost(this.minConnectionsPerHost.intValue());
		}

		if (this.maxConnectionsPerHost != null) {
			builder.connectionsPerHost(this.maxConnectionsPerHost.intValue());
		}

		if (this.threadsAllowedToBlockForConnectionMultiplier != null) {
			builder.threadsAllowedToBlockForConnectionMultiplier(
					this.threadsAllowedToBlockForConnectionMultiplier.intValue());
		}

		if (this.serverSelectionTimeout != null) {
			builder.serverSelectionTimeout(this.serverSelectionTimeout.intValue());
		}

		if (this.maxWaitTime != null) {
			builder.maxWaitTime(this.maxWaitTime.intValue());
		}

		if (this.maxConnectionIdleTime != null) {
			builder.maxConnectionIdleTime(this.maxConnectionIdleTime.intValue());
		}

		if (this.maxConnectionLifeTime != null) {
			builder.maxConnectionLifeTime(this.maxConnectionLifeTime.intValue());
		}

		if (this.connectTimeout != null) {
			builder.connectTimeout(this.connectTimeout.intValue());
		}

		if (this.socketTimeout != null) {
			builder.socketTimeout(this.socketTimeout.intValue());
		}

		if (this.socketKeepAlive != null) {
			builder.socketKeepAlive(this.socketKeepAlive.booleanValue());
		}

		if (this.sslEnabled != null) {
			builder.sslEnabled(this.sslEnabled.booleanValue());
		}

		if (this.sslInvalidHostNameAllowed != null) {
			builder.sslInvalidHostNameAllowed(this.sslInvalidHostNameAllowed.booleanValue());
		}

		if (this.alwaysUseMBeans != null) {
			builder.alwaysUseMBeans(this.alwaysUseMBeans.booleanValue());
		}

		if (this.heartbeatFrequency != null) {
			builder.heartbeatFrequency(this.heartbeatFrequency.intValue());
		}

		if (this.minHeartbeatFrequency != null) {
			builder.minHeartbeatFrequency(this.minHeartbeatFrequency.intValue());
		}

		if (this.heartbeatConnectTimeout != null) {
			builder.heartbeatConnectTimeout(this.heartbeatConnectTimeout.intValue());
		}

		if (this.heartbeatSocketTimeout != null) {
			builder.heartbeatSocketTimeout(this.heartbeatSocketTimeout.intValue());
		}

		if (this.localThreshold != null) {
			builder.localThreshold(this.localThreshold.intValue());
		}

		if (this.requiredReplicaSetName != null) {
			builder.requiredReplicaSetName(this.requiredReplicaSetName);
		}

		if (this.dbDecoderFactory != null) {
			builder.dbDecoderFactory(this.dbDecoderFactory);
		}

		if (this.dbEncoderFactory != null) {
			builder.dbEncoderFactory(this.dbEncoderFactory);
		}

		if (this.socketFactory != null) {
			builder.socketFactory(this.socketFactory);
		}

		if (this.cursorFinalizerEnabled != null) {
			builder.cursorFinalizerEnabled(this.cursorFinalizerEnabled.booleanValue());
		}

		return builder.build();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setReadPreference(ReadPreference readPreference) {
		this.readPreference = readPreference;
	}

	public void setWriteConcern(WriteConcern writeConcern) {
		this.writeConcern = writeConcern;
	}

	public void setCodecRegistry(CodecRegistry codecRegistry) {
		this.codecRegistry = codecRegistry;
	}

	public void setMinConnectionsPerHost(Integer minConnectionsPerHost) {
		this.minConnectionsPerHost = minConnectionsPerHost;
	}

	public void setMaxConnectionsPerHost(Integer maxConnectionsPerHost) {
		this.maxConnectionsPerHost = maxConnectionsPerHost;
	}

	public void setThreadsAllowedToBlockForConnectionMultiplier(Integer threadsAllowedToBlockForConnectionMultiplier) {
		this.threadsAllowedToBlockForConnectionMultiplier = threadsAllowedToBlockForConnectionMultiplier;
	}

	public void setServerSelectionTimeout(Integer serverSelectionTimeout) {
		this.serverSelectionTimeout = serverSelectionTimeout;
	}

	public void setMaxWaitTime(Integer maxWaitTime) {
		this.maxWaitTime = maxWaitTime;
	}

	public void setMaxConnectionIdleTime(Integer maxConnectionIdleTime) {
		this.maxConnectionIdleTime = maxConnectionIdleTime;
	}

	public void setMaxConnectionLifeTime(Integer maxConnectionLifeTime) {
		this.maxConnectionLifeTime = maxConnectionLifeTime;
	}

	public void setConnectTimeout(Integer connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public void setSocketTimeout(Integer socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public void setSocketKeepAlive(Boolean socketKeepAlive) {
		this.socketKeepAlive = socketKeepAlive;
	}

	public void setSslEnabled(Boolean sslEnabled) {
		this.sslEnabled = sslEnabled;
	}

	public void setSslInvalidHostNameAllowed(Boolean sslInvalidHostNameAllowed) {
		this.sslInvalidHostNameAllowed = sslInvalidHostNameAllowed;
	}

	public void setAlwaysUseMBeans(Boolean alwaysUseMBeans) {
		this.alwaysUseMBeans = alwaysUseMBeans;
	}

	public void setHeartbeatFrequency(Integer heartbeatFrequency) {
		this.heartbeatFrequency = heartbeatFrequency;
	}

	public void setMinHeartbeatFrequency(Integer minHeartbeatFrequency) {
		this.minHeartbeatFrequency = minHeartbeatFrequency;
	}

	public void setHeartbeatConnectTimeout(Integer heartbeatConnectTimeout) {
		this.heartbeatConnectTimeout = heartbeatConnectTimeout;
	}

	public void setHeartbeatSocketTimeout(Integer heartbeatSocketTimeout) {
		this.heartbeatSocketTimeout = heartbeatSocketTimeout;
	}

	public void setLocalThreshold(Integer localThreshold) {
		this.localThreshold = localThreshold;
	}

	public void setRequiredReplicaSetName(String requiredReplicaSetName) {
		this.requiredReplicaSetName = requiredReplicaSetName;
	}

	public void setDbDecoderFactory(DBDecoderFactory dbDecoderFactory) {
		this.dbDecoderFactory = dbDecoderFactory;
	}

	public void setDbEncoderFactory(DBEncoderFactory dbEncoderFactory) {
		this.dbEncoderFactory = dbEncoderFactory;
	}

	public void setSocketFactory(SocketFactory socketFactory) {
		this.socketFactory = socketFactory;
	}

	public void setCursorFinalizerEnabled(Boolean cursorFinalizerEnabled) {
		this.cursorFinalizerEnabled = cursorFinalizerEnabled;
	}
}