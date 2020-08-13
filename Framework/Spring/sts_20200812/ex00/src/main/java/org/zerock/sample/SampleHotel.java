package org.zerock.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
@RequiredArgsConstructor
public class SampleHotel {
	
	@NonNull
	private Chef chef;
	
	// 생성자 주입!
//	 public SampleHotel(Chef chef) {
//		 this.chef = chef;
//	 }
	 
}
