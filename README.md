# 예약서비스 API

>### 목표
기획서 WEB API 기능 구현하기

>### WEB API 목록
**1. 카테고리 목록 구하기**

GET: /api/categories

**2. 상품 목록 구하기**

GET: /api/displayinfos

![123](https://user-images.githubusercontent.com/19279163/106847315-065fea00-66f2-11eb-9985-7f1cc1070610.jpg)

**3. 프로모션 정보 구하기**

GET: /api/promotions

**4. 전시 정보 구하기**

GET: /api/displayinfos/{displayId}

**5. 댓글 목록 구하기**

GET: /api/displayinfos


![456](https://user-images.githubusercontent.com/19279163/106847578-88501300-66f2-11eb-8a40-6256966b8331.jpg)

>### 요구 스택
* Mysql + JDBC
  - SQL
* Spring
    - Junit + MockMvc 단위테스트 및 통합테스트