Запустить оба сервиса 
Producer принимает POST запрос с метрикой по URL http://localhost:8080/producer/metrics
Consumer через kafku получает метрику и складывает её в БД
Посмотреть метрики можно по URL  http://localhost:8081/consumer/metrics
