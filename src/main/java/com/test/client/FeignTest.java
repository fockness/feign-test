package com.test.client;

import java.util.List;

import feign.Feign;
import feign.gson.GsonDecoder;

public class FeignTest {

	public static void main(String[] args) {
		// FeignClient client = Feign.builder().target(FeignClient.class,
		// "http://localhost:8762");
		// System.out.println(client.getMemberServiceApi());

		FeignClient client = Feign.builder().decoder(new GsonDecoder())
				.target(FeignClient.class, "http://localhost:8762");
		List<String> list = client.getMemberAll("ownerT", "repoT");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
