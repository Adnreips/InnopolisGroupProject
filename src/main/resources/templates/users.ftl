<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Панель администратора. Выбор пользователя</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="profile-block">
    <h1 class="profile-title">Список пользователей</h1>
    <form class="profile-form">
        <fieldset class="profile-item">
            <label for="players">Доступные пользователи</label>
        </fieldset>
        <fieldset class="profile-item">
            <#list usersFromServer as user>
                <tr><p>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.state}</td>
                    <td><button type="submit" formaction="${'/users/' + user.id}">Редактировать</button></td>
                    </p>
                </tr>
            </#list>
        </fieldset>
        <fieldset class="profile-item">
            <button type="submit" formmethod="get" formaction="/">Вернуться на главную страницу</button>
        </fieldset>
    </form>
</div>

</body>
</html>
