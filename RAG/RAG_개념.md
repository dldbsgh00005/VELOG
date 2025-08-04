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

<h2> 법률 서비스(소장 작성) 구축 예시 </h2>
<li> 서비스 특징 : 키워드가 명확함 (예 : 민사 소송) / 정형화된 형식 / 내용은 상이할 수 있음 </li>
<li> 키워드 일정함 + 내용은 상이할 수 있음 -> 제목 기반 Context Search + 내용 기반 Sementic Search 하이브리드 전략 가능 할지 확인 / 검증 필요 </li>
<li> Context Search 시 인프라 : DB (RDB or NoSQL) + 임베딩 모델 (없음) </li>
<li> Sementic Search 시 인프라 : DB () </li>

<h2> DB 선정 </h2>
<il> Elastic Search : 기존에 Log 분석, 텍스트 검색을 위한 툴에 Vector 기능을 추가하여 대규모 Context Search + Sementic Search 하이브리드 전략이 가능 / ChromaDB, Milvus 등에 비해 대규모 데이터셋 처리 성능이 부족할 수 있음 / 본질적으로 검색 엔진이지만 DB 기능 지원 </il>
<il> ChromaDB : Python 호환성 높음 / 벡터 데이터 실시간 업데이트 기능 제공 / 생성형 AI와의 통합 용이 </il>
<il> Milvus : 대규모 데이터셋 처리 속도 우수 / 대규모 벡터 데이터 처리에 최적화 / 관리와 설정 난이도 높음 / 커스터마이징이 비교적 제한됨 </il>
<il> FAISS : Vector Embedding 라이브러리 / RDB나 NoSQL 등과 같이 사용 / Vector_id 를 기반으로 ORM 기반 식별자 검색 혹은 vector_id를 기반으로 인덱스 생성하여 검색 가능 (다양한 전략을 취사 선택) </il>

<h2> 데이터 변경사항 관리 </h2>
<li> 데이터 갱신에 의한 기존 데이터 폐기 방법론 ... 추후 작업 예정 </li>
