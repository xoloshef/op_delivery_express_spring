<!DOCTYPE html>
<html>
<head>
    <title>DeliveryExpress</title>
</head>
<body>
<h1>DeliveryExpress</h1><hr>
<h4>Доставка по всей России в лучшем виде</h4>
<form action="/"method="get">
    Поиск по названию отправления:t <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list delivers as delivery>
    <div>
        <p><b>${delivery.title}</b> ${delivery.price} руб. | <a href="/delivery/${delivery.id}">Подробнее...</a></p>
    </div>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/delivery/create" method="post">
    Название отправления: <input type="text" name="title"/><br><br>
    Описание отправления : <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Имя: <input type="text" name="author"/><br><br>
    <input type="submit" value="Добавить отпраление"/>
</form>
</body>
</html>