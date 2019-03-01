# Project Title

Study for using CoinStack BTC library in Spring boot

## Getting Started

...

### Prerequisites

...

```
...
```

### Installing

...

step ...

```
...
```

step ...

```
...
```

...


README sample by PurpleBooth / README-Template.md

### wait
1. [Postman 사용](https://www.getpostman.com/)
* 지갑 생성
(GET) http://localhost:8080/address/join
 * (Result) { "id" : ..., "privateKey" : ..., "address" : ... }
* 지갑 잔액 확인
(GET) http://localhost:8080/address/balance?address={your address}
 * (Result) {0}
* 트랜잭션 생성 (단순 BTC 송금 - data 포함 x)
(GET) http://localhost:8080/tx/simple?privateKey={your privateKey}&from={from address}&to={to address}&value={BTC value}
 * (Result) Success : {0} / Fail : {-1}
