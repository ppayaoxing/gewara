/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.msearch.external.entity;

public class KVObject<K, V> {
	private K key = null;
	private V value = null;

	public KVObject(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K key() {
		return this.key;
	}

	public V value() {
		return this.value;
	}
}