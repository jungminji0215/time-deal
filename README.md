# ⏰ Time Deal 


## 1️⃣ 사용 기술

<a><img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=flat-square&logo=SpringBoot&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=Java&logo&Color=white"/></a>
<a><img src="https://img.shields.io/badge/Spring Data JPA-6DB33F?style=flat-square&logo=&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=Gradle&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=Git&logoColor=white"/></a>
<a><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white"/></a>

## 2️⃣ 개발 히스토리

블로그에 개발 히스토리를 정리하였습니다.

👉🏻 [블로그 링크](https://wjdalswl0215.tistory.com/category/%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8/%ED%83%80%EC%9E%84%EB%94%9C%20%EC%84%9C%EB%B2%84%20%EA%B5%AC%EC%B6%95)

## 3️⃣ 프로젝트 설명

- 정해진 기간에만 상품을 구매할 수 있는 서버 구축

11번가가 제공하는 '쇼킹딜' 서비스는 특정 상품에 대해서 특정 시간 동안만 특가 가격으로 상품을 구매할 수 있는 서비스이다. 이와 같은 타임딜 REST API 서버를 구축해 보려고 한다.

### 예시

[11번가 쇼킹딜 서비스](https://deal.11st.co.kr/browsing/DealAction.tmall?method=getTimeDeal)

## 4️⃣ 기능 

- [회원] 가입/탈퇴/조회
- [상품] 등록/수정/삭제/목록/상세
- 구매하기

---

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

## 5️⃣ 설계

### ERD

<img width="973" alt="스크린샷 2023-04-04 오전 2 21 01" src="https://user-images.githubusercontent.com/83000829/229582021-753a8fc6-e317-443e-81c1-c08c7da60112.png">

### Entity

<img width="705" alt="스크린샷 2023-04-04 오전 2 22 02" src="https://user-images.githubusercontent.com/83000829/229582238-bfe06a83-6421-4ad4-8fc9-40daf0460096.png">


## 6️⃣ API

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

### 타임딜 

|   | 기능                   | HTTP Method | HTTP Path                   |
|---|----------------------|-------------|-----------------------------|
| ✅ | [타임딜] 타임딜 등록        | POST        | /time-deal                     |


---

## 7️⃣ 배포 해보기

🚧 TODO
