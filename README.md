# 2020-03-01
## CRUD 생성
 * insert 와 delete는 int로만 해야한다.
 * return type을 VO로 했다가 DB결과는 되지만 405(return type)ERROR가 나왔다.
 * Dao에서 어노테이션을 사용할 경우 @Mapper 어노테이션을 클래스에 꼭 붙여주자
 * insert / update 시 날짜/시간을 자동생성으로 넣어줄 경우
 	service 또는 controller에서 객체를 생성하여 insert / update에 주입하여 반환 해주어야 한다.(studyService(insert)참고)
 * mapper에서 namespace, comma, #$, jdbcType 확인을 잘하자
 * insert.jsp 에서 insert일 경우 form의 method는 POST로 지정해주자
 
# 2020-03-07
## Reset
 * login 폼이 필요한데 나중에 만들어놓고 묶으려다 보니 테이블 상 구조 또는
   유효성 검사에서 막히는게 많았다. 그렇기 때문에 만들어놓은 DB나 CRUD는 리셋하고
   같은 컨셉으로 테이블 구조를 다시 잡고 수정하는 중이다.
 * 프로젝트를 할때는 필수요소를 만들고 시작하는게 좋은 방법인것 같다.
 
# 2020-03-10
## login & join
### join
 * join(get)
  - 아무것도 들어있지 않은 VO를 생성해서 model에 담아 view단에 보내주지만
  	없다면 view단에 modelAttribute가 돌아가지 않아 405(not support 'GET') err 발생
 * join(post)
  - BindingResult / @valid, hasErrors 이해가 필요
 * ID중복확인(userIdCheck)
  - view단에서 ajax로 받아오지만 data값이 controller의 @RequestParam(value)와 맞지 않아서
    값을 못불러오는 현상 발생 @ReqeustParam(value)값과 ajax의 data값은 동일해야한다.
  - True / False 만 불러올때는 굳이 Map 형식이 아닌 Boolean으로 하는것이 편하다.
    Map으로 할때는 그안의 값까지 같이 가져올 때 사용한다.
    
# 2020-03-15
## 테이블 재수정 & Detail & Comment
### 테이블 재수정
 * FK관계 이해도가 미흡하여 실패를 겪고 재수정하여 테이블 설계\

### Detail
 * seq를 long으로 하는데 Form에서 보내주는값이 기본 String형으로 되서 TypeMissMatch가 발생 -> view단에서 controller로 보낼때 
 	long형으로 형변환 시켜야 할 칼럼은 value값을 0으로 설정하여 타입을 묶어서 보내줘야한다.
 
### Comment
 * 로그인 된 id를 가져오기 위해 Session에 등록되어 있는 vo를 꺼내서 cast후에 vo에 값을 담아주어야 한다.
 * insert시 model에 값을 담아 보내면 
 	ex) model.addAttribute("writer", userVO.getU_id());
 		Comment/insert?writer=${userVO.getU_id}가 된다.
 * 리스트를 뽑아낼 때 부모테이블의 FK를 파라미터 값으로 지정해주고 자식테의블의 FK에게 값을 넘겨준다. ex) long c_s_id = Long.valueOf(s_id)
 * input form에서 fk값을 넘겨줄때
 	ex) name="c_s_id" value="${studyVO.s_seq}로 자식테이블의 fk를 name으로 설정해두고 부모테이블의 fk를 value값으로 지정해준다.
 * insert시 form에 seq를 담아주지 않아도 mapper에서 담아주기 때문에 input에 해당하는값들이 자동으로 생성되는 seq를 찾아간다.(update할때는 seq필요)
 
 
# 2020-03-16
## study update / delete & Interceptor
### study udpate
 * jsp에 보내주는 url(s_seq)를 정확히 보내줘야 값을 찾는다
  괜히 이상한걸로 바꿔서 까먹지말자
 * seq를 받아서 get으로 받고 update에 넣어 post로 보내줘야 한다.
 
### Interceptor
 * 정확히 path를 지정해줘서 혼동되는일이 없도록 하자
 
# 2020-03-17
## 댓글 ajax 삭제 & 종료시간 ajax
### 종료시간 ajax
 * 무참히 실패했다... 내일 하나하나 다시봐야겠다.
 
# 2020-03-18
## 종료시간 ajax 성공
* 구분하기 쉽도록 study-update.jsp에 Diary를 빼서 detail.jsp에 include 한다.
 * 버튼 클릭시 이벤트로 종료시간이 작성되도록 했다.
 * 종료시간 - 시작시간 = 공부시간이 되기때문에 VO에 String으로 들어간 시간을 빼서 Date형으로 parse 하여 시간을 연산했고 String.format을 이용 String형으로 전환하여 VO에 다시 set했다.
 
# 2020-03-20
## 공부 기록 s_auth를 u_id로 지정하기
 * u_id를 바로 s_auth자리에 넣으려 했더니 controller에서 보내는 리턴오류가 발생
 	> - detail에서 study-update.jsp로 보내주는 contorler에서 session에 들어있는 id 값을 s_auth에 넣었더니 종료버튼 클릭시 id값이 auth의 위치로 들어가는걸 확인
 	> - getAttribute로 가져온 값은 login 컨트롤러에서 session에 보내주는 VO를 가져와야하고 그밖에 .getU_id를 가져와야한다.
 	> - studyVO.setS_auth(((UserVO) session.getAttribute("userVO")).getU_id());

# 2020-03-21
## auth insert
 * auth를 study-update.jsp에 보내는 fTime 컨트롤러에서 보냈더니 로그인이 끊겨 있기 때문에 기록을 볼때 작성자 기록이 안돼있었다.
 * 때문에 그냥 보여주는게 아닌 insert로 등록을 해서 당시에 session에 담겼던 id를 auth로 넣고 로그아웃을 하더라도 그대로 남아있어야한다.
  > - fTime에서 컨트롤러에서 넣어줬던 id값을 글작성시에 바로 들어갈 수 있도록 insert service에서 studyVO의 s_auth에 set했다.
  
# 2020-03-25
## 페이지 네이션
 * 전에 했던 페이지네이션을 보고 따라해봤다. 이해 못하는 코드가 좀 있다. 분해해석 해 봐야겠다.
  > - 전에는 자바파일을 만들어서 SQL문을 작성해서 페이징을 했으나 이번에는 mapper로 페이징을 처리했다.
  > - 다른점은 큰따옴표는 mapper에 사용하면 안되며 #{}를 사용시 null에대한 Exception이 나오기 때문에
  > - ,jdbcType=VARCHAR를 넣어주어야 한다. 

## UI 변경
 * header의 사진 등록 & 리스트 hover시 border 크기 에러 & 로그인/조인 UI구현
  > - 평소 사진등록시 link 태그로 src를 가져왔지만 이번에는 style에 이미지의 경로를 넣어 사용했다.
  > - 리스트에 마우스를 올렸을 때 생성되는 hover border가 오버되는 현상이 발생됐다.
  > - login과 join의 UI를 전에 사용했던 프로젝트에서 가져왔다.
 
 
 
 
 