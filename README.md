# 소복 스테이 / 게스트하우스 사이트(진행중)

---
⭐ 프로젝트 목적 및 주요 기능
---
🛠 Backend 개발 환경
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
👏 API URL

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


