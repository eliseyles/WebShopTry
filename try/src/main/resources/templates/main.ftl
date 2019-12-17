<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <div>
        <@l.logout />
        <span><a href = "/user">user list</a></span>
    </div>
    <div>
        <form method="post">
            <input type="text" name="title" placeholder="Введите название" />
            <button type="submit">Добавить</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </div>

    <div>Список продуктов</div>
    <form method="get" action="/main">
        <input type="text" name="filter" value = ${(filter)!}>
        <button type="submit">Найти</button>
    </form>

    <#list products as pr>
        <div>
            <b>${pr.id}</b>
            <span>${pr.title}</span>
            <strong>${pr.ownerName}</strong>
        </div>
    <#else>
        No products
    </#list>
</@c.page>

