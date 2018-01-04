package com.gewara.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.gewara.model.BaseObject;

public abstract class GcacheManager {
	private final static transient GewaLogger dbLogger = LoggerUtils.getLogger(GcacheManager.class);
	private static final String SCHEMA_CACHE = "cache";
	private static final String SCHEMA_ID = "id";
	private static final String SCHEMA_CLASS = "class";
	private static final String SCHEMA_NOTIFY = "notify";//璺ㄧ郴缁熸椂棰濆鐨勯�氱煡闃熷垪
	private static final String SCHEMA_EAGER = "eager";//娓呴櫎缂撳瓨鏃舵槸鍚︾珛绔嬪埢閲嶆柊鍔犺浇
	private static final String SCHEMA_MAXIMUNSIZE = "maxnumSize";
	private final static Map<Class, CacheMeta> cacheMetaMap =  new ConcurrentHashMap<>();
	private final static Map<String/*tag*/, CacheMeta> tag2MetaMap = new ConcurrentHashMap<>();
	static {
		InputStream xmlInput = null, xsdInput = null;
		try{
			xmlInput = GcacheManager.class.getClassLoader().getResourceAsStream("gcache.xml");
			xsdInput = GcacheManager.class.getClassLoader().getResourceAsStream("gcache.xsd");
			if(xmlInput != null && xsdInput != null){
				initGcache(xmlInput, xsdInput);
			}
		}catch(Throwable e){
			throw new RuntimeException("gcache.xml", e);
		}finally{
			if(xmlInput != null){
				try {
					xmlInput.close();
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
			if(xsdInput != null){
				try {
					xmlInput.close();
				} catch (IOException e) {
					//e.printStackTrace();
				}
			}
		}
		
	}
	
	private static void initGcache(InputStream xmlInput, InputStream xsdInput) throws Throwable{
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Source xsdSource = new StreamSource(xsdInput);
		Schema schema = factory.newSchema(xsdSource);
		Validator validator = schema.newValidator();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setIgnoringComments(true);
		dbf.setNamespaceAware(true);
		dbf.setSchema(schema);
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(xmlInput);
		DOMSource source = new DOMSource(doc);
		validator.validate(source);
		NodeList nodeList = doc.getElementsByTagName(SCHEMA_CACHE);
		int length = nodeList.getLength();
		for(int i = 0; i< length; i ++){
			
			NamedNodeMap nameNodeMap = nodeList.item(i).getAttributes();
			Node node1 = nameNodeMap.getNamedItem(SCHEMA_ID);
			String tag = node1.getNodeValue();
			Node node2 = nameNodeMap.getNamedItem(SCHEMA_CLASS);
			String canonicalName = node2.getNodeValue();
			
			Node node3 = nameNodeMap.getNamedItem(SCHEMA_EAGER);
			boolean eager = false;
			if(node3!=null){
				eager = Boolean.valueOf(node3.getNodeValue());
			}
			
			Node node4 = nameNodeMap.getNamedItem(SCHEMA_NOTIFY);
			String notify = "";
			if(node4!=null){
				notify = node4.getNodeValue();
			}
			
			Class clazz = Class.forName(canonicalName);
			
			CacheMeta meta = cacheMetaMap.get(clazz);
			if(meta != null){
				throw new RuntimeException("gcache.xml class:" + canonicalName + " there are many records");
			}
			Node node5 = nameNodeMap.getNamedItem(SCHEMA_MAXIMUNSIZE);
			Long maxinumSize = Long.valueOf(node5.getNodeValue());
			Gcache gcache = new Gcache(maxinumSize);
			meta = new CacheMeta(gcache, clazz, tag, eager, notify);
			cacheMetaMap.put(clazz, meta);
			tag2MetaMap.put(tag, meta);
			dbLogger.warn("class:" + canonicalName + ", maxinumSize:" + maxinumSize + ", eager:" + eager + ", notify:" + notify);
		}
	}
	
	public static <T extends BaseObject> CacheMeta<T> getCacheMeta(Class<? extends BaseObject> clazz){
		return cacheMetaMap.get(clazz);
	}

	public static CacheMeta getCacheMeta(String tag){
		return tag2MetaMap.get(tag);
	}
	
	public static Map<Class, CacheMeta> getAllCacheObjectMap(){
		return new HashMap<>(cacheMetaMap);
	}
	
	public static List<String> getAllTags(){
		return new ArrayList(tag2MetaMap.keySet());
	}
	
	public static boolean hasCache(Class clazz){
		return cacheMetaMap.containsKey(clazz);
	}

	public static boolean isEager(Class clazz) {
		return false;
	}
	public static void invalidObject(Class clazz, Serializable id){
		CacheMeta cm = getCacheMeta(clazz);
		if(cm!=null){
			cm.gcache.invalidate(id);
		}
	}

}
