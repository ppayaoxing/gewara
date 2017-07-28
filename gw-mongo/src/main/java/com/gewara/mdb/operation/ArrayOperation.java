/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.operation;

import com.gewara.mdb.helper.MongoMapAble;
import com.gewara.mdb.operation.Expression;
import com.gewara.util.BeanUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.bson.Document;

public class ArrayOperation {
	private Document doc = new Document();
	private boolean base = true;

	public ArrayOperation valueType(boolean isBase) {
		this.base = isBase;
		return this;
	}

	public <V> ArrayOperation set2Tail(String field, V... values) {
		assert values != null;

		Document hd = (Document) this.doc.get("$addToSet");
		if (values.length == 1) {
			if (null == hd) {
				this.doc.append("$addToSet", new Document(field, this.toTrans(values[0])));
			} else {
				hd.append(field, values[0]);
			}
		} else if (null == hd) {
			this.doc.append("$addToSet", new Document(field, new Document("$each", this.toList(values))));
		} else {
			hd.append(field, new Document("$each", this.toList(values)));
		}

		return this;
	}

	public <V> ArrayOperation set2Position(String field, int position, V... values) {
		assert values != null;

		Document f = new Document("$each", this.toList(values));
		f.append("$position", Integer.valueOf(position));
		this.doc.append("$addToSet", new Document(field, f));
		return this;
	}

	public <V> ArrayOperation push2Tail(String field, V... values) {
		assert values != null;

		Document hd = (Document) this.doc.get("$push");
		if (values.length == 1) {
			if (null == hd) {
				this.doc.append("$push", new Document(field, this.toTrans(values[0])));
			} else {
				hd.append(field, this.toTrans(values[0]));
			}
		} else if (null == hd) {
			this.doc.append("$push", new Document(field, new Document("$each", this.toList(values))));
		} else {
			hd.append(field, new Document("$each", this.toList(values)));
		}

		return this;
	}

	private List<Object> toList(Object... values) {
		ArrayList list = new ArrayList(values.length);
		Object[] arg2 = values;
		int arg3 = values.length;

		for (int arg4 = 0; arg4 < arg3; ++arg4) {
			Object value = arg2[arg4];
			list.add(this.toTrans(value));
		}

		return list;
	}

	private Object toTrans(Object value) {
		return value instanceof MongoMapAble ? ((MongoMapAble) value).toMap()
				: (this.base ? value : BeanUtil.getBeanMap(value));
	}

	public <V> ArrayOperation updateArrayItem(String arrayField, String arrayItemField, V value) {
		Object setd = (Map) this.doc.get("$set", Map.class);
		if (setd == null) {
			setd = new Document();
			this.doc.put("$set", setd);
		}

		Object obj = this.toTrans(value);
		if (arrayItemField != null) {
			((Map) setd).put(arrayField + ".$." + arrayItemField, obj);
		} else {
			((Map) setd).put(arrayField + ".$", obj);
		}

		return this;
	}

	public <V> ArrayOperation push2Position(String field, int position, V... values) {
		assert values != null;

		Document f = new Document("$each", this.toList(values));
		f.append("$position", Integer.valueOf(position));
		Document hd = (Document) this.doc.get("$push");
		if (hd != null) {
			hd.append(field, f);
		} else {
			this.doc.append("$push", new Document(field, f));
		}

		return this;
	}

	public ArrayOperation remove4Head(String... fields) {
		Document hd = (Document) this.doc.get("$pop");
		int arg4;
		if (hd != null) {
			String[] fc = fields;
			int arg3 = fields.length;

			for (arg4 = 0; arg4 < arg3; ++arg4) {
				String f = fc[arg4];
				hd.append(f, Integer.valueOf(-1));
			}
		} else {
			Document arg7 = new Document();
			String[] arg8 = fields;
			arg4 = fields.length;

			for (int arg9 = 0; arg9 < arg4; ++arg9) {
				String f1 = arg8[arg9];
				arg7.append(f1, Integer.valueOf(-1));
			}

			this.doc.append("$pop", arg7);
		}

		return this;
	}

	public ArrayOperation remove4Tail(String... fields) {
		assert fields != null;

		Document hd = (Document) this.doc.get("$pop");
		int arg4;
		if (hd != null) {
			String[] fc = fields;
			int arg3 = fields.length;

			for (arg4 = 0; arg4 < arg3; ++arg4) {
				String f = fc[arg4];
				hd.append(f, Integer.valueOf(1));
			}
		} else {
			Document arg7 = new Document();
			String[] arg8 = fields;
			arg4 = fields.length;

			for (int arg9 = 0; arg9 < arg4; ++arg9) {
				String f1 = arg8[arg9];
				arg7.append(f1, Integer.valueOf(1));
			}

			this.doc.append("$pop", arg7);
		}

		return this;
	}

	public <V> ArrayOperation remove4Value(String field, V... values) {
		assert values != null;

		Document hd = (Document) this.doc.get("$pullAll");
		if (hd != null) {
			hd.append(field, this.toList(values));
		} else {
			this.doc.append("$pullAll", new Document(field, this.toList(values)));
		}

		return this;
	}

	public ArrayOperation remove4Condition(String field, Expression expression) {
		if ($assertionsDisabled || field != null && expression != null) {
			Document hd = (Document) this.doc.get("$pull");
			if (hd != null) {
				hd.append(field, expression.toBson());
			} else {
				this.doc.append("$pullAll", new Document(field, expression.toBson()));
			}

			return this;
		} else {
			throw new AssertionError();
		}
	}

	public Document toDocument() {
		return this.doc;
	}
}