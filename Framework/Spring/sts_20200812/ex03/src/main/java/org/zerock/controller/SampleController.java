package org.zerock.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {

	@GetMapping(value = "/getText", produces = "text/plain; charsetUTF-8")
	public String getTest() {
		log.info(MediaType.TEXT_PLAIN_VALUE);

		return "hi";
	}

	@GetMapping(value = "/getSample", produces = { MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public SampleVO getSample() {
		log.info(MediaType.TEXT_PLAIN_VALUE);
		return new SampleVO(112, "최", "혜근");
	}

}
