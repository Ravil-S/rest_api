Доля покрытия кода тестами:

[![codecov](https://codecov.io/github/Ravil-S/rest_api/graph/badge.svg?token=KWXT58NPPS)](https://codecov.io/github/Ravil-S/rest_api)

1. Описание 

   Программа реализует rest api, вычисляющее частоту встречи символов по заданной строке. 

   Результат отсортирован по убыванию количества вхождений символа в заданную строку.

   Для использование rest api следует направить POST запрос на URL http://localhost:8080/
   
   В POST запросе должна быть отправлена строка текста длиной не более 100 символов.
   
   Ответ от сервера придет в виде JSON, содержащем пары "символ":"количество вхождений в строку". 
   
   В случае превышения длины строки, будет дан ответ: 400 Bad Request.
   
   Если будет отправлена пустая строка, также придет сообщение об ошибке: 400 Bad Request.


2. Запуск
   
   Требуется JDK 17+

   Перейдите в директорию ./rest_api

   Выполните команду для создания jar:

   mvn package

   Для запуска jar перейдите в директорию ./rest_api/target

   Выполните команду для запуска сервера:

   java -jar rest_api-1.0.jar

   Для отправки данных выполните комадну:

   curl -X POST -H "Content-Type: text/plain" --data "aaaaabcccc" http://localhost:8080/

   Придет ответ:

   {"a":5,"c":4,"b":1}


3. Docker

   Создание образа:

   mvn clear compile jib:dockerBuild

   Запуск контейнера:

   docker run -it restapi -p 8080:8080

5. Прочее

   SwaggerUI URL: http://localhost:8080/swagger-ui/index.html

   OpenAPI URL: http://localhost:8080/v3/api-docs
