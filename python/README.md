При запуске приложения на порту 7000 появится страничка с счетчиком перезагрузки страницы  
 требования для запуска  
 python 3.12.3   
команда сборки контейнера docker build -t edu-docker.artifactory.infinnity.ru/metrics_app:1.1.1  
команда запуска контейнерa docker run -p 7000:7000 edu-docker.artifactory.infinnity.ru/metrics_app:1.1.1  
