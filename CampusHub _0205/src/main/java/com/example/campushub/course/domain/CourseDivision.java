package com.example.campushub.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CourseDivision {
	//전공 필수, 전공 선택, 교양
	MAJOR_REQUIRED("전공필수"), MAJOR_ELECTIVE("전공선택"), GENERAL("교양");

	private final String name;

	public static CourseDivision of(String koreanName) {
		if (koreanName.equals("전공필수")){
			return MAJOR_REQUIRED;
		} else if (koreanName.equals("전공선택")) {
			return MAJOR_ELECTIVE;
		} else return GENERAL;
	}
//public static CourseDivision of(Object value) {
//	if (value instanceof String) {
//		String koreanName = ((String) value).trim().replaceAll("\\s+", "");
//		if (koreanName.equals("전공필수")) {
//			return MAJOR_REQUIRED;
//		} else if (koreanName.equals("전공선택")) {
//			return MAJOR_ELECTIVE;
//		} else if (koreanName.equals("교양")) {
//			return GENERAL;
//		}
//	} else if (value instanceof Integer) {
//		int num = (Integer) value;
//		if (num == 0) {
//			return MAJOR_REQUIRED;
//		} else if (num == 1) {
//			return MAJOR_ELECTIVE;
//		} else if (num == 2) {
//			return GENERAL;
//		}
//	}
//	throw new IllegalArgumentException("Invalid CourseDivision value: " + value);
//}



}
