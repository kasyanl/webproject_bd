<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добро пожаловать</title>
</head>
<body align="center" background="${pageContext.request.contextPath}/download/xls/bg.jpg" bgcolor="#CCFFCC">

<%@include file="header.jsp" %>
<h2>Добро пожаловать в Систему учета продуктов.
    <br>Для работы с базой данных введите логи и пароль, либо войдите как гость (доступна возможность только просмотра)
</h2>

<form action="${pageContext.request.contextPath}/person/startlogin" method="post">
    <label><input name="login" placeholder="Логин" type="text"></label> <br/>
    <label><input name="password" placeholder="Пароль" type="text"></label> <br/>
    <input type="submit" value=Войти>
</form>
<h4><a href="${pageContext.request.contextPath}/contentguest">Зайти как ГОСТЬ</a></h4>
<br>

<div id="map" style="height: 400px"></div>
<script src="http://api-maps.yandex.ru/2.1/?load=package.full&lang=ru-RU" type="text/javascript"></script>
<script type="text/javascript">
    var myMap;
    ymaps.ready(init); // Ожидание загрузки API с сервера Яндекса
    function init() {
        myMap = new ymaps.Map("map", {
            center: [53.9022, 27.5618], // Координаты центра карты
            zoom: 15
            // controls: ['smallMapDefaultSet']// Zoom
        },  {
            searchControlProvider: 'yandex#search'
        });
            objectManager = new ymaps.ObjectManager({
                // Чтобы метки начали кластеризоваться, выставляем опцию.
                clusterize: true,
                // ObjectManager принимает те же опции, что и кластеризатор.
                gridSize: 32,
                clusterDisableClickZoom: true
            });

        // Чтобы задать опции одиночным объектам и кластерам,
        // обратимся к дочерним коллекциям ObjectManager.
        objectManager.objects.options.set('preset', 'islands#greenDotIcon');
        objectManager.clusters.options.set('preset', 'islands#greenClusterIcons');
        myMap.geoObjects.add(objectManager);

        $.ajax({
            url: "data.json"
        }).done(function(data) {
            objectManager.add(data);
        });
        //     myPlacemark = new ymaps.Placemark([53.902284, 27.561831], {
        //         // Чтобы балун и хинт открывались на метке, необходимо задать ей определенные свойства.
        //         balloonContentHeader: "Балун метки",
        //         balloonContentBody: "Содержимое <em>балуна</em> метки",
        //         balloonContentFooter: "Подвал",
        //         hintContent: "Хинт метки"
        //     });
        //
        // myMap.geoObjects.add(myPlacemark);
        //
        // // Открываем балун на карте (без привязки к геообъекту).
        // myMap.balloon.open([53.902284, 27.561831], "Октябрьская площадь", {
        //     // Опция: не показываем кнопку закрытия.
        //     closeButton: false
        // });

        // // Показываем хинт на карте (без привязки к геообъекту).
        // myMap.hint.open(myMap.getCenter(), "Одинокий хинт без метки", {
        //     // Опция: задержка перед открытием.
        //     openTimeout: 1500
        // });

    }
</script>
<br>
<%@include file="footer.jsp" %>
<br>
<br>
</body>
</html>