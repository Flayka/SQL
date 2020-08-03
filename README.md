Команды в теминале
1. Запуск докер контейнер: docker-compose up
1. В новом терминале подключение к БД командой: docker-compose exec mysql mysql -u user1 database -p
1. В новом терминале подключение к SUT командой: java -jar artifacts/app-deadline.jar -P:jdbc.url=jdbc:mysql://192.168.99.100:3306/database -P:jdbc.user=user1 -P:jdbc.password=qwerty
1. Во втором терминале проверка наличия таблиц из schema командой: show tables; ?
1. Открыть в браузере localhost:3306 (192.168.99.100:3306?). Должна появится страница входа?