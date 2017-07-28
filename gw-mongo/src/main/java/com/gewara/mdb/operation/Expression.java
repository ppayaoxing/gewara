/*** Eclipse Class Decompiler plugin, copyright (c) 2016 Chen Chao (cnfree2000@hotmail.com) ***/
package com.gewara.mdb.operation;

import com.gewara.util.Util4Script;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.BsonType;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

public class Expression implements Util4Script {
	public static final String MongoDB_ID_FieldName = "_id";
	protected final Expression.LogicRelate logic;
	protected final List<Bson> condition;

	public Expression() {
		this(Expression.LogicRelate.AND);
	}

	public Expression(Expression.LogicRelate logic) {
		this.condition = new ArrayList();
		this.logic = logic;
	}

	public Expression eq(String fieldName, Object value) {
		this.condition.add(Filters.eq(fieldName, value));
		return this;
	}

	public Expression ne(String fieldName, Object value) {
		this.condition.add(Filters.ne(fieldName, value));
		return this;
	}

	public Expression gt(String fieldName, Object value) {
		this.condition.add(Filters.gt(fieldName, value));
		return this;
	}

	public Expression lt(String fieldName, Object value) {
		this.condition.add(Filters.lt(fieldName, value));
		return this;
	}

	public Expression gte(String fieldName, Object value) {
		this.condition.add(Filters.gte(fieldName, value));
		return this;
	}

	public Expression lte(String fieldName, Object value) {
		this.condition.add(Filters.lte(fieldName, value));
		return this;
	}

	public Expression between(final String fieldName, final Object min, final Object max,
			final Expression.OpenCloseState range) {
		this.condition.add(new Bson() {
			public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass,
					CodecRegistry codecRegistry) {
				String from = null;
				String to = null;
				switch (null.$SwitchMap$com$gewara$mdb$operation$Expression$OpenCloseState[range.ordinal()]) {
				case 1:
					from = "$gte";
					to = "$lt";
					break;
				case 2:
					from = "$gt";
					to = "$lt";
					break;
				case 3:
					from = "$gt";
					to = "$lte";
					break;
				case 4:
					from = "$gte";
					to = "$lte";
				}

				BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
				writer.writeStartDocument();
				writer.writeName(fieldName);
				writer.writeStartDocument();
				writer.writeName(from);
				Expression.encodeValue(writer, min, codecRegistry);
				writer.writeName(to);
				Expression.encodeValue(writer, max, codecRegistry);
				writer.writeEndDocument();
				writer.writeEndDocument();
				return writer.getDocument();
			}
		});
		return this;
	}

	private static void encodeValue(BsonDocumentWriter writer, Object value, CodecRegistry codecRegistry) {
		if (value == null) {
			writer.writeNull();
		} else if (value instanceof Bson) {
			codecRegistry.get(BsonDocument.class).encode(writer,
					((Bson) value).toBsonDocument(BsonDocument.class, codecRegistry), EncoderContext.builder().build());
		} else {
			codecRegistry.get(value.getClass()).encode(writer, value, EncoderContext.builder().build());
		}

	}

	public Expression in(String fieldName, Object[] values) {
		this.condition.add(Filters.in(fieldName, values));
		return this;
	}

	public Expression in(String fieldName, Iterable values) {
		this.condition.add(Filters.in(fieldName, values));
		return this;
	}

	public Expression nin(String fieldName, Object[] values) {
		this.condition.add(Filters.nin(fieldName, values));
		return this;
	}

	public Expression nin(String fieldName, Iterable values) {
		this.condition.add(Filters.nin(fieldName, values));
		return this;
	}

	public Expression exists(String fieldName, boolean exists) {
		this.condition.add(Filters.exists(fieldName, exists));
		return this;
	}

	public Expression type(String fieldName, BsonType type) {
		this.condition.add(Filters.type(fieldName, type));
		return this;
	}

	public Expression mod(String fieldName, long divisor, long remainder) {
		this.condition.add(Filters.mod(fieldName, divisor, remainder));
		return this;
	}

	public Expression regex(String fieldName, String pattern) {
		this.condition.add(Filters.regex(fieldName, pattern));
		return this;
	}

	public Expression regex(String fieldName, String pattern, String options) {
		this.condition.add(Filters.regex(fieldName, pattern, options));
		return this;
	}

	public Expression regex(String fieldName, Pattern pattern) {
		this.condition.add(Filters.regex(fieldName, pattern));
		return this;
	}

	public Expression text(String search) {
		this.condition.add(Filters.text(search));
		return this;
	}

	public Expression where(String javaScriptExpression) {
		this.condition.add(Filters.where(javaScriptExpression));
		return this;
	}

	public Expression all4Array(String fieldName, Object... values) {
		this.condition.add(Filters.all(fieldName, values));
		return this;
	}

	public Expression all4Array(String fieldName, Iterable values) {
		this.condition.add(Filters.all(fieldName, values));
		return this;
	}

	public Expression elemMatch4Array(String fieldName, Expression matchCondition) {
		this.condition.add(Filters.elemMatch(fieldName, matchCondition.toBson()));
		return this;
	}

	public Expression size4Array(String fieldName, int size) {
		this.condition.add(Filters.size(fieldName, size));
		return this;
	}

	public Expression bson(Bson... bsons) {
		Bson[] arg1 = bsons;
		int arg2 = bsons.length;

		for (int arg3 = 0; arg3 < arg2; ++arg3) {
			Bson bson = arg1[arg3];
			this.condition.add(bson);
		}

		return this;
	}

	public Expression expression(Expression... expressions) {
		Expression[] arg1 = expressions;
		int arg2 = expressions.length;

		for (int arg3 = 0; arg3 < arg2; ++arg3) {
			Expression expression = arg1[arg3];
			this.condition.add(expression.toBson());
		}

		return this;
	}

	public Bson toBson() {
		if (!this.condition.isEmpty()) {
			Bson bson = null;
			if (this.condition.size() == 1) {
				bson = this.logic == Expression.LogicRelate.NOT ? Filters.not((Bson) this.condition.get(0))
						: (Bson) this.condition.get(0);
			} else {
				switch (null.$SwitchMap$com$gewara$mdb$operation$Expression$LogicRelate[this.logic.ordinal()]) {
				case 1:
					bson = Filters.and(this.condition);
					break;
				case 2:
					bson = Filters.or(this.condition);
					break;
				case 3:
					bson = Filters.not(Filters.and(this.condition));
					break;
				case 4:
					bson = Filters.nor(this.condition);
				}
			}

			return bson;
		} else {
			return new BsonDocument();
		}
	}

	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("key1", "1");
		map.put("key2", "2");
		Expression exp = new Expression(Expression.LogicRelate.OR);
		Bson b = exp.toBson();
		System.out.println(b.toString());
	}

	public static enum OpenCloseState {
		CO, OO, OC, CC;
	}

	public static enum LogicRelate {
		AND, OR, NOT, NOR;
	}
}