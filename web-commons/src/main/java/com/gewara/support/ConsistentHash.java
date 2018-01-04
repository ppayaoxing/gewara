package com.gewara.support;

import java.nio.charset.Charset;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class ConsistentHash<T> {
	private SortedMap<Long,T> ketamaNodes=new TreeMap<Long,T>();
    private int numberOfReplicas=1024;
    private HashFunction hashFunction= Hashing.md5(); //guava
    private List<T> nodes;
    private volatile boolean init=false; //锟斤拷志锟角凤拷锟绞硷拷锟斤拷锟斤拷

    public ConsistentHash(int numberOfReplicas,List<T> nodes){
        this.numberOfReplicas=numberOfReplicas;
        this.nodes=nodes;

        init();
    }

    public T getNodeByKey(String key){
        if(!init) {
            throw new RuntimeException("init uncomplete...");
        }

        byte[] digest=hashFunction.hashString(key, Charset.forName("UTF-8")).asBytes();
        long hash=hash(digest,0);
        //锟斤拷锟斤拷业锟斤拷锟斤拷锟节点，直锟斤拷取锟节点，锟斤拷锟斤拷
        if(!ketamaNodes.containsKey(hash)){
            //锟矫碉拷锟斤拷锟节碉拷前key锟斤拷锟角革拷锟斤拷Map锟斤拷然锟斤拷锟斤拷锟饺★拷锟斤拷锟揭伙拷锟絢ey锟斤拷锟斤拷锟角达拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷歉锟絢ey
            SortedMap<Long,T> tailMap=ketamaNodes.tailMap(hash);
            if(tailMap.isEmpty()){
                hash=ketamaNodes.firstKey();
            }else{
                hash=tailMap.firstKey();
            }

        }
        return ketamaNodes.get(hash);
    }

    public synchronized void addNode(T node){
        init=false;
        nodes.add(node);
        init();
    }

    private void init(){
        //锟斤拷锟斤拷锟叫节点，锟斤拷锟斤拷numberOfReplicas锟斤拷锟斤拷锟斤拷诘锟�
        for(T node:nodes){
            //每锟侥革拷锟斤拷锟斤拷诘锟轿�1锟斤拷
            for(int i=0;i<numberOfReplicas/4;i++){
                //为锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷玫锟轿┮伙拷锟斤拷锟�
                byte[] digest=hashFunction.hashString(node.toString() +i, Charset.forName("UTF-8")).asBytes();
                //Md5锟斤拷一锟斤拷16锟街节筹拷锟饺碉拷锟斤拷锟介，锟斤拷16锟街节碉拷锟斤拷锟斤拷每锟侥革拷锟街斤拷一锟介，锟街憋拷锟接σ伙拷锟斤拷锟斤拷锟斤拷悖拷锟斤拷锟斤拷为什么锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷母锟斤拷锟斤拷锟揭伙拷锟斤拷原锟斤拷
                for(int h=0;h<4;h++){
                    Long k = hash(digest,h);
                    ketamaNodes.put(k,node);
                }
            }
        }
        init=true;
    }

    public void printNodes(){
        for(Long key:ketamaNodes.keySet()){
            System.out.println(ketamaNodes.get(key));
        }
    }

    public static long hash(byte[] digest, int nTime)
    {
        long rv = ((long)(digest[3 + nTime * 4] & 0xFF) << 24)
                | ((long)(digest[2 + nTime * 4] & 0xFF) << 16)
                | ((long)(digest[1 + nTime * 4] & 0xFF) << 8)
                | ((long)digest[0 + nTime * 4] & 0xFF);
        return rv;
    }
}
