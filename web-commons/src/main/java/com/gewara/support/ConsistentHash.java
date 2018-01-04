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
    private volatile boolean init=false; //��־�Ƿ��ʼ�����

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
        //����ҵ�����ڵ㣬ֱ��ȡ�ڵ㣬����
        if(!ketamaNodes.containsKey(hash)){
            //�õ����ڵ�ǰkey���Ǹ���Map��Ȼ�����ȡ����һ��key�����Ǵ���������������Ǹ�key
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
        //�����нڵ㣬����numberOfReplicas������ڵ�
        for(T node:nodes){
            //ÿ�ĸ�����ڵ�Ϊ1��
            for(int i=0;i<numberOfReplicas/4;i++){
                //Ϊ����������õ�Ωһ����
                byte[] digest=hashFunction.hashString(node.toString() +i, Charset.forName("UTF-8")).asBytes();
                //Md5��һ��16�ֽڳ��ȵ����飬��16�ֽڵ�����ÿ�ĸ��ֽ�һ�飬�ֱ��Ӧһ�������㣬�����Ϊʲô������������ĸ�����һ���ԭ��
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
