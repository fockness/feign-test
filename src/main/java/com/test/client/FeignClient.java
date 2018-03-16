package com.test.client;

import java.util.List;

import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * 
 *	Feign��client�ӿ�
 *	http://localhost:8762/getMemberServiceApi
 */
public interface FeignClient {

	/**
	 * �������������ͷ�������� 
	 */
	@RequestLine("GET /getMemberServiceApi")
	@Headers("Content-Type: application/xml")
	@Body("test")
	public String getMemberServiceApi();
	
	@RequestLine("GET /service/{owner}/{repo}/getMemberAll")
	public List<String> getMemberAll(@Param("owner") String owner, @Param("repo") String repo);
}


