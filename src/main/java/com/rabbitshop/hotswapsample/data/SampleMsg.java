package com.rabbitshop.hotswapsample.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Builder
public class SampleMsg {

	@lombok.NonNull
	@org.springframework.lang.NonNull
	String author;

	@lombok.NonNull
	@org.springframework.lang.NonNull
	String message;

}
