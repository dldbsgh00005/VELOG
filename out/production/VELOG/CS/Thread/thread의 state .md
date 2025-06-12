| 상태                 | 설명                                                         |
| ------------------ | ---------------------------------------------------------- |
| **NEW**            | `new Thread()` 후, 아직 `start()` 호출 전                        |
| **RUNNABLE**       | `start()` 후 OS 스케줄러에 등록되어 실행 가능 또는 실행 중                    |
| **BLOCKED**        | `synchronized` 블록의 모니터 락을 얻기 위해 대기 중                       |
| **WAITING**        | `Object.wait()`, `Thread.join()` 등으로 무기한 대기 중              |
| **TIMED\_WAITING** | `sleep()`, `wait(timeout)`, `join(timeout)` 등으로 시간 제한 대기 중 |
| **TERMINATED**     | `run()` 종료 또는 예외 발생 후 스레드가 완전히 종료된 상태                      |
