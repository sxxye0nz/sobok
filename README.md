# 소복 스테이 / 게스트하우스 사이트(진행중)

'소복 스테이'는 게스트하우스만을 모아둔 게스트하우스 채용 공고 웹 사이트입니다.

게스트하우스 스태프란?
→ 게스트하우스에서 스태프에게 숙식을 제공해 주는 대신, 보통 주에 2일 근무, 혹은 주에 2일 휴무의 형식으로 게스트하우스에 머무는 고객의 편의 시설을 관리하는 업무를 담당합니다.

게스트하우스 특성상 숙식을 제공하는 대신 무급여 조건으로 채용하는 사례가 많습니다. 이는 현행법상 불법행위이며, 근로의 대가로 숙식을 제공받는다 하더라도 근로계약서는 필수 조건입니다.

'소복 스테이'에는 급여가 제공되며 근로계약서의 절차가 필수인 게스트하우스만이 머물고 있습니다.

---
⭐ 프로젝트 목적 및 주요 기능
- Spring, Java, AWS 의 능률 향상 목적입니다.
- open API를 사용한 소셜 로그인, 유연한 결제 API 설계가 목적입니다.
- Gmail의 SMTP 서버로 메일 발송,인증 설계가 목적입니다.
- 회원가입, 로그인 정규식
- 이메일, 비밀번호, 이름 유효성 검사
- Security 보안 적용
- CRUD
---
###🛠 Backend 개발 환경
| 기술스택 | 버전 |
| ------------ | ------------- |
| springframework.bootl | 2.7.13 |
| java | 17 |
| CSS | 3 |
| HTML | 5 |
| Amazon Linux | 2 |
| Linux 커널 | 5.10.179-168.710.amzn2.x86_64 |
| apache-tomcat | 9.0.73 |
| Maria DB | 10.11 |
| Spring Security | 5.8.4 |
| jquery | 3.1.1-1 |
---
###👏 URL

#유저관련
| 기능 | url | 요청방식 |
| ------------ | ------------- | ------------- |
| 회원가입 | /signup | get |
| 회원등록 | /signup | post |
| 로그인 | /signin | get |
| 이메일 확인 | /common/email-check | get |
| 로그아웃 | /logout | post |

#메뉴관련
| 기능 | url | 요청방식 |
| ------------ | ------------- | ------------- |
| 스테이 | /menu/stays-board | get |
| 공고글 | /menu/step-board | get |
| 후기 | /menu/review-board | post |

#게시글관련
| 기능 | url | 요청방식 |
| ------------ | ------------- | ------------- |
| 작성 | /menu/step/step-write | get |
| 등록 | /menu/step/step-write | post |
| 조회 | /menu/step-board | get |
| 상세조회 | /menu/step-board/{sno} | get |
| 수정 | /menu/step-board/{sno} | put |
| 삭제 | /menu/step-board/{sno} | delete |


