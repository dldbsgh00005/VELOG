<h2> RAG 개념 </h2> 
<li> RAG(Retrieval-Augmented Generation) : LLM 출력 최적화 -> 아웃풋 전 -> 신뢰성 확보된 외부 지식 베이스를 참조하는 프로세스 </li>

<h2> 기존 LLM 문제점 </h2>
<li> 기존 LLM 학습 데이터 -> 정적 -> 데이터 학습의 마감일 존재 </li>
<li> 답변 결과 예측 어려움 </li>
<li> 답변의 근거 출처 신뢰성 낮음 </li>
<li> 용어 혼동 </li>
<li> 파인튜닝 비용이 큼 (모델 재학습, 재배포) </li>

<h2> RAG의 해결방안 </h2>
<li> 신뢰성 있는 답변 확보 </li>
<li> 저장 공간을 분리하면 답변에 필요한 데이터 개별 접근 가능 </li>
<li> 재학습 과정 간단 (DB에 데이터를 삽입하면 끝) </li>
<li> 권한 기반 정보 접근 제어 가능 (인가 -> 권한별 정보 접근 제어 ) </li>

<h2> DB 저장 수단 </h2>
<li> RDB </li>
<li> CSV </li>
<li> Vector DB </li>

<h2> LLM - RAG 프로세스 다이어그램 </h2>
<img width="850" height="506" alt="image" src="https://github.com/user-attachments/assets/fc7d2d86-f2ba-4c2e-ab5c-2f7d9116075b" />

<h2> Context Search & Semantic Search </h2>
<li> Context Search : 키워드 기반 검색 -> 명확한 키워드 유무로 성능 차이 발생 </li>

<li> Semantic Search : 의미 검색 기반 -> 비교적 복잡도가 높은 질문 가능 </li>
<li> 유사도 검사가 가능한 FAISS 등의 Vector DB 등 사용 가능 </li>
<li> Semantic Search를 위한 OPEN AI의 text-embedding-3-small 경량화 모델 사용 </li>
<li> HuggingFace 등의 자체 모델 구축 또한 가능 </li>


<h2> 관련 AWS 서비스 </h2>
<li> AWS Bedrock -> FM을 빠른 RAG 외부 데이터 소스 연결 </li>
<li> Vector 변환 / 검색 / 개선된 출력 생성 지원 </li>


<h2> 데이터 변경사항 관리 </h2>
<li> 데이터 갱신에 의한 기존 데이터 폐기 방법론 ... 추후 작업 예정 </li>
