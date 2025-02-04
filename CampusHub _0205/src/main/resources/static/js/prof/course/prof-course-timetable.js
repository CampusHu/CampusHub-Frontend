$(function () {
    // 페이지가 로드되면 교수 강의 시간표 데이터를 가져옴
    loadCourseSchedule();

    // 랜덤 색상을 생성하는 함수
    function getRandomColor() {
        const colors = ['#33fcff', '#43fe62', '#f56200', '#deff38', '#98FB98', '#FF69B4', '#E0FFFF'];
        return colors[Math.floor(Math.random() * colors.length)];
    }

    // 교수 강의 시간표 목록을 가져오는 함수
    function loadCourseSchedule() {
        var url = '/api/professor/course/calender'; // 교수 강의 시간표 API URL
        var token = localStorage.getItem('jwtToken'); // JWT 토큰을 로컬 스토리지에서 가져옴

        $.ajax({
            url: url,
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`, // JWT 토큰을 Authorization 헤더에 추가
                'Content-Type': 'application/json',
            },
            success: function (response) {
                console.log('서버 응답:', response); // 응답을 콘솔에 출력하여 확인

                if (response.status === 200) {
                    var tableBody = $('#prof-course-time-TableBody');
                    tableBody.empty(); // 기존 내용을 비움

                    let courseColors = {}; // 강의명별 배경색을 저장할 객체

                    for (let hour = 1; hour <= 9; hour++) {
                        const row = $('<tr></tr>'); // 새로운 행 생성
                        row.append(`<td><strong>${hour}교시</strong></td>`); // 시간대 열 추가

                        const days = ['월', '화', '수', '목', '금']; // 요일 배열
                        days.forEach(day => {
                            const course = response.data.find(schedule =>
                                schedule.courseDay === day + '요일' && schedule.startPeriod <= hour && schedule.endPeriod >= hour
                            );

                            let courseInfo = course ? `<strong>${course.courseName}</strong><br>${course.room}` : '';

                            if (course) {
                                // 기존에 색이 지정되지 않았다면 새로운 색 생성
                                if (!courseColors[course.courseName]) {
                                    courseColors[course.courseName] = getRandomColor();
                                }
                            }

                            // 배경색 지정
                            let bgColor = course ? `background-color: ${courseColors[course.courseName]};` : '';
                            row.append(`<td style="${bgColor}">${courseInfo}</td>`);
                        });

                        tableBody.append(row); // 테이블에 추가
                    }
                } else {
                    console.error('강의 시간표 조회 실패:', response.message);
                }
            },
            error: function (xhr, status, error) {
                console.error('시간표 데이터를 가져오는 중 오류 발생:', error);
                console.error('응답 상태 코드:', xhr.status);
                console.error('응답 메시지:', xhr.responseText);
            },
        });
    }
});
