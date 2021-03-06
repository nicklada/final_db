# План автоматизации тестирования вэб-сервиса покупки путешествий через интернет-банк

## Раздел 1. Сценарии тестирования

Тестировать будем через веб-интерфейс, т.к. работаем с продакшн-версией системы и важно, чтобы наши сценарии были максимально близки к поведению реального юзера.

### 1.Основные сценарии использования:
*1.1 Оплата по валидной карте с достаточным количеством средств. Операция одобрена.*

![Вкладка "Оплатить"](https://github.com/nicklada/Final/blob/master/screens/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202020-07-14%20%D0%B2%2016.22.04.png)

![Кнопка "Продолжить" под заполненной формой](https://github.com/nicklada/Final/blob/master/screens/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202020-07-14%20%D0%B2%2016.25.13.png)

Шаги:
1. На главной странице открываем вкладку “Купить” (для этого кликаем по кнопке "Купить")
2. Заполняем форму полностью валидными данными карты на которой достаточно средств
Валидные данные карты с достаточным количеством средств: "Номер" = "4444 4444 4444 4441", "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"
3. Кликаем кнопку “Продолжить”
4. Ожидание до 15 секунд (отправка запроса в банк)

Ожидаемый результат:
Появляется уведомление об успешном завершении операции. Операция одобрена банком.

*1.2 Оплата в кредит по данным валидной карты с достаточным кредитным лимитом. Операция одобрена.*

![Вкладка "Купить в кредит"](https://github.com/nicklada/Final/blob/master/screens/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202020-07-14%20%D0%B2%2016.22.14.png)

![Кнопка "Продолжить" под заполненной формой](https://github.com/nicklada/Final/blob/master/screens/%D0%A1%D0%BD%D0%B8%D0%BC%D0%BE%D0%BA%20%D1%8D%D0%BA%D1%80%D0%B0%D0%BD%D0%B0%202020-07-14%20%D0%B2%2016.25.45.png)

Шаги:
1. На главной странице открываем вкладку “Купить в кредит” (для этого кликаем по кнопке "Купить")
2. Заполняем форму полностью валидными данными карты, по которой одобрен кредитный лимит (во внутренней базе данных банка)
Валидные данные карты с одобренным кредитным лимитом: "Номер" = "4444 4444 4444 4441", "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"
3. Кликаем кнопку “Продолжить”
4. Ожидание до 15 секунд (отправка запроса в банк)

Ожидаемый результат:
Появляется уведомление об успешном завершении операции. Операция одобрена банком.

*1.3 Оплата с валидной карты с недостаточным количеством средств. Отказ в проведении операции.*

Шаги:
1. На главной странице открываем вкладку “Купить” (для этого кликаем по кнопке "Купить")
2. Заполняем форму полностью валидными данными карты на которой недостаточно средств
Валидные данные карты с достаточным количеством средств: "Номер" = "4444 4444 4444 4442", "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"
3. Кликаем кнопку “Продолжить”
4. Ожидание до 15 секунд (отправка запроса в банк)

Ожидаемый результат:
Появляется уведомление об ошибке. Банк отказал в проведении операции.

*1.4 Оплата в кредит с валидной карты с недостаточным кредитным лимитом. Отказ в проведении операции.*

Шаги:
1. На главной странице открываем вкладку “Купить в кредит” (для этого кликаем по кнопке "Купить в кредит")
2. Заполняем форму полностью валидными данными карты, по которой не одобрен кредитный лимит (во внутренней базе данных банка)
Валидные данные карты с одобренным кредитным лимитом: "Номер" = "4444 4444 4444 4442", "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"
3. Кликаем кнопку “Продолжить”
4. Ожидание до 15 секунд (отправка запроса в банк)

Ожидаемый результат:
Появляется уведомление об ошибке. Банк отказал в проведении операции.

*1.5 Оплата с карты другого банка (карта не зарегестрирована во внутренней базе данных). Отказ в проведении операции.*

Шаги:
1. На главной странице открываем вкладку “Купить” (для этого кликаем по кнопке "Купить")
2. Заполняем форму полностью валидными данными любой карты, которая не зарегестрирована в Альфа-банке
Пример данных карты: "Номер" = "5432 4444 4444 4442", "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"
3. Кликаем кнопку “Продолжить”
4. Ожидание до 15 секунд (отправка запроса в банк)

Ожидаемый результат:
Появляется уведомление об ошибке. Банк отказал в проведении операции.

*1.6 Покупка в кредит с карты другого банка (карта не зарегестрирована во внутренней базе данных). Отказ в проведении операции.*

Шаги:
1. На главной странице открываем вкладку “Купить в кредит” (для этого кликаем по кнопке "Купить в кредит")
2. Заполняем форму полностью валидными данными любой карты, которая не зарегестрирована в Альфа-банке
Пример данных карты: "Номер" = "5432 4444 4444 4442", "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"
3. Кликаем кнопку “Продолжить”
4. Ожидание до 15 секунд (отправка запроса в банк)

Ожидаемый результат:
Появляется уведомление об ошибке. Банк отказал в проведении операции.

### 2.Теперь тестируем конкретно формы оплаты/покупки в кредит.

Каждый тестовый сценарий для тестирования формы подразумевает стандартный путь захода на страницу формы (в зависимости от того, какую именно форму мы хотим протестировать):
* Для формы "Оплата по карте": на главной странице кликаем по кнопке "Купить"
* Для формы "Кредит по данным карты": на главной странице кликаем по кнопке "Купить в кредит"
* Для каждой формы необходимо протестировать поля. Т.к. для каждого поля - свое уведомление, которое можно найти через отдельный CSS-селектор, можно пробовать объединять сценарии в рамках одного тест-кейса.
* После заполнения полей кликаем на кнопку "Продолжить".

#### 2.1 Тестируем поле “Номер”:
Предусловия для формы "Купить":
1. На главной странице открываем вкладку “Купить” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными:  "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"

Предусловия для формы "Купить в кредит":
1. На главной странице открываем вкладку “Купить в кредит” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными:  "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"

*Позитивные сценарии*:

2.1.1 Поле "Номер" содержит 16 цифр. Форма на вкладке "Купить" отправлена.
Данный сценарий реализуется в сценарии 1.1, отдельная проверка не требуется.

2.1.2 Поле "Номер" содержит 16 цифр. Форма на вкладке "Купить в кредит" отправлена.
Данный сценарий реализуется в сценарии 1.2, отдельная проверка не требуется.

*Негативные сценарии*:

2.1.3 Поле “Номер” в форме "Купить" пустое.
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Оставляем поле номер карты пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что номер карты необходимо заполнить. Форма не отправляется. Операция не проходит.

2.1.4 Поле “Номер” в форме "Купить в кредит" пустое.
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Оставляем поле номер карты пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что номер карты необходимо заполнить. Форма не отправляется. Операция не проходит.


2.1.5 Поле “Номер” в форме "Купить" содержит меньше 16 цифр 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Номер" любые 15 цифр
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что номер карты необходимо заполнить. Форма не отправляется. Операция не проходит.

2.1.6 Поле “Номер” в форме "Купить в кредит" содержит меньше 16 цифр 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Номер" любые 15 цифр
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что номер карты необходимо заполнить. Форма не отправляется. Операция не проходит.


2.1.7 Поле “Номер” в форме "Купить" содержит больше 16 цифр 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Номер" любые 17 цифр
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что номер карты необходимо заполнить. Форма не отправляется. Операция не проходит.

2.1.8 Поле “Номер” в форме "Купить в кредит" содержит больше 16 цифр 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Номер" любые 17 цифр
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что номер карты необходимо заполнить. Форма не отправляется. Операция не проходит.

2.1.9 Поле “Номер” в форме "Купить" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Номер" любые 16 букв
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что номер карты необходимо заполнить. Форма не отправляется. Операция не проходит.

2.1.10 Поле “Номер” в форме "Купить в кредит" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Номер" любые 16 букв
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что номер карты необходимо заполнить. Форма не отправляется. Операция не проходит.

#### 2.2 Тестируем поле “Месяц”:
Предусловия для формы "Купить":
1. На главной странице открываем вкладку “Купить” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными: "Номер" = "4444 4444 4444 4441", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"

Предусловия для формы "Купить в кредит":
1. На главной странице открываем вкладку “Купить в кредит” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными:  "Номер" = "4444 4444 4444 4441", "Год" = "2021", "Владелец" = "Ivan Ivanov", "CVV" = "123"

Требования стоило бы уточнить у руководства, но, предположим, я уточнила и мне сказали, что данное поле принимает строго номер месяца от 1 до 12, причем числам от 1 до 9 всегда предшествует 0, т.к. форма принимает строго 2 числа.

*Позитивные сценарии*:

2.2.1 Поле “Месяц” содержит число от 1 до 12, записанное в формате 2 цифр (например, "08") и совпадает с номером месяца для данной конкретной карты. Форма на вкладке "Купить" отправлена.
Данный сценарий реализуется в сценарии 1.1, отдельная проверка не требуется.
2.2.2 Поле “Месяц” содержит число от 1 до 12, записанное в формате 2 цифр (например, "08") и совпадает с номером месяца для данной конкретной карты. Форма на вкладке "Купить в кредит" отправлена.
Данный сценарий реализуется в сценарии 1.2, отдельная проверка не требуется.

*Негативные сценарии*:

2.2.3 Поле “Месяц” в форме "Купить" пустое
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Оставляем поле "Месяц" пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

2.2.4 Поле “Месяц” в форме "Купить в кредит" пустое
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Оставляем поле "Месяц" пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

2.2.5 Поле “Месяц” в форме "Купить" содержит нерелевантное значение "00"
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Месяц" значение "00"
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

2.2.6 Поле “Месяц” в форме "Купить в кредит" содержит нерелевантное значение "00"
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Месяц" значение "00"
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

2.2.7 Поле “Месяц” в форме "Купить" содержит число больше 12
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Месяц" любое двузначное число больше "12" (например "13")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

2.2.8 Поле “Месяц” в форме "Купить в кредит" содержит число больше 12 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Месяц" любое двузначное число больше "12" (например "13")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

2.2.9 Поле “Месяц” в форме "Купить" содержит одну цифру 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Месяц" любое однозначное число (например, "8")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

2.2.10 Поле “Месяц” в форме "Купить в кредит" содержит одну цифру 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Месяц" любое однозначное число (например, "8")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

2.2.11 Поле “Месяц” в форме "Купить" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Месяц" любые 2 буквы
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

2.2.12 Поле “Месяц” в форме "Купить в кредит" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Месяц" любые 2 буквы
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что месяц необходимо заполнить. Форма не отправляется. Операция не проходит.

#### 2.3 Тестируем поле “Год”:
Предусловия для формы "Купить":
1. На главной странице открываем вкладку “Купить” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными: "Номер" = "4444 4444 4444 4441", "Месяц" = "08", "Владелец" = "Ivan Ivanov", "CVV" = "123"

Предусловия для формы "Купить в кредит":
1. На главной странице открываем вкладку “Купить в кредит” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными: "Номер" = "4444 4444 4444 4441", "Месяц" = "08", "Владелец" = "Ivan Ivanov", "CVV" = "123"

Требования стоило бы уточнить у руководства, но, предположим, я уточнила и мне сказали, что данное поле принимает номер года не ранее текущего строго в формате 4 цифр.

*Позитивные сценарии*:

2.3.1 Поле “Год” в форме "Купить" содержит номер года не ранее текущего в формате 4 цифр и совпадает с номером года для данной карты (например, "2021") 
Данный сценарий реализуется в сценарии 1.1, отдельная проверка не требуется.
2.3.2 Поле “Год” в форме "Купить в кредит" содержит номер года не ранее текущего в формате 4 цифр и совпадает с номером года для данной карты (например, "2021") 
Данный сценарий реализуется в сценарии 1.2, отдельная проверка не требуется.

*Негативные сценарии*:

Кнопка “Продолжить” должна быть неактивной + должно появляться уведомление об ошибке.
2.3.3 Поле “Год” в форме "Купить" пустое
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Оставляем поле "Год" пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.3.4 Поле “Год” в форме "Купить в кредит" пустое
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Оставляем поле "Год" пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.3.5 Поле “Год” в форме "Купить" содержит номер года ранее текущего 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Оставляем поле "Год" номер года, ранее текущего (например "2019")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.3.6 Поле “Год” в форме "Купить в кредит" содержит номер года ранее текущего 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Оставляем поле "Год" номер года, ранее текущего (например "2019")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.3.7 Поле “Год” в форме "Купить" содержит 2 цифры 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Год" номер "21"
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.3.8 Поле “Год” в форме "Купить в кредит" содержит 2 цифры 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Год" номер "21"
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.3.9 Поле “Год” в форме "Купить" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Год" любые 4 буквы
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.3.10 Поле “Год” в форме "Купить в кредит" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Год" любые 4 буквы
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

#### 2.4 Тестируем поле “Владелец”:
Предусловия для формы "Купить":
1. На главной странице открываем вкладку “Купить” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными: "Номер" = "4444 4444 4444 4441", "Месяц" = "08", "Год" = "2021", "CVV" = "123"

Предусловия для формы "Купить в кредит":
1. На главной странице открываем вкладку “Купить в кредит” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными: "Номер" = "4444 4444 4444 4441", "Месяц" = "08", "Год" = "2021", "CVV" = "123"

Требования стоило бы уточнить у руководства, но, предположим, я уточнила и мне сказали, что данное поле принимает только имя и фамилию в том виде, как это написано на карта (латинские буквы с заглавной буквы).

*Позитивные сценарии*:

2.4.1 Поле “Владелец” в форме "Купить" содержит имя и фамилию владельца на латинице, совпадающее c именем владельца для данного номера карты (например, "Ivan Ivanov") 
Данный сценарий реализуется в сценарии 1.1, отдельная проверка не требуется.
2.4.2 Поле “Владелец” в форме "Купить в кредит" содержит имя и фамилию владельца на латинице, совпадающее c именем владельца для данного номера карты (например, "Ivan Ivanov") 
Данный сценарий реализуется в сценарии 1.2, отдельная проверка не требуется.

*Негативные сценарии*:

Кнопка “Продолжить” должна быть неактивной + должно появляться уведомление об ошибке.
2.4.3 Поле “Владелец” в форме "Купить" пустое
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Оставляем поле "Владелец" пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.4.4 Поле “Владелец” в форме "Купить в кредит" пустое
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Оставляем поле "Владелец" пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.4.5 Поле “Владелец” в форме "Купить" содержит одно слово
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Владелец" любое одно слово на латинице с заглавной буквы (например "Ivan")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.4.6 Поле “Владелец” в форме "Купить в кредит" содержит одно слово 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Владелец" любое одно слово на латинице с заглавной буквы (например "Ivan")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.4.7 Поле “Владелец” в форме "Купить" содержит 3 слова 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Владелец" любое три слова на латинице с заглавной буквы (например "Ivanov Ivan Ivanovich")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.4.8 Поле “Владелец” в форме "Купить в кредит" содержит 3 слова 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Владелец" любsе три слова на латинице с заглавной буквы (например "Ivanov Ivan Ivanovich")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.4.9 Поле “Владелец” в форме "Купить" содержит имя и фамилию со строчной буквы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Владелец" значение “ivanov ivan”
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.4.10 Поле “Владелец” в форме "Купить в кредит" содержит имя и фамилию со строчной буквы
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Владелец" значение “ivanov ivan”
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.4.11 Поле “Владелец” в форме "Купить" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "Владелец" любое имя и фамилию с большой буквы на кириллице (например, "Иванов Иван")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

2.4.12 Поле “Владелец” в форме "Купить в кредит" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "Владелец" любое имя и фамилию с большой буквы на кириллице (например, "Иванов Иван")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что год необходимо заполнить. Форма не отправляется. Операция не проходит.

#### 2.5 Тестируем поле “CVV”:
Предусловия для формы "Купить":
1. На главной странице открываем вкладку “Купить” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными: "Номер" = "4444 4444 4444 4441", "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov"

Предусловия для формы "Купить в кредит":
1. На главной странице открываем вкладку “Купить в кредит” (для этого кликаем по кнопке "Купить в кредит)
2. Заполняем поля следующими валидными данными: "Номер" = "4444 4444 4444 4441", "Месяц" = "08", "Год" = "2021", "Владелец" = "Ivan Ivanov"

Требования стоило бы уточнить у руководства, но, предположим, я уточнила и мне сказали, что данное поле принимает только 3 цифры.

*Позитивные сценарии*:

2.5.1 Форма должна отправляться, если поле “CVV” содержит имя и фамилию владельца на латинице, совпадающее с CVV для данного номера карты (например, "123") 
Данный сценарий реализуется в сценарии 1.1, отдельная проверка не требуется.
2.5.2 Форма должна отправляться, если поле “CVV” содержит имя и фамилию владельца на латинице, совпадающее с CVV для данного номера карты (например, "123") 
Данный сценарий реализуется в сценарии 1.2, отдельная проверка не требуется.

*Негативные сценарии*:

2.5.3 Поле “CVV" в форме "Купить" пустое
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Оставляем поле "CVV" пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.5.4 Поле “CVV" в форме "Купить в кредит" пустое
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Оставляем поле "CVV" пустым
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.5.5 Поле “CVV” в форме "Купить" содержит 2 цифры 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "CVV" любые 2 цифры (например, "12")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.5.6 Поле “CVV” в форме "Купить в кредит" содержит 2 цифры 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "CVV" любые 2 цифры (например, "12")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.5.7 Поле “CVV” в форме "Купить" содержит 4 цифры
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "CVV" любые 4 цифры (например, "1234")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.5.8 Поле “CVV” в форме "Купить в кредит" содержит 4 цифры 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "CVV" любые 4 цифры (например, "1234")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.5.9 Поле “Cvv” в форме "Купить" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить"
2. Вводим в поле "CVV" любые 3 буквы (например, "поа")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

2.5.10 Поле “Cvv” в форме "Купить в кредит" содержит нерелевантные символы 
Шаги:
1. Выполняем шаги из предусловий для формы "Купить в кредит"
2. Вводим в поле "CVV" любые 3 буквы (например, "поа")
3. Кликаем кнопку “Продолжить” 
4. Ожидаем 15 секунд (отправка запроса в банк)
Ожидаемый результат:
Появляется уведомление о том, что поле "Владелец" необходимо заполнить. Форма не отправляется. Операция не проходит.

## Раздел 2. Перечень используемых инструментов

### Среда разработки - IntelliJ IDEA CE
Если такой проект поручили делать мне - похоже, в команде у нас начинающие разработчики. Наша цель будет - сократить число ошибок и минимизировать время разработки тестов. Это и позволит сделать нам IDE благодаря встроенному редактору кода. Если будем делать ошибки в коде - они будут сразу же видны и будет возможность их исправить на месте. К тому же, в IDE легко работать с JAVA - язык, на котором будем писать автотесты. И также IDE интегрирована с Git, который мы также будем использовать.

### Язык проекта - Java 11
Выбор остановлен на Java ввиду высокой распространенности данного языка, а также универсальности. “Написано однажды - работает везде” - наш код будет запускаться на разных платформах, в случае, если мы решим что-то изменить в окружении, мы сможем продолжать работать с текущим кодом. 
Java используют и развивают многие уважаемые компании (FB, Twitter). Ясно, что в ближайшем будущем язык, а вместе с ним и наш код, не устареет.
К тому же Java позволяет подключать к проекту различные библиотеки, обеспечивающие гибкую реализацию потребностей проекта. Например, фреймворк JUNIT.
Последний аргумент: с экономической точки зрения - Java - очень распространенный язык, на нем пишут многие программисты, так что найти специалистов будет относительно нетрудно и исключены простои из-за отсутствия нужных сотрудников.
11 версия вышла в 2018 году и уже показала свою стабильность (а также содержит некоторые полезные улучшения в методах по сравнению с Java 9).

### Система сборки проекта - Gradle. (Альтернатива - Maven)
Если в команде привыкли работать с Maven - можно остаться в рамках данной системы сборки. Если есть возможность выбора - лучше делать проект на Gradle, т.к. Gradle легко масштабируется (легко увеличивает производительность) 2) Gradle поддерживает многопроектные сборки (а Maven поддерживает только сборку группы независимых проектов).

### Система контроля версий - Git
Очевидно, что в таком масштабном проекте как тестирование сайта Альфа-банка будет задействована большая команда. Для того, чтобы у всех была возможность взаимодействовать с проектом up-to-date, используем Git. 
Почему именно Git:
ЛСКВ нам не подходят, т.к. над проектом трудится команда, а не один человек. ЦСКВ тоже - мы не можем позволить сломанному серверу остановить работу над проектом.
В Git удобно откатывать изменения, если что-то пошло не так. Также удобно то, что есть система веток - можем разрабатывать альтернативную версию проекта на другой ветке и, если разработка увенчается успехом, смерджить ее с основной веткой. 

### Тестовый фреймворк - JUNIT 5
Альтернатива: TestNG
Прочитав множество источников не вижу явных преимуществ одной системы над другой. 
Возможности аннотаций TestNG шире, однако JUNIT - популярнее. Т.к. JUNIT популярнее - легче будет найти ответы на сложные вопросы, а сокращение времени на решение проблем = сокращение времени на тестирование.

### Selenium Web Driver с оберткой Selenide
Для тестирования через веб-интерфейс не обойтись без Selenium Web Driver. Применение обертки Selenide обосновано сокращением времени на написание тестов, а также сокращением строк кода (не нужно загружать driver, Selenide сам запустит браузер, откроет нужную страницу и закроет браузер).

### Lombok
Аннотации помогут нам избавиться от бесконечной генерации конструкторов, сократить размер и улучшить читаемость кода.

### СУБД MySQL 
Альтернатива: PostgreSQL
Выбор обусловлен тем, что эти СУБД поддерживаются приложением (как заявлено).

### Node.js 
(Альтернатива - в контейнере Docker)
Данное приложение понадобится для запуска симулятора банковских серверов, т.к. они написаны на Node.js

## Раздел 3. Перечень и описание возможных рисков при автоматизации

1. Т.к. мы тестируем не на Production, есть вероятность, что пропустим некоторые баги, которые есть на Production
2. Не можем сделать интеграционное тестирование (взаимодействия между сервисом покупки путешествий на Production и реальными сервисами Payment Gate, и Credit Gate). Нет гарантии, что реальное взаимодействие между сервисами будет осуществляться также, как и между сервисом и симуляторами.
3. Ложные срабатывания тестов (при ошибках в коде или в генерации валидных данных). Отсюда падение доверия к тестам и игнорирование их результатов в дальнейшем.
4. Значительное увеличение времени на тестирование (а, следовательно, и стоимости). Возможно, в данном конкретном случае было бы дешевле и быстрее провести ручное тестирование по указанным сценариям.54. Проблемы с CI  - разные версии проекта могут привести к путанице в коде и внутри команды.
5. Изменение какого - то элемента в production- версии повлечет за собой нерелевантность данного тестирования. Тесты будут проходить (т.к. тестируемая нами SUT - не Production версия), но для реальной системы они уже не будут подходить. 
6. Похоже, из-за того, что в симуляторе из данных нам доступны только 2 номера карт, мы не сможем протестировать остальные поля. Особенно критично это для поля CVV. Система может пускать мошенников, которые введут корректный номер карты и фальшивые данные, в том числе код CVV, а мы об этом даже не узнаем. На мой взгляд - недопустимые риски для банковского приложения.

## Раздел 4. Интервальная оценка с учётом рисков (в часах)

* 27 часов на проект, учитывая процент рисков (20-25%)

## Раздел 5. План сдачи работ
* 05.08 - завершение автоматизации
* 07.08 - подготовка отчетных документов по итогам тестирования
* 08.08 - подготовка отчетных документов по итогам автоматизации
