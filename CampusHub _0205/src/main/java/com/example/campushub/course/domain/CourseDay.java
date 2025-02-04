package com.example.campushub.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CourseDay {
	MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"), THURSDAY("목요일"), FRIDAY("금요일");

	private final String name;

	public static CourseDay of(String koreanName) {
		if (koreanName.equals("월요일")) {
			return MONDAY;
		} else if (koreanName.equals("화요일")) {
			return TUESDAY;
		} else if (koreanName.equals("수요일")) {
			return WEDNESDAY;
		} else if (koreanName.equals("목요일")) {
			return THURSDAY;
		} else return FRIDAY;
	}
}
