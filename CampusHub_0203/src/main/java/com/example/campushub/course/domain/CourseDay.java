package com.example.campushub.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CourseDay {
	MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"), THURSDAY("목요일"), FRIDAY("금요일");

	private final String name;

	public static CourseDay of(String koreaName) {
		if ("월요일".equals(koreaName)) {
			return MONDAY;
		} else if ("화요일".equals(koreaName)) {
			return TUESDAY;
		} else if ("수요일".equals(koreaName)) {
			return WEDNESDAY;
		} else if ("목요일".equals(koreaName)) {
			return THURSDAY;
		} else {
			return FRIDAY;
		}
	}
}