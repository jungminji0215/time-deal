# ⏰ Time Deal 

# 목차
- [사용 기술](#사용-기술)
- [개발 히스토리](#개발-히스토리)
- [프로젝트 설명](#프로젝트-설명)
- [설계](#설계)
- [API](#API)
- [브랜치 전략](#브랜치-전략)
- [배포 해보기](#배포-해보기)

---

## 사용 기술

<a><img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=SpringBoot&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logo&Color=white"/></a>
<a><img src="https://img.shields.io/badge/Spring Data JPA-6DB33F?style=flat-square&logo=&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=Gradle&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=Git&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/></a>

## 개발 히스토리

개발하면서 고민한 것, 오류 등을 정리하였습니다.

👉🏻 [위키에 개발 히스토리 정리](https://github.com/jungminji0215/time-deal/wiki)

## 프로젝트 설명

11번가가 제공하는 '쇼킹딜' 서비스는 특정 상품에 대해서 특정 시간 동안만 특가 가격으로 상품을 구매할 수 있는 서비스이다. 이와 같은 타임딜 REST API 서버를 구축해 보려고 한다.

### 예시

[11번가 쇼킹딜 서비스](https://deal.11st.co.kr/browsing/DealAction.tmall?method=getTimeDeal)

### 프로젝트 목적

🚧 TODO

### 기능

- [회원] 가입/탈퇴/조회
- [상품] 등록/수정/삭제/목록/상세
- 구매하기

### 요구사항
- 각 상품마다 '구매 가능한 시간'이 있다.
    - '구매 가능 시간' 전에는 구매가 불가능하다. 
    - '구매 가능 시간'이 도래하면 구매가 가능하다.
- 각 상품마다 '구매 가능한 수량'이 있다.
  - 정해진 수량을 모두 판매하면 더 이상 구매할 수 없다.
- 유저는 일반 유저와 어드민 유저를 구분해야 한다.
- 상품 등록은 어드민 권한을 가진 유저만 등록 가능하다.
- 상품별로 구매한 유저 리스트를 조회할 수 있어야 한다.
- 유저별로 구매한 상품 리스트를 조회할 수 있어야 한다.
- 상품을 구매한 사람 수와 상품의 재고수량이 일치해야 한다.
- 구매하기 API는 구매 성공/실패만 구분해도 된다.

## 설계

### ERD

![time deal](https://user-images.githubusercontent.com/83000829/228023408-00c01d4b-ff10-4322-abf7-781f27020fa4.png)


### Entity

![스크린샷 2023-03-28 오전 2 44 51](https://user-images.githubusercontent.com/83000829/228023594-a59c57f3-cea3-4bd0-8609-867092b5a1a0.png)


## API

### 회원

|    | 기능      | HTTP Method | HTTP Path            |
|----|---------|-------------|----------------------|
| ✅ | [회원] 가입 | POST        | /users               |
| ✅ | [회원] 조회 | GET         | /users/{userId}      |
| ✅ | [회원] 목록 | GET         | /users        |
| ✅ | [회원] 수정 | PUT         | /users/{userId}      |
| ✅ | [회원] 탈퇴 | DELETE      | /users               |


### 상품

|     | 기능      | HTTP Method | HTTP Path                    |
|-----|---------|-------------|-------------------------------|
| ✅   | [상품] 등록 | POST        | /products                    |
| ✅   | [상품] 조회 | GET         | /products/{productId}        |
| ✅   | [상품] 목록 | GET         | /products                    |
| ✅   | [상품] 수정 | PUT         | /products/{productId}        |
| ✅   | [상품] 삭제 | DELETE      | /products/{productId}        |

### 구매 

|   | 기능                   | HTTP Method | HTTP Path                   |
|---|----------------------|-------------|-----------------------------|
| ✅ | [구매] 구매              | POST        | /purchase                     |
| ✅ | [구매] 회원별 구매 상품 리스트   | GET        | /purchase/{userId}/user       |
| ✅ | [구매] 상품별 구매 유저 리스트   | GET         | /purchase/{productId}/product |

---

|     | 기능            |  
|-----|---------------| 
| 진행중 | 테스트코드         | 
| ✅ | error handler | 
|     | API 문서        |  
|     | CI/CD 구축      |  
|     | 성능 테스트        |  

## TODO 
- 페이징 처리
- 상품 여러개 구매
- 구매시 알림톡

## 브랜치 전략

기능 개발을 체계적으로 해보고싶어서 브랜치 전략 사용

<img width="528" alt="스크린샷 2023-03-16 오전 1 31 25" src="https://user-images.githubusercontent.com/83000829/225377053-2a378f57-aff1-4f04-a2eb-a145877816a3.png">

- github 브랜치 전략을 사용하여 프로젝트 진행
  - feature : [주요 기능](https://github.com/jungminji0215/time-deal/issues)에 대한 작업을 하는 브랜치
    - 개발이 완료되면 PR을 올리고, main에 머지
  - main : 개발이 완료되면 feature 브랜치를 머지


## 배포 해보기

🚧 TODO
