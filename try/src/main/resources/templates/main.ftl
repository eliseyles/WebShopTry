<#import "parts/common.ftl" as c>

<@c.page>


<div class="form-row">
    <div class="form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Search by title">
            <button type="submit" class="btn btn-primary ml-2">Search</button>
        </form>
    </div>
</div>

    <div>
        <form method="post">
            <input type="text" name="title" placeholder="Введите название" />
            <button type="submit">Добавить</button>
            <input type="hidden" name="_csrf" value="${_csrf.token}" />
        </form>
    </div>


<div class="card-columns">
    <#list products as pr>
    <div class="card my-3">
        <div class="m-2">
            <span>${pr.title}</span>
        </div>
        <div class="card-footer text-muted">
            <strong>${pr.ownerName}</strong>
        </div>
    </div>
    <#else>
    No products
    </#list>
</div>
</@c.page>

