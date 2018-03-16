package com.test.client;

import java.util.List;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public class FeignStudy {

}

/**
 * 
 * 有些请求中的一些方法是通用的，但是可能会有不同的参数类型或者返回类型，这个时候可以这么用:
 */
interface BaseAPI2 {
	@RequestLine("GET /health")
	String health();

	@RequestLine("GET /all")
	List<String> all();
}

// 继承通用API
interface CustomAPI extends BaseAPI2 {
	@RequestLine("GET /custom")
	String custom();
}

// 各种类型有相同的表现形式，定义一个统一的API--------------------------------------------------
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

// 根据不同的类型来继承
interface StringApi extends BaseApi<String> {
}

interface IntegerApi extends BaseApi<Integer> {
}
