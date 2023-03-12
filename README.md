# ⏰ Time Deal 

# 목차
- [사용 기술](#사용-기술)
- [프로젝트 설명](#프로젝트-설명)
- [설계](#설계)
- [API 스펙](#API-스펙)
- [트러블 슈팅](#트러블-슈팅)
- [브랜치 전략](#브랜치-전략)
- [관리](#관리)
- [배포 해보기](#배포-해보기)

---

## 사용 기술

<a><img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=SpringBoot&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logo&Color=white"/></a>
<a><img src="https://img.shields.io/badge/Spring Data JPA-6DB33F?style=flat-square&logo=&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=Gradle&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=Git&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/></a>



## 프로젝트 설명

11번가가 제공하는 '쇼킹딜' 서비스는 특정 상품에 대해서 특정 시간 동안만 특가 가격으로 상품을 구매할 수 있는 서비스이다. 이와 같은 타임딜 REST API 서버를 구축해 보려고 한다.

### 예시

[11번가 쇼킹딜 서비스](https://deal.11st.co.kr/browsing/DealAction.tmall?method=getTimeDeal)

### 기능

- [회원] 가입/탈퇴/조회
- [상품] 등록/수정/삭제/목록/상세
- 구매하기

### 요구사항

- 각 상품마다 '구매 가능한 시간'이 있다.
    - '구매 가능 시간' 전에는 구매가 불가능하다. 
    - '구매 가능 시간'이 도래하면 구매가 가능하다.
- 유저는 일반 유저와 어드민 유저를 구분해야 한다.
- 상품 등록은 어드민 권한을 가진 유저만 등록 가능하다.
- 각 상품마다 구매 가능한 수량이 있다.
    - 정해진 수량을 모두 판매하면 더 이상 구매할 수 없다.
- 상품별로 구매한 유저 리스트를 조회할 수 있어야 한다.
- 유저별로 구매한 상품 리스트를 조회할 수 있어야 한다.
- 상품을 구매한 사람 수와 상품의 재고수량이 일치해야 한다.
- 구매하기 API는 구매 성공/실패만 구분해도 된다.

## 설계

### ERD

<img width="437" alt="스크린샷 2023-03-02 오후 9 03 04" src="https://user-images.githubusercontent.com/83000829/222423518-a5b887bb-1e0c-4fb7-b478-df3c1dbf7e9f.png">

🚧 구매 정보 관련 테이블 추가 예정

### Entity

<img width="437" alt="스크린샷 2023-03-02 오후 9 03 17" src="https://user-images.githubusercontent.com/83000829/222423587-3db341df-3dea-4153-88ae-cff7fca74926.png">

🚧 구매 정보 관련 엔티티 추가 예정

## API


| 기능      | HTTP Method | HTTP Path           |
|---------|-------------|---------------------|
| [회원] 가입 | POST        | /user               |
| [회원] 탈퇴 | DELETE      | /user               |
| [회원] 조회 | GET         | /user/{userId}      |
| [회원] 수정 | PUT         | /user/{userId}      |
| [상품] 등록 | POST        | /product               |
| [상품] 수정 | PUT         | /product/{productId} |
| [상품] 삭제 | DELETE      | /product/{productId} |
| [상품] 목록 | GET         | /product               |
| [상품] 상세 | GET         | /product  /{productId} |
| [상품] 구매 | POST        | /product/{productId}  |



## 트러블 슈팅

🚧 업데이트 예정

## 배포 해보기

🚧 업데이트 예정
