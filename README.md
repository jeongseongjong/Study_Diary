# 2020-03-01
## CRUD 생성
 * insert 와 delete는 int로만 해야한다.
 * return type을 VO로 했다가 DB결과는 되지만 405(return type)ERROR가 나왔다.
 * Dao에서 어노테이션을 사용할 경우 @Mapper 어노테이션을 클래스에 꼭 붙여주자
 * insert / update 시 날짜/시간을 자동생성으로 넣어줄 경우
 	service 또는 controller에서 객체를 생성하여 insert / update에 주입하여 반환 해주어야 한다.(studyService(insert)참고)
 * mapper에서 namespace, comma, #$, jdbcType 확인을 잘하자
 * insert.jsp 에서 insert일 경우 form의 method는 POST로 지정해주자