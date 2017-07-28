/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.util;

import java.io.Serializable;
import java.lang.management.ManagementFactory;
import java.net.NetworkInterface;
import java.nio.ByteBuffer;
import java.util.Enumeration;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ObjectId implements Serializable {
	private static final long serialVersionUID = -4415279469780082174L;
	final int _time;
	final int _machine;
	final int _inc;
	private static AtomicInteger _nextInc = new AtomicInteger((new Random()).nextInt());
	private static final int _genmachine;

	public static ObjectId get() {
		return new ObjectId();
	}

	public static String uuid() {
		return get().toString();
	}

	public ObjectId() {
		this._time = (int) (System.currentTimeMillis() / 1000L);
		this._machine = _genmachine;
		this._inc = _nextInc.getAndIncrement();
	}

	public ObjectId(Long timestamp, Integer num1) {
		this._time = (int) (timestamp.longValue() / 1000L);
		this._machine = num1.intValue();
		this._inc = _nextInc.getAndIncrement();
	}

	public ObjectId(Long timestamp, Integer num1, Integer num2) {
		this._time = (int) (timestamp.longValue() / 1000L);
		this._machine = num1.intValue();
		this._inc = num2.intValue();
	}

	public ObjectId(Long timestamp) {
		this._time = (int) (timestamp.longValue() / 1000L);
		this._machine = _genmachine;
		this._inc = _nextInc.getAndIncrement();
	}

	public Long getTimestamp() {
		return Long.valueOf((long) this._time * 1000L);
	}

	public byte[] toByteArray() {
		byte[] b = new byte[12];
		ByteBuffer bb = ByteBuffer.wrap(b);
		bb.putInt(this._time);
		bb.putInt(this._machine);
		bb.putInt(this._inc);
		return b;
	}

	public String toString() {
		byte[] b = this.toByteArray();
		StringBuilder buf = new StringBuilder(24);

		for (int i = 0; i < b.length; ++i) {
			int x = b[i] & 255;
			String s = Integer.toHexString(x);
			if (s.length() == 1) {
				buf.append("0");
			}

			buf.append(s);
		}

		return buf.toString();
	}

	static {
		try {
			int e;
			try {
				StringBuilder processId = new StringBuilder();
				Enumeration loader = NetworkInterface.getNetworkInterfaces();

				while (loader.hasMoreElements()) {
					NetworkInterface loaderId = (NetworkInterface) loader.nextElement();
					processId.append(loaderId.toString());
				}

				e = processId.toString().hashCode() << 16;
			} catch (Exception arg6) {
				e = (new Random()).nextInt() << 16;
			}

			int processId1 = (new Random()).nextInt();

			try {
				processId1 = ManagementFactory.getRuntimeMXBean().getName().hashCode();
			} catch (Throwable arg5) {
				;
			}

			ClassLoader loader1 = ObjectId.class.getClassLoader();
			int loaderId1 = loader1 != null ? System.identityHashCode(loader1) : 0;
			StringBuilder sb = new StringBuilder();
			sb.append(Integer.toHexString(processId1));
			sb.append(Integer.toHexString(loaderId1));
			int processPiece = sb.toString().hashCode() & '?';
			_genmachine = e | processPiece;
		} catch (Exception arg7) {
			throw new RuntimeException(arg7);
		}
	}
}