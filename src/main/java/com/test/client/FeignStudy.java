package com.test.client;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public class FeignStudy {

}

/**
 * 
 * ��Щ�����е�һЩ������ͨ�õģ����ǿ��ܻ��в�ͬ�Ĳ������ͻ��߷������ͣ����ʱ�������ô��:
 */
interface BaseAPI2 {
	@RequestLine("GET /health")
	String health();

	@RequestLine("GET /all")
	List<String> all();
}

// �̳�ͨ��API
interface CustomAPI extends BaseAPI2 {
	@RequestLine("GET /custom")
	String custom();
}

// ������������ͬ�ı�����ʽ������һ��ͳһ��API--------------------------------------------------
@Headers("Accept: application/json")
interface BaseApi<V> {
	@RequestLine("GET /api/{key}")
	V get(@Param("key") String key);

	@RequestLine("GET /api")
	List<V> list();

	@Headers("Content-Type: application/json")
	@RequestLine("PUT /api/{key}")
	void put(@Param("key") String key, V value);
}

// ���ݲ�ͬ���������̳�
interface StringApi extends BaseApi<String> {
}

interface IntegerApi extends BaseApi<Integer> {
}
