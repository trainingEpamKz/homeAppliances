### Решение: Задача 1, Вариант 3, Домашние электроприборы.
Определить иерархию электроприборов. Включить некоторые в розетку. Посчитать потребляемую мощность. 
Провести сортировку приборов в квартире на основе одного из параметров. 
Найти прибор в квартире, соответствующий заданному диапазону параметров.


Создать консольное приложение, удовлетворяющее следующим требованиям:


- 1.	Использовать возможности ООП: классы, наследование, полиморфизм, инкапсуляция.
- 2.	Каждый класс должен иметь исчерпывающее смысл название и информативный состав.
- 3.	Наследование должно применяться только тогда, когда это имеет смысл.
- 4.	При кодировании должны быть использованы соглашения об оформлении кода java code convention.
- 5.	Классы должны быть грамотно разложены по пакетам.
- 6.	Работа с консолью или консольное меню должно быть минимальным.
- 7.	Для хранения параметров инициализации можно использовать файлы.


Добавлено по рекомендации преподавателя:
------------------------------------
- Абстрактный класс([Device](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/devices/Device.java)), и иерархия на его основе ([EuroplugDevice](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/devices/EuroplugDevice.java), [ThreepinDevice](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/devices/ThreepinDevice.java))
- Mutable field(typePlug у [EuroplugDevice](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/devices/EuroplugDevice.java),  [ThreepinDevice](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/devices/ThreepinDevice.java)) доступ к котрому обеспечивается через setter/getter
- Static nested class Enums внутри [GenerateDevices](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/devices/devicesGenerator/GenerateDevices.java), который может генерировать случайное значение из любого Enum(Спасибо ;) Брюсу Эккелю)
- clone в методе foundByPower() класса [Run](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/Run.java)
- сортировки: с помощью компораторов [SortByPower](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/devices/SortByPower.java), [SortByState](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/devices/SortByState.java); переопределения метода compareTo для [Device](https://github.com/traningEpamKz/homeAppliances/blob/master/src/main/java/kz/homeAppliances/appliances/devices/Device.java) который сортирует по двум полям, первично по состоянию(вкл/выкл), вторично по мощности, возрастание.
