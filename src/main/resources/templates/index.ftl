<#ftl encoding='UTF-8'>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Interface</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrapper">
    <div class="profile">
        <div class="profile-window">
            <h2 class="profile-title">Характеристики персонажа</h2>
            <table class="specifications">
                <tr class="specification-item">
                    <td>HP</td>
                    <td>150</td>
                </tr>
                <tr class="specification-item">
                    <td>MP</td>
                    <td>200</td>
                </tr>
                <tr class="specification-item">
                    <td>LVL</td>
                    <td>90</td>
                </tr>
                <tr class="specification-item">
                    <td>EXP</td>
                    <td>80000</td>
                </tr>
            </table>
            <h3 class="skills">Навыки</h3>
            <table class="specifications">
                <tr class="specification-item">
                    <td>Знание</td>
                    <td>1</td>
                </tr>
                <tr class="specification-item">
                    <td>Сила</td>
                    <td>1</td>
                </tr>
                <tr class="specification-item">
                    <td>Общение</td>
                    <td>1</td>
                </tr>
                <tr class="specification-item">
                    <td>Удача</td>
                    <td>1</td>
                </tr>
            </table>
        </div>
    </div>
    <div class="game">
        <div class="game-window">

        </div>
    </div>
    <div class="actions">
        <div class="action-window">
            <h2 class="action-title">Действия</h2>
            <ul class="action-items">
                <li class="action-item"><a href="#">Ограбить караван</a></li>
                <li class="action-item"><a href="#">Ограбить игрока</a></li>
                <li class="action-item"><a href="#">Вызвать на дуэль</a></li>
                <li class="action-item"><a href="#">Отдохнуть</a></li>
                <li class="action-item"><a href="#">Нанять бойца</a></li>
                <li class="action-item"><a href="#">Зайти в Saloon</a></li>
                <li class="action-item"><a href="#">Повысить уровень</a></li>
            </ul>
        </div>
    </div>
    <div class="chat">
        <div class="chat-window">
            <h2 class="chat-title">Чат</h2>
            <div class="messages">
                <div class="message-items"></div>
                <form id="message-form" class="message-form">
                    <input type="text" class="chat-input" name="chat">
                    <button id="message-send" class="message-send"><img src="images/message-button.png" width="100%" height="100%"></button>
                </form>
            </div>
        </div>
    </div>
    <div class="events">
        <div class="event-window">
            <h2 class="event-title">События</h2>
            <div class="event-items"></div>
        </div>
    </div>
</div>
</body>
</html>