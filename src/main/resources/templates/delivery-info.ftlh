<!DOCTYPE html>
<html>
<head>
    <title>DeliveryExpress</title>
</head>
<body>
<h1>DeliveryExpress</h1><hr>
<h4>Подробнее о посылке</h4>
<#list delivers as delivery>
<b>Название товара: </b>${delivery.title}<br>
<b>Описание товара: </b>${delivery.description}<br>
<b>Цена: </b>${delivery.price}<br>
<b>Город: </b>${delivery.city}<br>
<b>Автор: </b>${delivery.author}<br>
</#list>
<hr>
<form action="/delivery/delete/${delivery.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>
