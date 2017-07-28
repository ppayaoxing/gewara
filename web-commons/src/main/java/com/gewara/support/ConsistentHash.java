/** <a href="http://www.cpupk.com/decompiler">Eclipse Class Decompiler</a> plugin, Copyright (c) 2017 Chen Chao. **/
package com.gewara.support;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash<T> {
	private SortedMap<Long, T> ketamaNodes = new TreeMap();
	private int numberOfReplicas = 1024;
	private HashFunction hashFunction = Hashing.md5();
	private List<T> nodes;
	private volatile boolean init = false;

	public ConsistentHash(int numberOfReplicas, List<T> nodes) {
		this.numberOfReplicas = numberOfReplicas;
		this.nodes = nodes;
		this.init();
	}

	public T getNodeByKey(String key) {
		if (!this.init) {
			throw new RuntimeException("init uncomplete...");
		} else {
			byte[] digest = this.hashFunction.hashString(key, Charset.forName("UTF-8")).asBytes();
			long hash = hash(digest, 0);
			if (!this.ketamaNodes.containsKey(Long.valueOf(hash))) {
				SortedMap tailMap = this.ketamaNodes.tailMap(Long.valueOf(hash));
				if (tailMap.isEmpty()) {
					hash = ((Long) this.ketamaNodes.firstKey()).longValue();
				} else {
					hash = ((Long) tailMap.firstKey()).longValue();
				}
			}

			return this.ketamaNodes.get(Long.valueOf(hash));
		}
	}

	public synchronized void addNode(T node) {
		this.init = false;
		this.nodes.add(node);
		this.init();
	}

	private void init() {
		Iterator arg0 = this.nodes.iterator();

		while (arg0.hasNext()) {
			Object node = arg0.next();

			for (int i = 0; i < this.numberOfReplicas / 4; ++i) {
				byte[] digest = this.hashFunction.hashString(node.toString() + i, Charset.forName("UTF-8")).asBytes();

				for (int h = 0; h < 4; ++h) {
					Long k = Long.valueOf(hash(digest, h));
					this.ketamaNodes.put(k, node);
				}
			}
		}

		this.init = true;
	}

	public void printNodes() {
		Iterator arg0 = this.ketamaNodes.keySet().iterator();

		while (arg0.hasNext()) {
			Long key = (Long) arg0.next();
			System.out.println(this.ketamaNodes.get(key));
		}

	}

	public static long hash(byte[] digest, int nTime) {
		long rv = (long) (digest[3 + nTime * 4] & 255) << 24 | (long) (digest[2 + nTime * 4] & 255) << 16
				| (long) (digest[1 + nTime * 4] & 255) << 8 | (long) digest[0 + nTime * 4] & 255L;
		return rv;
	}
}