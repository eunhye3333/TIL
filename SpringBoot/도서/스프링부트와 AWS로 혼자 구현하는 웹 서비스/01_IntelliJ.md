# IntelliJ 
## 1. 인텔리제이 소개
인텔리제이의 강점  
+ 강력한 추천 기능  
+ 다양한 리팩토링과 디버깅 기능
+ 높은 자유도
+ 프로젝트 시작 시 인덱싱을 하여 검색 속도가 빠름
+ HTML과 CSS, JS, XML에 대한 강력한 기능 지원
+ 자바, 스프링 부트 버전업에 맞춘 빠른 업데이트

## 2. 인텔리제이 설치
[젯브레인 툴박스를 이용하여 설치](https://www.jetbrains.com/toolbox-app/)    
+ 인텔리제이를 만든 젯브레인의 제품 전체를 관리해 주는 데스크톱 앱  
+ 툴 박스를 이용하는 경우 버전 관리가 쉬움

## 3. 프로젝트 생성
프로젝트 생성 시 등록하는 ArtifactId는 프로젝트의 이름이 됨  
build.gradle에 플러그인 의존성 관리를 위한 설정 추가  
repositories{}는 각종 의존성들을 어떤 원격 저장소에서 받을지를 정하며, mavenCentral 혹은 jcenter를 사용  
+ mavenCentral: 기본적으로 많이 사용되는 저장소지만, 봄인이 만든 라이브러리를 업로드하기 위해서는 많은 과정과 설정이 필요
+ jcenter: mavenCentral의 문제점을 개선하여 라이브러리의 업로드를 간단하게 함 또한 mavenCentral에도 같이 업로드될 수 있도록 자동화함  

의존성 코드 작성 시 버전을 명시하지 않아야 'org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}' 버전을 따라감

## 4. 인텔리제이에서 깃 연동
Ctrl + shift + A를 사용해 Action 검색창을 열어 share project on github 검색  
깃허브 로그인 후 Repository 이름을 입력하여 저장소 생성  
Share를 클릭하여 동기화  
__.gitignore__
+ .ignore 플러그인에서 지원하며, 해당 플러그인으로 파일 위치 자동 완성, 이그노어 처리 여부 확인, 다양한 이그노어 파일 지원 등의 기능 사용 가능
+ 인텔리제이에서 자동으로 생성되는 파일(.gradle, .idea)은 이그노어 처리하는 것이 좋음


    
