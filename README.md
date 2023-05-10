# 기능 목록
- 특정 사원 현재 정보 조회 API
- 특정 사원 이력 정보 조회 API
- 부서 및 위지 정보 조회 API
- 특정 부서의 급여를 특정 비율로 인상 및 사원 정보 업데이트 API
- 공공데이터 포털의 데이터를 조회할 수 있는 API - 환율 조회 

# 사용한 기술 스택 및 라이브러리
- Java 11
- Spring boot 2.7.11
- Spring boot devtools
- Spring data JPA
- Lombok
- MySQL Connector
- Gson 2.8.9

# 커밋 규칙 & 코딩 컨벤션
1) 코딩 컨벤션 : 구글 코딩 컨벤션 적용
2) 커밋 규칙
    - feat : 새로운 기능 추가
    - refactor : 코드 리팩토링

# 사용한 데이터
https://github.com/nomemory/hr-schema-mysql/blob/master/hr-schema-mysql.sql

# API 명세서
| 기능                                  | 메서드   | 범위           | URL                                | 응답 예시                                                                                                                                                                                                                                                             |
|-------------------------------------|-------|--------------|------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 부서 및 위지정보 조회                        | GET   | department   | /department/{depId}                | {<br/>"depId":"int"<br/>"depName":"String"<br/>"managerId":"int"<br/>"locationId":"int"<br/>}                                                                                                                                                                     |
| 특정 부서의 급여를 특정 비율로 인상 API            | POST  | employee     | /employee                          |
| 사원 정보 업데이트 API                      | PATCH | employee     | /employee/{employeeId}             |                            
| 특정 직원 직업이력 조회                       | GET   | employee     | /employee/{employeeId}/{startDate} | {<br/>"emplyeeId":"int"<br/>"startDate":"Date"<br/>"endDate":"Date"<br/>"jobId":"String"<br/>"depId":"int"<br/>}                                                                                                                                                        |
| 특정 직원 현재정보 조회                       | GET   | employee     | /employee/{employeeId}             | {<br/>"employeeId":"int"<br/>"firstName":"String"<br/>"lastName":"String"<br/>"email":"String"<br/>"phoneNumber":"int"<br/>"hireDate":"Date"<br/>"jobId":"String"<br/>"salary":"Double"<br/>"comissionPct":"Double"<br/>"managerId":"int"<br/>"depId":"int"<br/>} |
| 공공데이터 포털의 데이터를 조회할 수 있는 API - 환율 조회 | GET   | exchangeRate | /exchangeRate                      | {<br/>"curNm":"String"<br/>"ttb":"String"<br/>"tts":"String"<br/>"dealBasR":"String"<br/>"bkpr":"String"<br/>"yyEfeeR":"String"<br/>"tenDdEfreeR":"String"<br/>"kftcDealBasR":"String"<br/>"kftcBkpr":"String"<br/>}                                              |

