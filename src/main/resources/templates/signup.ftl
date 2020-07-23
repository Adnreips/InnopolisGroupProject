<#ftl encoding='UTF-8'>
<html>
<head>
    <link href="/css/styles.css" rel="stylesheet">
    <link href="/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<#if error??>
    <div class="alert alert-danger" role="alert">Поля не могут быть пустыми</div>
</#if>
<div class="form-style-2">
    <div class="form-style-2-heading">
        Зарегистрируйтесь!
    </div>
    <form method="post" action="/signup">
        <label for="login">Логин
            <input class="input-field" type="text" id="login" name="login">
        </label>
        <br>
        <label for="password">Пароль
            <input class="input-field" type="password" id="password" name="password">
        </label>
        <br>
        <label for="first-name">Имя
            <input class="input-field"  id="first-name" name="firstName">
        </label>
        <br>
        <label for="last-name">Фамилия
            <input class="input-field"  id="last-name" name="lastName">
        </label>
        <br>
        <label for="remember-me">
            <input type="checkbox" id="remember-me" name="remember-me">Запомнить меня</label>
        <input type="submit" value="Зарегистрироваться">
        <br>
    </form>
    <form method="get" action="/login">
        <input type="submit" value="Авторизоваться">
    </form>
</div>
</body>
</html>