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

<h2> DB 저장 수단 </h2>
<li> RDB </li>
<li> CSV </li>
<li> Vector DB </li>
