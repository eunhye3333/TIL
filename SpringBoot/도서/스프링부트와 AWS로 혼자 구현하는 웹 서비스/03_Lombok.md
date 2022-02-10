# Lombok
## Lombok 소개
Getter, Setter, 기본 생성자, toString 등을 어노테이션으로 자동 생성해 주는 라이브러리  
인텔리제이에서는 플러그인으로 쉽게 설정 가능

## Lombok 설치
1. build.gradle에 다음 코드 추가
```
compile('org.projectlombok:lombok')
```
2.롬복 플러그인 설치
```
[Ctrl + Shift + A]를 이용해 플러그인 Action 검색
Plugins Action을 선택하면 플러그인 설치 팝업이 뜸
Markplace 탭으로 이동하여 lombok 건색 후 설치 진행
```
3. 롬복 설정
```
롬복에 대한 설정이 필요하다는 팝업의 파란색으로 표기된 곳 클릭 (Settings > Build > Compiler > Annotation Processors)
Enable annotation processing 체크
```
4. 롬복 사용
``` 
@Getter : 선언된 모든 필드의 get 메소드를 생성
@RequiredArgsConstructor : 선언된 모든 final 필드가 포함된 생성자 생성 (final이 없는 필드는 포함하지 않음)
