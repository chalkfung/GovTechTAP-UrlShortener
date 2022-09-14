package com.chalkfung.urlshortener;

import com.chalkfung.urlshortener.controller.LinkController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class UrlshortenerApplicationTests {

	@Test
	void testEncoding() {
		String result = LinkController.encode(65);
		assertEquals("bd", result);

	}

}
